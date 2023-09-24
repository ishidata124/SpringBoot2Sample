package com.NewTest.myBatisSample.controller;

import com.NewTest.myBatisSample.constant.UserManagementConstant;
import com.NewTest.myBatisSample.form.UserListForm;
import com.NewTest.myBatisSample.service.UserManagementService;
import com.NewTest.myBatisSample.utils.SelectItemsUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;
import java.util.Map;

/**
 * ユーザ登録コントローラー
 *
 * @author john
 */
@Controller
public class UserRegistController {

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
     * @return ユーザ登録画面
     * @throws Exception 例外
     */
    @RequestMapping(value = UserManagementConstant.URL_USER_REGIST_VIEW, method = RequestMethod.POST)
    public String show(UserListForm form, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        logger.info("ユーザ新規登録画面が表示されます。");

        // ユーザ登録画面へ遷移
        return UserManagementConstant.PAGE_USER_REGIST;
    }

    /**
     * 登録ボタン押したときの処理
     *
     * @param form 画面入力値
     * @param model モデル
     * @param request リクエスト
     * @param response レスポンス
     * @return ユーザ一覧画面
     * @throws Exception 例外
     */
    @RequestMapping(value = UserManagementConstant.URL_USER_REGIST_RAGISTER, method = RequestMethod.POST)
    public String Register(UserListForm form, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 初期PW生成
        //String pw = RandomStringUtils.randomAlphanumeric(16);
        String pw = "npw_" + form.getUserId();
        form.setUserPassword(DigestUtils.sha256Hex(pw));

        // 登録用バリデーション
        String errMsg = form.valid();
        if (null != errMsg) {

            // ダイアログにエラーメッセージを設定
            form.setDialogueErrMsg(errMsg);

            // ユーザ登録画面へ遷移
            return UserManagementConstant.PAGE_USER_REGIST;
        }

        // データベースに登録前にユーザ情報の重複を確認
        errMsg = userManagementService.userInfoCheck(form);

        if (null != errMsg) {

            // ダイアログにエラーメッセージを設定
            form.setDialogueErrMsg(errMsg);

            // ユーザ登録画面へ遷移
            return UserManagementConstant.PAGE_USER_REGIST;
        }

        // データベースに登録するためにサービスクラスにフォームを渡す
        userManagementService.insertUserInfo(form);

        // ユーザにメールを送信 TODO

        // モデルを設定(Map情報)
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
