package com.ni.retail.respositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ni.retail.Retailer;

@Repository
public interface RetailerRepositry extends JpaRepository<Retailer, Integer> {
    public int deleteByName(String name);

    @Query(value = "SELECT * Retailer r where r.name=:name OR r.age=:age", nativeQuery = true)
    public int findByNameOrAge(String name, int age);

    @Modifying
    @Query(value = "DELETE FROM Retailer r where r.age=:age", nativeQuery = true)
    public int deleteByAge(int age);

    @Modifying
    @Query(value = "DELETE FROM Retailer r where r.age=:age and r.name=:name", nativeQuery = true)
    public int deleteByAgeAndName(int age, String name);

}
