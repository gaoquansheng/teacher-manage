package com.controller;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.entity.certificate;
import com.entity.education;
import com.entity.emergencycontact;
import com.entity.news;
import com.entity.user;
import com.entity.workexperience;




@Controller
@RequestMapping("")
public class SignController {
	 
		//¿ØÖÆÌø×ªÒ³Ãæ
		@RequestMapping("/html/{where}")
		public String tiaozhuan(@PathVariable String where) {
			return where;
		}
		
		

}
