package com.CareerDevs.UserAuthentication.repositories;

import com.CareerDevs.UserAuthentication.models.ERole;
import com.CareerDevs.UserAuthentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
