package com.NewTest.jpaSample.controller;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NewTest.jpaSample.utils.SelectItemsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.NewTest.jpaSample.constant.MeetingReservationConstant;
import com.NewTest.jpaSample.form.MeetingReservationListForm;
import com.NewTest.jpaSample.service.MeetingReservationService;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 会議予約一覧コントローラークラス
 * http://localhost:8080/MeetingReservation/MeetingReservationListを打つと遷移
 *
 * @author john
 */
// コントローラークラスとしてのアノテーション宣言
@Controller
@EnableAutoConfiguration
public class MeetingReservationListController {

    /** ロガー */
    Logger logger = LoggerFactory.getLogger(getClass());

    // 別のクラスを使用するためここで呼び出し可能にするための処理(インスタンス化)
    @Autowired
    MeetingReservationService meetingReservationService;

    /**
     * 初期表示処理
     *
     * @param form 特に情報は入ってこない
     * @param model モデル
     * @param request リクエスト
     * @param response レスポンス
     * @return 会議室予約一覧画面
     * @throws Exception 例外
     */
    // @RequestMapping の value = について
    // method = RequestMethod.GET でGETのみ受け取る
    // method = RequestMethod.POST POSTのみ受け取る 両方ともなら書かない
    @RequestMapping(value = MeetingReservationConstant.URL_MEETING_RESERVATION_VIEW)
    public String show(MeetingReservationListForm form, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // フォームを設定(Map情報)
        model.addAllAttributes(this.init());

        logger.info("会議室一覧画面が表示されます。");

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

        // 検索で使用する予約ステータス設定
        meetingReservationListMap.put(MeetingReservationConstant.RESERVATION_STATUS_ITEMS, SelectItemsUtil.RESERVATION_STATUS_ITEMS);

        return meetingReservationListMap;
    }

}
