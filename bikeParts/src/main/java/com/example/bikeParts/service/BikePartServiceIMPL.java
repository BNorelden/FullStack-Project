package com.example.bikeParts.service;

import com.example.bikeParts.dao.BikePartDAO;
import com.example.bikeParts.entity.BikePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikePartServiceIMPL implements BikePartService{

    private final BikePartDAO bikePartDAO;

    @Autowired
    public BikePartServiceIMPL(BikePartDAO bikePartDAO){
        this.bikePartDAO = bikePartDAO;
    }


    @Override
    public List<BikePart> findAll() {
        return bikePartDAO.findAll();
    }

    @Override
    public List<BikePart> findAllSearch(String containsStr) {
        return bikePartDAO.findAllSearch(containsStr);
    }

    @Override
    public Object findPartById(int theId) {
        return bikePartDAO.findPartById(theId);
    }

    @Override
    public List<BikePart> findEvens() {

        return bikePartDAO.findEvens();
    }

    @Override
    public List<BikePart> findOdds() {
        return bikePartDAO.findOdds();
    }

    @Override
    public void saveOrUpdate(BikePart bikePart) {
         bikePartDAO.saveOrUpdate(bikePart);
    }

    @Override
    public void deleteById(int theId) {
        bikePartDAO.deleteById(theId);
    }


}
