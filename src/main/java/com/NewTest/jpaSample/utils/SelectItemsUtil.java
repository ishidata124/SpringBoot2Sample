package com.NewTest.jpaSample.utils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * セレクトアイテムUtilクラス
 *
 * @author john
 */
public class SelectItemsUtil {

    /** 時間セレクトボックス項目（開始） */
    public final static Map<String, String> START_HOUR_ITEMS =
            Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
                {
                    String key;
                    String value;

                    // 8-19時まで作成
                    for (int i = 8; i <= 19; i++) {
                        key = String.format("%1$02d", i);
                        value = key;
                        put(key, value);
                    }
                }
            });

    /** 時間セレクトボックス項目（終了） */
    public static final Object END_HOUR_ITEMS =
            Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
                {
                    String key;
                    String value;

                    // 0-23時まで作成
                    for (int i = 0; i <= 23; i++) {
                        key = String.format("%1$02d", i);
                        value = key;
                        put(key, value);
                    }
                }
            });

    /** 10分刻みセレクトボックス項目 */
    public final static Map<String, String> PER_10_MINUTES_ITEMS =
            Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
                {
                    put("00", "00");
                    put("10", "10");
                    put("20", "20");
                    put("30", "30");
                    put("40", "40");
                    put("50", "50");
                }
            });

    /** 検索で使用する予約ステータス */
    public final static Map<String, String> RESERVATION_STATUS_ITEMS =
            Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
                {
                    put("1", "予約中");
                    put("2", "キャンセル");
                    put("3", "終了");
                    put("4", "削除");
                }
            });
}
