package com.NewTest.myBatisSample.mapper;

import com.NewTest.myBatisSample.entity.UserInfo;
import com.NewTest.myBatisSample.form.UserListForm;
import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Select; @Selectを実行するのに使用

import java.util.List;

/**
 * マッパークラス(データベースにアクセスするクラス)
 *
 * @author john
 */
@Mapper
public interface UserInfoMapper {
    /**
     * 全ユーザーを取得
     *
     * @return 全ユーザーの情報
     *
     */
    // @Select("SELECT  * from user_info") マッパーに書かずにこのように書いても機能する
    List<UserInfo> selectAll();

    /**
     * ユーザを新規登録
     *
     * @param form ユーザーの情報
     *
     */
    void insertUserInfo(UserListForm form);

    /**
     * ユーザを検索
     * userNoからデータベース検索
     *
     * @param userNo ユーザ番号
     *
     * @return ユーザの情報
     *
     */
    UserInfo selectUserInfoByUserNo(int userNo);

    /**
     * ユーザを検索
     * userIdからデータベース検索
     *
     * @param userId ユーザID
     *
     * @return ユーザの情報
     *
     */
    UserInfo selectUserInfoByUserId(String userId);

    /**
     * ユーザを検索
     * userMailからデータベース検索
     *
     * @param userId ユーザID
     *
     * @return ユーザの情報
     *
     */
    UserInfo selectUserInfoByUserMail(String userId);
}
