package com.group3.springProject.dto;

import lombok.Data;

/*
 * +----------------+--------------+------+-----+---------+-------+
| Field          | Type         | Null | Key | Default | Extra |
+----------------+--------------+------+-----+---------+-------+
| shipping_id    | varchar(255) | NO   | PRI | NULL    |       |
| shipping_name  | varchar(255) | NO   |     | NULL    |       |
| shipping_phone | varchar(255) | NO   |     | NULL    |       |
| shipping_fee   | int          | NO   |     | 0       |       |
+----------------+--------------+------+-----+---------+-------+
*/

@Data
public class Shipping {
	 private String shipping_id;
	 private String shipping_name;
	 private String shipping_phone;
	 private int shipping_fee;
}
