package com.NewTest.myBatisSample.controller;

import com.NewTest.myBatisSample.constant.UserManagementConstant;
import com.NewTest.myBatisSample.form.UserListForm;
import com.NewTest.myBatisSample.service.UserManagementService;
import com.NewTest.myBatisSample.utils.SelectItemsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;
import java.util.Map;

/**
 * ユーザ一覧コントローラークラス
 * http://localhost:8080/UserManagement/UserListを打つと遷移
 *
 * @author john
 */
// コントローラークラスとしてのアノテーション宣言
@Controller
@EnableAutoConfiguration
public class UserListController {

    /** ロガー */
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserManagementService userManagementService;

    /**
     * 初期表示処理
     *
     * @param form 特に情報は入ってこない
     * @param model モデル
     * @param request リクエスト
     * @param response レスポンス
     * @return ユーザ一覧画面
     * @throws Exception 例外
     */
    // @RequestMapping の value = について
    // method = RequestMethod.GET でGETのみ受け取る
    // method = RequestMethod.POST POSTのみ受け取る 両方ともなら書かない
    @RequestMapping(value = UserManagementConstant.URL_USER_LIST_VIEW)
    public String show(UserListForm form, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // フォームを設定(Map情報)
        model.addAllAttributes(this.init());

        logger.info("ユーザ一覧画面が表示されます。");

        // ユーザ一覧画面へ遷移
        return UserManagementConstant.PAGE_USER_LIST;
    }


    /**
     * サービスクラス → マッパークラスに繋がり、データベースよりデータ取得している
     *
     * @return フォーム情報(Map)
     */
    private Map<String, Object> init() {

        // 返却する入れ物(Map生成)
        Map<String, Object> userListMap = new Hashtable<>();

        // サービスクラスよりフォーム情報取得
        UserListForm userListForm = userManagementService.initForm();

        // UserListForm(Key)に対してフォーム情報(value)を設定
        userListMap.put(UserManagementConstant.USER_LIST_FORM, userListForm);

        // 検索で使用する予約ステータス設定
        userListMap.put(UserManagementConstant.USER_STATUS_ITEMS, SelectItemsUtil.USER_STATUS_ITEMS);

        return userListMap;
    }
}
