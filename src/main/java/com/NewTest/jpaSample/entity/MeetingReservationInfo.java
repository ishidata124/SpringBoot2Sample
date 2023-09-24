package com.NewTest.jpaSample.entity;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * エンティティクラス(データベースから受け取るクラス)
 *
 * @author john
 */
@Data
@Entity
@Table(name = "meeting_reservation_info")
@IdClass(value = MeetingReservationInfoKey.class)
public class MeetingReservationInfo {

    /** 予約ID */
    @Id
    @Column(name = "reservation_id")
    private Integer reservationId;

    /** 予約名 */
    @Column(name = "reservation_name")
    private String reservationName;

    /** 予約開始時間 */
    @Column(name = "reservation_start_date")
    private Date reservationStartDate;

    /** 予約終了時間 */
    @Column(name = "reservation_end_date")
    private Date reservationEndDate;

    /** 備考 */
    @Column(name = "remarks")
    private String remarks;

    /** 予約ステータス */
    @Column(name = "reservation_status")
    private Integer reservationStatus;

    /** 登録者 */
    @Column(name = "regist_user")
    private String registUser;

    /** 登録日時 */
    @Column(name = "regist_date")
    private Date registDate;
}

/*
 * SQLは MeetingReservationListRepository クラスに記載
 */