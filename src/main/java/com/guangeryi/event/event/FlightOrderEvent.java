package com.guangeryi.event.event;

import org.springframework.context.ApplicationEvent;

import com.guangeryi.event.entity.TFlight;

public class FlightOrderEvent extends ApplicationEvent{

	public FlightOrderEvent(TFlight tflight) {
		super(tflight);
	}
}
