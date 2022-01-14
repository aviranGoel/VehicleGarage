# Vehicle Garage

## Welcome to Vehicle Garage Backend API!

### A Backend Rest API which based Java, Spring Boot Application, using MongoDB and runs locally.

Java 17 <br>
Maven 4<br>
Spring Boot 2.6.2 <br>

### The server can receive the following requests from the client:

1. Add a new Vehicle to the Vehicle Garage.

   By receiving a Post request that contains the Vehicle details, within the body request:

   "http://localhost:8080/vehicle_garage"

2. Find Vehicle in the Vehicle Garage.

   By receiving a Get request that contains the vehicle License Number, within the path parameters:

   "http://localhost:8080/vehicle_garage/{licenseNumber}"

3. Find all Vehicles in the Vehicle Garage.

   By receiving a Get request.
   
   The request can contain an array of properties to sort the vehicles, within the body request:

   "http://localhost:8080/vehicle_garage"

4. Inflate the Vehicle tires to the maximum pressure of it.

   By receiving a Put request that contains the vehicle License Number, within the path parameters:

   "http://localhost:8080/vehicle_garage/inflate_tire/{licenseNumber}"

5. Add energy to the Vehicle.

   By receiving a Put request that contains the vehicle License Number, within the path request,
   and an energy, within the query parameters:

   "http://localhost:8080/vehicle_garage/add_energy/{licenseNumber}?energy={energyToAdd}"

### The Vehicles are saved in 'test.vehicle' Collection at 'MyVehicleGarageCluster' Database of MongoDB. 

---
## Instructions:

To get the VehicleGarageApplication app running locally, follow these steps:

1. Unzip the `VehicleGarage` folder.
2. Open the `VehicleGarage` project on your favorite IDE.
3. Run the `main` function of `VehicleGarageApplication` class. 
4. Access the paths mentioned above by using `Postman`.

Note: <br>
A file called `VehicleGarage.postman_collection.json` attached in the folder. <br>
You can import it to your `Postman` and run the HTTP requests, or use them as an example to write your own HTTP requests.