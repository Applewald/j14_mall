package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.User;
import com.cskaoyan.mall.admin.bean.UserInfo;
import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.service.UserService;
import com.cskaoyan.mall.admin.token.UserToken;
import com.cskaoyan.mall.admin.token.UserTokenManager;
import com.cskaoyan.mall.admin.util.JacksonUtil;
import com.cskaoyan.mall.admin.vo.BaseRespVo;

import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by little Stone
 * Date 2019/7/8 Time 20:55
 */
@RestController
@RequestMapping("/wx")
public class WxAuthController {

	@Autowired
	UserService userService;


	@Autowired
	OrderService orderService;

	@RequestMapping("/auth/login")
	@ResponseBody
	public Object login(@RequestBody String body, HttpServletRequest request) {
		String username = JacksonUtil.parseString(body, "username");
		String password = JacksonUtil.parseString(body, "password");

		User user = userService.findUserInfoByUsernameAndPassword(username,password);

		//数据库没有userInfo的字段--
		UserInfo userInfo = new UserInfo();
		userInfo.setAvatarUrl(user.getAvatar());
		userInfo.setNickName(user.getNickname());
		userInfo.setCountry("中国");
		userInfo.setProvince("湖北");
		userInfo.setCity("武汉");
		userInfo.setLanguage("ch");
		userInfo.setGender(user.getGender());


		//********************************
		//根据获得userid
		int userId = user.getId();
		//********************************
		// token
		UserToken userToken = UserTokenManager.generateToken(userId);

		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put("token", userToken.getToken());
		result.put("tokenExpire", userToken.getExpireTime().toString());
		result.put("userInfo", userInfo);
		return BaseRespVo.ok(result);
	}

	@GetMapping("user/index")
	public Object list(HttpServletRequest request) {
		//前端写了一个token放在请求头中
		//*************************
		//获得请求头
		String tokenKey = request.getHeader("X-Litemall-Token");
		Integer userId = UserTokenManager.getUserId(tokenKey);
		//通过请求头获得userId，进而可以获得一切关于user的信息
		//**************************
		if (userId == null) {
			return BaseRespVo.fail();
		}

		Map<Object, Object> order = orderService.findOrderStatusByUserId(userId);
		//***********************************
		Map<Object,Object> data =  new HashMap<>();

		data.put("order",order);
		data.put("errmsg","成功");
		data.put("errno",0);

		return data;

	}

	//
	@PostMapping("auth/logout")
	public Object logout() {
		return ResponseVo.ok();
	}

	// 验证码  不支持
	@PostMapping("auth/regCaptcha")
	public Object regCaptcha() {
		return ResponseVo.fail("小程序后台验证码服务不支持", 701);
	}
}
