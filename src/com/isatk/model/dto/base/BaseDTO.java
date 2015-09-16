package com.isatk.model.dto.base;

import com.isatk.ge.model.bean.Page;

public class BaseDTO {

	private Page page;

	private String orderString;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getOrderString() {
		return orderString;
	}

	public void setOrderString(String orderString) {
		this.orderString = orderString;
	}

	public boolean hasAvailable() {
		return false;
	}

	private Integer pc;

	public void setPageCount(int pageCount) {
		if (pageCount <= 0) {
			pc = 0;
			page = null;
		} else {

			if (page == null) {
				page = new Page();
				pc = 1;
			} else {
				pc = null;
			}
			page.setLength(pageCount);
		}

	}

	public void setStartIndex(int ind) {
		if (pc == null) {
			page = new Page();
			page.setBegin(ind);
		} else if (pc == 1) {
			page.setBegin(ind);
		}
	}
}
