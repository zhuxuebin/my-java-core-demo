package com.zxb.jvm.core.j05methodinvoke;

import java.util.Random;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/26
 */
public class Profiteer extends Commercial {

    @Override
    public double afterDiscount(double originPrice, Client client) {
        if (client.isVIP()) {
            return originPrice * priceProfiteer();
        } else {
            return super.afterDiscount(originPrice, client);
        }
    }

    public static double priceProfiteer() {
        return new Random()
                .nextDouble()
                + 0.8d;
    }
}
