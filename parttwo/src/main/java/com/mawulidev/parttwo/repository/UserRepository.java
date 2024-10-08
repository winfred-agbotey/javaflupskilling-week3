package com.mawulidev.parttwo.repository;

import org.springframework.stereotype.Repository;


public interface UserRepository {

     /**
      * Simulates fetching a user by their ID.
      * @param id the ID of the user
      * @return the name of the user or null if not found
      */
     String getUserById(Long id);
}
