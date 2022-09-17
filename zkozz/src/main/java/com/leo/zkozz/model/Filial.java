package com.leo.zkozz.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "filial")
public class Filial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    @NotNull
    @Column(name = "name", unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Filial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}