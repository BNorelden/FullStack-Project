package com.example.bikeParts.dao;

import com.example.bikeParts.entity.BikePart;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BikePartIMPL implements BikePartDAO{

    private final EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public BikePartIMPL(EntityManager entityManager) {

        this.entityManager = entityManager;
    }


    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<BikePart> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<BikePart> myQuery = currentSession.createQuery("from BikePart");//think its from class not table here
        return myQuery.getResultList();

    }

    @Override
    @Transactional
    public List<BikePart> findAllSearch(String containsStr) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<BikePart> myQuery = currentSession.createQuery("from BikePart where bike_part like '%"+containsStr+"%'");//think its from class not table here
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public List<BikePart> findEvens() { // even ids
        Session currentSession = entityManager.unwrap(Session.class);
        Query<BikePart> myQuery = currentSession.createQuery("from BikePart where id%2=0");//think its from class not table here

        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public List<BikePart> findOdds() { //odd ids
        Session currentSession = entityManager.unwrap(Session.class);
                                                //the query Statement you :/
//        Query<BikePart> myQuery = currentSession.createQuery("from BikePart where id%2!=0");//think its from class not table here
//        Query<BikePart> myQuery = currentSession.createQuery("from bikepart");
        Query<BikePart> myQuery = currentSession.createQuery("from BikePart");

        List<BikePart> oddArrayList = new ArrayList<>(myQuery.getResultList());

        oddArrayList.removeIf(i->i.getId()%2==0); //TRYING TO REMOVE EVEN ONES worked here but not with forEach

//        oddArrayList.forEach(i ->{  //this doesn't work for some reason??
//
//            if(i.getId()%2==0){//TRYING TO REMOVE EVEN ONES
//                oddArrayList.remove(i);
//
//            }
//        });


//        return myQuery.getResultList();

        return oddArrayList;
    }

    @Override
    @Transactional
    public Object findPartById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(BikePart.class, theId);
    }

    @Override
    @Transactional
    public void saveOrUpdate(BikePart bikePart) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(bikePart);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        BikePart bikePart = currentSession.get(BikePart.class, theId);
        currentSession.delete(bikePart);
    }
}
