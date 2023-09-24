package com.NewTest.jpaSample.form;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 共通Form親クラス
 * 認証用トークン、画面出力用メッセージを所有
 *
 * @author john
 */
@Getter
@Setter
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
