package com.group3.springProject.dto;

import lombok.Data;

/*
+-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| user_id     | varchar(255) | NO   | PRI | NULL    |       |
| user_pw     | varchar(255) | NO   |     | NULL    |       |
| user_phone  | varchar(255) | NO   | UNI | NULL    |       |
| user_email  | varchar(255) | NO   | UNI | NULL    |       |
| user_adress | varchar(255) | NO   |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+
*/

@Data
public class User {
	private String user_id;
	private String user_pw;
	private String user_phone;
	private String user_email;
	private String user_adress; 
}
