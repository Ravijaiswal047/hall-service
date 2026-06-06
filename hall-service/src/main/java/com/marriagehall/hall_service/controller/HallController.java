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
public class  HallController {

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


}
