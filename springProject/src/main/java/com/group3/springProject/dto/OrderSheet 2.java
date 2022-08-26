package com.group3.springProject.dto;

import java.util.Date;

import lombok.Data;

/*
+------------+--------------+------+-----+-------------------+-------------------+
| Field      | Type         | Null | Key | Default           | Extra             |
+------------+--------------+------+-----+-------------------+-------------------+
| order_no   | int          | NO   | PRI | NULL              |                   |
| user_id    | varchar(255) | NO   | MUL | NULL              |                   |
| order_type | varchar(255) | NO   |     | NULL              |                   |
| order_time | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+------------+--------------+------+-----+-------------------+-------------------+
*/

@Data
public class OrderSheet {
	private int order_no;
	private String user_id;
	private String order_type;
	private Date order_time;
}
