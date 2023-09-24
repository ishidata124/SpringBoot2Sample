-- CREATE DATABASE
CREATE DATABASE IF NOT EXISTS database_jpa;

-- CREATE TABLE
CREATE TABLE IF not exists database_jpa.reservation_list_info (
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