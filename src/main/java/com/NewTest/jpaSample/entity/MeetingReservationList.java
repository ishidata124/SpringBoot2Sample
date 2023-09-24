package com.NewTest.jpaSample.entity;

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
@Entity
@Table(name = "reservation_list_info")
@IdClass(value = MeetingReservationListKey.class)
public class MeetingReservationList {

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

    /**
     * 予約名を取得します。
     *
     * @return 予約名
     */
    public String getReservationName() {
        return reservationName;
    }

    /**
     * 予約名を設定します。
     *
     * @param reservationName 予約名
     */
    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    /**
     * 予約開始時間を取得します。
     *
     * @return 予約開始時間
     */
    public Date getReservationStartDate() {
        return reservationStartDate;
    }

    /**
     * 予約開始時間を設定します。
     *
     * @param reservationStartDate 予約開始時間
     */
    public void setReservationStartDate(Date reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    /**
     * 予約終了時間を取得します。
     *
     * @return 予約終了時間
     */
    public Date getReservationEndDate() {
        return reservationEndDate;
    }

    /**
     * 予約終了時間を設定します。
     *
     * @param reservationEndDate 予約終了時間
     */
    public void setReservationEndDate(Date reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 備考を設定します。
     * @param remarks 備考
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 予約ステータスを取得します。
     *
     * @return 予約ステータス
     */
    public Integer getReservationStatus() {
        return reservationStatus;
    }

    /**
     * 予約ステータスを設定します。
     *
     * @param reservationStatus 予約ステータス
     */
    public void setReservationStatus(Integer reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    /**
     * 登録者を取得します。
     *
     * @return 登録者
     */
    public String getRegistUser() {
        return registUser;
    }

    /**
     * 登録者を設定します。
     *
     * @param registUser 登録者
     */
    public void setRegistUser(String registUser) {
        this.registUser = registUser;
    }

    /**
     * 登録日時を取得します。
     *
     * @return 登録日時
     */
    public Date getRegistDate() {
        return registDate;
    }

    /**
     * 登録日時を設定します。
     *
     * @param registDate 登録日時
     */
    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }
}

/*
 * SQLは MeetingReservationListRepository クラスに記載
 */