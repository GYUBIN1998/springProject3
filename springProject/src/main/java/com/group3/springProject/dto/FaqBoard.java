package com.group3.springProject.dto;
import java.util.Date;
import lombok.Data;
/*
+------------------+--------------+------+-----+-------------------+-------------------+
| Field            | Type         | Null | Key | Default           | Extra             |
+------------------+--------------+------+-----+-------------------+-------------------+
| faqboard_no      | int          | NO   | PRI | NULL              | auto_increment    |
| faq_division_no  | int          | NO   |     | NULL              |                   |
| faqboard_title   | varchar(255) | NO   |     | NULL              |                   |
| faqboard_content | varchar(255) | NO   |     | NULL              |                   |
| post_time        | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+------------------+--------------+------+-----+-------------------+-------------------+
*/
@Data
public class FaqBoard {
	 private int faqboard_no;
	 private int faq_division_no;
	 private String faqboard_title;
	 private String faqboard_content;
	 private Date post_time;
}
