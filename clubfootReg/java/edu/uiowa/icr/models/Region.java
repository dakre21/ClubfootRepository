package edu.uiowa.icr.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import edu.uiowa.icr.models.Hospital;
 
@Entity
@Table
public class Region {
 
    @Id
    @GeneratedValue
    private Long id;
 
     
    private String name;
     
    @OneToMany(mappedBy="region",cascade=CascadeType.PERSIST)
    private List<Hospital> hospitals = new ArrayList<Hospital>();
      
    public Region() {
        super();
    }
    public Region(String name) {
        this.name = name;
    }
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
    public List<Hospital> getHospitals() {
        return hospitals;
    }
    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
}
