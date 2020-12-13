package src.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.application.controller.Store;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = null; 
		Scene scene = null;
		Store.getInstance().setStage(primaryStage);
		try {
			root =  FXMLLoader.load(getClass().getResource("layout/manager-layout.fxml"));
			primaryStage.setTitle("Quản lý thư viện");
			scene = new Scene(root);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		primaryStage.setScene(scene);
		primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
