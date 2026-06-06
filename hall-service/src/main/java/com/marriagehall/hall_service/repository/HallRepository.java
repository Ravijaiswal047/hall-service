package com.marriagehall.hall_service.repository;

import com.marriagehall.hall_service.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface HallRepository extends JpaRepository<Hall, UUID> {
    List<Hall> findByVendorId(UUID vendorId);

    @Query("""
           SELECT h FROM Hall h
           WHERE (:location IS NULL OR LOWER(h.location) LIKE LOWER(CONCAT('%' , :location, '%')))
           AND (:minPrice IS NULL OR h.price >= :minPrice)
           AND(:maxPrice IS NULL OR h.price <= :maxPrice)
           AND(:capacity IS NULL OR h.capacity >= :capacity )
""")
    List<Hall> searchHalls(
         @Param("location") String location,
         @Param("minPrice") Double minPrice,
         @Param("maxPrice") Double maxPrice,
         @Param("Capacity") Integer capacity
 );

}
