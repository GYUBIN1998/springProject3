package com.group3.springProject.dto;

import lombok.Data;

/*
+---------------+--------------+------+-----+---------+-------+
| Field         | Type         | Null | Key | Default | Extra |
+---------------+--------------+------+-----+---------+-------+
| division_code | int          | NO   | PRI | NULL    |       |
| notebook_name | varchar(255) | NO   |     | NULL    |       |
| maker         | varchar(255) | YES  |     | NULL    |       |
| main_cpu      | varchar(255) | YES  |     | NULL    |       |
| screen_size   | float        | YES  |     | NULL    |       |
| memory_size   | varchar(255) | YES  |     | NULL    |       |
| storage_size  | varchar(255) | YES  |     | NULL    |       |
| weight        | float        | YES  |     | NULL    |       |
+---------------+--------------+------+-----+---------+-------+
*/

@Data
public class Notebook {
	private int division_code;
	private String notebook_name;
	private String maker;
	private String main_cpu;
	private float screen_size;
	private String memory_size;
	private String storage_size;
	private float weight;
}
