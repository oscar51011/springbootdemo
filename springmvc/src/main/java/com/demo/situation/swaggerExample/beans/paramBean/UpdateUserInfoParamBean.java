package com.demo.situation.swaggerExample.beans.paramBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 傳入 Request 參數物件
 * @author oscar51011
 * @date 2022年4月24日
 */
@ApiModel(value = "UpdateUserInfoParamBean")
public class UpdateUserInfoParamBean {

	/**
	 * 用戶流水碼
	 */
	@ApiModelProperty(name = "id",value = "客戶流水碼", required = true)
	private Long id;
	
	/**
	 * 備註
	 */
	@ApiModelProperty(name = "note",value = "備註")
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
