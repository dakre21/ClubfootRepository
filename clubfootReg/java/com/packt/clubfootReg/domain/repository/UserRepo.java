package com.packt.clubfootReg.domain.repository;

import java.util.List;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.User;

/**
 * 
 * @author David
 * Interface for the User Repository to synchronize data to the database via the following interface methods.
 */
public interface UserRepo {
	void addUser(User user); // addUser method to add the model data to the database
	void setDataSource(DataSource ds); // Sets up the dataSource for the database synch
	List<User> getUser(int id);	// List object that has the method getUser and takes in an int id
	List<User> getAllUsers(); // List object that contains the getAllusers method
	void deleteUser(int id);	// DeleteUser method which takes the id value 
	void updateUser(User user);	// UpdateUser method which takes in the user object
	int getMaxPersonID();	 // Method that returns the maxpersonid
}
