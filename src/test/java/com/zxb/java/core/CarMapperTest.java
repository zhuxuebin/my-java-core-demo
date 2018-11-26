package com.zxb.java.core;

import com.zxb.java.core.mapstruct.Car;
import com.zxb.java.core.mapstruct.CarDto;
import com.zxb.java.core.mapstruct.CarMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/23
 */
public class CarMapperTest extends MySpringBootDemoApplicationTests{

//    @Autowired
//    private CarMapper carMapper;

    @Test
    public void  test(){
        System.out.println("test");
    }

//    @Test
//    public void shouldMapCarToDto() {
//        //given
//        Car car = new Car("morris", 5, "sean");
//
//        //when
////        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);
//        CarDto carDto = carMapper.carToCarDto(car);
//
//        Assert.assertEquals(carDto.getMake(),"morris");
//        Assert.assertEquals(carDto.getSeatCount(),5);
//        Assert.assertEquals(carDto.getType(),"sean");
//    }
}
