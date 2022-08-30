package com.group3.springProject.dto;

import java.util.List;

import lombok.Data;

/*
+--------------------+--------------+------+-----+---------+-------+
| Field              | Type         | Null | Key | Default | Extra |
+--------------------+--------------+------+-----+---------+-------+
| user_id            | varchar(255) | NO   | PRI | NULL    |       |
| user_pw            | varchar(255) | NO   |     | NULL    |       |
| user_name          | varchar(255) | NO   |     | NULL    |       |
| user_phone         | varchar(255) | NO   | UNI | NULL    |       |
| user_email         | varchar(255) | NO   | UNI | NULL    |       |
| user_addr_postcode | varchar(255) | NO   |     | NULL    |       |
| user_addr_main     | varchar(255) | NO   |     | NULL    |       |
| user_addr_detail   | varchar(255) | NO   |     | NULL    |       |
| user_addr_extra    | varchar(255) | NO   |     | (없음)   |       |
+--------------------+--------------+------+-----+---------+-------+
*/

@Data
public class User {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_phone;
	private String user_email;
	private String user_addr_postcode;
	private String user_addr_main;
	private String user_addr_detail;
	private String user_addr_extra;
}