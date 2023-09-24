package com.NewTest.jpaSample.form;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.NewTest.jpaSample.constant.MeetingReservationConstant;
import com.NewTest.jpaSample.entity.MeetingReservationList;
import com.NewTest.jpaSample.utils.DateTimeUtil;

/**
 * 受け渡しする会議予約情報のためのクラス
 *
 * @author john
 */
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
     * 画面選択IDを取得します。
     *
     * @return 画面選択ID
     */
    public Integer getSelectedId() {
        return selectedId;
    }

    /**
     * 画面選択IDを設定します。
     *
     * @param selectedId 画面選択ID
     */
    public void setSelectedId(Integer selectedId) {
        this.selectedId = selectedId;
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
     * 予約開始日時(日)を取得します。
     *
     * @return 予約開始日時(日)
     */
    public String getMeetingStartDateD() {
        return meetingStartDateD;
    }

    /**
     * 予約開始日時(日)を設定します。
     *
     * @param meetingStartDateD 予約開始日時(日)
     */
    public void setMeetingStartDateD(String meetingStartDateD) {
        this.meetingStartDateD = meetingStartDateD;
    }

    /**
     * 予約開始日時(時)を取得します。
     *
     * @return 予約開始日時(時)
     */
    public String getMeetingStartDateH() {
        return meetingStartDateH;
    }

    /**
     * 予約開始日時(時)を設定します。
     *
     * @param meetingStartDateH 予約開始日時(時)
     */
    public void setMeetingStartDateH(String meetingStartDateH) {
        this.meetingStartDateH = meetingStartDateH;
    }

    /**
     * 予約開始日時(分)を取得します。
     *
     * @return 予約開始日時(分)
     */
    public String getMeetingStartDateM() {
        return meetingStartDateM;
    }

    /**
     * 予約開始日時(分)を設定します。
     *
     * @param meetingStartDateM 予約開始日時(分)
     */
    public void setMeetingStartDateM(String meetingStartDateM) {
        this.meetingStartDateM = meetingStartDateM;
    }

    /**
     * 予約終了日時(日)を取得します。
     *
     * @return 予約終了日時(日)
     */
    public String getMeetingEndDateD() {
        return meetingEndDateD;
    }

    /**
     * 予約終了日時(日)を設定します。
     *
     * @param meetingEndDateD 予約終了日時(日)
     */
    public void setMeetingEndDateD(String meetingEndDateD) {
        this.meetingEndDateD = meetingEndDateD;
    }

    /**
     * 予約終了日時(時)を取得します。
     *
     * @return 予約終了日時(時)
     */
    public String getMeetingEndDateH() {
        return meetingEndDateH;
    }

    /**
     * 予約終了日時(時)を設定します。
     *
     * @param meetingEndDateH 予約終了日時(時)
     */
    public void setMeetingEndDateH(String meetingEndDateH) {
        this.meetingEndDateH = meetingEndDateH;
    }

    /**
     * 予約終了日時(分)を取得します。
     *
     * @return 予約終了日時(分)
     */
    public String getMeetingEndDateM() {
        return meetingEndDateM;
    }

    /**
     * 予約終了日時(分)を設定します。
     *
     * @param meetingEndDateM 予約日時(分)
     */
    public void setMeetingEndDateM(String meetingEndDateM) {
        this.meetingEndDateM = meetingEndDateM;
    }

    /**
     * 備考を取得します。
     *
     * @return 備考
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 備考を設定します。
     *
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
     * 予約ステータス(画面表示用)を取得します。
     *
     * @return 予約ステータス(画面表示用)
     */
    public String getReservationStatusDisp() {
        return reservationStatusDisp;
    }

    /**
     * 予約ステータス(画面表示用)を設定します。
     *
     * @param reservationStatusDisp 予約ステータス(画面表示用)
     */
    public void setReservationStatusDisp(String reservationStatusDisp) {
        this.reservationStatusDisp = reservationStatusDisp;
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

    /**
     * 時間セレクトボックス項目（開始）を取得します。
     *
     * @return 時間セレクトボックス項目（開始）
     */
    public Map<String, String> getStartHourItems() {
        return startHourItems;
    }

    /**
     * 時間セレクトボックス項目（開始）を設定します。
     *
     * @param startHourItems 時間セレクトボックス項目（開始）
     */
    public void setStartHourItems(Map<String, String> startHourItems) {
        this.startHourItems = startHourItems;
    }

    /**
     * 時間セレクトボックス項目（開始）を取得します。
     *
     * @return 時間セレクトボックス項目（開始）
     */
    public Map<String, String> getEndHourItems() {
        return endHourItems;
    }

    /**
     * 時間セレクトボックス項目（開始）を設定します。
     *
     * @param endHourItems 時間セレクトボックス項目（開始）
     */
    public void setEndHourItems(Map<String, String> endHourItems) {
        this.endHourItems = endHourItems;
    }

    /**
     * 分セレクトボックス項目を取得します。
     *
     * @return 分セレクトボックス項目
     */
    public Map<String, String> getMinuteItems() {
        return minuteItems;
    }

    /**
     * 分セレクトボックス項目を設定します。
     *
     * @param minuteItems 分セレクトボックス項目
     */
    public void setMinuteItems(Map<String, String> minuteItems) {
        this.minuteItems = minuteItems;
    }

    /**
     * 使用開始日時を取得します。
     *
     * @return 使用開始日時
     */
    public Date getMeetingStartDate() {
        if (StringUtils.isEmpty(meetingStartDateD) || StringUtils.isEmpty(meetingStartDateH) ||
                StringUtils.isEmpty(meetingStartDateM)) {
            return null;
        }

        if (!DateTimeUtil.chkDate(meetingStartDateD)) {
            return null;
        }

        int dateH = -1;
        int dateM = -1;
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
        if (StringUtils.isEmpty(meetingEndDateD) || StringUtils.isEmpty(meetingEndDateH) ||
                StringUtils.isEmpty(meetingEndDateM)) {
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
     * @param meetingReservationList 会議室予約一覧情報
     */
    public void setMeetingReservationList(MeetingReservationList meetingReservationList) {

        this.setReservationId(meetingReservationList.getReservationId());
        this.setReservationName(meetingReservationList.getReservationName());
        this.setMeetingStartDate(meetingReservationList.getReservationStartDate());
        this.setMeetingEndDate(meetingReservationList.getReservationEndDate());
        this.setReservationStatus(meetingReservationList.getReservationStatus());
        // 画面表示用ステータスの設定
        this.setReservationStatusDisp(MeetingReservationConstant.getReservationStatusLabel(meetingReservationList.getReservationStatus().toString()));

        this.setRegistUser(meetingReservationList.getRegistUser());
        this.setRegistDate(meetingReservationList.getRegistDate());
    }

    /**
     * 会議予約情報リストを取得します。
     *
     * @return 会議予約情報リスト
     */
    public List<MeetingReservationListForm> getMeetingReservationFormList() {
        return meetingReservationFormList;
    }

    /**
     * 会議予約情報リストを設定します。
     *
     * @param meetingReservationFormList 会議予約情報リスト
     */
    public void setMeetingReservationFormList(List<MeetingReservationListForm> meetingReservationFormList) {
        this.meetingReservationFormList = meetingReservationFormList;
    }

    /**
     * 登録バリデーション
     *
     * @return エラーメッセージ
     */
    public String valid() {

        // 予約名が入力されているかチェック
        if (StringUtils.isEmpty(this.reservationName)) {
            // エラーメッセージを返却
            return "予約名が入力されていません";
        }

        // 登録者が入力されているかチェック
        if (StringUtils.isEmpty(this.registUser)) {
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
    public void copy(MeetingReservationList inMeetingReservationForm) {
        this.setReservationId(inMeetingReservationForm.getReservationId());
        this.setReservationName(inMeetingReservationForm.getReservationName());
        this.setMeetingStartDate(inMeetingReservationForm.getReservationStartDate());
        this.setMeetingEndDate(inMeetingReservationForm.getReservationEndDate());
        this.setReservationStatus(inMeetingReservationForm.getReservationStatus());
        this.setRemarks(inMeetingReservationForm.getRemarks());
        // 画面表示用ステータスの設定
        this.setReservationStatusDisp(MeetingReservationConstant
                .getReservationStatusLabel(inMeetingReservationForm.getReservationStatus().toString()));

        this.setRegistUser(inMeetingReservationForm.getRegistUser());
        this.setRegistDate(inMeetingReservationForm.getRegistDate());

    }
}
