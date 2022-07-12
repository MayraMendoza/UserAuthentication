package com.CareerDevs.UserAuthentication.repositories;

import com.CareerDevs.UserAuthentication.models.Listener;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenerRepository extends JpaRepository<Listener, Long> {
//    //custom function
//    //generates query: "Select * From listener WHERE age = ?1"
//    List<Listener> findALLByAge(Integer age);
//
//    @Query("Select * From listener WHERE name Like '%?1%'")
//    List<Listener> findAllByPartialName(String query);

}
