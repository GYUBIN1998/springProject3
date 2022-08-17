package com.group3.springProject.dto;

import java.util.Date;

import lombok.Data;

/*
+----------------+--------------+------+-----+-------------------+-------------------+
| Field          | Type         | Null | Key | Default           | Extra             |
+----------------+--------------+------+-----+-------------------+-------------------+
| review_no      | int          | NO   | PRI | NULL              |                   |
| prod_id        | varchar(255) | NO   | MUL | NULL              |                   |
| user_id        | varchar(255) | NO   | MUL | NULL              |                   |
| review_title   | varchar(255) | NO   |     | NULL              |                   |
| review_content | varchar(255) | NO   |     | NULL              |                   |
| review_img     | varchar(255) | YES  |     | NULL              |                   |
| review_score   | int          | NO   |     | 0                 |                   |
| review_time    | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+----------------+--------------+------+-----+-------------------+-------------------+
*/

@Data
public class Review {
	private int review_no;
	private String prod_id;
	private String user_id;
	private String review_title;
	private String review_content;
	private String review_img;
	private int review_score;
	private Date review_time;
}
