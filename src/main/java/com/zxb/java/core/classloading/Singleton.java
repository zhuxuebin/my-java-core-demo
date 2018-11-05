
public class Singleton {

    private Singleton(){

    }

    public static Object getInstance(boolean flag){
        if(flag){
            return  new InnerHolder[2];
        }
        return InnerHolder.INSTANCE;
    }

    //只会在类调用INSTANCE时才会初始化
    private static class InnerHolder{
        private static Singleton INSTANCE = new Singleton();
        static{
            System.out.println("Lazy Holder.<clinit>");
        }
    }

    public static void main(String[] args) {
        getInstance(true);
        System.out.println("------------");
        getInstance(false);
    }
}
