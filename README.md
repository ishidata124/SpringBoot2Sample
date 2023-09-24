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
DB接続無しはspring bootでの簡易的な動作を確認するためだけのために作成してあります。  
そのため手を抜いて作成しておりますのでご了承ください。

### JPA会議室予約一覧について
JPAでの簡易的な動作を確認できます。  
凝った内容は入れておりません。

### MyBatis会議室予約一覧について
MyBatisでの簡易的な動作を確認できます。  
凝った内容は入れておりません。

## 使用方法
docker起動させるだけでOK。

1.docker起動
```
# docker compose起動
docker-compose up
```
2.phpMyAdminへアクセス
```
# phpMyAdminのURL
http://localhost:8081
```
3.AP資材へアクセス
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

## フォーマット直し
https://www.purin-it.com/intellij-code-format
