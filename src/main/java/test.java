import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Project name(项目名称)：随机数接口
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/25
 * Time(创建时间)： 13:09
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{          //实时模板函数
    public static int getIntRandom(int min, int max)         //空间复杂度和时间复杂度更低
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static int getIntRandom1(int min, int max)          //获取int型的随机数
    {
        if (min > max)
        {
            min = max;
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static double getDoubleRandom(double min, double max)  //double型随机数
    {
        if (min > max)
        {
            min = max;
        }
        return min + (Math.random() * (max - min));
    }

    public static double getDoubleRandom(double min, double max, String format)
    {            //空间复杂度和时间复杂度都特别高，只适合获取非常少的格式化的随机数使用。farmat：##.##或00.00
        DecimalFormat decimalFormat = new DecimalFormat(format);
        if (min > max)
        {
            min = max;
        }
        return Double.parseDouble(decimalFormat.format(min + (Math.random() * (max - min))));
    }

    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------

        LinkedList<Integer> p = new LinkedList<>();
        for (int i = 0; i < 100000; i++)
        {
            p.add(getIntRandom1(99, 1893));
        }
        Collections.sort(p);
        System.out.println("max:" + p.getLast());
        System.out.println("min:" + p.getFirst());


        LinkedList<Double> p1 = new LinkedList<>();
        for (int i = 0; i < 100000; i++)
        {
            p1.add(getDoubleRandom(9.4, 19.92));
        }
        Collections.sort(p1);
        System.out.println("max:" + p1.getLast());
        System.out.println("min:" + p1.getFirst());
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
