package com.guangeryi.event;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guangeryi.event.service.EmailService;
import com.guangeryi.event.service.FlightService;
import com.guangeryi.event.service.MsgService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EventTest {
	
	
	@Resource(name="msgServiceImpl")
	private MsgService ms;
	@Resource(name="flightServiceImpl")
	private FlightService fs;
	@Resource(name="emailServiceImpl")
	private EmailService es;
	@Test
	public void orderFlight() throws InterruptedException{
		fs.orderFlight(13, "HU8215");
		//Thread.currentThread().sleep(500);
		System.out.println("test");
	}


}
