package proxy.sample;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class Student implements Person{
    private String name;

    public Student(String name) {
        this.name = name;
    }


    @Override
    public void provideFee() {
        // 数钱
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name+"上交班费");
    }
}
