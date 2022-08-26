package com.group3.springProject.dto;

import lombok.Data;

/*
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| basket_no | int          | NO   | PRI | NULL    |       |
| user_id   | varchar(255) | NO   | MUL | NULL    |       |
| prod_id   | varchar(255) | NO   | MUL | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
*/

@Data
public class basket {
	 private int basket_no;
	 private String user_id;
	 private String prod_id;
}
