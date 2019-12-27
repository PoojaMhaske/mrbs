package com.digitas.roomservice.repository;

import com.digitas.roomservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    @Query("From Room r where r.type= ?1")
    List<Room> findAllType(String type);

    @Query("From Room r where r.id= ?1")
    Room findAllById(long id);
}
