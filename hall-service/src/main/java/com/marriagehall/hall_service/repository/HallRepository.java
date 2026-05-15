package com.marriagehall.hall_service.repository;

import com.marriagehall.hall_service.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HallRepository extends JpaRepository<Hall, UUID> {

}
