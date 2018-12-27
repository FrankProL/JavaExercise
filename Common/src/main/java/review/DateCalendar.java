package review;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Frank on 2018/12/12.
 * 字符串转日期 parse
 * 日期转字符串 format
 * 依赖于SimpleDateFormat实例
 *
 * 日期大小比较，字符串可以直接比较，Date格式要转化为秒getTime后比较,或者before、after、conmpareTo方法
 *
 * calendar.get(Calendar.MONTH)	//获得的月份加 1 才对应实际月份
 *
 * Calendar类的静态方法getInstance()可以初始化一个日历对象，Calendar是个抽象类
 *
 * Date:最基础的日期时间类，返回一个相对日期的毫秒数，不支持日期的国际化
 * Calender：相对于Date更强大的时间类，是抽象类，提供了常规的日期修改功能和国际化支持
 * GregorianCalender：Calender类的子类，提供处理日期的方法，用于计算日期，有用的是有个判断闰年的方法
 * DateFormat：可以接受字符串的输入输出，提供了将日期、时间进行格式化处理的功能
 * SimpleDateFormat：更强大的日期时间格式化类，自定义格式化日期和时间
 * java.util.Locate：描述特定的地理、政治、文化上的地区，封装了‘地区’和‘语言种类’
 */
public class DateCalendar {
    public static void main(String[] args) {
        // Date
        Date date = new Date();

        Date now = new Date();
        System.out.println(now);

        Date d1 = new Date(2018, 12, 11);
        System.out.println(d1);

        System.out.println(now.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        // Date转化为字符串，通过SimpleDateFormat实例					******
        System.out.println(df.format(date));			//20170823
        System.out.println(date);						//Wed Aug 23 09:45:57 CST 2017
        // Date日期加减,先获取毫秒数，进行加减，然后再转为Date
        System.out.println(df.format(new Date(date.getTime()-2*24*60*60*1000)));	//20170821

        // 字符串转日期
        String strDate = "2018-12-12";
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sDate = sFormat.parse(strDate);
            System.out.println(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 日期转字符串
        System.out.println(df.format(date));

        // Calendar
        Calendar calendar = Calendar.getInstance();            //默认即为当前时间
        calendar.setTime(new Date());                          //可以赋值Date类型值，更改时间
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        // 日期加减
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DATE));

        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR) + ":" + cal.get(Calendar.MONTH) + ":" + cal.get(Calendar.DATE) + ":" + cal.getTimeInMillis());
        //获取一月前时间
        cal.add(Calendar.MONTH, -1);
        System.out.println(cal.get((Calendar.MONTH)));

        String a= "20161201";
        Date datea = null;
        try {
            datea = df.parse(a);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(datea);
        cal.add(Calendar.DATE, 1);
        System.out.println("日期20161201加1：   "+cal.getTime());

        //GregorianCalendar
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(1, +1);
        System.out.println(df.format(gc.getTime()));		//00010823
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
        // GregorianCalendar 基于Date和Calendar
        // 输入时间DAte
        // 输出需要Calendar
        // 太复杂


        System.out.println("===================计算时间间隔=========================");
        // http://blog.csdn.net/hongweigg/article/details/59106619
        // 计算两个时间的间隔,例如计算 2016 年 1 月 1 日距离现在有多少天
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = "2016-01-01 11:11:11";
        calendar.setTime(new Date());					//设置为当前时间
        long nowDate = calendar.getTime().getTime(); 	//Date.getTime() 获得毫秒型日期
        try {
            long specialDate = df.parse("20171012").getTime();
            long betweenDate = (nowDate - specialDate) / (1000 * 60 * 60 * 24); //计算间隔多少天，则除以毫秒到天的转换公式
            System.out.print(betweenDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("======================日期比较大小===========================");
        //
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString_01 = "2016-01-02 11:11:10";			//若格式化为2016-01-02，则可按天进行判断
        String dateString_02 = "2016-01-02 11:11:11";
        try {
            Date date_01 = sdf.parse(dateString_01);
            Date date_02 = sdf.parse(dateString_02);
            System.out.println(date_01.before(date_02)); //true，当 date_01 小于 date_02 时，为 true，否则为 false
            System.out.println(date_02.after(date_01)); //true，当 date_02 大于 date_01 时，为 true，否则为 false
            System.out.println(date_01.compareTo(date_02)); //-1，当 date_01 小于 date_02 时，为 -1
            System.out.println(date_02.compareTo(date_01)); //1，当 date_02 大于 date_01 时，为 1
            System.out.println(date_02.compareTo(date_02)); //0，当两个日期相等时，为 0
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
