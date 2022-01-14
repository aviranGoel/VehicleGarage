package com.example.vehicle_garage.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Class that represent a Truck, Extends the Abstract Class Vehicle.
 * Each Truck has exactly 16 wheels.
 */
@JsonTypeName("truck")
public class Truck extends Vehicle
{
    /**
     * Constructor - Crate new Truck, using Super to Vehicle Class Constructor, with 16 wheels property.
     * @param modelName
     * @param licenseNumber
     * @param availableEnergyPercentage
     * @param maximumTirePressure
     * @param currentTirePressure
     * @param energySource
     */
    public Truck(String modelName, Long licenseNumber, double availableEnergyPercentage, double maximumTirePressure, double currentTirePressure, EnergySource energySource)
    {
        super(modelName, licenseNumber, availableEnergyPercentage, maximumTirePressure, currentTirePressure, energySource, 16);
    }
}
