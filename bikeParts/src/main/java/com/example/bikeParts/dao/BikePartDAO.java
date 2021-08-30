package com.example.bikeParts.dao;

import com.example.bikeParts.entity.BikePart;

import java.util.List;

public interface BikePartDAO {

    List<BikePart> findAll();
    List<BikePart> findAllSearch(String containsStr);
    List<BikePart> findEvens();
    List<BikePart> findOdds();
    Object findPartById(int theId);
    void saveOrUpdate(BikePart bikePart);
    void deleteById(int theId);
}
