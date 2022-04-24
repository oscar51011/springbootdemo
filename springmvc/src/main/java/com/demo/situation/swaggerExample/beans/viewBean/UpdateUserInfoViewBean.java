package com.demo.situation.swaggerExample.beans.viewBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 回傳 Response 物件
 * @author oscar51011
 * @date 2022年4月24日
 */
@ApiModel(value = "UpdateUserInfoViewBean")
public class UpdateUserInfoViewBean {

	/**
	 * 用戶名稱
	 */
	@ApiModelProperty(name = "name",value = "使用者姓名")
	private String name;
	
	/**
	 * 更新結果
	 */
	@ApiModelProperty(name = "result",value = "更新結果")
	private String result;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
