package com.leo.zkozz.model;

import com.leo.zkozz.model.enumeration.Form;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    @NotNull
    @Column(name = "name", unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Form form;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "company")
    private List<Filial> listFilials;

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

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Filial> getListFilials() {
        return listFilials;
    }

    public void setListFilials(List<Filial> listFilials) {
        this.listFilials = listFilials;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", form=" + form +
                ", address=" + address +
                '}';
    }
}