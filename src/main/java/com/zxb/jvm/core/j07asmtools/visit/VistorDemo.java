package com.zxb.jvm.core.j07asmtools.visit;

/**
 * 描述：
 *
 * @author xuery
 * @date 2018/11/27
 */
public class VistorDemo {

    public static Element[] list = {new This(), new That(), new Theother()};

    public static void main(String[] args) {
        IVisitor upVisitor = new UpVisitor();
        IVisitor downVisitor = new DownVisitor();
        for (int i = 0; i < list.length; i++) {
            list[i].accept(upVisitor);
        }

        for (int i = 0; i < list.length; i++) {
            list[i].accept(downVisitor);
        }
    }
}
