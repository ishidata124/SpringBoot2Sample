package com.NewTest.myBatisSample.form;

import com.NewTest.jpaSample.form.FormBase;
import com.NewTest.myBatisSample.entity.UserInfo;
import com.NewTest.myBatisSample.utils.MakeLabelUtil;
import com.NewTest.myBatisSample.utils.ValidationUtil;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ユーザ情報フォーム
 *
 * @author john
 */
@Data
public class UserListForm extends FormBase implements Serializable {
    /** Form名 */
    public static final String FORM_NAME = "userListForm";

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

    /** ユーザステータス(画面表示用) */
    private String userStatusDisp;

    /** ユーザステータスセレクトボックス項目 */
    private Map<String, String> userStatusItems;

    /** チャレンジレスポンス用文字列 */
    private String hash;

    /** ログインNG回数 */
    private String loginErr;

    /** ユーザ情報リスト */
    private List<UserListForm> userFormList;

    /**
     * ユーザ情報一覧を設定します。
     *
     * @param userInfo ユーザ情報一覧
     */
    public void setUserInfoList(UserInfo userInfo) {

        this.setUserNo(userInfo.getUserNo());
        this.setUserId(userInfo.getUserId());
        this.setUserPassword(userInfo.getUserPassword());
        this.setUserName(userInfo.getUserName());
        this.setLastLoginDataTime(userInfo.getLastLoginDataTime());
        this.setPwElapsedDate(userInfo.getPwElapsedDate());
        this.setUserStatus(userInfo.getUserStatus());

        // 画面表示用ステータスの設定
        this.setUserStatusDisp(MakeLabelUtil.getUserStatusLabel(userInfo.getUserStatus().toString()));
    }

    /**
     * 確認画面表示用情報セット
     *
     * @param inUserInfo データベース取得フォーム情報
     */
    public void copy(UserInfo inUserInfo) {
        this.setUserNo(inUserInfo.getUserNo());
        this.setUserId(inUserInfo.getUserId());
        this.setUserPassword(inUserInfo.getUserPassword());
        this.setUserName(inUserInfo.getUserName());
        this.setUserMail(inUserInfo.getUserMail());
        this.setLastLoginDataTime(inUserInfo.getLastLoginDataTime());
        this.setPwElapsedDate(inUserInfo.getPwElapsedDate());
        this.setUserStatus(inUserInfo.getUserStatus());

        // 画面表示用ステータスの設定
        this.setUserStatusDisp(MakeLabelUtil.getUserStatusLabel(inUserInfo.getUserStatus().toString()));
    }

    /**
     * 登録バリデーション
     *
     * @return エラーメッセージ
     */
    public String valid() {

        // ユーザIDが入力されているかチェック
        if (ObjectUtils.isEmpty(this.userId)) {
            // エラーメッセージを返却
            return "ユーザIDが入力されていません";
        }
        // ユーザPWが入力されているかチェック
        if (ObjectUtils.isEmpty(this.userPassword)) {
            // エラーメッセージを返却
            return "パスワードが入力されていません";
        }

        // ユーザ名が入力されているかチェック
        if (ObjectUtils.isEmpty(this.userName)) {
            // エラーメッセージを返却
            return "ユーザ名が入力されていません";
        }

        // メールアドレスが入力されているかチェック
        if (ObjectUtils.isEmpty(this.userMail)) {
            // エラーメッセージを返却
            return "メールアドレスが入力されていません";
        }

        // メールアドレスの構文チェック
        if (!ValidationUtil.emailValidation(this.userMail)) {
            // エラーメッセージを返却
            return "メールアドレスの入力値が不正です";
        }

        return null;
    }
}
