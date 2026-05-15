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

    private final HallService hallService;

    public ResponseEntity<?> createHall(@RequestBody HallRequest hallRequest) {
        return ResponseEntity.ok(hallService.createHall(hallRequest));

    }

}
