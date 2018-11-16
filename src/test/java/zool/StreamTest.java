package zool;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import sun.java2d.cmm.Profile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zoolye
 * 何为Stream：
 * 可以把Stream当成一个高级版本的Iterator。
 * 原始版本的Iterator，用户只能一个一个的遍历元素并对其执行某些操作；
 * 高级版本的Stream，用户只要给出需要对其包含的元素执行什么操作，比如“过滤掉长度大于10的字符串”
 * “获取每个字符串的首字母”等，具体这些操作如何应用到每个元素上，就给Stream就好了
 *
 * 操作步骤：
 * 1.创建Stream
 * 2.转换Stream，每次转换原有Stream对象不改变，返回一个新的Stream对象（**可以有多次转换**）
 * 3.对Stream进行聚合（Reduce）操作，获取想要的结果
 */
public class StreamTest {

    @Test
    public void test1(){
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
        long l = nums.stream().filter(num -> num != null).limit(2).count();
    }

    @Test
    public Profile fetch(String id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://www.baidu.com",Profile.class,id);
    }


}
