package com.NewTest.jpaSample.controller;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.NewTest.jpaSample.constant.MeetingReservationConstant;
import com.NewTest.jpaSample.form.MeetingReservationListForm;
import com.NewTest.jpaSample.service.MeetingReservationListService;

/**
 * 会議予約一覧コントローラークラス
 * http://localhost:8080/jpa/MeetingReservationListを打つと遷移
 *
 * @author john
 */
// コントローラークラスとしてのアノテーション宣言
@Controller
@EnableAutoConfiguration
public class MeetingReservationListController {

    // 別のクラスを使用するためここで呼び出し可能にするための処理(インスタンス化)
    @Autowired
    MeetingReservationListService meetingReservationListService;

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
    // method = RequestMethod.POST POSTのみ受け取る 両方ともなら書かない(セキュリティに問題あるので基本書く)
    @RequestMapping(value = MeetingReservationConstant.URL_MEETINGRESERVATION_VIEW)
    public String show(MeetingReservationListForm form, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // フォームを設定(Map情報)
        model.addAllAttributes(this.init());

        // 会議予約一覧画面へ遷移
        return MeetingReservationConstant.PAGE_MEETINGRESERVATIONLIST;
    }

    /**
     * サービスクラス → リポジトリクラスに繋がり、データベースよりデータ取得している
     *
     * @return フォーム情報(Map)
     */
    private Map<String, Object> init() {

        // 返却する入れ物(Map生成)
        Map<String, Object> meetingReservationListMap = new Hashtable<String, Object>();

        // サービスクラスよりフォーム情報取得
        MeetingReservationListForm meetingReservationList = meetingReservationListService.initForm();

        // meetingReservationListForm(Key)に対してフォーム情報(value)を設定
        meetingReservationListMap.put(MeetingReservationConstant.MEETINGRESERVATIONLISTFORM, meetingReservationList);

        return meetingReservationListMap;
    }

}
