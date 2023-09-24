package com.NewTest.myBatisSample.form;

import lombok.Data;

import java.util.List;

/**
 * 共通Form親クラス
 * 認証用トークン、画面出力用メッセージを所有
 *
 * @author john
 */
@Data
public class FormBase {

    /** トークン */
    private String token;

    /** エラーメッセージ */
    private String singleErrMsg;

    /** フッターのエラーメッセージリスト */
    private List<String> footErrMsgList;

    /** ダイアログのエラーメッセージ */
    private String dialogueErrMsg;

    /** ダイアログのメッセージ */
    private String dialogueMsg;

    /** ダイアログの完了メッセージ */
    private String dialogueCompMsg;
}
