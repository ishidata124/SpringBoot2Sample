package com.NewTest.myBatisSample.utils;

import java.util.regex.Pattern;

/**
 * 構文チェックUtilクラス
 *
 * @author john
 */
public class ValidationUtil {

    // メールアドレスRFC-5322コンプライアンス正規表現の使用
    private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * メールアドレスの構文チェック
     *
     * @param mail メールアドレス
     * @return OK: true NG:false
     */
    public static boolean emailValidation(String mail) {

        // メールアドレスRFC-5322コンプライアンス正規表現で確認
        return EMAIL_PATTERN.matcher(mail).matches();
    }
}
