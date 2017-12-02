package com.guangeryi.event.listener;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.guangeryi.event.entity.TFlight;
import com.guangeryi.event.entity.TMsg;
import com.guangeryi.event.event.FlightOrderEvent;
import com.guangeryi.event.service.MsgService;
@Component
public class FlightOrderMsgListener implements ApplicationListener<FlightOrderEvent> {
	@Resource(name = "msgServiceImpl")
	private MsgService ms;

	public void onApplicationEvent(FlightOrderEvent event) {
		TFlight tflight = (TFlight)event.getSource();
		TMsg msg = new TMsg();
		msg.setPhone("15875545236");
		msg.setContent("你预定航班成功了，航班号：" + tflight.getFcode());
		msg.setUser(13);
		msg.setCreatetime(new Date());
		ms.addMsg(msg);
	}
}
