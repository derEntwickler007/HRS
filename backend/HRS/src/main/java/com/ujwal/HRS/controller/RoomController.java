package com.ujwal.HRS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.HRS.dao.RoomDao;
import com.ujwal.HRS.entity.Room;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hrs")
public class RoomController {
	
	@Autowired
	private RoomDao roomDao;
	
	@PostMapping("room")
	public Room saveUser(@RequestBody Room room) {
		return roomDao.save(room);
	}
	
	@GetMapping("room/{id}")
	public Optional<Room> getUserBtId(@PathVariable Integer id) {
		return roomDao.getRoom(id);
	}
	
	@GetMapping("room/getAll")
	public List<Room> getAll(){
		return roomDao.getAllRoom();
	}
}
