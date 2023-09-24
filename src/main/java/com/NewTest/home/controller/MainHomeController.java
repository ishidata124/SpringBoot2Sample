package com.NewTest.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * メインホーム画面コントローラークラス
 * 使用方法：http://localhost:8080/sample/home/mainHomeを打つと遷移
 * 説明：http://localhost:8080/sample/home/○○でアクセス
 *
 * @author john
 */
@Controller
@RequestMapping(value = "/sample/home")
public class MainHomeController {

    /**
     * コントローラークラス配下メソッド
     * 説明：上記クラスの下の○○が/mainHomeでアクセス
     *
     * @return ディレクトリのresources/templtes の下の /home/MainHomeに接続
     */
    @RequestMapping(value = "/mainHome")
    public String view() {

        return "/home/MainHome";
    }

}
