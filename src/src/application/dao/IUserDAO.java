package src.application.dao;

import java.util.List;

import src.application.model.User;

public interface IUserDAO extends GenericDAO<User>{
	List<User> findAll();
	Long insertUser(User user);
	void updateUser(User user);
	User findOne(Long id);
	void delete(Long id);
}
