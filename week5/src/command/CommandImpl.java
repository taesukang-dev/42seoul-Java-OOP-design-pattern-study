package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

interface Command {
    public void execute();
}

class Light {
    String location = "";
    public Light(String location) {
        this.location = location;
    }
    public void on() {
        System.out.println(location + " light is on");
    }
    public void off() {
        System.out.println(location + " light is off");
    }
}

class CeilingFan {
    String location = "";

    public CeilingFan(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " Ceiling fan is on");
    }

    public void off() {
        System.out.println(location + " Ceiling fan is off");
    }
}

class Stereo {
    String location = "";

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " stereo is on");
    }

    public void off() {
        System.out.println(location + " stereo is off");
    }
}

class GarageDoor {
    String location;
    public GarageDoor(String location) {
        this.location = location;
    }
    public void up() {
        System.out.println(location + " garage Door is Up");
    }
    public void down() {
        System.out.println(location + " garage Door is Down");
    }
    public void stop() {
        System.out.println(location + " garage Door is Stopped");
    }
    public void lightOn() {
        System.out.println(location + " garage light is on");
    }
    public void lightOff() {
        System.out.println(location + " garage light is off");
    }
}

class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.off();
    }
}

class CeilingFanOnCommand implements Command {

    CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.on();
    }
}

class CeilingFanOffCommand implements Command {

    CeilingFan ceilingFan;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }
}

class GarageDoorUpCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}

class GarageDoorDownCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }
}

class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
    }
}

class StereoOffCommand implements Command {

    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }
}

class RemoteControl {
    ArrayList<Command> onStore = new ArrayList<>();
    ArrayList<Command> offStore = new ArrayList<>();

    public void setCommand(int idx, Command commandOn, Command commandOff) {
        onStore.add(idx, commandOn);
        offStore.add(idx, commandOff);
    }

    public void onButtonWasPushed(int idx) {
        if (onStore.size() <= idx)
            return;
        onStore.get(idx).execute();
    }

    public void offButtonWasPushed(int idx) {
        if (offStore.size() <= idx)
            return;
        offStore.get(idx).execute();
    }
}

public class CommandImpl {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light livingRoomLight = new Light("Living Room");
        CeilingFan ceilingFan= new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("Garage");
        Stereo stereo = new Stereo("Living Room");
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommand(2, stereoOnWithCD, stereoOff);
        remoteControl.setCommand(3, garageDoorUp, garageDoorDown);
        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);
    }
}
