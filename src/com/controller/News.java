package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.baidu.ueditor.ActionEnter;
import com.entity.news;
import com.service.NewsService;



@Controller
@RequestMapping("news")
public class News {
	
	 @Autowired
	 NewsService newsService;
	 
	 
	 
	//控制跳转页面
	@RequestMapping("/html/{where}")
	public String tiaozhuan(@PathVariable String where) {
		return where;
	}
	
	
	 @ResponseBody
	 @RequestMapping("/find_news")
	 public String find_news(@RequestBody news news_id){
		List<news> list=newsService.find_news(news_id);
		System.out.print(list);
		String ne=JSON.toJSONString(list);
		return ne.toString();
	 }
	 //添加新闻
	 @ResponseBody
	 @RequestMapping("/add_news")
	 public void add_news(@RequestBody news add_news) {
			System.out.print(add_news.getNews_title());
			System.out.print(add_news.getNews_content());
			newsService.add_news(add_news);
		}
	 
	 //显示新闻列表
	 @ResponseBody
	 @RequestMapping("/L_news")
	 public String Lnews(){
			List<news> list=newsService.L_news();
			System.out.println(JSON.toJSONString(list));
			return JSON.toJSONString(list).toString();

		}
	 
	 //删除指定新闻
	 @ResponseBody
	 @RequestMapping("/delete_news")
	 public void delete_news( @RequestBody news delete_news){
		 newsService.delete_news(delete_news);
	 }
	 
	 //更新新闻
	 @ResponseBody
	 @RequestMapping("/update_news")
	 public void update_news(@RequestBody news up_news){
		 newsService.update_news(up_news);
	 }
	 
	 //接收新闻图片并存储
	 @ResponseBody
	 @RequestMapping("/upload_images2")
	 public void upload_images(HttpServletRequest request, HttpServletResponse response) {
 
        response.setContentType("application/json");
        String rootPath = request.getSession()
                .getServletContext().getRealPath("news_images");
        System.out.println("进入UEditorController");
        System.out.println(rootPath);
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
	 
	 

 
@RequestMapping(value="/upload_images")
	 public Map<String, Object> images (@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
			Map<String, Object> params = new HashMap<String, Object>();
			if (file == null){
	            System.out.println("未获得上传文件!");			
				return null;
			}  
			try{
				 Object oUser = request.getSession().getAttribute("YJ_UserID");
			        if (oUser == null)
			        {
			        	return null;
			        }
			        
				String imagePath = request.getSession().getServletContext().getRealPath("/uploadImages/");
				String filePath = request.getSession().getServletContext().getRealPath("/uploadFiles/");
				 String filetype = request.getParameter("filetype")+"";
				 System.out.println("filetype:"+filetype);
				 String basePath = "";
				 if("image".equals(filetype)){
					 basePath =imagePath;
				 }else if("file".equals(filetype)){
					 basePath = filePath;
				 }
				 if(basePath == null || "".equals(basePath)){
					 basePath = filePath; 
				 }
				 String fname =file.getOriginalFilename();
				 
				 System.out.println("filename:"+file.getOriginalFilename());
				 String ext =fname.substring(fname.lastIndexOf('.'));
				 String fileName = oUser.toString()+"_"+String.valueOf(System.currentTimeMillis()).concat(ext);
				 StringBuilder sb = new StringBuilder();
				 //拼接保存路径
				 sb.append(basePath).append("/").append(fileName);
				 
				 String visitUrl = basePath.concat("/"+fileName);
				 File f = new File(sb.toString());
				 if(!f.exists()){
					 f.getParentFile().mkdirs();
				 }
				 OutputStream out = new FileOutputStream(f);
				 FileCopyUtils.copy(file.getInputStream(), out);
				 params.put("state", "SUCCESS");
				 params.put("url", visitUrl);
				 params.put("size", file.getSize());
				 params.put("original", fileName);
				 params.put("type", file.getContentType());
				 params.put("filename", file.getOriginalFilename());
				 System.out.println("url:"+visitUrl+" original:"+fileName+" filename:"+file.getOriginalFilename()+" type:"+file.getContentType());
			} catch (Exception e){
				 params.put("state", "ERROR");
				 e.printStackTrace();
			}
			 return params;
		} 

}
