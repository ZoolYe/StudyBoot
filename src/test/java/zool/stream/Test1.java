package zool.stream;

import org.junit.Test;
import sun.misc.Launcher;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : zoolye
 * @date : 2018-11-14 10:25
 * @describe :
 */
public class Test1 {

    @Test
    public void test1() {

        // 定义人名数组
        final String[] names = {"Zebe", "Hebe", "Mary", "July", "David"};
        Stream<String> stream1 = Stream.of(names);
        Stream<String> stream2 = Stream.of(names);
        Stream<String> stream3 = Stream.of(names);
        // 拼接成 [x, y, z] 形式
        String result1 = stream1.collect(Collectors.joining(", ", "[", "]"));
        // 拼接成 x | y | z 形式
        String result2 = stream2.collect(Collectors.joining(" | ", "", ""));
        // 拼接成 x -> y -> z] 形式
        String result3 = stream3.collect(Collectors.joining(" -> ", "", ""));
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }

    @Test
    public void test2() {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
    }

    @Test
    public void test3() {

        // 创建一个包含人名称的流
        Stream<String> stream = Stream.of("Alen", "Hebe", "Zebe", "Helen", "Alex");
        // 通过人名称的首字母进行分组
        final Map<Character, List<String>> collect = stream.collect(Collectors.groupingBy(x -> toString().charAt(0)));
        // 输出分组结果
        collect.forEach((letter, groups) -> {
            System.out.println("以字母 " + letter + " 开头的名字如下：");
            groups.forEach(name -> System.out.println("\t" + name));
        });
    }
}