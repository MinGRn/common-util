package com.mingrn.common.redis.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisConfig {

	private JedisConfig() {
	}

	private static JedisPool jedisPool;

	static {
		try {
			Properties properties = PropertyUtil.loadProperties("redis.properties");
			JedisPoolConfig config = poolConfig(properties);

			String ssl = properties.getProperty("redis.ssl", "false");
			String minIdle = properties.getProperty("redis.minIdle", "0");
			String maxIdle = properties.getProperty("redis.maxIdle", "8");
			String maxTotal = properties.getProperty("redis.maxTotal", "8");

			String port = properties.getProperty("redis.port", "6379");
			String database = properties.getProperty("redis.database", "0");
			String host = properties.getProperty("redis.host", "localhost");
			String timeout = properties.getProperty("redis.timeout", "2000");
			String password = properties.getProperty("redis.password", null);

			jedisPool = new JedisPool(config, host, Integer.valueOf(port), Integer.valueOf(timeout), password, Integer.valueOf(database));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取 Jedis 对象
	 */
	public static Jedis getResource() {
		return jedisPool.getResource();
	}

	/**
	 * 回收 Redis
	 *
	 * @param jedis 实例
	 */
	public static void returnJedisObject(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

	private static class PropertyUtil {

		/**
		 * 加载property文件到io流里面
		 *
		 * @param propertyFile 配置文件
		 * @return 配置文件
		 */
		static Properties loadProperties(String propertyFile) {
			Properties properties = new Properties();
			try {
				InputStream is = PropertyUtil.class.getClassLoader().getResourceAsStream(propertyFile);
				if (is == null) {
					is = PropertyUtil.class.getClassLoader().getResourceAsStream("properties/" + propertyFile);
				}
				properties.load(is);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return properties;
		}

		/**
		 * 根据key值取得对应的value值
		 *
		 * @param propertyFile 配置文件
		 * @param key 键
		 * @return 键值
		 */
		static String getValue(String propertyFile, String key) {
			Properties properties = loadProperties(propertyFile);
			return properties.getProperty(key);
		}
	}


	/**
	 * 获取 JedisPoolConfig
	 *
	 * @param properties 配置文件
	 */
	private static JedisPoolConfig poolConfig(Properties properties) {
		Long minEvictableIdleTimeMillisNum, softMinEvictableIdleTimeMillisNum;
		minEvictableIdleTimeMillisNum = softMinEvictableIdleTimeMillisNum = 1000L * 60L * 30L;

		String lifo = properties.getProperty("redis.lifo", "true");
		String fairness = properties.getProperty("redis.fairness", "false");
		String jmxEnabled = properties.getProperty("redis.jmxEnabled", "true");
		String jmxNameBase = properties.getProperty("redis.jmxNameBase", null);
		String maxWaitMillis = properties.getProperty("redis.maxWaitMillis", "-1");
		String testOnCreate = properties.getProperty("redis.testOnCreate", "false");
		String testOnBorrow = properties.getProperty("redis.testOnBorrow", "false");
		String testOnReturn = properties.getProperty("redis.testOnReturn", "false");
		String jmxNamePrefix = properties.getProperty("redis.jmxNamePrefix", "pool");
		String testWhileIdle = properties.getProperty("redis.testWhileIdle", "false");
		String blockWhenExhausted = properties.getProperty("redis.blockWhenExhausted", "true");
		String numTestsPerEvictionRun = properties.getProperty("redis.numTestsPerEvictionRun", "3");
		String timeBetweenEvictionRunsMillis = properties.getProperty("redis.timeBetweenEvictionRunsMillis", "-1");
		String minEvictableIdleTimeMillis = properties.getProperty("redis.minEvictableIdleTimeMillis", String.valueOf(minEvictableIdleTimeMillisNum));
		String softMinEvictableIdleTimeMillis = properties.getProperty("redis.softMinEvictableIdleTimeMillis", String.valueOf(softMinEvictableIdleTimeMillisNum));
		String evictionPolicyClassName = properties.getProperty("redis.evictionPolicyClassName", "org.apache.commons.pool2.impl.DefaultEvictionPolicy");

		JedisPoolConfig config = new JedisPoolConfig();
		config.setJmxNameBase(jmxNameBase);
		config.setJmxNamePrefix(jmxNamePrefix);
		config.setLifo(Boolean.parseBoolean(lifo));
		config.setFairness(Boolean.parseBoolean(fairness));
		config.setMaxWaitMillis(Long.parseLong(maxWaitMillis));
		config.setJmxEnabled(Boolean.parseBoolean(jmxEnabled));
		config.setEvictionPolicyClassName(evictionPolicyClassName);
		config.setTestOnCreate(Boolean.parseBoolean(testOnCreate));
		config.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
		config.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
		config.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle));
		config.setBlockWhenExhausted(Boolean.parseBoolean(blockWhenExhausted));
		config.setNumTestsPerEvictionRun(Integer.parseInt(numTestsPerEvictionRun));
		config.setMinEvictableIdleTimeMillis(Long.parseLong(minEvictableIdleTimeMillis));
		config.setSoftMinEvictableIdleTimeMillis(Long.parseLong(softMinEvictableIdleTimeMillis));
		config.setTimeBetweenEvictionRunsMillis(Long.parseLong(timeBetweenEvictionRunsMillis));

		return config;
	}
}