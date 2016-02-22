package club.ljk.security.cache;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * redisManager
 * Created by XKey on 2016/1/30.
 */
public class RedisManager {
    private Logger log = Logger.getLogger(this.getClass());

    @Value("${redis.ip}")
    private String host;

    @Value("${redis.port}")
    private int port;

    // 0 - never expire
    private int expire = 0;

    private static JedisPool jedisPool = null;

    public RedisManager() {}

    /**
     * 初始化方法
     */
    public void init(){
        if(null == host || 0 == port){
            log.error("请初始化redis配置文件！");
            throw new NullPointerException("找不到redis配置");
        }
        if(jedisPool == null){
            //jedisPool = JedisUtil.getJedisPool();
            jedisPool = new JedisPool(new JedisPoolConfig(), host, port);
        }
    }

    /**
     * get value from redis
     * @param key
     * @return
     */
    public byte[] get(byte[] key) {
        byte[] value = null;
        Jedis jedis = jedisPool.getResource();
        try {
            value = jedis.get(key);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return value;
    }

    /**
     * get value from redis
     * @param key
     * @return
     */
    public String get(String key) {
        String value=null;
        Jedis jedis = jedisPool.getResource();
        try {
            value = jedis.get(key);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return value;
    }

    /**
     * set
     * @param key
     * @param value
     * @return
     */
    public byte[] set(byte[] key, byte[] value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
            if (this.expire != 0) {
                jedis.expire(key, this.expire);
            }
        } finally {
            jedisPool.returnResource(jedis);
        }
        return value;
    }

    /**
     * set
     * @param key
     * @param value
     * @return
     */
    public String set(String key,String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
            if (this.expire != 0) {
                jedis.expire(key, this.expire);
            }
        } finally {
            jedisPool.returnResource(jedis);
        }
        return value;
    }

    /**
     * set
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public byte[] set(byte[] key, byte[] value, int expire) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
            if (expire != 0) {
                jedis.expire(key, expire);
            }
        } finally {
            jedisPool.returnResource(jedis);
        }
        return value;
    }

    /**
     * set
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public String set(String key,String value, int expire) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
            if (expire != 0) {
                jedis.expire(key, expire);
            }
        } finally {
            jedisPool.returnResource(jedis);
        }
        return value;
    }

    /**
     * del
     * @param key
     */
    public void del(byte[] key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(key);
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * del
     * @param key
     */
    public void del(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(key);
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * flush
     */
    public void flushDB() {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.flushDB();
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * size
     */
    public Long dbSize() {
        Long dbSize = 0L;
        Jedis jedis = jedisPool.getResource();
        try {
            dbSize = jedis.dbSize();
        } finally {
            jedisPool.returnResource(jedis);
        }
        return dbSize;
    }

    /**
     * keys
     * @param regex
     * @return
     */
    public Set<byte[]> keys(String regex) {
        Set<byte[]> keys = null;
        Jedis jedis = jedisPool.getResource();
        try {
            keys = jedis.keys(regex.getBytes());
        } finally {
            jedisPool.returnResource(jedis);
        }
        return keys;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
