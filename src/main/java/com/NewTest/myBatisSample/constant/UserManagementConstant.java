package com.NewTest.myBatisSample.constant;

public class UserManagementConstant {

    // Controllerへ ---------------------------------------------------------------------
    /** ユーザ一覧画面(初期表示) */
    public static final String URL_USER_LIST_VIEW = "/UserManagement/UserList/View";

    /** ユーザ登録画面(初期表示) */
    public static final String URL_USER_REGIST_VIEW = "/UserManagement/UserRegist/View";

    /** ユーザ登録画面(登録) */
    public static final String URL_USER_REGIST_RAGISTER  = "/UserManagement/UserRegist/Register";

    /** ユーザ確認画面(初期表示) */
    public static final String URL_USER_CONFIRM_VIEW = "/UserManagement/UserConfirm/View";

    // htmlへ ---------------------------------------------------------------------

    /** ユーザ一覧画面(画面パス) */
    public static final String PAGE_USER_LIST = "UserManagement/UserList";

    /** ユーザ新規登録画面(画面パス) */
    public static final String PAGE_USER_REGIST = "UserManagement/UserRegist";

    /** ユーザ確認画面(画面パス) */
    public static final String PAGE_USER_CONFIRM = "UserManagement/UserConfirm";

    // 文字定数 ----------------------------------------------------------------------
    /** ブランク */
    public static final String BLANK = "";

    /** 0：未ログイン */
    public static final String UNUSED = "0";

    /** 1：管理者 */
    public static final String ADMIN = "1";

    /** 2：一般 */
    public static final String ORDINARY = "2";

    /** 3：PW期限切れ */
    public static final String PW_EXPIRATION = "3";

    /** 4：無効 */
    public static final String INVALID = "4";

    /** ラベル：未ログイン */
    public static final String LABEL_UNUSED = "未ログイン";

    /** ラベル：管理者 */
    public static final String LABEL_ADMIN = "管理者";

    /** ラベル：一般 */
    public static final String LABEL_ORDINARY = "一般";

    /** ラベル：PW期限切れ */
    public static final String LABEL_PW_EXPIRATION = "PW期限切れ";

    /** ラベル：無効 */
    public static final String LABEL_INVALID = "無効";

    // Key文字定数 ----------------------------------------------------------------------

    /** UserListFormのKey定数 */
    public static final String USER_LIST_FORM = "userListForm";

    /** userStatusItemsのKey定数 */
    public static final String USER_STATUS_ITEMS = "userStatusItems";

    // エラーメッセージ ----------------------------------------------------------------------

    /** ユーザID重複時メッセージ */
    public static final String ERR_MSG_USER_ID_NOT_AVAILABLE = "そのユーザIDは使用できません。";

    /** ユーザアドレス重複時メッセージ */
    public static final String ERR_MSG_USER_ADDRESS_NOT_AVAILABLE = "そのメールアドレスは使用できません。";
}
