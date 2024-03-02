package com.vtxlab.bootcamp.bootcampsbforum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;

@Repository // -> Bean, similar to @Controller/ @Service
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  // Spring Boot (Hibernate - implementation class for JPA Interface)
  // Hibernate usage: According to the driver (yml),
  // 1. it can generate corresponding SQL syntax (implementation logic)
  // 2. this class also implementing interface UserRepository -> bean

  // Approach 1:
  // Query Methods: java method -> JPQL (Java Persistence Query Language)
  // Hibernate: select u from User u where u.email = ?
  List<UserEntity> findByEmail(String email);

  // Hibernate: select u from u.Users where u.email = ? and u.phone = ? order by u.email desc
  List<UserEntity> findByEmailAndPhoneOrderByEmailDesc(String email, String phone);

  // 1
  // Hibernate: select u from u.Users where u.email = ? or u.phone = ?
  List<UserEntity> findByEmailOrPhoneOrderByEmailDesc(String email, String phone);

  // Approach 2:
  // JPQL: hand-write JPQL
  // Method name is not important in JPQL
  @Query(value = "select u from UserEntity u where u.zipcode = :zc")
  List<UserEntity> findUsersByZipCode(@Param("zc") String zipcode);

  // 2
  @Query(
      value = "select u from UserEntity u where CAST(u.addrLat AS double) > :lat and CAST(u.addrLng AS double) > :lng")
  List<UserEntity> findUsersByLatitudeLongitudeGtrThan(@Param("lat") String latitude,
      @Param("lng") String longitude);
  
  // Approach 3
  // Real SQL - Product Specific (PostgreSQL)
  @Query(value = "select e.* from users e where e.zipcode = :zc", nativeQuery = true)
  List<UserEntity> findUsersByZipCode2(@Param("zc") String zipcode);

}
