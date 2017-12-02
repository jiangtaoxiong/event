package com.guangeryi.event.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guangeryi.event.entity.TFlight;
import com.guangeryi.event.mapper.TFlightMapper;
import com.guangeryi.event.service.EmailService;
import com.guangeryi.event.service.FlightService;
import com.guangeryi.event.service.MsgService;

@Service
public class FlightServiceImpl implements FlightService, ApplicationContextAware {

	@Resource
	private TFlightMapper mapper;

	@Resource(name = "msgServiceImpl")
	private MsgService ms;
	@Resource(name = "emailServiceImpl")
	private EmailService es;
	private ApplicationContext applicationContext;

	@Override
	@Transactional
	public void orderFlight(int user, String fcode) {

		TFlight flight = new TFlight();
		flight.setFcode(fcode);
		flight.setOrdertime(new Date());
		flight.setUser(user);
		mapper.insertSelective(flight);

		
/*		 TMsg msg = new TMsg();
		 msg.setPhone("15875545236");
		 msg.setContent("你预定航班成功了，航班号："+"HU8215");
		 msg.setUser(13);
		 msg.setCreatetime(new Date());
		 ms.addMsg(msg);
		 Email email = new
		 Email("系统","15875545236","航班预订成功邮件","你预定航班成功了，航班号："+"HU8215");
		 es.sendMail(email);*/
		 
		//applicationContext.publishEvent(new FlightOrderEvent(flight));
		
		applicationContext.publishEvent(flight);

	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

}
