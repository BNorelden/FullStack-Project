package com.example.bikeParts.entity;


import javax.persistence.*;

@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "bikeparts") //This is for the actual name of the database table we are mapping to the class.
//DONT FORGET TABLE NAME HAS TO BE THE SAME
public class BikePart {

// `id` `bike_part` `part_description`


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//an incremental
    @Column(name = "id")
    private int id;

    @Column(name = "bike_part") //This is sql column called bike_part
    private String bike_part;

    @Column(name = "part_description") //This is another sql column
    private String part_description;

    public BikePart(){
    }

    public BikePart(String bike_part,String part_description){
        this.bike_part = bike_part;
        this.part_description = part_description;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBike_part(String bike_part) {
        this.bike_part = bike_part;
    }

    public String getBike_part() {
        return bike_part;
    }

    public void setPart_description(String part_description) {
        this.part_description = part_description;
    }

    public String getPart_description() {
        return part_description;
    }

    @Override
    public String toString() {
        return "BikePart{" +
                "id=" + id +
                ", bike_part='" + bike_part + '\'' +
                ", part_description='" + part_description + '\'' +
                '}';
    }
}
