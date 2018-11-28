package com.zxb.jvm.core.j07asmtools.visit;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/27
 */
public class This implements Element {

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String doSth() {
        return "this";
    }
}
