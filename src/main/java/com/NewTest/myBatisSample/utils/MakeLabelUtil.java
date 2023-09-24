package com.NewTest.myBatisSample.utils;

import com.NewTest.jpaSample.constant.MeetingReservationConstant;
import com.NewTest.myBatisSample.constant.UserManagementConstant;


/**
 * ラベル作成Utilクラス
 *
 * @author john
 */
public class MakeLabelUtil {

    /**
     * ユーザステータスラベルを取得
     *
     * @param status ユーザステータス番号
     * @return ユーザステータス番号に対応したラベル
     */
    public static String getUserStatusLabel(String status) {
        String label;

        switch (status) {
            case UserManagementConstant.UNUSED:
                label = UserManagementConstant.LABEL_UNUSED;
                break;
            case UserManagementConstant.ADMIN:
                label = UserManagementConstant.LABEL_ADMIN;
                break;
            case UserManagementConstant.ORDINARY:
                label = UserManagementConstant.LABEL_ORDINARY;
                break;
            case UserManagementConstant.PW_EXPIRATION:
                label = UserManagementConstant.LABEL_PW_EXPIRATION;
                break;
            case UserManagementConstant.INVALID:
                label = UserManagementConstant.LABEL_INVALID;
                break;
            case UserManagementConstant.BLANK:
                label = UserManagementConstant.BLANK;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return label;
    }
}
