package com.NewTest.jpaSample.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NewTest.jpaSample.entity.MeetingReservationInfo;
import com.NewTest.jpaSample.form.MeetingReservationListForm;
import com.NewTest.jpaSample.repository.MeetingReservationInfoRepository;
import com.NewTest.jpaSample.utils.SelectItemsUtil;

/**
 * コントローラークラスとリポジトリのクラスの間で処理をするクラス
 *
 * @author john
 */
// サービスクラスのアノテーションを宣言
@Service
public class MeetingReservationService {

    /** ロガー */
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MeetingReservationInfoRepository meetingReservationInfoRepository;

    /**
     * フォーム情報の取得(データベースに登録されているもの全て)
     *
     * @return 会議予約情報一覧
     */
    public MeetingReservationListForm initForm() {
        // リポジトリから取得
        List<MeetingReservationInfo> meetingReservationlist = meetingReservationInfoRepository.findMeetingReservationAllList();

        // 入れ物が違うためリポジトリから取得したものを移す作業(List)
        List<MeetingReservationListForm> meetingReservationListForm = new ArrayList<>();

        // 拡張for文で1つずつ取り出し
        for (MeetingReservationInfo meetingList : meetingReservationlist) {

            // 移し先の作成
            MeetingReservationListForm form = new MeetingReservationListForm();

            // 移して
            form.setMeetingReservationList(meetingList);

            logger.info("meetingList " + meetingList);

            // リストへ入れる
            meetingReservationListForm.add(form);
        }

        // フォーム生成
        MeetingReservationListForm formList = new MeetingReservationListForm();

        // フォームの中に作成したリスト(画面に表示するもの)を入れる
        formList.setMeetingReservationFormList(meetingReservationListForm);

        // それを返却
        return formList;
    }

    /**
     * フォーム情報の新規登録(画面入力値)
     *
     * @param form 画面入力値
     */
    public void insertMeetingReservation(MeetingReservationListForm form) {

        // リポジトリにパラメータ渡し
        meetingReservationInfoRepository.saveMeetingReservation(form.getReservationName(), form.getMeetingStartDate(),
                form.getMeetingEndDate(), form.getRemarks(), form.getRegistUser(), new Date());

    }

    /**
     * 画面表示用情報設定
     *
     * @return 画面表示用情報
     */
    public Map<String, Object> init() {
        Map<String, Object> result = new Hashtable<>();

        // 開始時間セレクトボックス項目
        result.put("startHourItems", SelectItemsUtil.START_HOUR_ITEMS);
        // 終了時間セレクトボックス項目
        result.put("endHourItems", SelectItemsUtil.END_HOUR_ITEMS);

        // 分セレクトボックス項目
        result.put("minuteItems", SelectItemsUtil.PER_10_MINUTES_ITEMS);

        return result;
    }

    /**
     * 確認画面表示用情報設定
     *
     * @param form 選択ID所持フォーム
     */
    public void getMeetingReservationForm(MeetingReservationListForm form) {

        // リポジトリからIDに紐づく情報を取得
        MeetingReservationInfo inMeetingReservationForm = meetingReservationInfoRepository.selectMeetingReservationForm(form.getSelectedId());

        // 取得した値をフォームにセットする
        form.copy(inMeetingReservationForm);

    }
}
