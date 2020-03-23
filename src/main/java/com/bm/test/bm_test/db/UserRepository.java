package com.bm.test.bm_test.db;

// vendors
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// local
import com.bm.test.bm_test.model.entity.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE user_name = ?1")
    User findUserById(String userName);
}
