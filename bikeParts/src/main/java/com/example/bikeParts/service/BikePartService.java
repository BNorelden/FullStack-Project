package com.example.bikeParts.service;

import com.example.bikeParts.entity.BikePart;

import java.util.List;

public interface BikePartService {
    List<BikePart> findAll();
    List<BikePart> findAllSearch(String containsStr);

    Object findPartById(int theId);
    List<BikePart> findEvens();
    List<BikePart> findOdds();
    void saveOrUpdate(BikePart bikePart);
    void deleteById(int theId);

}
