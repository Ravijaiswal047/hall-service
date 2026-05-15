package com.marriagehall.hall_service.service;

import com.marriagehall.hall_service.dto.HallRequest;
import com.marriagehall.hall_service.entity.Hall;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class HallService {
   public Hall createHall(@RequestBody HallRequest hallRequest) {
       Hall hall = new Hall();
       hall.setName(hallRequest.getName());
       hall.setLocation(hallRequest.getLocation());
       hall.setPrice(hallRequest.getPrice());
       hall.setCapacity(hallRequest.getCapacity());
       hall.setDescription(hallRequest.getDescription());
       hall.setVendorId(hallRequest.getVendorId());
       return hall;
   }
}
