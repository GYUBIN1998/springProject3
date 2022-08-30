package com.group3.springProject.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

/*
+---------------------+--------------+------+-----+-------------------+-------------------+
| Field               | Type         | Null | Key | Default           | Extra             |
+---------------------+--------------+------+-----+-------------------+-------------------+
| order_no            | int          | NO   | PRI | NULL              |                   |
| user_id             | varchar(255) | NO   | MUL | NULL              |                   |
| prod_id             | varchar(255) | NO   | MUL | NULL              |                   |
| order_type          | varchar(255) | NO   |     | NULL              |                   |
| order_time          | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| order_name          | varchar(255) | NO   |     | NULL              |                   |
| order_phone         | varchar(255) | NO   |     | NULL              |                   |
| order_email         | varchar(255) | NO   |     | NULL              |                   |
| order_addr_postcode | varchar(255) | NO   |     | NULL              |                   |
| order_addr_main     | varchar(255) | NO   |     | NULL              |                   |
| order_addr_detail   | varchar(255) | NO   |     | NULL              |                   |
| order_addr_extra    | varchar(255) | NO   |     | (없음)             |                   |
+---------------------+--------------+------+-----+-------------------+-------------------+
*/

@Data
public class OrderSheet {
	private int order_no;
	private String order_type;
	private Date order_time;
	private String order_name;
	private String order_phone;
	private String order_email;
	private String order_addr_postcode;
	private String order_addr_main;
	private String order_addr_detail;
	private String order_addr_extra;
	//join
	private User user;
	private Product product;
}

