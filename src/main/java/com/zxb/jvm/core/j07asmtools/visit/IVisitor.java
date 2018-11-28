package com.zxb.jvm.core.j07asmtools.visit;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/27
 */
public interface IVisitor {

    void visit(This e);

    void visit(That e);

    void visit(Theother e);
}
