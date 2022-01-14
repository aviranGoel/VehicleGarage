package com.example.vehicle_garage.Repository;

import com.example.vehicle_garage.Entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * VehicleGarageRepository, a Repository.
 * Connects the Service to the MongoDB.
 */
@Repository
public interface VehicleGarageRepository extends MongoRepository<Vehicle, Long>
{
    /**
     * Find Vehicle in the DB, by the given licenseNumber.
     * @param licenseNumber - Given licenseNumber (Long type).
     * @return the Vehicle if exists in the DB, otherwise null.
     */
    @Query("{ 'licenseNumber' : ?0 }")
    Vehicle findByLicenseNumber(Long licenseNumber);
}
