package com.zxb.jvm.core.j07asmtools.visit;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/27
 */
public interface Element {

    void accept(IVisitor visitor);

    String doSth();
}
