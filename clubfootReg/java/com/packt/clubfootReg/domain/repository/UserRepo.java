package com.packt.clubfootReg.domain.repository;

import java.util.List;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.User;

public interface UserRepo {
	void addUser(User user);
	void setDataSource(DataSource ds);
	List<User> getUser(int id);
	List<User> getAllUsers();
	void deleteUser(int id);
	void updateUser(User user);
	int getMaxPersonID();	
}
