package src.application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController implements Initializable{
	
	@FXML
	TableView<FormTable> table;
	
	@FXML
	TableColumn<FormTable, Number> id;
	
	@FXML
	TableColumn<FormTable, String> name;
	
	@FXML
	TableColumn<FormTable, String> phone;
	
	@FXML
	TableColumn<FormTable, String> room;
	
	@FXML
	TableColumn<FormTable, Number> deposit;
	
	@FXML
	TableColumn<FormTable, Number> money;
	
	@FXML
	TableColumn<FormTable, String> reason;
	
	@FXML
	Button search;
	
	@FXML
	Button pay;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		room.setCellValueFactory(new PropertyValueFactory<>("room"));
		deposit.setCellValueFactory(new PropertyValueFactory<>("deposit"));
		money.setCellValueFactory(new PropertyValueFactory<>("money"));
		reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
		
		//logic
		
	}

	public class FormTable{
		//map form_info -> FormTable
	}
}
