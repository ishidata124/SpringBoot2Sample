package com.NewTest.jpaSample.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * エンティティの主キークラス
 *
 * @author john
 */
@Data
public class MeetingReservationInfoKey implements Serializable {

    /** 予約ID */
    private Integer reservationId;

}
