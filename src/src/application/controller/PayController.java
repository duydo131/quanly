package src.application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import src.application.dao.IDeviceDAO;
import src.application.dao.impl.DeviceDAO;
import src.application.model.Device;
import src.application.model.Form_info;
import src.application.model.add.FormTable;
import src.application.model.add.PayDevice;
import src.application.service.IFormInfoService;
import src.application.service.impl.FormInfoService;

public class PayController implements Initializable{
	
	@FXML
	Label name;
	
	@FXML
	Label phone;
	
	@FXML
	Label room;
	
	@FXML
	Label paymoney;
	
	@FXML
	Label deposit;
	
	@FXML
	TextArea reason;
	
	@FXML
	TableView<PayDevice> table;
	
	@FXML
	TableColumn<PayDevice, Number> id;
	
	@FXML
	TableColumn<PayDevice, String> device;
	
	@FXML
	TableColumn<PayDevice, Number> quantity;
	
	@FXML
	TableColumn<PayDevice, Number> price;
	
	@FXML
	Button pay;
	
	@FXML
	Button close;
	
	private Map<String , Long> priceDevice;
	private List<PayDevice> listData;
	private FormTable form;
	private Form_info formInfo;
	
	private IFormInfoService formService = new FormInfoService();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setTable();
		setPrice();
		form = Store.getInstance().getForm();
		if(form != null) {
			name.setText(form.getName());
			phone.setText(form.getPhone());
			room.setText(form.getRoom());
			deposit.setText(form.getDeposit() + "");
			reason.setText(form.getReason());
			
			listData = new ArrayList<>();
			formInfo = formService.findOne(form.getID());
			List<String> list = Store.getInstance().getListDevice();
			for(int i = 0; i < list.size(); i++) {
				PayDevice pd = new PayDevice();
				pd.setDevice(list.get(i));
				pd.setQuantity(formInfo.getQuantity(i));
				pd.setPrice(priceDevice.get(list.get(i)) * pd.getQuantity());
				
				listData.add(pd);
			}
			
			table.setItems(FXCollections.observableArrayList(listData));
			
			Long payMoney = form.getSumPrice() - form.getDeposit();
			paymoney.setText("" + payMoney);
			
		}
		
		pay.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				formInfo.setStatus(1);
				formService.updateRoom(formInfo);
				Redirect();
				
			}
		});
		
		close.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				Redirect();
			}
		});
	}
	
	private void Redirect() {
		Stage stage = Store.getInstance().getStage();
		Parent root = null;
		Scene scene = null;
		try {
			root = FXMLLoader.load(this.getClass().getResource("../layout/manager-layout.fxml"));
			stage.setTitle("Thanh toán");
			scene = new Scene(root);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		stage.setScene(scene);
		stage.show();
	}
	
	private void setPrice() {
		priceDevice = new HashMap<>();
		
		IDeviceDAO deviceDAO = new DeviceDAO();
		List<Device> listDevice = deviceDAO.findAll();
		for(Device device : listDevice) {
			priceDevice.put(device.getName(), device.getPrice());
		}
	}
	
	private void setTable() {
		id.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
		device.setCellValueFactory(new PropertyValueFactory<>("deivce"));
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
	}
}
