package mediator;

import java.util.ArrayList;

abstract class Colleague {
    Mediator mediator;
    String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}

class ColleagueImpl extends Colleague {
    public ColleagueImpl(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + " send message = " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + " received message = " + msg);
    }
}

interface Mediator {
    void addUser(Colleague user);

    void deleteUser(Colleague user);

    void sendMessage(String msg, Colleague user);
}

class MediatorImplClass implements Mediator {
    ArrayList<Colleague> store = new ArrayList<>();

    @Override
    public void addUser(Colleague user) {
        store.add(user);
    }

    @Override
    public void deleteUser(Colleague user) {
        store.remove(user);
    }

    @Override
    public void sendMessage(String msg, Colleague user) {
        for (Colleague colleague : store) {
            if (colleague != user) {
                colleague.receive(msg);
            }
        }
    }
}


public class MediatorImpl {
    public static void main(String[] args) {
        MediatorImplClass m = new MediatorImplClass();
        ColleagueImpl asd1 = new ColleagueImpl(m, "asd");
        ColleagueImpl asd2 = new ColleagueImpl(m, "zxc");
        ColleagueImpl asd3 = new ColleagueImpl(m, "qwe");
        ColleagueImpl asd4 = new ColleagueImpl(m, "cvb");
        m.addUser(asd1);
        m.addUser(asd2);
        m.addUser(asd3);
        m.addUser(asd4);
        asd1.send("hi!");
    }
}
