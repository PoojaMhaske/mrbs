package com.digitas.roomservice.controller;

import com.digitas.roomservice.model.Room;
import com.digitas.roomservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepo;

    // Get All Bookings
    @GetMapping("/list")
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @GetMapping("/list/type/{type}")
    public List<Room> retrieve(@PathVariable("type") String type) {
        return roomRepo.findAllType(type);

    }

    @GetMapping("/list/{id}")
    public Optional<Room> getRoomById(@PathVariable(value = "id") long id) {
        return roomRepo.findById(id);
    }


    @PostMapping("/add")
    public Room createRooms(@Valid @RequestBody Room room) {

        return roomRepo.save(room);
    }

    @PutMapping("/update/{id}")
    public Room updateRoom(@PathVariable(value = "id") int id,
                           @Valid @RequestBody Room roomDetails) {

        Room room = roomRepo.findAllById(id);


        room.setLocation(roomDetails.getLocation());
        room.setType(roomDetails.getType());
        room.setCapacity(roomDetails.getCapacity());

        Room updatedRoom = roomRepo.save(room);
        return updatedRoom;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") long id) {
        Room room = roomRepo.findAllById(id);
        roomRepo.delete(room);

        return ResponseEntity.ok().build();
    }
}
