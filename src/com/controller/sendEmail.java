package com.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.mail.EmailException;

import org.apache.commons.mail.SimpleEmail;

import com.entity.user;

public class sendEmail {
	public static void sendAuthCodeEmail(String email, String authCode) {
   		try {
   	 	SimpleEmail mail = new SimpleEmail();
   	 	mail.setHostName("smtp.qq.com");//�����ʼ��ķ�����
   	 	mail.setAuthentication("962338171@qq.com","pymuynzxajidbdee");//�ոռ�¼����Ȩ�룬�ǿ���SMTP������
   	 	mail.setFrom("962338171@qq.com","Ӧ������������Ԯ�ٽ�����");  //�����ʼ�������ͷ�����
   	 	mail.setSSLOnConnect(true); //ʹ�ð�ȫ����
   	 	mail.addTo(email);//���յ�����
   	 	//System.out.println("email"+email);
   	 	mail.setSubject("��֤��");//�����ʼ�������
   		mail.setMsg("�𾴵��û�:���!\n ������֤��Ϊ:" + authCode+"\n"+"     (��Ч��Ϊһ����)");//�����ʼ�������
   		mail.send();//����
   		} catch (EmailException e) {
   			e.printStackTrace();
   		}  
   	}
	
	// �����֤��
			public String achieveCode() {  //�������� 1 �� 0 ����ĸ O ��l ��ʱ�ֲ���������ԣ�û������ 1 �� 0
				String[] beforeShuffle= new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
				"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
				"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z" };
				List list = Arrays.asList(beforeShuffle);//������ת��Ϊ����
				Collections.shuffle(list);  //���Ҽ���˳��
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i)); //������ת��Ϊ�ַ���
				}
				return sb.toString().substring(3, 8);  //��ȡ�ַ�����4��8
			}
			
			
			public static void new_pwdEmail(String email, String authCode) {
		   		try {
		   	 	SimpleEmail mail = new SimpleEmail();
		   	 	mail.setHostName("smtp.qq.com");//�����ʼ��ķ�����
		   	 	mail.setAuthentication("962338171@qq.com","pymuynzxajidbdee");//�ոռ�¼����Ȩ�룬�ǿ���SMTP������
		   	 	mail.setFrom("962338171@qq.com","Ӧ������������Ԯ�ٽ�����");  //�����ʼ�������ͷ�����
		   	 	mail.setSSLOnConnect(true); //ʹ�ð�ȫ����
		   	 	mail.addTo(email);//���յ�����
		   	 	//System.out.println("email"+email);
		   	 	mail.setSubject("������");//�����ʼ�������
		   		mail.setMsg("�𾴵��û�:���!\n ���������Ϊ:" + authCode+"\n");//�����ʼ�������
		   		mail.send();//����
		   		} catch (EmailException e) {
		   			e.printStackTrace();
		   		}  
		   	}


}
