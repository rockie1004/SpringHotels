package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
