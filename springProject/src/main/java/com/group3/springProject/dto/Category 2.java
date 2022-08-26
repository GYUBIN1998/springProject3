package com.group3.springProject.dto;

import lombok.Data;

/*
+---------------+--------------+------+-----+---------+-------+
| Field         | Type         | Null | Key | Default | Extra |
+---------------+--------------+------+-----+---------+-------+
| category_no   | int          | NO   |     | NULL    |       |
| category_name | varchar(255) | NO   |     | NULL    |       |
| category_code | varchar(255) | NO   | PRI | NULL    |       |
| category_root | varchar(255) | YES  | MUL | NULL    |       |
+---------------+--------------+------+-----+---------+-------+
*/

@Data
public class Category {
	private int category_no;
	private String category_name;
	private String category_code;
	private String category_root;  
}
