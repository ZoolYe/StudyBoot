package zool;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {

    public static void main(String args[]){

        Jedis jedis = getJedis("");
        jedis.set("username","zoolye");
        jedis.set("email","www.iphone@foxmail.com");

        String name = jedis.get("username");
        String email = jedis.get("email");

        System.out.println(name+" : "+email);

    }

    /**
     * 连接Jedis，传入连接的Jedis地址，如果参数为空连接默认的localhost
     * @param ip 地址
     * @return Jedis 实例
     */
    public static Jedis getJedis(String ip) {
        return "".equals(ip) || ip == null ? new Jedis("localhost") : new Jedis(ip);
    }

}
