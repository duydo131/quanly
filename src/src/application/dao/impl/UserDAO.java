package src.application.dao.impl;

import java.util.List;

import src.application.dao.IUserDAO;
import src.application.mapper.UserMapper;
import src.application.model.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO{

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM user";
		return query(sql, new UserMapper());
	}

	@Override
	public Long insertUser(User user) {
		StringBuilder sql = new StringBuilder("INSERT INTO user");
		sql.append("(username, password, status)");
		sql.append(" VALUES(?, ?, ?)");
		return insert(sql.toString(), user.getUsername(), user.getPassword(), user.getStatus());
	}

	@Override
	public void updateUser(User user) {
		StringBuilder sql = new StringBuilder("UPDATE user SET username = ?, password = ?, status = ?   WHERE id = ?");
		update(sql.toString(),user.getUsername(), user.getPassword(), user.getStatus(), user.getId());
	}

	@Override
	public User findOne(Long id) {
		String sql = "SELECT * FROM user WHERE id = ?" ;
		List<User> list = query(sql, new UserMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM user WHERE id = ?";
		update(sql, id);
	}

}
