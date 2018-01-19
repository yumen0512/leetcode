package com.ect.designPattern;

/**
 * Created by Mr Wang :) on 18-1-19.
 */
public class SingLeton {

    private static SingLeton singLeton;

    private volatile static SingLeton1 singLeton1;


    public static class Holder{
        public static SingLeton instance = new SingLeton();
    }

    public synchronized static SingLeton getInstance() {

        if (singLeton == null) {
            singLeton = new SingLeton();
        }

        return singLeton;
    }

    // double check 有问题，有可能代码读取到instance不为null时,instance引用的对象有可能还没有完成初始化。
//    前面的双重检查锁定示例代码的第7行(instance=new Singleton();)创建了一个对象。这一
//    行代码可以分解为如下的3行伪代码。
//    memory = allocate();  // 1:分配对象的内存空间
//    ctorInstance(memory);  // 2:初始化对象
//    instance = memory;   // 3:设置instance指向刚分配的内存地址
//    上面3行伪代码中的2和3之间,可能会被重排序(在一些JIT编译器上,这种重排序是真实
//            发生的,详情见参考文献1的“Out-of-order writes”部分)。2和3之间重排序之后的执行时序如
//    下。解决方式

    public static SingLeton getInstanceDoubleCheck() {

        if (singLeton == null) {
            synchronized (SingLeton.class) {
                if (singLeton == null) {
                    singLeton = new SingLeton();
                }
            }
        }

        return singLeton;
    }

    // 解决方式1 用volatitle,禁止初始化和复制重排序
    public static SingLeton1 getInstanceForNotNull() {

        if (singLeton1 == null) {
            synchronized (SingLeton.class) {
                if (singLeton == null) {
                    singLeton = new SingLeton();
                }
            }
        }

        return singLeton1;
    }

    // 解决方式2 基于类初始化解决,类初始化期间可以获取一个锁
    public static SingLeton getInstanceByStiacClass() {
        return Holder.instance ;  // 这里将导致InstanceHolder类被初始化
    }



    public static class SingLeton1 {

    }


}
