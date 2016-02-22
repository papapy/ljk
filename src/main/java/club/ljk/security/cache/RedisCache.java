package club.ljk.security.cache;

import club.ljk.comm.util.SerializeUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;

import java.util.*;

/**
 * redisCache
 * Created by XKey on 2016/1/30.
 */
public class RedisCache<K, V> implements Cache<K, V> {
    private Logger log = Logger.getLogger(this.getClass());

    private RedisManager cache;

    private String keyPrefix = "shiro_session:";

    public RedisCache(RedisManager cache) {
        if (cache == null) {
            throw new IllegalArgumentException("Cache argument cannot be null.");
        }
        this.cache = cache;
    }

    public RedisCache(RedisManager cache, String prefix) {
        this(cache);
        // set the prefix
        this.keyPrefix = prefix;
    }

    /**
     * 获得byte[]型的key
     * @param key
     * @return
     */
    private byte[] getByteKey(K key) {
        if (key instanceof String) {
            String preKey = this.keyPrefix + key;
            return preKey.getBytes();
        } else if(key instanceof PrincipalCollection){
            String preKey = this.keyPrefix + key.toString();
            return preKey.getBytes();
        }else{
            return SerializeUtils.serialize(key);
        }
    }

    public V get(K k) throws CacheException {
        log.debug("根据key从Redis中获取对象 key [" + k + "]");
        try {
            if (k == null) {
                return null;
            } else {
                byte[] rawValue = cache.get(getByteKey(k));
                @SuppressWarnings("unchecked") V value = (V) SerializeUtils.deserialize(rawValue);
                return value;
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public String getStr(String key) throws CacheException {
        log.debug("根据key从Redis中获取对象 key [" + key + "]");
        try {
            if (key == null) {
                return null;
            } else {
                return cache.get(key);
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public V put(K k, V v) throws CacheException {
        log.debug("根据key从存储 key [" + k + "]");
        try {
            cache.set(getByteKey(k), SerializeUtils.serialize(v));
            return v;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public String putStr(String key, String value) throws CacheException {
        log.debug("根据key从存储 key [" + key + "]");
        try {
            cache.set(key, value);
            return value;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public String put(String key,String value, int expire) throws CacheException {
        log.debug("根据key从存储 key [" + key + "]");
        try {
            cache.set(key, value, expire);
            return value;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public String removeString(String key) throws CacheException {
        log.debug("从redis中删除 key [" + key + "]");
        try {
            String previous = cache.get(key);
            cache.del(key);
            return previous;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public V remove(K k) throws CacheException {
        log.debug("从redis中删除 key [" + k + "]");
        try {
            V previous = get(k);
            cache.del(getByteKey(k));
            return previous;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public void clear() throws CacheException {
        log.debug("从redis中删除所有元素");
        try {
            cache.flushDB();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public int size() {
        try {
            Long longSize = new Long(cache.dbSize());
            return longSize.intValue();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public Set<K> keys() {
        try {
            Set<byte[]> keys = cache.keys(this.keyPrefix + "*");
            if (CollectionUtils.isEmpty(keys)) {
                return Collections.emptySet();
            } else {
                Set<K> newKeys = new HashSet<K>();
                for (byte[] key : keys) {
                    newKeys.add((K) key);
                }
                return newKeys;
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public Collection<V> values() {
        try {
            Set<byte[]> keys = cache.keys(this.keyPrefix + "*");
            if (!CollectionUtils.isEmpty(keys)) {
                List<V> values = new ArrayList<V>(keys.size());
                for (byte[] key : keys) {
                    @SuppressWarnings("unchecked") V value = get((K) key);
                    if (value != null) {
                        values.add(value);
                    }
                }
                return Collections.unmodifiableList(values);
            } else {
                return Collections.emptyList();
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }
}
