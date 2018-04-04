package zool;

import redis.clients.jedis.Jedis;

public class RedisTest {

    public static void main(String args[]){

        Jedis jedis = new Jedis("localhost");
        jedis.set("username","zoolye");
        jedis.set("email","www.iphone@foxmail.com");

        String name = jedis.get("username");
        String email = jedis.get("email");

        System.out.println(name+" : "+email);

    }

}
