package club.ljk.security.cache;

import org.apache.log4j.Logger;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * cacheManager
 * Created by XKey on 2016/1/30.
 */
public class RedisCacheManager implements CacheManager {
    private Logger log = Logger.getLogger(this.getClass());

    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

    private RedisManager redisManager;

    private String keyPrefix = "shiro_redis_cache:";

    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        log.debug("获取名称为: " + s + " 的RedisCache实例");
        Cache c = caches.get(s);
        if (c == null) {
            // initialize the Redis manager instance
            redisManager.init();
            // create a new cache instance
            c = new RedisCache<K, V>(redisManager, keyPrefix);
            // add it to the cache collection
            caches.put(s, c);
        }
        return c;
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    public RedisManager getRedisManager() {
        return redisManager;
    }

    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }
}
