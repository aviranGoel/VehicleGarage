package com.example.vehicle_garage.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Class that represent a RegularCar, Extends the Abstract Class Car.
 * Each RegularCar has FUEL_TANK as an EnergySource.
 */
@JsonTypeName("regularCar")
public class RegularCar extends Car
{
    /**
     * Constructor - Crate new RegularCar, using Super to Car Class Constructor, with EnergySource.FUEL_TANK property.
     * @param modelName
     * @param licenseNumber
     * @param availableEnergyPercentage
     * @param maximumTirePressure
     * @param currentTirePressure
     */
    public RegularCar(String modelName, Long licenseNumber, double availableEnergyPercentage, double maximumTirePressure, double currentTirePressure)
    {
        super(modelName, licenseNumber, availableEnergyPercentage, maximumTirePressure, currentTirePressure, EnergySource.FUEL_TANK);
    }
}
