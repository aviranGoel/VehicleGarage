package com.example.vehicle_garage.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Class that represent a ElectricCar, Extends the Abstract Class Car.
 * Each ElectricCar has BATTERY as an EnergySource.
 */
@JsonTypeName("electricCar")
public class ElectricCar extends Car
{
    /**
     * Constructor - Crate new ElectricCar, using Super to Car Class Constructor, with EnergySource.BATTERY property.
     * @param modelName
     * @param licenseNumber
     * @param availableEnergyPercentage
     * @param maximumTirePressure
     * @param currentTirePressure
     */
    public ElectricCar(String modelName, Long licenseNumber, double availableEnergyPercentage, double maximumTirePressure, double currentTirePressure)
    {
        super(modelName, licenseNumber, availableEnergyPercentage, maximumTirePressure, currentTirePressure, EnergySource.BATTERY);
    }
}
