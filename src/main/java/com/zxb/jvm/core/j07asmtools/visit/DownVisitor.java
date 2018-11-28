package com.zxb.jvm.core.j07asmtools.visit;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/27
 */
public class DownVisitor implements IVisitor {

    @Override
    public void visit(This e) {
        System.out.println("down " + e.doSth());
    }

    @Override
    public void visit(That e) {
        System.out.println("down " + e.doSth());
    }

    @Override
    public void visit(Theother e) {
        System.out.println("down " + e.doSth());
    }
}
