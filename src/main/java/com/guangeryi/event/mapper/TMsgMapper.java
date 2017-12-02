package com.guangeryi.event.mapper;

import com.guangeryi.event.entity.TMsg;

public interface TMsgMapper {
    int insert(TMsg record);

    int insertSelective(TMsg record);
}