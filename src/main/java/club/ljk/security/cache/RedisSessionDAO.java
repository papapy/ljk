package club.ljk.security.cache;

import club.ljk.comm.util.SerializeUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * redisSessionDAO
 * Created by XKey on 2016/1/30.
 */
public class RedisSessionDAO extends AbstractSessionDAO {
    private Logger log = Logger.getLogger(this.getClass());

    private RedisManager redisManager;

    private String keyPrefix = "shiro_session:";

    public void update(Session session) throws UnknownSessionException {
        this.saveSession(session);
    }

    private void saveSession(Session session) throws UnknownSessionException{
        if(session == null || session.getId() == null){
            log.error("session or session id is null");
            return;
        }

        byte[] key = getByteKey(session.getId());
        byte[] value = SerializeUtils.serialize(session);
        session.setTimeout(redisManager.getExpire()*1000);
        this.redisManager.set(key, value, redisManager.getExpire());
    }

    public void delete(Session session) {
        if(session == null || session.getId() == null){
            log.error("session or session id is null");
            return;
        }
        redisManager.del(this.getByteKey(session.getId()));
    }

    public Collection<Session> getActiveSessions() {
        Set<Session> sessions = new HashSet<Session>();
        Set<byte[]> keys = redisManager.keys(this.keyPrefix + "*");
        if(keys != null && keys.size()>0){
            for(byte[] key:keys){
                Session s = (Session) SerializeUtils.deserialize(redisManager.get(key));
                sessions.add(s);
            }
        }
        return sessions;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        if(serializable == null){
            log.error("session id is null");
            return null;
        }
        Session s = (Session)SerializeUtils.deserialize(redisManager.get(this.getByteKey(serializable)));
        return s;
    }

    /**
     * 获得byte[]型的key
     * @param serializable
     * @return
     */
    private byte[] getByteKey(Serializable serializable){
        String preKey = this.keyPrefix + serializable;
        return preKey.getBytes();
    }

    public RedisManager getRedisManager() {
        return redisManager;
    }

    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;

        /**
         * 初始化redisManager
         */
        this.redisManager.init();
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }
}
