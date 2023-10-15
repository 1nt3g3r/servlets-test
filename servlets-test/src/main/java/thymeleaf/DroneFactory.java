package thymeleaf;

import java.util.stream.Stream;

public class DroneFactory {
    private static final DroneFactory INSTANCE = new DroneFactory();

    private int wings;
    private int frames;
    private int electronics;

    private int assembledDrones;

    private DroneFactory() {
    }

    public static DroneFactory getInstance() {
        return INSTANCE;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    public int getWings() {
        return wings;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public int getFrames() {
        return frames;
    }

    public void setElectronics(int electronics) {
        this.electronics = electronics;
    }

    public int getElectronics() {
        return electronics;
    }

    public int getPossibleDrones() {
        return Stream.of(wings, frames, electronics).min(Integer::compare).orElseThrow();
    }

    public int getAssembledDrones() {
        return assembledDrones;
    }

    public void assembleAndSend() {
        wings--;
        frames--;
        electronics--;

        assembledDrones++;
    }
}
