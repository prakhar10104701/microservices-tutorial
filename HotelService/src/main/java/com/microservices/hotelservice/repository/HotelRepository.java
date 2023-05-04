package com.microservices.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.hotelservice.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
