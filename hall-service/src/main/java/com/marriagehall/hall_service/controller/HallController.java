package com.marriagehall.hall_service.controller;

import com.marriagehall.hall_service.dto.HallRequest;
import com.marriagehall.hall_service.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/halls")
@RequiredArgsConstructor
public class HallController {

    private final HallRepository hallRepository;
    private final HallService hallService;

    @PostMapping("/create-hall")
    public ResponseEntity<?> createHall(
            @RequestBody HallRequest hallRequest,
            @RequestHeader("X-User-Id")
             String vendorId,
            @RequestHeader("X-Role")
            String role
    ) {
        System.out.println("VendorId = " + vendorId);
        return ResponseEntity.ok(hallService.createHall(hallRequest , vendorId , role));

    }
    @GetMapping("/{hallId}")
    public ResponseEntity<?> getHallById(@PathVariable UUID hallId) {
        return ResponseEntity.ok(hallService.getHallById(hallId));

    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<?> getVendorHalls(@PathVariable UUID vendorId){
        return ResponseEntity.ok(hallService.getVendorHalls(vendorId));
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
