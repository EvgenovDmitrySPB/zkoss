package com.leo.zkozz.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long  id;

    @Column(name = "index")
    private String index;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "street")
    private String street;

    @NotNull
    @Column(name = "house")
    private String house;

    @Column(name = "room")
    private String room;

    @OneToOne(mappedBy = "address")
    private Company company;

    @OneToOne(mappedBy = "address")
    private Filial filial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

//    public Company getCompany() {
//        return company;
//    }
//
//    public void setCompany(Company company) {
//        this.company = company;
//    }
//
//    public Filial getFilial() {
//        return filial;
//    }
//
//    public void setFilial(Filial filial) {
//        this.filial = filial;
//    }

    public String getFullAddress() {
        return index + ", " +
                city + ", " +
                street + ", " +
                house + ", " +
                room + ", " ;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}