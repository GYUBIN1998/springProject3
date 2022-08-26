package com.group3.springProject.dto;

import lombok.Data;

/*
+---------------+--------------+------+-----+---------+-------+
| Field         | Type         | Null | Key | Default | Extra |
+---------------+--------------+------+-----+---------+-------+
| prod_id       | varchar(255) | NO   | PRI | NULL    |       |
| prod_name     | varchar(255) | NO   |     | NULL    |       |
| prod_price    | int          | NO   |     | 0       |       |
| prod_stock    | int          | NO   |     | 0       |       |
| category_code | varchar(255) | NO   | MUL | NULL    |       |
| prod_img      | varchar(255) | YES  |     | NULL    |       |
| division_code | int          | NO   | MUL | NULL    |       |
| good          | int          | NO   |     | 0       |       |
| shipping_id   | varchar(255) | NO   | MUL | NULL    |       |
+---------------+--------------+------+-----+---------+-------+
*/

@Data
public class Product {
	 private String prod_id;
	 private String prod_name;
	 private int prod_price;
	 private int prod_stock;
	 private String category_code;
	 private String prod_img;
	 private int division_code;
	 private int good;
	 private String shipping_id;
}
