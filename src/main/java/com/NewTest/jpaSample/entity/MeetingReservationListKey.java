package com.NewTest.jpaSample.entity;

import java.io.Serializable;

/**
 * エンティティの主キークラス
 *
 * @author john
 */
public class MeetingReservationListKey implements Serializable {

    /** 予約ID */
    private Integer reservationId;

    /**
     * 予約IDを取得します。
     *
     * @return 予約ID
     */
    public Integer getReservationId() {
        return reservationId;
    }

    /**
     * 予約IDを設定します。
     *
     * @param reservationId 予約ID
     */
    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

}
