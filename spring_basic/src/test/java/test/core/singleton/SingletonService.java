package test.core.singleton;

public class SingletonService {

    // static 으로 명시하면 class-level로 올라가기 때문에 딱 하나의 인스턴스만 존재한다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    // private 접근제한자로 기본생성자를 생성해 놓으면 외부 클래스에서 싱글톤 인스턴스를 생성하는걸 방지할 수 있다.
    private SingletonService(){

    }
    // 만약 임의로 누가 새로운 객체를 생성해놓는다는 가정하에
    public static void main(String[] args) {
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();
    }

    public void login(){
        System.out.println("싱글톤 객체 출력");
    }
}
