package com.example.vehicle_garage.Entity;

/**
 * Abstract Class that represent a Car, Extends the Abstract Class Vehicle.
 * Each Car has exactly 4 wheels.
 */
public abstract class Car extends Vehicle
{
    /**
     * Constructor - Crate new Car, using Super to Vehicle Class Constructor, with 4 wheels property.
     * @param modelName
     * @param licenseNumber
     * @param availableEnergyPercentage
     * @param maximumTirePressure
     * @param currentTirePressure
     * @param energySource
     */
    public Car(String modelName, Long licenseNumber, double availableEnergyPercentage, double maximumTirePressure, double currentTirePressure, EnergySource energySource)
    {
        super(modelName, licenseNumber, availableEnergyPercentage, maximumTirePressure, currentTirePressure, energySource, 4);
    }
}
