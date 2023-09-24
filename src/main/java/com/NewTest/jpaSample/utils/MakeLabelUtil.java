package com.NewTest.jpaSample.utils;

import com.NewTest.jpaSample.constant.MeetingReservationConstant;

/**
 * ラベル作成Utilクラス
 *
 * @author john
 */
public class MakeLabelUtil {
    /**
     * 予約ステータスラベルを取得
     *
     * @param status 予約ステータス番号
     * @return 予約ステータス番号に対応したラベル
     */
    public static String getReservationStatusLabel(String status) {
        String label;

        switch (status) {
            case MeetingReservationConstant.RESERVED:
                label = MeetingReservationConstant.LABEL_RESERVED;
                break;
            case MeetingReservationConstant.EDITING:
                label = MeetingReservationConstant.LABEL_EDITING;
                break;
            case MeetingReservationConstant.CANCEL:
                label = MeetingReservationConstant.LABEL_CANCEL;
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
