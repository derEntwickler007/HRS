package com.ujwal.HRS.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.ujwal.HRS.entity.Room;
import com.ujwal.HRS.repository.RoomRepository;

@Repository
@Transactional
@Scope("prototype")
public class RoomDao {
	
	@Autowired
	RoomRepository repository;
	
	@Autowired
	EntityManager entityManager;
	
	public Room save(Room room) {
		return repository.save(room);
	}
	
	public List<Room> getAllRoom(){
		
//		 TypedQuery<Room> query = entityManager.createQuery(
//			      "SELECT room FROM Room AS room where  room.status like 'A'", Room.class);
//		 List<Room> room = query.getResultList();
		return repository.findAll();
	}
	
	public Optional<Room> getRoom(Integer id) {
		return repository.findById(id);
	}
}
