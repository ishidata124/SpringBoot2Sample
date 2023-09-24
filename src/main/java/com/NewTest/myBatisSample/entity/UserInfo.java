package com.NewTest.myBatisSample.entity;

import lombok.Data;

import java.util.Date;

/**
 * エンティティクラス(データベースから受け取るクラス)
 *
 * @author john
 */
@Data
public class UserInfo {
    /** ユーザNo */
    private Integer userNo;

    /** ユーザID */
    private String userId;

    /** ユーザPW */
    private String userPassword;

    /** ユーザ名 */
    private String userName;

    /** メールアドレス */
    private String userMail;

    /** 最終ログイン日時 */
    private Date lastLoginDataTime;

    /** パスワード変更後経過日数 */
    private Integer pwElapsedDate;

    /** ユーザステータス */
    private Integer userStatus;

    /** チャレンジレスポンス用文字列 */
    private String hash;

    /** ログインNG回数 */
    private String loginErr;
}
