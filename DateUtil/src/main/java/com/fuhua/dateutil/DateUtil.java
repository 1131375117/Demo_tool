package com.fuhua.dateutil;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author fuhua
 **/
public class DateUtil {
    /**
     * 返回当前月第一天
     *
     * @return 返回当前月第一天
     */
    public static LocalDate geFirstDayOfThisMonth() {
        Calendar cale = null;
        cale = Calendar.getInstance();
        // 获取当月第一天和最后一天
        SimpleDateFormat formatTemp = new SimpleDateFormat("yyyy-MM-dd");
        String firstday, lastday;
        // 获取当前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = formatTemp.format(cale.getTime());
        return LocalDate.parse(firstday);
    }

    /**
     * 计算两个日期之间的间隔
     *
     * @param startDay 开始日期
     * @param endDay   结束日期
     * @return 间隔多少天
     */
    public static int calculationTwoDays(LocalDate startDay, LocalDate endDay) {
        if (startDay == null || endDay == null) {
            return 0;
        }
        return endDay.getDayOfYear() - startDay.getDayOfYear();
    }


    public static void main(String[] args) {
        LocalDate localDate = geFirstDayOfThisMonth();
        System.out.println(localDate);
        LocalDate parse = LocalDate.parse("2022-04-22");
        System.out.println(LocalDate.parse("2022-04-22"));

        //计算两个日期差
        int days = calculationTwoDays(LocalDate.parse("2022-04-22"), LocalDate.now());
        System.out.println(days);
    }
}
