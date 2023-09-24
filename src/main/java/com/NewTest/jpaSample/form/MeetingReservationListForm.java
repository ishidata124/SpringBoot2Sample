package com.NewTest.jpaSample.form;

import com.NewTest.jpaSample.constant.MeetingReservationConstant;
import com.NewTest.jpaSample.entity.MeetingReservationInfo;
import com.NewTest.jpaSample.utils.DateTimeUtil;
import com.NewTest.jpaSample.utils.MakeLabelUtil;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 会議予約情報フォーム
 *
 * @author john
 */
@Data
public class MeetingReservationListForm extends FormBase implements Serializable {
    /** Form名 */
    public static final String FORM_NAME = "meetingReservationListForm";

    /** 予約ID */
    private Integer reservationId;

    /** 画面選択ID */
    private Integer selectedId;

    /** 予約名 */
    private String reservationName;

    /** 予約開始日時(日) */
    private String meetingStartDateD;

    /** 予約開始日時(時) */
    private String meetingStartDateH;

    /** 予約開始日時(分) */
    private String meetingStartDateM;

    /** 予約終了日時(日) */
    private String meetingEndDateD;

    /** 予約終了日時(時) */
    private String meetingEndDateH;

    /** 予約終了日時(分) */
    private String meetingEndDateM;

    /** 備考 */
    private String remarks;

    /** 予約ステータス */
    private Integer reservationStatus;

    /** 予約ステータス(画面表示用) */
    private String reservationStatusDisp;

    /** 登録者 */
    private String registUser;

    /** 登録日時 */
    private Date registDate;

    /** 時間セレクトボックス項目（開始） */
    private Map<String, String> startHourItems;

    /** 時間セレクトボックス項目（開始） */
    private Map<String, String> endHourItems;

    /** 分セレクトボックス項目 */
    private Map<String, String> minuteItems;

    /** 会議予約情報リスト */
    private List<MeetingReservationListForm> meetingReservationFormList;

    /** 予約ステータスセレクトボックス項目 */
    private Map<String, String> reservationStatusItems;

    /**
     * 使用開始日時を取得します。
     *
     * @return 使用開始日時
     */
    public Date getMeetingStartDate() {
        if (ObjectUtils.isEmpty(meetingStartDateD) || ObjectUtils.isEmpty(meetingStartDateH) ||
                ObjectUtils.isEmpty(meetingStartDateM)) {
            return null;
        }

        if (!DateTimeUtil.chkDate(meetingStartDateD)) {
            return null;
        }

        int dateH;
        int dateM;
        try {
            dateH = Integer.parseInt(meetingStartDateH);
            dateM = Integer.parseInt(meetingStartDateM);
        } catch (NumberFormatException ex) {
            return null;
        }

        return DateTimeUtil.toDate(meetingStartDateD, dateH, dateM);
    }

    /**
     * 使用開始日時を設定します。
     *
     * @param meetingStartDate 使用開始日時
     */
    public void setMeetingStartDate(Date meetingStartDate) {
        if (meetingStartDate == null) {
            this.meetingStartDateD = null;
            this.meetingStartDateH = null;
            this.meetingStartDateM = null;
        } else {
            LocalDateTime datetime = LocalDateTime.ofInstant(meetingStartDate.toInstant(), ZoneId.systemDefault());
            DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            DateTimeFormatter formatterH = DateTimeFormatter.ofPattern("HH");
            DateTimeFormatter formatterM = DateTimeFormatter.ofPattern("mm");

            this.meetingStartDateD = datetime.format(formatterD);
            this.meetingStartDateH = datetime.format(formatterH);
            this.meetingStartDateM = datetime.format(formatterM);
        }
    }

    /**
     * 使用終了日時を取得します。
     *
     * @return 使用終了日時
     */
    public Date getMeetingEndDate() {
        if (ObjectUtils.isEmpty(meetingEndDateD) || ObjectUtils.isEmpty(meetingEndDateH) ||
                ObjectUtils.isEmpty(meetingEndDateM)) {
            return null;
        }

        if (!DateTimeUtil.chkDate(meetingEndDateD)) {
            return null;
        }

        int dateH = -1;
        int dateM = -1;
        try {
            dateH = Integer.parseInt(meetingEndDateH);
            dateM = Integer.parseInt(meetingEndDateM);
        } catch (NumberFormatException ex) {
            return null;
        }

        return DateTimeUtil.toDate(meetingEndDateD, dateH, dateM);
    }

    /**
     * 使用終了日時を設定します。
     *
     * @param meetingEndDate 使用終了日時
     */
    public void setMeetingEndDate(Date meetingEndDate) {
        if (meetingEndDate == null) {
            this.meetingEndDateD = null;
            this.meetingEndDateH = null;
            this.meetingEndDateM = null;
        } else {
            LocalDateTime datetime = LocalDateTime.ofInstant(meetingEndDate.toInstant(), ZoneId.systemDefault());
            DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            DateTimeFormatter formatterH = DateTimeFormatter.ofPattern("HH");
            DateTimeFormatter formatterM = DateTimeFormatter.ofPattern("mm");

            this.meetingEndDateD = datetime.format(formatterD);
            this.meetingEndDateH = datetime.format(formatterH);
            this.meetingEndDateM = datetime.format(formatterM);
        }
    }

    /**
     * 会議室予約一覧情報を設定します。
     *
     * @param meetingReservationInfo 会議室予約一覧情報
     */
    public void setMeetingReservationList(MeetingReservationInfo meetingReservationInfo) {
        this.setReservationId(meetingReservationInfo.getReservationId());
        this.setReservationName(meetingReservationInfo.getReservationName());
        this.setMeetingStartDate(meetingReservationInfo.getReservationStartDate());
        this.setMeetingEndDate(meetingReservationInfo.getReservationEndDate());
        this.setReservationStatus(meetingReservationInfo.getReservationStatus());
        this.setRegistUser(meetingReservationInfo.getRegistUser());
        this.setRegistDate(meetingReservationInfo.getRegistDate());

        // 画面表示用ステータスの設定
        this.setReservationStatusDisp(MakeLabelUtil.getReservationStatusLabel(meetingReservationInfo.getReservationStatus().toString()));
    }

    /**
     * 登録バリデーション
     *
     * @return エラーメッセージ
     */
    public String valid() {

        // 予約名が入力されているかチェック
        if (ObjectUtils.isEmpty(this.reservationName)) {
            // エラーメッセージを返却
            return "予約名が入力されていません";
        }

        // 登録者が入力されているかチェック
        if (ObjectUtils.isEmpty(this.registUser)) {
            // エラーメッセージを返却
            return "登録者が入力されていません";
        }

        return null;
    }

    /**
     * 確認画面表示用情報セット
     *
     * @param inMeetingReservationForm データベース取得フォーム情報
     */
    public void copy(MeetingReservationInfo inMeetingReservationForm) {
        this.setReservationId(inMeetingReservationForm.getReservationId());
        this.setReservationName(inMeetingReservationForm.getReservationName());
        this.setMeetingStartDate(inMeetingReservationForm.getReservationStartDate());
        this.setMeetingEndDate(inMeetingReservationForm.getReservationEndDate());
        this.setReservationStatus(inMeetingReservationForm.getReservationStatus());
        this.setRemarks(inMeetingReservationForm.getRemarks());
        this.setRegistUser(inMeetingReservationForm.getRegistUser());
        this.setRegistDate(inMeetingReservationForm.getRegistDate());

        // 画面表示用ステータスの設定
        this.setReservationStatusDisp(MakeLabelUtil
                .getReservationStatusLabel(inMeetingReservationForm.getReservationStatus().toString()));
    }
}
