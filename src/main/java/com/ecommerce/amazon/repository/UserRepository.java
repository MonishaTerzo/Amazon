package com.ecommerce.amazon.repository;

import com.ecommerce.amazon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findById(int id);
    @Query("SELECT u.name FROM User u WHERE u.id = :userId")
    String getUsernameById(Long userId);

}
