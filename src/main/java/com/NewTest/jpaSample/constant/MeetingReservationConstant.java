package com.NewTest.jpaSample.constant;

/**
 * 定数クラス
 *
 * @author john
 */
public class MeetingReservationConstant {

    // Controllerへ ---------------------------------------------------------------------
    /** 会議予約一覧画面(初期表示) */
    public static final String URL_MEETING_RESERVATION_VIEW = "/MeetingReservation/MeetingReservationList/View";

    /** 会議予約登録画面(初期表示) */
    public static final String URL_MEETING_RESERVATION_REGIST_VIEW = "/MeetingReservation/MeetingReservationRegist/View";

    /** 会議予約登録画面(登録) */
    public static final String URL_MEETING_RESERVATION_REGIST_RAGISTER = "/MeetingReservation/MeetingReservationRegist/Register";

    /** 会議予約確認画面(初期表示) */
    public static final String URL_MEETING_RESERVATION_CONFIRM_VIEW = "/MeetingReservation/MeetingReservationConfirm/View";

    // htmlへ ---------------------------------------------------------------------

    /** 会議予約リスト一覧画面(画面パス) */
    public static final String PAGE_MEETING_RESERVATION_LIST = "MeetingReservation/MeetingReservationList";

    /** 会議予約新規登録画面(画面パス) */
    public static final String PAGE_MEETING_RESERVATION_REGIST = "MeetingReservation/MeetingReservationRegist";

    /** 会議予約確認画面(画面パス) */
    public static final String PAGE_MEETING_RESERVATION_CONFIRM = "MeetingReservation/MeetingReservationConfirm";

    // 文字定数 ----------------------------------------------------------------------

    /** ブランク */
    public static final String BLANK = "";

    /** 1：予約中 */
    public static final String RESERVED = "1";

    /** 2：編集中 */
    public static final String EDITING = "2";

    /** 3：キャンセル */
    public static final String CANCEL = "3";

    /** ラベル：予約中 */
    public static final String LABEL_RESERVED = "予約中";

    /** ラベル：編集中 */
    public static final String LABEL_EDITING = "編集中";

    /** ラベル：キャンセル */
    public static final String LABEL_CANCEL = "キャンセル";

    // Key文字定数 ----------------------------------------------------------------------

    /** meetingReservationListFormのKey定数 */
    public static final String MEETING_RESERVATION_LIST_FORM = "meetingReservationListForm";

    /** reservationStatusItemsのKey定数 */
    public static final String RESERVATION_STATUS_ITEMS = "reservationStatusItems";

}
