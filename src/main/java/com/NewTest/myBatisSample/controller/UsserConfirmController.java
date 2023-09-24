package com.NewTest.myBatisSample.controller;

import com.NewTest.myBatisSample.constant.UserManagementConstant;
import com.NewTest.myBatisSample.form.UserListForm;
import com.NewTest.myBatisSample.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ユーザ確認コントローラー
 *
 * @author john
 */
@Controller
public class UsserConfirmController {
    /** ロガー */
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserManagementService userManagementService;

    /**
     * 初期表示処理
     *
     * @param form ユーザフォーム
     * @param model モデル
     * @param request リクエスト
     * @param response レスポンス
     * @return ユーザ登録画面
     * @throws Exception 例外
     */
    @RequestMapping(value = UserManagementConstant.URL_USER_CONFIRM_VIEW, method = RequestMethod.POST)
    public String show(UserListForm form, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        userManagementService.getUserListForm(form);

        logger.info("ユーザ確認画面が表示されます。");

        // ユーザ確認画面へ遷移
        return UserManagementConstant.PAGE_USER_CONFIRM;
    }
}
