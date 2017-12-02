package com.guangeryi.event.mapper;

import com.guangeryi.event.entity.TFlight;

public interface TFlightMapper {
    int insert(TFlight record);

    int insertSelective(TFlight record);
}