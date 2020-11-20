package com.ujwal.HRS.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.HRS.dao.BookingDao;
import com.ujwal.HRS.dao.RoomDao;
import com.ujwal.HRS.entity.Booking;
import com.ujwal.HRS.entity.Room;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hrs")
public class BookingController {
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private RoomDao roomDao;
		
	@PostMapping("booking")
	public Booking saveUser(@RequestBody Booking book) {
//		Optional<Room> room=roomDao.getRoom(book.getRoom().getId());
//		Room roomData=new Room();
//		roomData=room.get();
//		roomData.setStatus("NA");
//		roomDao.save(roomData);
		return bookingDao.save(book);
	}
	
	@GetMapping("booking/getAll")
	public List<Booking> getAll(){
		return bookingDao.getAllBookings();
	}
	
	@GetMapping("/getAvail")
	public List<Room> getAvailableRooms(@RequestParam String date) throws ParseException {
		return bookingDao.getAvailableRooms(date);
	}
	
	@GetMapping("booking/getFilterByDate")
	public List<Booking> getFilterByDate(@RequestParam String date, @RequestParam String checkBy) throws ParseException{
		return bookingDao.getFilterByDate(date, checkBy);
	}
	
}

