package com.example.vehicle_garage.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Abstract Class that represent a ElectricMotorcycle, Extends the Abstract Class Motorcycle.
 * Each ElectricMotorcycle has BATTERY as an EnergySource.
 */
@JsonTypeName("electricMotorcycle")
public class ElectricMotorcycle extends Motorcycle
{
    /**
     *
     * @param modelName
     * @param licenseNumber
     * @param availableEnergyPercentage
     * @param maximumTirePressure
     * @param currentTirePressure
     */
    public ElectricMotorcycle(String modelName, Long licenseNumber, double availableEnergyPercentage, double maximumTirePressure, double currentTirePressure)
    {
        super(modelName, licenseNumber, availableEnergyPercentage, maximumTirePressure, currentTirePressure, EnergySource.BATTERY);
    }
}
