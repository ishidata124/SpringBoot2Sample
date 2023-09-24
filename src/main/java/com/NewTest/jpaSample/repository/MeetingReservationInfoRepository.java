package com.NewTest.jpaSample.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.NewTest.jpaSample.entity.MeetingReservationInfo;
import com.NewTest.jpaSample.entity.MeetingReservationInfoKey;

/**
 * データベースへ繋ぐためのリポジトリ
 *
 * @author john
 */
// リポジトリのアノテーションを宣言
@Repository
public interface MeetingReservationInfoRepository extends JpaRepository<MeetingReservationInfo, MeetingReservationInfoKey> {

    /**
     * 画面表示する会議室予約リスト情報を全て取得する。
     *
     * @return 会議室予約リスト情報
     */
    @Query(value = "SELECT * FROM meeting_reservation_info "
            , nativeQuery = true)
    List<MeetingReservationInfo> findMeetingReservationAllList();

    /**
     * @param reservationName 予約名
     * @param meetingStartDate 予約開始日時
     * @param nowDate 現在日時
     * @param meetingEndDate 予約終了日時
     * @param remarks 備考
     * @param registUser 登録者名
     */
    // insertやupdate等テーブルの中身を変えるときには @Modifying と @Transactionalが必要
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO meeting_reservation_info (reservation_name , reservation_start_date, reservation_end_date,"
            + " remarks, regist_user, regist_date, reservation_status) VALUES (:reservationName, :meetingStartDate,"
            + " :meetingEndDate, :remarks, :registUser, :nowDate , 1)", nativeQuery = true)
    void saveMeetingReservation(@Param("reservationName") String reservationName, @Param("meetingStartDate") Date meetingStartDate,
            @Param("meetingEndDate") Date meetingEndDate, @Param("remarks") String remarks, @Param("registUser") String registUser,
            @Param("nowDate") Date nowDate);

    /**
     * @param selectedId 選択ID
     * @return 選択IDに紐づく会議室予約情報
     */
    @Query(value = "SELECT * FROM meeting_reservation_info where reservation_id = :selectedId"
            , nativeQuery = true)
    MeetingReservationInfo selectMeetingReservationForm(@Param("selectedId") Integer selectedId);
}

/*
 * SAMPLE SQL
 *
 * テーブル削除
 * DROP TABLE meeting_reservation_info;
 *
 * テーブル作成
 * CREATE TABLE meeting_reservation_info (reservation_id INT AUTO_INCREMENT PRIMARY KEY, reservation_name VARCHAR(50),
 * reservation_start_date DATETIME, reservation_end_date DATETIME, remarks VARCHAR(500), reservation_status INT,
 * regist_user VARCHAR(20), regist_date DATETIME, invalid_flg BOOLEAN) DEFAULT CHARSET=utf8;
 *
 * テーブルの内容
 * reservation_id = 予約ID reservation_name = 予約名 reservation_start_date = 使用開始日時 reservation_end_date = 使用終了日時
 * remarks = 備考 reservation_status = 予約ステータス regist_user = 登録者名 regist_date = 登録日 invalid_flg = 無効フラグ
 * テーブルの中身のみ全部削除
 * TRUNCATE TABLE meeting_reservation_info;
 *
 * カラム(列)追加
 * ALTER TABLE meeting_reservation_info ADD PhoneNumber VARCHAR(20) NULL;
 *
 * カラム(列)削除
 * ALTER TABLE meeting_reservation_info DROP COLUMN PhoneNumber;
 *
 * 検索
 * SELECT * FROM meeting_reservation_info;
 *
 * 挿入
 * INSERT INTO meeting_reservation_info (reservation_name) VALUES ('1234');
 *
 * 更新
 * UPDATE meeting_reservation_info SET regist_date = 登録したい日付 where reservation_id = ID番号;
 *
 * 削除
 * DELETE FROM meeting_reservation_info WHERE reservation_id = ID番号;
 */
