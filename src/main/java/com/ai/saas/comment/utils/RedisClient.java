package com.ai.saas.comment.utils;

import java.io.IOException;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {

    public static JedisPool jedisPool;// 池化管理jedis链接池

    static {
    	try {
    	Properties properties = ReadPropertiesUtil.getProperties("/context/redis.properties");   	
        // 读取相关的配置
        int maxActive = Integer.parseInt(properties.getProperty("redis.pool.maxActive"));
        int maxIdle = Integer.parseInt(properties.getProperty("redis.pool.maxIdle"));
        int maxWait = Integer.parseInt(properties.getProperty("redis.pool.maxWait"));
        String ip = properties.getProperty("redis.ip");
        int port = Integer.parseInt(properties.getProperty("redis.port"));
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(maxActive);
        // 设置最大空闲数
        config.setMaxIdle(maxIdle);
        // 设置超时时间
        config.setMaxWaitMillis(maxWait);

        // 初始化连接池
        jedisPool = new JedisPool(config, ip, port);
    	} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    
    
    private static Jedis getJedis(String method) {
        try {
            Jedis jedis = jedisPool.getResource();
            jedis.connect();
            return jedis;
        } catch (Exception e) {
            try {
                throw new Exception(method + "缓存出错: REDIS连接失败", e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    public static void close(Jedis jedis) {
        if (jedis != null && jedis.isConnected()) {
            try {
                jedis.quit();
            } catch (Exception ex) {
            }
            jedis.disconnect();
        }
    }
    
    

    //增
    public static void set(String key, String value) {
    	Jedis jedis = getJedis("加载");
        if (jedis != null) {
            try {
                jedis.set(key, value);
            } catch (Exception ex) {
            } finally {
                close(jedis);
            }
        }
    }
    
    //删
    public static void del(String key) {
        Jedis jedis = getJedis("删除");
        if (jedis != null) {
            try {
                jedis.del(key);
            } catch (Exception ex) {
            } finally {
                close(jedis);
            }
        }
    }
    
    //该
    public static void update(String key, String value) {
    	Jedis jedis = getJedis("加载");
        if (jedis != null) {
            try {
            	 jedis.del(key);
            	 jedis.set(key, value);
            } catch (Exception ex) {
            } finally {
                close(jedis);
            }
        }
    }
  
 
    //查
	public static String get(String key) {
        Jedis jedis = getJedis("读取");
        if (jedis != null) {
            try {
                return jedis.get(key);
            } catch (Exception ex) {
            } finally {
                close(jedis);
            }
        }
        return null;
    }    

    public void expire(String key, int seconds) {
        Jedis jedis = getJedis("过期时间");
        if (jedis != null) {
            jedis.expire(key, seconds);
            close(jedis);
        }
    }

    public static void flush() {
        Jedis jedis = getJedis("刷新");
        if (jedis != null) {
            try {
                jedis.flushAll();
            } catch (Exception ex) {
            } finally {
                close(jedis);
            }
        }
    }
  

    public static void main(String[] args) throws Exception {      
       //请勿删除下面的set语句：这里是用以初始化的数据
//       RedisClient.set("emailurl", "http://10.1.228.200:20184/sendemail");
//       RedisClient.set("sender", "ai-cloud@asiainfo.com");
//       RedisClient.set("receiver", "mapl@asiainfo.com");
       
       RedisClient.set("renfeng55", "12345667");
       System.out.println(RedisClient.get("renfeng55"));
       
       
    }
}