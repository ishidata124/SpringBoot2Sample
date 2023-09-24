package com.NewTest.jpaSample.constant;

/**
 * 定数クラス
 *
 * @author john
 */
public class MeetingReservationConstant {

    // Controllerへ ---------------------------------------------------------------------
    /** 会議予約一覧画面(初期表示) */
    public static final String URL_MEETINGRESERVATION_VIEW = "/jpa/MeetingReservationList";

    /** 会議予約登録画面(初期表示) */
    public static final String URL_MEETINGRESERVATIONREGIST_VIEW = "/jpa/MeetingReservationRegist/View";

    // htmlへ ---------------------------------------------------------------------

    /** 会議予約リスト一覧画面(画面パス) */
    public static final String PAGE_MEETINGRESERVATIONLIST = "jpa/MeetingReservationList";

    /** 会議予約新規登録画面(画面パス) */
    public static final String PAGE_MEETINGRESERVATIONREGIST = "jpa/MeetingReservationRegist";

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
    public static final String MEETINGRESERVATIONLISTFORM = "meetingReservationListForm";

    // ラベル作成 ----------------------------------------------------------------------

    /**
     * 予約ステータスラベルを取得
     *
     * @param status 予約ステータス番号
     * @return 予約ステータス番号に対応したラベル
     */
    public static String getReservationStatusLabel(String status) {
        String label = null;

        switch (status) {
            case RESERVED:
                label = LABEL_RESERVED;
                break;
            case EDITING:
                label = LABEL_EDITING;
                break;
            case CANCEL:
                label = LABEL_CANCEL;
                break;
            case MeetingReservationConstant.BLANK:
                label = MeetingReservationConstant.BLANK;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return label;
    }
}
