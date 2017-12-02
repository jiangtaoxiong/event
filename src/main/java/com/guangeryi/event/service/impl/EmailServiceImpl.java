package com.guangeryi.event.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.SerializationUtils;

import com.guangeryi.event.entity.Email;
import com.guangeryi.event.entity.TFlight;
import com.guangeryi.event.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public void sendMail(Email email) {
		try {
			FileCopyUtils.copy(SerializationUtils.serialize(email), new File("E:/temp/"+email.getTitle()));
		} catch (IOException e) {
			throw new RuntimeException("发生了io异常，异常信息："+e.getMessage());
		}
	}
	@EventListener
	public void eventDoSendMail(TFlight flight){
		//调用邮箱服务，发送邮件
		Email email = new Email("系统","15875545236","航班预订成功邮件","你预定航班成功了，航班号："+flight.getFcode());
		this.sendMail(email);
	}

}
