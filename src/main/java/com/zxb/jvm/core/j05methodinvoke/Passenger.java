package com.zxb.jvm.core.j05methodinvoke;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/26
 */
public abstract class Passenger {

    abstract void goOutside();

    public static void main(String[] args) {
        Passenger chinese = new Chinese();
        Passenger foreign = new Foreign();
        long current = System.currentTimeMillis();

        for (int i = 0; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            Passenger c = i < 1_000_000_000 ? chinese : foreign;
            c.goOutside();
        }
    }
}

class Chinese extends Passenger {
    @Override
    void goOutside() {
//        System.out.println("Chinese go outside");
    }
}

class Foreign extends Passenger {
    @Override
    void goOutside() {
//        System.out.println("Foreign go outside");
    }
}
