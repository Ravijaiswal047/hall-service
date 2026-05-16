package com.marriagehall.hall_service.controller;

import com.marriagehall.hall_service.dto.HallRequest;
import com.marriagehall.hall_service.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/halls")
@RequiredArgsConstructor
public class HallController {

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
    public ResponseEntity<?> getHall(@PathVariable UUID id){
        return ResponseEntity.ok(hallService.getHallById(id));

    }

}
