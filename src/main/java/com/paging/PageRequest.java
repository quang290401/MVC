package com.paging;

public class PageRequest implements Pageble {
	private Integer page;
	private Integer maxpageItem;
	public PageRequest(Integer page,Integer maxpageItem) {
        this.page=page;
        this.maxpageItem= maxpageItem;
	}

	@Override
	public Integer getPage() {

		return this.page;
	}

	@Override
	public Integer getOffset() {
	if(this.page!=null && this.maxpageItem!=null) {
		return (this.page-1)*this.maxpageItem;
	}
		return null;
	}

	@Override
	public Integer getlimit() {

		return this.maxpageItem;
	}

}
