package src.application.dao;

import java.util.List;

import src.application.model.Form_info;

public interface IFormInfoDAO extends GenericDAO<Form_info>{
	List<Form_info> findAll();
	Long insertRoom(Form_info form_info);
	void updateRoom(Form_info form_info);
	Form_info findOne(Integer id);
	void delete(Integer id);
	List<Form_info> searchForm(Form_info form);
}
