package com.zxb.jvm.core.j07asmtools.visit;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/27
 */
public class UpVisitor implements IVisitor {

    @Override
    public void visit(This e) {
        System.out.println("up " + e.doSth());
    }

    @Override
    public void visit(That e) {
        System.out.println("up " + e.doSth());
    }

    @Override
    public void visit(Theother e) {
        System.out.println("up " + e.doSth());
    }
}
