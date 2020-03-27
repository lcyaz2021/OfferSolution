/**
 * @Author ChenYang Li
 * @Date 2020/3/27 18:55
 * 双重加锁校验单例模式
 **/
public class Offer2 {
    private volatile static Offer2 singleton;
    private Offer2(){
    }
    public static Offer2 getInstance(){
        if(singleton == null){
            synchronized (Offer2.class){
                if(singleton == null){
                    singleton = new Offer2();
                }
            }
        }
        return singleton;
    }
}
