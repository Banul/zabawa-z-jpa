package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, UUID>, StreamableJpaSpecificationRepository<UserData> {

    @Query(value = "select * from user_data", nativeQuery = true)
    Stream<UserData> findAllUsingStream();
}
