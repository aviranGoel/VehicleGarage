package com.example.vehicle_garage.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Abstract Class that represent a RegularMotorcycle, Extends the Abstract Class Motorcycle.
 * Each RegularMotorcycle has FUEL_TANK as an EnergySource.
 */
@JsonTypeName("regularMotorcycle")
public class RegularMotorcycle extends Motorcycle
{
    /**
     * Constructor - Crate new RegularMotorcycle, using Super to Motorcycle Class Constructor, with EnergySource.BATTERY property.
     * @param modelName
     * @param licenseNumber
     * @param availableEnergyPercentage
     * @param maximumTirePressure
     * @param currentTirePressure
     */
    public RegularMotorcycle(String modelName, Long licenseNumber, double availableEnergyPercentage, double maximumTirePressure, double currentTirePressure)
    {
        super(modelName, licenseNumber, availableEnergyPercentage, maximumTirePressure, currentTirePressure, EnergySource.FUEL_TANK);
    }
}
