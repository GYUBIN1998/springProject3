package com.group3.springProject.dto;
import lombok.Data;
@Data
public class Paging {
	private int page;
	private int rowCount;
	private String url;
	private int row = 5;
	
	private int start;
	private int end;
	private int firstPage = 1;
	private int previousPage;
	private int nextPage;
	private int lastPage;
	
	private boolean isFirst;
	private boolean isPrevious;
	private boolean isNext;
	private boolean isLast;
	
	public Paging(int page, int rowCount, String url) {
		this.page = page;
		this.rowCount = rowCount;
		this.url = url;
		this.setAll();
	}
	
	public Paging(int page, int rowCount, String url, int row) {
		this.page = page;
		this.rowCount = rowCount;
		this.url = url;
		this.row = row;
		this.setAll();
	}
	
	public void setAll() {
		this.previousPage = page - 1;
		this.nextPage = page + 1;
		this.lastPage = rowCount/row + ((rowCount % row > 0) ? 1 : 0);
		
		this.isFirst = (page > firstPage) ? true : false;
		this.isPrevious = (page > firstPage) ? true : false;
		this.isNext = (page < lastPage) ? true : false;
		this.isLast = (page < lastPage) ? true : false;
		
		this.start = page - 1;
		this.end = page + 1;
		
		if(start < firstPage) {
			end = end + (-(start) + 1);
			if(end > lastPage) {
				end = lastPage;
				}
			start = firstPage;
		}
		if(end > lastPage) {
			start = start - (end - lastPage);
			if(start < firstPage) {
				start = firstPage;
				}
			end = lastPage;
		}
	}
}
