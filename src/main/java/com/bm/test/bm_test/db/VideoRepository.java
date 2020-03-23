package com.bm.test.bm_test.db;

// vendors
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// local
import com.bm.test.bm_test.model.Video;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface VideoRepository extends CrudRepository<Video, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM video WHERE name = ?1")
    Video findVideoByName(String name);
}
