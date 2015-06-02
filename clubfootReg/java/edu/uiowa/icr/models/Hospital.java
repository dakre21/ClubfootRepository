package edu.uiowa.icr.models;

/**
 * 
 * @author David
 * Hospital model class that contains all the attributes to be added to the database and visible on the form.
 */
//Hospital class
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import edu.uiowa.icr.models.Region;

@Entity
@Table(name="hospital")
public class Hospital {
	
	// Form attributes to by synchronized to the database
	@Id
	@GeneratedValue
    //@Column(columnDefinition = "int")
	private Long id;
	//private int id;
	
	@Column(name = "name")
	private String hospitalName;
	
	@ManyToOne
	@JoinColumn(name="region_id")  //added may 29
    //@Column(columnDefinition = "Long")   //added may 29
	private Region region;
	
	//@Column(name = "region_id")
	//private int regionId;
	
	@Transient
	private String regionName;
	
	@Transient
    //@Column(columnDefinition = "int")
	private Long regionId;
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}
	public Hospital(String name, Region region) {
		this.hospitalName = name;
		this.region = region;
		this.regionId = region.getId();
		this.regionName = region.getName();
	}
	// Hospital constructor that sets up the retrieving information from the database via this model
	public Hospital(Long id, String hospitalName, Long regionId, String regionName){
		// Sets current object "this" to the value being passed when this model is being instantiated 
		this.id = id;
		this.hospitalName = hospitalName;
		this.regionId = regionId;
		this.regionName = regionName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//@Override
	//public String toString() {
	//	return "Hospital [id=" + id + ", name=" + hospitalName + ", region="
	//			+ region.getName() + "]";
	//}
	/**
	 * 
	 * Getter and setter methods for all of the forms attributes. These get the value being passed into the model, and effectively set
	 * the value to the model attribute to be synchronized to the database (visa versa for pull requests). 
	 */

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public Region getRegion () {
		return region;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
	
	@Transient
	public Long getRegionId () {
		return regionId;
	}
	
	@Transient
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	@Transient
	public String getRegionName() {
		return regionName;
	}
	
	@Transient
	public void setRegionName(String regionName) {
		region.setName(regionName);
		this.regionName = regionName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
