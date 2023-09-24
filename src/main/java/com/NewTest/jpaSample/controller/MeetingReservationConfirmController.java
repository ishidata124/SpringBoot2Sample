package com.NewTest.jpaSample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NewTest.jpaSample.constant.MeetingReservationConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.NewTest.jpaSample.form.MeetingReservationListForm;
import com.NewTest.jpaSample.service.MeetingReservationService;

/**
 * 会議予約確認コントローラークラス
 *
 * @author john
 */
@Controller
public class MeetingReservationConfirmController {
    /** ロガー */
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MeetingReservationService meetingReservationService;

    /**
     * 初期表示処理
     *
     * @param form 選択したID情報フォーム
     * @param model モデル
     * @param request リクエスト
     * @param response レスポンス
     * @return 会議室予約確認画面
     * @throws Exception 例外
     */
    // RequestMethod.POST でPOSTのみ受け取る
    @RequestMapping(value = MeetingReservationConstant.URL_MEETING_RESERVATION_CONFIRM_VIEW, method = RequestMethod.POST)
    public String show(MeetingReservationListForm form, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 画面表示するform情報の取得
        meetingReservationService.getMeetingReservationForm(form);

        // セレクトボックス項目の設定
        model.addAllAttributes(meetingReservationService.init());

        logger.info("会議室予約確認画面が表示されます。");

        // 会議室予約確認画面へ遷移
        return MeetingReservationConstant.PAGE_MEETING_RESERVATION_CONFIRM;
    }

}