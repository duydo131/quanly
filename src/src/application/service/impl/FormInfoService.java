package src.application.service.impl;

import java.util.List;

import src.application.dao.IFormInfoDAO;
import src.application.dao.impl.FormInfoDAO;
import src.application.model.Form_info;
import src.application.service.IFormInfoService;

public class FormInfoService implements IFormInfoService{
	
	IFormInfoDAO formInfoDAO = new FormInfoDAO();

	@Override
	public List<Form_info> findAll() {
		return formInfoDAO.findAll();
	}

	@Override
	public Long insertRoom(Form_info form_info) {
		return formInfoDAO.insertRoom(form_info);
	}

	@Override
	public void updateRoom(Form_info form_info) {
		formInfoDAO.updateRoom(form_info);
	}

	@Override
	public Form_info findOne(Integer id) {
		return formInfoDAO.findOne(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Form_info> searchForm(Form_info form) {
		return formInfoDAO.searchForm(form);
	}

}
