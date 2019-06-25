package proxy;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class Proxy implements Subject {
    private RealSubject mReal;

    public Proxy(RealSubject mReal) {
        this.mReal = mReal;
    }

    @Override
    public void print() {
        if (mReal!=null){
            mReal.print();
        }
    }
}
