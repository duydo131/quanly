package src.application.dao.impl;

import java.util.List;

import src.application.dao.IFormInfoDAO;
import src.application.mapper.FormInfoMapper;
import src.application.model.Form_info;

public class FormInfoDAO extends AbstractDAO<Form_info> implements IFormInfoDAO{
	
	@Override
	public List<Form_info> findAll() {
		String sql = "SELECT * FROM form_info where status = 0";
		FormInfoMapper m = new FormInfoMapper();
		return query(sql, m);
	}

	@Override
	public Long insertRoom(Form_info form) {
		StringBuilder sql = new StringBuilder("INSERT INTO form_info");
		sql.append("(full_name, address, credit_card, birthday, gender,");
		sql.append("resident, reason, deposit, status, status_pay,");
		sql.append("date_of_allocation, nation, religion, address_of_allocation, ");
		sql.append("phone, permanent_address, sum_price, room, table_column, chair, speaker, protector, radio)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), form.getFullname(), form.getAdress(), form.getCredit_card(), form.getBirthday(),
				form.getGender(), form.getResident(), form.getReason(), form.getDeposit(), form.getStatus(), form.getStatus_pay(),
				form.getDate_of_allocation(), form.getNation(), form.getReligion(), form.getAddress_of_allocation(),
				form.getPhone(), form.getPermanent_address(), form.getSum_price(),
				form.getRoom(), form.getTable(), form.getChair(), form.getSpeaker(), form.getProtector(), form.getRadio());
	}

	@Override
	public void updateRoom(Form_info form) {
		StringBuilder sql = new StringBuilder("UPDATE form_info SET full_name = ?, address = ?, credit_card = ?, birthday = ?, gender = ?,");
		sql.append("resident = ?, reason = ?, deposit = ?, status = ?, status_pay = ?,");
		sql.append("date_of_allocation = ?, nation = ?, religion = ?, address_of_allocation = ?,");
		sql.append("phone = ?, permanent_address = ?, sum_price = ?");
		sql.append(" WHERE id = ?");
		update(sql.toString(), form.getFullname(), form.getAdress(), form.getCredit_card(), form.getBirthday(),
				form.getGender(), form.getResident(), form.getReason(), form.getDeposit(), form.getStatus(), form.getStatus_pay(),
				form.getDate_of_allocation(), form.getNation(), form.getReligion(), form.getAddress_of_allocation(),
				form.getPhone(), form.getPermanent_address(), form.getSum_price(), form.getId());
	}

	@Override
	public Form_info findOne(Integer id) {
		String sql = "SELECT * FROM form_info WHERE id = ?" ;
		List<Form_info> list = query(sql, new FormInfoMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM form_info WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<Form_info> searchForm(Form_info form) {
		StringBuilder sql = new StringBuilder("SELECT * FROM form_info WHERE ");
		boolean flag = false;
		if(!form.getFullname().equals("")) {
			if(flag) sql.append(" and ");
			sql.append("full_name = N" + form.getFullname() + "'");
			flag = true;
		}
		if(!form.getPhone().equals("")) {
			if(flag) sql.append(" and ");
			sql.append("NhaXB_20183905 = N'" + form.getPhone() + "'");
			flag = true;
		}
		return query(sql.toString(), new FormInfoMapper());
	}
}