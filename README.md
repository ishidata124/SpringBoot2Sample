# Spring boot maven sample
- 新規参画者の学習用に作成したサンプル。  
- JPAとMyBatisが同一のwarで動作するように作成してあります。  
- JPAからMyBatisに徐々に移行するときとかに参考にできます。
- spring bootはmavenでなくgredleの使用を勧めており、Spring bootは2系のサポートが終了するため<span style="color: red; ">この資材は廃盤にします</span>。

## 構成
- Java 1.8
- Spring boot 2.2.4.RELEASE
- JPA
- maven 3.8.6
- mysql 5.7.40
- JavaScript
- Jquery-3.4.1
- phpmyadmin 5.2.0

## 各サンプルの動作について
### DB無し会議室予約一覧について
- DB接続無しはspring bootでの簡易的な動作を確認するためだけのために作成してあります。  
そのため手を抜いて作成しておりますのでご了承ください。

### JPA会議室予約一覧について
- JPAでの簡易的な動作を確認できます。  
- 凝った内容は入れておりません。

### MyBatis会議室予約一覧について
- MyBatisでの簡易的な動作を確認できます。  
- 凝った内容は入れておりません。

## DB定義について
- [001-create-tables.sql](./db/sql/001-create-tables.sql)
を参照

## ユーザについて
- 初期PWを作成しメールにて通知機能を作成しようとしたが、忙しくてできず。
- 初期PWは「npw_ユーザID」にしています。

## 使用方法
docker起動させるだけでOK。

1.docker起動
```
# docker compose起動
docker-compose up
```
2.[phpMyAdmin](http://localhost:8081)へアクセス
```
# phpMyAdminのURL
http://localhost:8081
```
3.[AP資材](http://localhost:8080/sample/home/mainHome)へアクセス
```
# メインページのURL
http://localhost:8080/sample/home/mainHome
```
4.コンテナアクセス
```
# プロセス確認
docker ps
# bashでアクセス
docker exec -it NAMES(MySQLのコンテナ名) bash
# rootでアクセス(PWはmy-secret-pw)
mysql -u root -p
```

## docker-composeの中に入る
```
# docker-compose.yml 内で決めた名前を入れると入れる
docker-compose exec web bash
```

## License
SpringBoot2Sample is licensed under the Creative Commons Zero v1.0 Universal license. You can see a copy of the license here.

# TODO 気が向いたら実装
- ユーザ編集処理一式
  - ユーザ作成
    - メール送信
  - ユーザ一覧
    - 検索処理
  - ユーザ確認
    - 画面作成
    - 編集処理起動
    - PWリセット処理
    - ユーザ有効 or 無効処理
  - ユーザ編集
    - 設定部分確認
- ログイン処理
  - チャレンジレスポンス
  - 予約画面
  - ユーザ登録画面
  - セッション

- 会議予約処理一式
  - 予約作成
  - 予約一覧
  - 予約編集

- テスト
  - DB無しサンプル移動
  - ログイン
- ログ直し
- フォーマット直し
- メール送信
- チャレンジレスポンス

