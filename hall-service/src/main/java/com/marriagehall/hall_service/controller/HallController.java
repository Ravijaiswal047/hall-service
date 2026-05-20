package com.marriagehall.hall_service.controller;

import com.marriagehall.hall_service.dto.HallRequest;
import com.marriagehall.hall_service.entity.Hall;
import com.marriagehall.hall_service.repository.HallRepository;
import com.marriagehall.hall_service.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.UUID;

@RestController
@RequestMapping("/api/halls")
@RequiredArgsConstructor
public class HallController {

    private final HallRepository hallRepository;
    private final HallService hallService;

    public ResponseEntity<?> createHall(@RequestBody HallRequest hallRequest) {
        return ResponseEntity.ok(hallService.createHall(hallRequest));

    }

    public ResponseEntity<?> searchHall(
            @RequestParam(required = false) String location,
            @RequestParam(required  = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer capacity
            ){
        return  ResponseEntity.ok(hallService.searchHalls(location, minPrice, maxPrice, capacity));
    }

    @GetMapping("/id")
    public ResponseEntity<?> getHallBy(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(hallService.getHallById(id));

    }
    public ResponseEntity<?> getAllHalls(
            @RequestParam(defaultValue =  "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ){
        return ResponseEntity.ok(hallService.getAllHalls(page, size, sortBy));
    }

}
