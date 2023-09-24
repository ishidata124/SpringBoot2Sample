package com.NewTest.dbNone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.NewTest.dbNone.constant.DbNoneConstant;

/**
 * タイムリーフ、jpa無しサンプル用コントローラークラス
 * 使用方法：http://localhost:8080/dbNone/listを打つと遷移
 * 説明：http://localhost:8080/dbNone/○○でアクセス
 *
 * @author john
 */
@Controller
@RequestMapping(value = "/dbNone")
public class DbNoneMeetingReservationListController {

    /**
     * 上記クラスの下の○○が/listでアクセス
     *
     * @return ディレクトリのresources/templtes の下の /dbNone/MeetingReservationListに接続
     */
    @RequestMapping(value = "/list")
    public String view() {

        return "/dbNone/MeetingReservationList";
    }

    /**
     * コンストに登録して使用した場合
     * 説明：上記クラスの下の○○が/id1でアクセス
     *
     * @return ディレクトリのresources/templtes の下の/dbNone/ConfirmId1に接続
     */
    @RequestMapping(value = DbNoneConstant.ID1)
    public String id1() {

        return DbNoneConstant.CONFIRMID1;
    }

}
