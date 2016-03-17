package com.adanac.b2b.oms.utils;

import java.util.Map;

import com.adanac.framework.cache.redis.client.impl.MyShardedClient;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;

/**
 * redis操作的工具类
 * @author adanac
 * @version 1.0
 */
public class RedisUtil {

	private static MyLogger log = MyLoggerFactory.getLogger(RedisUtil.class);

	private int RETRYCOUNT = 3;

	/**
	 * redis
	 */
	private MyShardedClient redisClient;

	public RedisUtil(MyShardedClient redisClient) {
		this.redisClient = redisClient;
	}

	public void set(String key, String value) {
		set(key, value, RETRYCOUNT);
	}

	private void set(String key, String value, int count) {
		try {
			redisClient.set(key, value);
		} catch (Exception e) {
			log.error("set from redis by key = [" + key + "] retry count =" + count + " fail ,error = ", e);
			// 重试3次
			if (count > 0) {
				set(key, value, --count);
			}
			throw new SysException("redis连接失败", e);
		} finally {
		}
	}

	public String get(String key) {
		return get(key, RETRYCOUNT);
	}

	private String get(String key, int count) {
		String value = null;
		try {
			value = redisClient.get(key);
		} catch (Exception e) {
			log.error("get from redis by key = [" + key + "] retry count =" + count + " fail ,error = ", e);
			// 重试3次
			if (count > 0) {
				value = get(key, --count);
			}
			throw new SysException("redis连接失败", e);
		} finally {
		}
		return value;
	}

	public void hset(String key, String field, String value) {
		hset(key, field, value, RETRYCOUNT);
	}

	private void hset(String key, String field, String value, int count) {
		try {
			redisClient.hset(key, field, value);
		} catch (Exception e) {
			log.error("hset from redis by key = [" + key + "] retry count =" + count + " fail ,error = ", e);
			// 重试3次
			if (count > 0) {
				set(key, value, --count);
			}
			throw new SysException("redis连接失败", e);
		} finally {
		}
	}

	public String hget(String key, String field) {
		return hget(key, field, RETRYCOUNT);
	}

	public Map<String, String> hgetAll(String key) {
		Map<String, String> value = null;
		try {
			value = redisClient.hgetAll(key);
		} catch (Exception e) {
			log.error("hgetAll from redis by key = [" + key + "] fail ,error = ", e);
		} finally {
		}
		return value;
	}

	private String hget(String key, String field, int count) {
		String value = null;
		try {
			value = redisClient.hget(key, field);
		} catch (Exception e) {
			log.error("hget from redis by key = [" + key + "] retry count =" + count + " fail ,error = ", e);
		} finally {
		}
		return value;
	}

	public String rpop(String key) {
		return rpop(key, RETRYCOUNT);
	}

	private String rpop(String key, int retrycount) {
		String value = null;
		try {
			value = redisClient.lpop(key);
		} catch (Exception e) {
			log.error("rpop from redis by key = [" + key + "] retry count =" + retrycount + " fail ,error = ", e);
			// 重试3次
			if (retrycount > 0) {
				value = rpop(key, --retrycount);
			}
		} finally {
		}

		return value;
	}

	public void flush() {
		redisClient.flushDB();
	}

	public void del(String key) {
		try {
			redisClient.del(key);
		} catch (Exception e) {
			throw new SysException("redis连接失败", e);
		}
	}

	public void hdel(String key, String field) {
		try {
			redisClient.hdel(key, field);
		} catch (Exception e) {
			throw new SysException("redis连接失败", e);
		}
	}

}
