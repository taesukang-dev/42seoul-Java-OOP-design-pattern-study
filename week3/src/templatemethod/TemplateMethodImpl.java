package templatemethod;

abstract class Car {
    public void startCar(){
        System.out.println("시동을 켭니다.");
    }
    public abstract void drive();
    public abstract void stop();
    public void turnOff(){
        System.out.println("시동을 끕니다.");
    }
    public final void run() {
        startCar();
        drive();
        stop();
        turnOff();
    }
}

class AICar extends Car {
    @Override
    public void drive() {
        System.out.println("자율주행합니다.");
    }

    @Override
    public void stop() {
        System.out.println("자동차가 스스로 방향을 바꿉니다.");
    }
}

class ManualCar extends Car {
    @Override
    public void drive() {
        System.out.println("사람이 운전합니다.");
    }

    @Override
    public void stop() {
        System.out.println("브레이크를 밟아서 정지합니다.");
    }
}



public class TemplateMethodImpl {
    public static void main(String[] args) {
        AICar aiCar = new AICar();
        aiCar.run();

        System.out.println("============");
        ManualCar manualCar = new ManualCar();
        manualCar.run();
    }
}
