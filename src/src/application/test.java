package src.application;

import java.util.Date;
import java.util.List;

import src.application.model.Form_info;
import src.application.service.IFormInfoService;
import src.application.service.impl.FormInfoService;

public class test {
	public static void main(String[] args) {
//		IFormInfoService formService = new FormInfoService();
//		Form_info form1 = new Form_info(1, "aa", "aa", "aa", new Date(), "aa", "aa", "aa", 1, 0, 0, new Date(),
//				"aa", "aa", "aa", "aa", "aa", 10L, "aa", 1, 1, 1, 1, 1);
//		Form_info form2 = new Form_info(2, "aa", "aa", "aa", new Date(), "aa", "aa", "aa", 1, 1, 0, new Date(),
//				"aa", "aa", "aa", "aa", "aa", 10L, "aa", 1, 1, 1, 1, 1);
//		Form_info form3 = new Form_info(3, "aa", "aa", "aa", new Date(), "aa", "aa", "aa", 1, 0, 0, new Date(),
//				"aa", "aa", "aa", "aa", "aa", 10L, "aa", 1, 1, 1, 1, 1);
//		
//		formService.insertRoom(form1);
//		formService.insertRoom(form2);
//		formService.insertRoom(form3);
		
		IFormInfoService service = new FormInfoService();
		List<Form_info> list_form = service.findAll();
		for(Form_info f : list_form) {
			System.out.println(f.getAdress());
		}
	}
}
