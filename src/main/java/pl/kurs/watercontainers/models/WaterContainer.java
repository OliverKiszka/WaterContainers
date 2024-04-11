package pl.kurs.watercontainers.models;

import pl.kurs.watercontainers.exceptions.InvalidCapacityException;
import pl.kurs.watercontainers.exceptions.InvalidWaterAmountException;
import pl.kurs.watercontainers.exceptions.InvalidWaterLevelException;

import java.io.Serializable;

public class WaterContainer implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final double maxCapacity;
    private double waterLevel;

    private WaterContainer(String name, double maxCapacity, double waterLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.waterLevel = waterLevel;
    }

    public static WaterContainer create(String name, double maxCapacity, double waterLevel) {
        if (maxCapacity <= 0)
            throw new InvalidCapacityException("Max capacity must be more than zero");
        if (waterLevel < 0 || waterLevel > maxCapacity)
            throw new InvalidWaterLevelException("Invalid water level value");
        return new WaterContainer(name, maxCapacity, waterLevel);
    }

    public void addWater(double value) {
        if (value <= 0) {
            throw new InvalidWaterAmountException("Water value should be more than 0");
        }
        if (waterLevel + value > maxCapacity) {
            throw new InvalidWaterAmountException("Too much water to add!");
        }
        waterLevel += value;
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
