package com.NewTest.myBatisSample.service;

import com.NewTest.myBatisSample.constant.UserManagementConstant;
import com.NewTest.myBatisSample.entity.UserInfo;
import com.NewTest.myBatisSample.form.UserListForm;
import com.NewTest.myBatisSample.mapper.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 各種処理をするクラス
 *
 * @author john
 */
// サービスクラスのアノテーションを宣言
@Service
public class UserManagementService {

    /** ロガー */
    Logger logger = LoggerFactory.getLogger(getClass());

    // @Autowiredをつけるとエラーになるためつけない
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * フォーム情報の取得(データベースに登録されているもの全て)
     *
     * @return 会議予約情報一覧
     */
    public UserListForm initForm() {
        // リポジトリから取得
        List<UserInfo> UserInfolist = userInfoMapper.selectAll();

        // 入れ物が違うためリポジトリから取得したものを移す作業(List)
        List<UserListForm> userListForm = new ArrayList<>();

        // 拡張for文で1つずつ取り出し
        for (UserInfo userInfo : UserInfolist) {

            // 移し先の作成
            UserListForm form = new UserListForm();

            // 移して
            //BeanUtils.copyProperties(form, userInfo);
            form.setUserInfoList(userInfo);

            // リストへ入れる
            userListForm.add(form);
        }

        // フォーム生成
        UserListForm formList = new UserListForm();

        // フォームの中に作成したリスト(画面に表示するもの)を入れる
        formList.setUserFormList(userListForm);

        // それを返却
        return formList;
    }

    /**
     * フォーム情報の新規登録(画面入力値)
     *
     * @param form 画面入力値
     */
    public void insertUserInfo(UserListForm form) {

        // リポジトリにパラメータ渡し
        userInfoMapper.insertUserInfo(form);
    }

    /**
     * フォーム情報の新規登録の重複確認(画面入力値)
     *
     * @param form 画面入力値
     */
    public String userInfoCheck(UserListForm form) {

        // ユーザIDの重複確認
        UserInfo userInfo = userInfoMapper.selectUserInfoByUserId(form.getUserId());
        if (null != userInfo) {
            // エラーメッセージを返却
            return UserManagementConstant.ERR_MSG_USER_ID_NOT_AVAILABLE;
        }

        // ユーザアドレスの重複確認
        userInfo = userInfoMapper.selectUserInfoByUserMail(form.getUserMail());
        if (null != userInfo) {
            // エラーメッセージを返却
            return UserManagementConstant.ERR_MSG_USER_ADDRESS_NOT_AVAILABLE;
        }

        return null;
    }

    /**
     * 確認画面表示用情報設定
     *
     * @param form 選択ID所持フォーム
     */
    public void getUserListForm(UserListForm form) {

        // リポジトリにパラメータ渡し
        UserInfo userInfo = userInfoMapper.selectUserInfoByUserNo(form.getUserNo());

        // 取得した値をフォームにセットする
        form.copy(userInfo);
    }
}
