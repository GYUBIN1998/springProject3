package com.group3.springProject.dto;
import java.util.Date;
import lombok.Data;
/*
+------------------+--------------+------+-----+-------------------+-------------------+
| Field            | Type         | Null | Key | Default           | Extra             |
+------------------+--------------+------+-----+-------------------+-------------------+
| qnaboard_no      | int          | NO   | PRI | NULL              | auto_increment    |
| qnaboard_title   | varchar(255) | NO   |     | NULL              |                   |
| qnaboard_content | varchar(255) | NO   |     | NULL              |                   |
| user_id          | varchar(255) | NO   | MUL | NULL              |                   |
| post_time        | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+------------------+--------------+------+-----+-------------------+-------------------+
*/
@Data
public class QnaBoard {
	 private int qnaboard_no;
	 private String qnaboard_title;
	 private String qnaboard_content;
	 private String user_id;
	 private Date post_time;
}
