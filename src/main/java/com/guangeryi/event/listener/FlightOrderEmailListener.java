package com.guangeryi.event.listener;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.guangeryi.event.entity.Email;
import com.guangeryi.event.entity.TFlight;
import com.guangeryi.event.event.FlightOrderEvent;
import com.guangeryi.event.service.EmailService;
@Component
public class FlightOrderEmailListener implements ApplicationListener<FlightOrderEvent> {
	@Resource(name = "emailServiceImpl")
	private EmailService es;

	public void onApplicationEvent(FlightOrderEvent event) {
		TFlight tflight = (TFlight) event.getSource();
		Email email = new Email("系统", "15875545236", "航班预订成功邮件", "你预定航班成功了，航班号：" + tflight.getFcode());
		es.sendMail(email);
	}
}
