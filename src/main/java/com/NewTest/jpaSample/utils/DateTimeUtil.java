package com.NewTest.jpaSample.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日付Util
 *
 * @author john
 */
public class DateTimeUtil {

    /**
     * 日付の妥当性チェック
     *
     * @param param 日付文字列(yyyyMMdd)
     * @return チェック結果{ture:正常 , false:異常}
     */
    public static boolean chkDate(String param) {
        // 中身がない場合は終了
        if (param == null)
            return false;

        // ParseExceptionが発生するため例外処理
        try {
            // 変換作業
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            format.setLenient(false);
            format.parse(param);

        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 日付に変換する。
     *
     * @param date 日付
     * @param hour 時
     * @param minute 分
     * @return 日付
     */
    public static Date toDate(String date, int hour, int minute) {

        // 文字列連結作業
        StringBuilder distDate = new StringBuilder();
        distDate.append(date);
        distDate.append(" ");
        distDate.append(String.format("%1$02d", hour));
        distDate.append(":");
        distDate.append(String.format("%1$02d", minute));
        distDate.append(":00");

        // 文字列を日付に変更
        LocalDateTime datetime = LocalDateTime.parse(distDate.toString(), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        return Date.from(datetime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
