package com.NewTest.jpaSample.controller;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.NewTest.jpaSample.constant.MeetingReservationConstant;
import com.NewTest.jpaSample.form.MeetingReservationListForm;
import com.NewTest.jpaSample.service.MeetingReservationService;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 会議室新規予約コントローラー
 *
 * @author john
 */
@Controller
public class MeetingReservationRegistController {
    /** ロガー */
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MeetingReservationService meetingReservationService;

    /**
     * 初期表示処理
     *
     * @param form 特に情報は入ってこない
     * @param model モデル
     * @param request リクエスト
     * @param response レスポンス
     * @return 会議室新規予約画面
     * @throws Exception 例外
     */
    @RequestMapping(value = MeetingReservationConstant.URL_MEETING_RESERVATION_REGIST_VIEW, method = RequestMethod.POST)
    public String show(MeetingReservationListForm form, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // セレクトボックス項目の設定
        model.addAllAttributes(meetingReservationService.init());

        logger.info("会議室新規予約画面が表示されます。");

        // 会議室新規予約画面へ遷移
        return MeetingReservationConstant.PAGE_MEETING_RESERVATION_REGIST;
    }

    /**
     * 予約ボタン押したときの処理
     *
     * @param form 画面入力値
     * @param model モデル
     * @param request リクエスト
     * @param response レスポンス
     * @return 会議予約一覧画面
     * @throws Exception 例外
     */
    @RequestMapping(value = MeetingReservationConstant.URL_MEETING_RESERVATION_REGIST_RAGISTER, method = RequestMethod.POST)
    public String Register(MeetingReservationListForm form, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 登録用バリデーション
        String errMsg = form.valid();
        if (null != errMsg) {

            // ダイアログにエラーメッセージを設定
            form.setDialogueErrMsg(errMsg);

            // セレクトボックス項目の設定(日付)
            model.addAllAttributes(meetingReservationService.init());

            // 会議室新規予約画面へ遷移
            return MeetingReservationConstant.PAGE_MEETING_RESERVATION_REGIST;
        }

        // データベースに登録するためにサービスクラスにフォームを渡す
        meetingReservationService.insertMeetingReservation(form);

        // モデルを設定(Map情報)
        model.addAllAttributes(this.init());

        logger.info("会議室予約一覧画面が表示されます。");

        // 会議予約一覧画面へ遷移
        return MeetingReservationConstant.PAGE_MEETING_RESERVATION_LIST;
    }

    /**
     * サービスクラス → リポジトリクラスに繋がり、データベースよりデータ取得している
     *
     * @return フォーム情報(Map)
     */
    private Map<String, Object> init() {

        // 返却する入れ物(Map生成)
        Map<String, Object> meetingReservationListMap = new Hashtable<>();

        // サービスクラスよりフォーム情報取得
        MeetingReservationListForm meetingReservationList = meetingReservationService.initForm();

        // meetingReservationListForm(Key)に対してフォーム情報(value)を設定
        meetingReservationListMap.put(MeetingReservationConstant.MEETING_RESERVATION_LIST_FORM, meetingReservationList);

        return meetingReservationListMap;
    }

}
