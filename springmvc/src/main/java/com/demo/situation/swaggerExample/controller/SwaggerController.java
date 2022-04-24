package com.demo.situation.swaggerExample.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.situation.swaggerExample.beans.paramBean.UpdateUserInfoParamBean;
import com.demo.situation.swaggerExample.beans.viewBean.UpdateUserInfoViewBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 測試 swagger API 用法
 * @author oscar51011
 * @date 2022年4月24日
 */
// value: 類別檔案說明 ; tag: 可以針對不同類型功能做分群
@Api(value = "SWAGGER控制器類別", tags= {"User"})
@RequestMapping("/swaggerTest")
@RestController
public class SwaggerController {

	@ApiOperation(value = "更新使用者資訊", notes = "根據XXX場景，更新使用者資訊", response = UpdateUserInfoViewBean.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "用戶資訊"), 
						   @ApiResponse(code = 500, message = "異常資訊")})
	@PutMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public UpdateUserInfoViewBean updateUserInfo(@ApiParam(name="updateUserInfoParamBean", value = "更新使用者參數")@RequestBody UpdateUserInfoParamBean paramBean) {
		
		UpdateUserInfoViewBean viewBean = new UpdateUserInfoViewBean();
		
		viewBean.setName("test");
		viewBean.setResult("success");
		
		return viewBean;
	}
}
