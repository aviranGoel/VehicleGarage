package com.example.vehicle_garage.Service;

import com.example.vehicle_garage.Entity.Vehicle;
import com.example.vehicle_garage.Repository.VehicleGarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * VehicleGarageService, a Service.
 * Connects the RestController to the Repository.
 * In case of Exception, can throw it directly to the Client side, without passing through the RestController.
 */
@Service
public class VehicleGarageService
{
    private final VehicleGarageRepository vehicleGarageRepository;

    @Autowired
    public VehicleGarageService(VehicleGarageRepository vehicleGarageRepository)
    {
        this.vehicleGarageRepository = vehicleGarageRepository;
    }

    /**
     * Add new Vehicle to the Vehicle Garage.
     * If the given Vehicle exists in the Garage (Vehicle licenseNumber exists in the DB),
     * throw new ResponseStatusException of HttpStatus.CONFLICT (409).
     * @param vehicle - Given Vehicle (Vehicle type).
     */
    public void addVehicle(Vehicle vehicle)
    {
        Long licenseNumber = vehicle.getLicenseNumber();

        // Check if given Vehicle already exists in the Garage (DB), by searching its licenseNumber.
        if(vehicleGarageRepository.findByLicenseNumber(licenseNumber) != null)
        {
            // In case the Vehicle already exists, throw Exception.
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Sorry, Vehicle with licenseNumber " + vehicle.getLicenseNumber() + " already exists.");
        }
        // Otherwise (Vehicle not exists in the Garage), add it.
        vehicleGarageRepository.save(vehicle);
    }

    /**
     * Find Vehicle in the Vehicle Garage, by the given licenseNumber.
     * If the given licenseNumber not exists in the Garage,
     * throw new ResponseStatusException of HttpStatus.NOT_FOUND (404).
     * @param licenseNumber - Given licenseNumber (Long type).
     * @return the Vehicle if exists in the DB, otherwise throw ResponseStatusException.
     */
    public Vehicle findVehicle(Long licenseNumber)
    {
        // Find the Vehicle in the Garage (DB), by searching its licenseNumber.
        Vehicle vehicle = vehicleGarageRepository.findByLicenseNumber(licenseNumber);

        if(vehicle == null)
        {
            // In case the Vehicle not exists, throw Exception.
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Sorry, Vehicle with licenseNumber " + licenseNumber + " does not exists.");
        }

        // Otherwise (Vehicle exists in the Garage), return it.
        return vehicle;
    }

    /**
     * Get all Vehicles in the Vehicle Garage.
     * The vehicles can be sort by one or more properties (in an ASC order), but it is not must.
     * @param properties - The properties to sort by, not a required parameter (String[] type).
     * @return all Vehicles in the Vehicle Garage, otherwise [].
     */
    public List<Vehicle> getAllVehicles(String[] properties)
    {
        // In case where not want to sort by any property.
        if (properties == null)
        {
            // Find all Vehicles in the Vehicle Garage.
            return vehicleGarageRepository.findAll();
        }

        // In case where want to sort by a property one or more.

        // Create a List of Sorting Orders for the given properties.
        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order;

        // For each property, create an ASC Sorting order.
        for (String property : properties)
        {
            order = new Sort.Order(Sort.Direction.ASC, property);
            orders.add(order);
        }

        // Find all Vehicles in the Vehicle Garage, sorting by the List of Sorting Orders (the given properties).
        return vehicleGarageRepository.findAll(Sort.by(orders));
    }

    /**
     * Inflate the Vehicle tires to the maximum pressure of it, by a given licenseNumber.
     * If the given licenseNumber not exists in the Garage,
     * throw new ResponseStatusException of HttpStatus.NOT_FOUND (404).
     * @param licenseNumber - Given licenseNumber (Long type).
     */
    @Transactional
    public void inflateTireVehicle(Long licenseNumber)
    {
        // Find the Vehicle in the Garage (DB), by searching its licenseNumber.
        Vehicle vehicle = vehicleGarageRepository.findByLicenseNumber(licenseNumber);

        if(vehicle == null)
        {
            // In case the Vehicle not exists, throw Exception.
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Sorry, Vehicle with licenseNumber " + licenseNumber + " does not exists.");
        }

        // Otherwise (Vehicle exists in the Garage), inflate its tires and update it in the DB.
        vehicle.inflateTire();
        vehicleGarageRepository.save(vehicle);
    }

    /**
     * Add energy to the Vehicle, by a given licenseNumber.
     * If the given licenseNumber not exists in the Garage,
     * throw new ResponseStatusException of HttpStatus.NOT_FOUND (404).
     * @param licenseNumber - Given licenseNumber (Long type).
     * @param energy - Given energy to add to the Vehicle (double type).
     */
    @Transactional
    public void addEnergyVehicle(Long licenseNumber, double energy)
    {
        // Find the Vehicle in the Garage (DB), by searching its licenseNumber.
        Vehicle vehicle = vehicleGarageRepository.findByLicenseNumber(licenseNumber);

        if(vehicle == null)
        {
            // In case the Vehicle not exists, throw Exception.
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Sorry, Vehicle with licenseNumber " + licenseNumber + " does not exists.");
        }

        // Otherwise (Vehicle exists in the Garage), add energy to it and update it in the DB.
        vehicle.addEnergy(energy);
        vehicleGarageRepository.save(vehicle);
    }
}
