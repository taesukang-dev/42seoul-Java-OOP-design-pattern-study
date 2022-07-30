package statepattern;

interface PlayerLevel {
    public void run();
    public void jump();
    public void turn();
    public void showLevelMessage();
}

class Beginner implements PlayerLevel {

    @Override
    public void run() {
        System.out.println("천천히 달립니다..");
    }

    @Override
    public void jump() {
        System.out.println("Jump 할 줄 모르지롱.");
    }

    @Override
    public void turn() {
        System.out.println("turn 할 줄 모르지롱");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("Beginner");
    }
}

class Advanced implements PlayerLevel {

    @Override
    public void run() {
        System.out.println("빨리 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("높이 Jump 합니다.");
    }

    @Override
    public void turn() {
        System.out.println("turn 할 줄 모르지롱");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("Advanced");
    }
}

class Super implements PlayerLevel {

    @Override
    public void run() {
        System.out.println("아주 빨리 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("아주 높이 jump 합니다.");
    }

    @Override
    public void turn() {
        System.out.println("한 바퀴 돕니다..");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("Super");
    }
}

class Player {

    PlayerLevel pl;

    public Player() {
        this.pl = new Beginner();
    }

    public void play(int time) {
        pl.run();
        for (int i = 0; i < time; i++) {
            pl.jump();
        }
        pl.turn();
    }

    public void upgradeLevel(int level) {
        if (level == 1)
            return ;
        else if (level == 2)
            this.pl = new Advanced();
        else if (level == 3)
            this.pl = new Super();
    }
}

public class StatePattern {
    public static void main(String[] args) {
        Player player = new Player();
        player.play(1);
        System.out.println();

        player.upgradeLevel(2);
        player.play(2);
        System.out.println();

        player.upgradeLevel(3);
        player.play(3);
    }
}
