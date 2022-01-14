package com.example.vehicle_garage.Controller;

import com.example.vehicle_garage.Entity.Vehicle;
import com.example.vehicle_garage.Service.VehicleGarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * VehicleGarageController, a RestController.
 * Connects the Client to the Service.
 * Using HTTP requests, with the end point: '/vehicle_garage'.
 * Transfer tasks / data from the Client side to the Server side and back.
 */
@RestController
@RequestMapping(path = "vehicle_garage")
public class VehicleGarageController
{
    private final VehicleGarageService vehicleGarageService;

    @Autowired
    public VehicleGarageController(VehicleGarageService vehicleGarageService)
    {
        this.vehicleGarageService = vehicleGarageService;
    }

    /**
     * A Post Request - add new Vehicle to the Vehicle Garage.
     * The Vehicle pass through the RequestBody.
     * If the addition was successful, the HttpStatus.CREATED (201).
     * @param vehicle - Given Vehicle in the Request Body (Vehicle type).
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addVehicle(@RequestBody Vehicle vehicle)
    {
        vehicleGarageService.addVehicle(vehicle);
    }

    /**
     * A Get Request - find Vehicle in the Vehicle Garage, by a given licenseNumber.
     * The licenseNumber pass through the PathVariable.
     * @param licenseNumber - Given licenseNumber (Long type).
     * @return the Vehicle if exists in the DB, otherwise null.
     */
    @GetMapping(path = "{licenseNumber}")
    public Vehicle findVehicle(@PathVariable("licenseNumber") Long licenseNumber)
    {
        return vehicleGarageService.findVehicle(licenseNumber);
    }

    /**
     * A Get Request - Get all Vehicles in the Vehicle Garage.
     * The vehicles can be sort by one or more properties (in an ASC order), but it is not must.
     * The properties pass through the RequestBody, but it is not a required parameter.
     * @param properties - The properties to sort by, not a required parameter (String[] type).
     * @return all Vehicles in the Vehicle Garage, otherwise [].
     */
    @GetMapping
    public List<Vehicle> getAllVehicles(@RequestBody(required = false) String[] properties)
    {
        return vehicleGarageService.getAllVehicles(properties);
    }

    /**
     * A Put Request - inflate the Vehicle tires to the maximum pressure of it, by a given licenseNumber.
     * The licenseNumber pass through the PathVariable.
     * If the tires inflate was successful, the HttpStatus.NO_CONTENT (204).
     * @param licenseNumber - Given licenseNumber (Long type).
     */
    @PutMapping(path = "inflate_tire/{licenseNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inflateTireVehicle(@PathVariable("licenseNumber") Long licenseNumber)
    {
        try
        {
            vehicleGarageService.inflateTireVehicle(licenseNumber);
        }
        catch (Exception e)
        {
            // Case where tires inflate did not succeed (Vehicle not exists in DB), throw Exception.
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Sorry, Vehicle with licenseNumber " + licenseNumber + " does not exists.");
        }
    }

    /**
     * A Put Request - add energy to the Vehicle, by a given licenseNumber.
     * The licenseNumber pass through the PathVariable.
     * If the energy addition was successful, the HttpStatus.NO_CONTENT (204).
     * @param licenseNumber - Given licenseNumber (Long type).
     * @param energy - Given energy to add to the Vehicle (double type).
     */
    @PutMapping(path = "add_energy/{licenseNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addEnergyVehicle(
            @PathVariable("licenseNumber") Long licenseNumber,
            @RequestParam double energy)
    {
        try
        {
            vehicleGarageService.addEnergyVehicle(licenseNumber, energy);
        }
        catch (Exception e)
        {
            // Case where energy addition did not succeed (Vehicle not exists in DB), throw Exception.
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Sorry, Vehicle with licenseNumber " + licenseNumber + " does not exists.");
        }
    }
}
