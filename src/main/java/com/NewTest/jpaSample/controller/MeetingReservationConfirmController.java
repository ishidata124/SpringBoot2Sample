package com.NewTest.jpaSample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.NewTest.jpaSample.form.MeetingReservationListForm;
import com.NewTest.jpaSample.service.MeetingReservationListService;

/**
 * 会議予約確認コントローラークラス
 *
 * @author john
 */
@Controller
public class MeetingReservationConfirmController {

    @Autowired
    MeetingReservationListService meetingReservationListService;

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
    @RequestMapping(value = "/jpa/MeetingReservationConfirm/View", method = RequestMethod.POST)
    public String show(MeetingReservationListForm form, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 画面表示するform情報の取得
        meetingReservationListService.getMeetingReservationForm(form);

        // セレクトボックス項目の設定
        model.addAllAttributes(meetingReservationListService.init());

        // 会議室予約確認画面へ遷移
        return "jpa/MeetingReservationConfirm";
    }

}