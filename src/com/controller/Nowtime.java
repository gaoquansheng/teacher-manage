package com.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Nowtime {
    public Date Time() throws ParseException  {

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            String time=df.format(new Date());
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd ");
            Date date = fmt.parse(time);
            return date;




    }


}
