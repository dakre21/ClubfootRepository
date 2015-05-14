package edu.uiowa.icr.models;

/**
 * 
 * @author David
 * User model class that contains all the attributes to be added to the database and visible on the form.
 */
//User class
public class User {
	// Form attributes to by synchronized to the database
	private int id;
	private String userName;
	private String email;
	private int hospitalId;
	private String hospitalName;
	private int roleId;
	private String roleName;
	
	public User() {
		
	}
	
	// User constructor that sets up the retriving information from the database via this model
	public User(int id, String userName, String email, int hospitalId, String hospitalName, int roleId, String roleName) {
		// Sets current object "this" to the value being passed when this model is being instantiated 
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * Getter and setter methods for all of the forms attributes. These get the value being passed into the model, and effectively set
	 * the value to the model attribute to be synchronized to the database (visa versa for pull requests). 
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
