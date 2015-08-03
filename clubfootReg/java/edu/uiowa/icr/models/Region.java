package edu.uiowa.icr.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import edu.uiowa.icr.models.Hospital;
 
@Entity
@Table(name="region")
public class Region {
 
    @Id
    @GeneratedValue
    //@Column(columnDefinition = "int")
    private Long id;
 
     
    private String name;
         
    //CascadeType was PERSIST
    @OneToMany(mappedBy="region",cascade=CascadeType.ALL)
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
    public String toString() {
    	return this.id + ", name: " + this.name;
    }
}
