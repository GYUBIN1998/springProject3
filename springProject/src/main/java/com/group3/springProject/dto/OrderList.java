package com.group3.springProject.dto;

import lombok.Data;

/*
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| orderlist_no | int          | NO   | PRI | NULL    |       |
| order_no     | int          | NO   | MUL | NULL    |       |
| prod_id      | varchar(255) | NO   | MUL | NULL    |       |
| order_qty    | int          | NO   |     | 0       |       |
+--------------+--------------+------+-----+---------+-------+
*/

@Data
public class OrderList {
	private int orderlist_no;
	private int order_qty;
	
	//join
	private Product product;
	private OrderSheet orderSheet;
}
