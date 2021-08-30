package com.example.bikeParts.Controller;


import com.example.bikeParts.entity.BikePart;
import com.example.bikeParts.service.BikePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
                                                    // angular: http://localhost:4200/
@CrossOrigin(origins = { "http://localhost:3000/"})// react: http://localhost:3000 //frontend will have to link angular here maybe?
@RestController
public class BikePartController {

private final BikePartService bikePartService;

    @Autowired
    public BikePartController(@Qualifier("bikePartServiceIMPL") BikePartService bikePartService) {//BikePartServiceIMPL didn't work
        this.bikePartService = bikePartService;
    }

    //This is a GET request that will read a list of all the parts.
    //http://localhost:8080/retrieveBikeParts
    @GetMapping("/retrieveBikeParts")
    public List<BikePart> findAll() {
        return bikePartService.findAll();

    }
    //http://localhost:8080/findAllSearch/string
    @GetMapping("/findAllSearch/{searchSTR}")
    public List<BikePart> findAllSearch(@PathVariable String searchSTR) {
        return bikePartService.findAllSearch(searchSTR);

    }//findAllSearch

    //http://localhost:8080/retrieveBikePartsEvens
    @GetMapping("/retrieveBikePartsEvens")
    public List<BikePart> findEvens() {
        return bikePartService.findEvens();

    }
//http://localhost:8080/retrieveBikePartsOdds
    @GetMapping("/retrieveBikePartsOdds")
    public List<BikePart> findOdds() {
        return bikePartService.findOdds();

    }

    //http://localhost:8080/findPartById/5
    @GetMapping("/findPartById/{partId}")
    public Object findById(@PathVariable int partId) {
        return bikePartService.findPartById(partId);


    }

    //http://localhost:8080/addBikePart JSON
    @PostMapping("/addBikePart")
    public BikePart addBikePart(@RequestBody BikePart theBikePart) {
        //also just in case they pass an id in JSON .... set id to o
        //this is to force a save of new item .... instead of update
        theBikePart.setId(0);

        //This will call the employeeDqoImpl.save method to save a new part
        //through the employeeService interface SPRING
        bikePartService.saveOrUpdate(theBikePart);
        return theBikePart;
    }


    //http://localhost:8080/updateBikePart
    @PutMapping("/updateBikePart")
    public BikePart updateBikePart(@RequestBody BikePart updateTheBikePart) {
        //No theEmployee.setId(0); this will execute an update instead of a create
        bikePartService.saveOrUpdate(updateTheBikePart);
        return updateTheBikePart;
    }


    //This is a DELETE request to delete an existing part.
    //http://localhost:8080/deleteBikePart/1
    @DeleteMapping("/deleteBikePart/{partId}")
    public String deletePart(@PathVariable int partId) {
        //This will execute the deleteByID.

        bikePartService.deleteById(partId);
        return "Deleted BikePart id : " + partId;
    }






}
