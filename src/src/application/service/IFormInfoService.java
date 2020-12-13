package src.application.service;

import java.util.List;

import src.application.model.Form_info;

public interface IFormInfoService {
	List<Form_info> findAll();
	Long insertRoom(Form_info form_info);
	void updateRoom(Form_info form_info);
	Form_info findOne(Integer id);
	void delete(Long id);
	List<Form_info> searchForm(Form_info form);
}
