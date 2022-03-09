package com.api.weatherapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.weatherapp.model.UserData;



@Repository
public interface UserDao extends JpaRepository<UserData,String> {

}
