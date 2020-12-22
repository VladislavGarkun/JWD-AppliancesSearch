package by.tc.task02.entity;

import java.util.Objects;

public class Laptop extends Appliance
{
    private float batteryCapacity;
    private String OS;
    private int memoryROM;
    private int systemMemory;
    private float CPU;
    private int display;

    public Laptop(float batteryCapacity, String OS, int memoryROM, int systemMemory, float CPU, int display) {
        this.batteryCapacity = batteryCapacity;
        this.OS = OS;
        this.memoryROM = memoryROM;
        this.systemMemory = systemMemory;
        this.CPU = CPU;
        this.display = display;
    }

    @Override
    public String toString() {
        String str = "Laptop : " +
                "batteryCapacity = " + batteryCapacity +
                ", os = " + OS  +
                ", memoryRom = " + memoryROM +
                ", systemMemory = " + systemMemory +
                ", cpu = " + CPU +
                ", display = " + display;

        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        boolean bool = batteryCapacity == laptop.batteryCapacity &&
                memoryROM == laptop.memoryROM &&
                systemMemory == laptop.systemMemory &&
                Double.compare(laptop.CPU, CPU) == 0 &&
                display == laptop.display &&
                Objects.equals(OS, laptop.OS);

        return bool;
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, OS, memoryROM, systemMemory, CPU, display);
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return OS;
    }

    public void setOs(String os) {
        this.OS = OS;
    }

    public int getMemoryRom() {
        return memoryROM;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryROM = memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return CPU;
    }

    public void setCpu(float cpu) {
        this.CPU = cpu;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }
}
