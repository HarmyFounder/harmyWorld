package com.harmyFounder.harmyWorld.repositories;

import com.harmyFounder.harmyWorld.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<User, String> {



}
