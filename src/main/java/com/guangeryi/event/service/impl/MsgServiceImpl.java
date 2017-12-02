package com.guangeryi.event.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.guangeryi.event.entity.TFlight;
import com.guangeryi.event.entity.TMsg;
import com.guangeryi.event.mapper.TMsgMapper;
import com.guangeryi.event.service.MsgService;

@Service
public class MsgServiceImpl implements MsgService {
	
	@Resource
	private TMsgMapper mapper;
	

	@Override
	public void addMsg(TMsg msg) {
		mapper.insertSelective(msg);

	}
	@EventListener
	public void eventDoMsg(TFlight flight){
		//调用短信服务，新增短信数据
		TMsg msg = new TMsg();
		msg.setPhone("15875545236");
		msg.setContent("你预定航班成功了，航班号："+flight.getFcode());
		msg.setUser(flight.getUser());
		msg.setCreatetime(new Date());
		this.addMsg(msg);
	}

}
