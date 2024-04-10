package pl.kurs.watercontainers.models;

import pl.kurs.watercontainers.exceptions.InvalidCapacityException;
import pl.kurs.watercontainers.exceptions.InvalidWaterLevelException;

public class WaterContainer {

    private String name;
    private double maxCapacity;
    private double waterLevel;

    private WaterContainer(String name, double maxCapacity, double waterLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.waterLevel = waterLevel;
    }
    public static WaterContainer create(String name, double maxCapacity, double waterLevel){
        if (maxCapacity <= 0)
            throw new InvalidCapacityException("Max capacity must be more than zero");
        if (waterLevel < 0 || waterLevel > maxCapacity)
            throw new InvalidWaterLevelException("Invalid water level value");
        return new WaterContainer(name, maxCapacity, waterLevel);
    }



    @Override
    public String toString() {
        return "WaterContainer{" +
                "name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", waterLevel=" + waterLevel +
                '}';
    }
}
