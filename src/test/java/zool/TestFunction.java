package zool;

import org.junit.Test;

import java.time.*;
import java.util.Date;

/**
 * @author : zoolye
 * @date : 2018-09-30 14:03
 * @describe :
 */
public class TestFunction {

    @Test
    public void test(){

        LocalDate time = LocalDate.parse("2020-01-01");
        LocalDate time1 = LocalDate.parse("2020-12-31");

        Period period = Period.between(time1,time);

        System.out.println(period.getYears() + "年" +
                period.getMonths() + "月" +
                period.getDays() + "天");

        System.out.println(isYearOneWithin(period));

    }

    /**
     * 是否在两年之内
     *
     * @param period
     * @return
     */
    private boolean isYearOneWithin(Period period) {
        //相差的年
        Integer year = period.getYears();
        //相差的月
        Integer month = period.getMonths();
        //相差的天
        Integer days = period.getDays();

        if (1 == year && month == 0 && days == 0) {
            return true;
        }

        if (year == 0) {

            if (month <= 11 && month >= 0 && days >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否在一年之内
     *
     * @return
     */
    private boolean isYearTowWithin(Period period) {
        //相差的年
        Integer year = period.getYears();
        //相差的月
        Integer month = period.getMonths();
        //相差的天
        Integer days = period.getDays();

        if (2 == year && month == 0 && days == 0) {
            return true;
        }

        if (year == 0) {

            if (month <= 11) {
                return true;
            }
        }

        if (year == 1) {

            if (month <= 11) {
                return true;
            }

        }
        return false;
    }

    @Test
    public void test2(){

        Period period = Period.between(LocalDate.parse("2018-12-20"), LocalDate.parse("2018-08-27"));

        boolean b = isYearOneWithin(period);

        System.out.println(b);

    }

    @Test
    public void test3(){
        /*
        * 如果整型字面量的值介于-128到127之间，
        * 就不会new一个新的Integer对象，而是直接引用常量池中的Integer对象
        * */
        Integer a = 128 , b = 128;
        Integer c = 127 , d = 127;

        System.out.println(a==b); //false
        System.out.println(c==d); //true


        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }

}
