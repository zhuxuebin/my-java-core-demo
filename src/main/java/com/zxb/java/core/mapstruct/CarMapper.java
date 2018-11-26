package com.zxb.java.core.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/23
 */
@Mapper(componentModel = "spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class); //提供实例给调用方调用

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);

}
