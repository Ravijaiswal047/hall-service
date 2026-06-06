package com.marriagehall.hall_service.service;

import com.marriagehall.hall_service.dto.HallRequest;
import com.marriagehall.hall_service.entity.Hall;
import com.marriagehall.hall_service.repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HallService {
    private final HallRepository hallRepository;

    public Hall createHall(HallRequest hallRequest, String vendorId, String role) {
        if (!role.equals("VENDOR")) {
            throw new RuntimeException("Only vendors can create halls");
        }
        Hall hall = new Hall();
        UUID vendorUUID = UUID.fromString(vendorId);
        hall.setName(hallRequest.getName());
        hall.setLocation(hallRequest.getLocation());
        hall.setPrice(hallRequest.getPrice());
        hall.setCapacity(hallRequest.getCapacity());
        hall.setDescription(hallRequest.getDescription());
        hall.setVendorId(vendorUUID);
        hallRepository.save(hall);
        return hall;
    }

    public Hall getHallById(UUID hallId) {
        return hallRepository.findById(hallId).orElseThrow(
                () -> new RuntimeException("Hall with id " + hallId + " not found")
        );
    }

    public List<Hall> getVendorHalls(UUID vendorId) {
        return hallRepository.findByVendorId(vendorId);
    }
}
