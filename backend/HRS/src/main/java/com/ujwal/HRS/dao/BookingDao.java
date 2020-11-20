package com.ujwal.HRS.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.ujwal.HRS.entity.Booking;
import com.ujwal.HRS.entity.Room;
import com.ujwal.HRS.repository.BookingRepo;

@Repository
@Transactional
@Scope("prototype")
public class BookingDao {
	
	@Autowired
	BookingRepo repository;
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private EntityManager entity;
	
	public Booking save(Booking book) {
		return repository.save(book);
	}
	
	public List<Booking> getAllBookings(){
		return repository.findAll();
	}
	
	public List<Booking> getFilterByDate(String date, String checkBy) throws ParseException {
		SimpleDateFormat format=new  SimpleDateFormat("dd-mm-yyyy");
		Date parseDate1=format.parse(date);
		SimpleDateFormat format1=new  SimpleDateFormat("yyyy-MM-dd");
		String date1=format1.format(parseDate1);
		Date parseDate=format1.parse(date1);
		List<Booking> bookings=getAllBookings();
		List<Booking> filteBookings=new ArrayList<Booking>();
		for(Booking book:bookings) {
			if(checkBy=="checkin") {
				if(book.getCheck_in().equals(parseDate)) {
					filteBookings.add(book);
				}
			}else{
				if(book.getCheck_out().equals(parseDate)) {
					filteBookings.add(book);
				}
			}
		}
		return filteBookings;
		
	}
	
	@GetMapping("/getAvail")
	public List<Room> getAvailableRooms(String date) throws ParseException {
		SimpleDateFormat format=new  SimpleDateFormat("dd-mm-yyyy");
		Date parseDate1=format.parse(date);
		SimpleDateFormat format1=new  SimpleDateFormat("yyyy-MM-dd");
		String date1=format1.format(parseDate1);
		Date parseDate=format1.parse(date1);
		
		List<Booking> bookings=getAllBookings();
		List<Integer> roomIds=new ArrayList<Integer>();
		for(Booking book:bookings) {
			if(book.getCheck_in().before(parseDate)) {
				roomIds.add(book.getRoom().getId());
			}
		}
		
		 TypedQuery<Room> query = entity.createQuery(
			      "SELECT room FROM Room AS room where room.id in (:arg1) or room.status like 'A'", Room.class);
		 query.setParameter("arg1", roomIds);
		 List<Room> room = query.getResultList();

		return room;
	}
}
