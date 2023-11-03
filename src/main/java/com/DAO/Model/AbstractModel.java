package com.DAO.Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class AbstractModel<T> {
	private Date createDate;
	private String createBy;
	private Date modifiDate;
	private String modifyByte;
	private List<T> listResulset = new ArrayList<>();
    private Integer page;
    private Integer maxPageItem ;
    private Integer totalPage;
    private Integer totalItem;
    private String type;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getModifiDate() {
		return modifiDate;
	}
	public void setModifiDate(Date modifiDate) {
		this.modifiDate = modifiDate;
	}
	public String getModifyByte() {
		return modifyByte;
	}
	public void setModifyByte(String modifyByte) {
		this.modifyByte = modifyByte;
	}
	public List<T> getListResulset() {
		return listResulset;
	}
	public void setListResulset(List<T> listResulset) {
		this.listResulset = listResulset;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
    
	

}
