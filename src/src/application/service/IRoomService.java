package src.application.service;

import java.util.List;

import src.application.model.Room;

public interface IRoomService {
	List<Room> findAll();
	Long insertBook(Room room);
	void updateBook(Room room);
	Room findOne(Long id);
	void delete(Long id);
}
