package com.example.vehicle_garage.Entity;

/**
 * Abstract Class that represent a Motorcycle, Extends the Abstract Class Vehicle.
 * Each Motorcycle has exactly 2 wheels.
 */
public abstract class Motorcycle extends Vehicle
{
    /**
     * Constructor - Crate new Motorcycle, using Super to Vehicle Class Constructor, with 2 wheels property.
     * @param modelName
     * @param licenseNumber
     * @param availableEnergyPercentage
     * @param maximumTirePressure
     * @param currentTirePressure
     * @param energySource
     */
    public Motorcycle(String modelName, Long licenseNumber, double availableEnergyPercentage, double maximumTirePressure, double currentTirePressure, EnergySource energySource)
    {
        super(modelName, licenseNumber, availableEnergyPercentage, maximumTirePressure, currentTirePressure, energySource, 2);
    }
}
