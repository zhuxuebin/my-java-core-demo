package com.zxb.java.core.mapstruct;

import lombok.Data;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/23
 */
@Data
public class Car {

    private String make;
    private int numberOfSeats;
    private String type;
    private String name;

    public Car(String make, int numberOfSeats, String type, String name){
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
        this.name = name;
    }

    public Car(String make, int numberOfSeats, String type){
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }
}
