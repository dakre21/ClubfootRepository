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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import edu.uiowa.icr.models.Region;

@Entity
@Table
public class Hospital {
	
	// Form attributes to by synchronized to the database
	@Id
	@GeneratedValue
	private int id;
	//private int id;
	
	@Column(name = "name")
	private String hospitalName;
	
	@ManyToOne
	private Region region;
	
	//@Column(name = "region_id")
	//private int regionId;
	
	@Transient
	private String regionName;
	
	@Transient
	private int regionId;
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}
	public Hospital(String name, Region region) {
		this.hospitalName = name;
		this.region = region;
		this.regionId = region.getId().intValue();
		this.regionName = region.getName();
	}
	// Hospital constructor that sets up the retrieving information from the database via this model
	public Hospital(int id, String hospitalName, int regionId, String regionName){
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
	public int getRegionId () {
		return regionId;
	}
	
	@Transient
	public void setRegionId(int regionId) {
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
