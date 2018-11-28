package com.zxb.jvm.core.j06throwable;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/26
 */
public class Foo implements AutoCloseable {

    private final String name;

    public Foo(String name) {
        this.name = name;
    }

    @Override
    public void close() throws RuntimeException {
        throw new RuntimeException(name);
    }

    public static void main(String[] args) throws RuntimeException{
        try(Foo foo0 = new Foo("Foo0");
            Foo foo1 = new Foo("Foo1");
            Foo foo2 = new Foo("Foo2")){
            throw  new RuntimeException("initial");
        }
    }
}
