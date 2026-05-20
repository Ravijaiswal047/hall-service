package com.marriagehall.hall_service.service;

import com.marriagehall.hall_service.dto.HallRequest;
import com.marriagehall.hall_service.entity.Hall;
import com.marriagehall.hall_service.repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HallService {
    private final HallRepository hallRepository;
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

   public List<Hall> searchHalls(
           String location,
           double minPrice,
           double maxPrice,
           Integer capacity
   ){
       return hallRepository.searchHalls(location, minPrice, maxPrice,capacity);
   }

   public Hall getHallById(UUID id){
        return hallRepository.findById(id).orElseThrow(RuntimeException::new);
   }

    public Page<Hall> getAllHalls(
            int page,
            int size,
            String sortBy

    ){
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).ascending()
        );
        return hallRepository.findAll(pageable);
    }
}
