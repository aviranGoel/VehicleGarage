package com.example.vehicle_garage.Entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Abstract Class that represent a Vehicle.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Truck.class, name = "truck"),
        @JsonSubTypes.Type(value = RegularCar.class, name = "regularCar"),
        @JsonSubTypes.Type(value = ElectricCar.class, name = "electricCar"),
        @JsonSubTypes.Type(value = RegularMotorcycle.class, name = "regularMotorcycle"),
        @JsonSubTypes.Type(value = ElectricMotorcycle.class, name = "electricMotorcycle"),
})
@Data
public abstract class Vehicle
{
    protected String modelName;
    @Id
    protected Long licenseNumber;
    // How much battery or fuel is left, the maximum its 100.
    protected double availableEnergyPercentage;
    protected double maximumTirePressure;
    protected double currentTirePressure;
    // Enum property, EnergySource can be: BATTERY or FUEL_TANK.
    protected EnergySource energySource;
    protected int wheels;

    /**
     * Constructor - Crate new Vehicle.
     * @param modelName
     * @param licenseNumber
     * @param availableEnergyPercentage
     * @param maximumTirePressure
     * @param currentTirePressure
     * @param energySource
     * @param wheels
     */
    public Vehicle(String modelName, Long licenseNumber, double availableEnergyPercentage, double maximumTirePressure, double currentTirePressure, EnergySource energySource, int wheels)
    {
        this.modelName = modelName;
        this.licenseNumber = licenseNumber;
        this.availableEnergyPercentage = availableEnergyPercentage;
        this.maximumTirePressure = maximumTirePressure;
        this.currentTirePressure = currentTirePressure;
        this.energySource = energySource;
        this.wheels = wheels;
    }

    /**
     * Inflate the Vehicle tire to maximum tire pressure.
     */
    public void inflateTire()
    {
        this.currentTirePressure = this.maximumTirePressure;
    }

    /**
     * Fill the Vehicle energy to full energy.
     * The maximum energy of Vehicle its 100.
     * @param addEnergyPercentage - energy to add (double type).
     */
    public void addEnergy(double addEnergyPercentage)
    {
        double newEnergyPercentage = this.availableEnergyPercentage + addEnergyPercentage;
        if(newEnergyPercentage > 100)
        {
            this.availableEnergyPercentage = 100;
        }
        else
        {
            this.availableEnergyPercentage = newEnergyPercentage;
        }
    }

    /**
     * Create a String of the Vehicle details.
     * @return String of the Vehicle details.
     */
    @Override
    public String toString()
    {
        return "Vehicle{" +
                "modelName='" + modelName + '\'' +
                ", licenseNumber=" + licenseNumber +
                ", availableEnergyPercentage=" + availableEnergyPercentage +
                ", maximumTirePressure=" + maximumTirePressure +
                ", currentTirePressure=" + currentTirePressure +
                ", energySource=" + energySource +
                ", wheels=" + wheels +
                '}';
    }
}
