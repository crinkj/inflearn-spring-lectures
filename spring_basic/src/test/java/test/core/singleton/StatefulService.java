package test.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public int order(String name, int price){
        return price;
    }

}
