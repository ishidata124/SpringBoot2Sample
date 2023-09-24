-- CREATE DATABASE
CREATE DATABASE IF NOT EXISTS database_jpa;

CREATE DATABASE IF NOT EXISTS database_mybatis;

-- CREATE TABLE
-- ユーザ情報
CREATE TABLE IF not exists database_mybatis.user_info (
user_no INT AUTO_INCREMENT PRIMARY KEY,
user_id VARCHAR(50) NOT NULL,
user_password VARCHAR(64) NOT NULL,
user_name VARCHAR(50) NOT NULL,
user_mail VARCHAR(255) NOT NULL,
last_login_data_time DATETIME,
pw_elapsed_date INT,
user_status INT,
hash VARCHAR(50),
login_err INT DEFAULT 0,
unique(user_id)
) DEFAULT CHARSET=utf8;

/*
ユーザ情報のテーブルの内容

user_no = ユーザ番号
user_id = ユーザ識別ID
user_password = ユーザパスワード
user_name = ユーザ名
user_mail = メールアドレス
last_login_data_time = ユーザ最終ログイン日時
pw_elapsed_date = パスワード変更後経過日時
user_status = ユーザステータス  0:未ログイン, 1:有効化(管理者), 2:有効化(一般), 3:パスワード有効期限切れ, 4:無効(論理削除)
hash = チャレンジレスポンス用文字列
login_err = ログインNG回数
*/

-- 会議予約情報
CREATE TABLE IF not exists database_jpa.meeting_reservation_info (
reservation_id INT AUTO_INCREMENT PRIMARY KEY,
reservation_name VARCHAR(50),
reservation_start_date DATETIME,
reservation_end_date DATETIME,
remarks VARCHAR(500),
reservation_status INT,
regist_user VARCHAR(20),
regist_date DATETIME,
invalid_flg BOOLEAN
) DEFAULT CHARSET=utf8;

/*
会議予約情報のテーブルの内容

reservation_id = 予約ID
reservation_name = 予約名
reservation_start_date = 使用開始日時
reservation_end_date = 使用終了日時
remarks = 備考
reservation_status = 予約ステータス  1:予約中, 2：編集中, 3：キャンセル
regist_user = 登録者名
regist_date = 登録日
invalid_flg = 無効フラグ  0:有効, 1:無効(論理削除)
*/