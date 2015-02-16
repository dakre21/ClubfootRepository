package com.packt.clubfootReg.domain.repository;

import java.util.List;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.User;

public interface UserRepo {

	User getUser1(int id);
	void addUser(User user);
	void setDataSource(DataSource ds);
	List<User> getUser(int id);
	List<User> getAllUsers();
	void deleteUser(int id);
	void updateUser(User user);
	int getMaxUserID();
	
}
