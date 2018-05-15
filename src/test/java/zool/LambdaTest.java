package zool;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zoolye
 * 何为lambda表达式：
 * 一个不用被绑定到一个标识符上，并且可能被调用的函数。
 * 这个解释还不够通俗，lambda表达式可以这样定义（不精确，自己的理解）：一段带有输入参数的可执行语句块
 */
public class LambdaTest {

    @Test
    public void test1(){
        List<String> names = new ArrayList<>();
        names.add("zool");
        names.add("ye");
        names.add("www");
        names.add("iphone");
        System.out.println(names);
        Collections.sort(names,(o1,o2)->o1.compareTo(o2));
        System.out.println(names);
    }

    public void test2(){
        List<String> names = new ArrayList<>();
        names.add("zool");
        names.add("ye");
        names.add("www");
        names.add("iphone");
        List<String> list = names.stream().map((String name) ->{return name.toLowerCase();}).collect(Collectors.toList());
    }

}
