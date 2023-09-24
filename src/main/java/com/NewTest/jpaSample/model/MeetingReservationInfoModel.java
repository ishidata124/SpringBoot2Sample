package com.NewTest.jpaSample.model;

import lombok.Data;

import java.util.Date;

/**
 * 会議予約情報モデル
 *
 * @author john
 */
@Data
public class MeetingReservationInfoModel {

    /** 予約ID */
    private Integer reservationId;

    /** 予約名 */
    private String reservationName;

    /** 予約開始時間 */
    private Date reservationStartDate;

    /** 予約終了時間 */
    private Date reservationEndDate;

    /** 予約ステータス */
    private Integer reservationStatus;

    /** 予約ステータス(画面表示用) */
    private String reservationStatusDisp;

    /** 登録者 */
    private String registUser;

    /** 登録日時 */
    private Date registDate;

    /** 予約 */
    private Boolean reservation;

    /** キャンセル */
    private Boolean cancel;

}
