package com.NewTest.jpaSample.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NewTest.jpaSample.entity.MeetingReservationList;
import com.NewTest.jpaSample.form.MeetingReservationListForm;
import com.NewTest.jpaSample.repository.MeetingReservationListRepository;
import com.NewTest.jpaSample.utils.SelectItemsUtil;

/**
 * コントローラークラスとリポジトリのクラスで処理をするクラス
 *
 * @author john
 */
// サービスクラスのアノテーションを宣言
@Service
public class MeetingReservationListService {

    @Autowired
    MeetingReservationListRepository meetingReservationListRepository;

    /**
     * フォーム情報の取得(データベースに登録されているもの全て)
     *
     * @return 会議予約情報一覧
     */
    public MeetingReservationListForm initForm() {
        // リポジトリから取得
        List<MeetingReservationList> meetingReservationlist = meetingReservationListRepository.findMeetingReservationAllList();

        // 入れ物が違うためリポジトリから取得したものを移す作業(List)
        List<MeetingReservationListForm> meetingReservationListForm = new ArrayList<MeetingReservationListForm>();

        // 拡張for文で1つずつ取り出し
        for (MeetingReservationList meetingList : meetingReservationlist) {

            // 移し先の作成
            MeetingReservationListForm form = new MeetingReservationListForm();

            // 移して
            form.setMeetingReservationList(meetingList);

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
        meetingReservationListRepository.saveMeetingReservation(form.getReservationName(), form.getMeetingStartDate(),
                form.getMeetingEndDate(), form.getRemarks(), form.getRegistUser(), new Date());

    }

    /**
     * 画面表示用情報設定
     *
     * @return 画面表示用情報
     */
    public Map<String, Object> init() {
        Map<String, Object> result = new Hashtable<String, Object>();

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
        MeetingReservationList inMeetingReservationForm = meetingReservationListRepository.selectMeetingReservationForm(form.getSelectedId());

        // 取得した値をフォームにセットする
        form.copy(inMeetingReservationForm);

    }
}
