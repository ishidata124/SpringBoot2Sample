package com.NewTest.myBatisSample.utils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * セレクトアイテムUtilクラス
 *
 * @author john
 */
public class SelectItemsUtil {

    /** 検索で使用するユーザステータス */
    public final static Map<String, String> USER_STATUS_ITEMS =
            Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
                {
                    put("0", "未ログイン");
                    put("1", "管理者");
                    put("2", "一般");
                    put("3", "PW期限切れ");
                    put("4", "無効");
                }
            });
}
