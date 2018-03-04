package gui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parsers.CSVDataParser;
import parsers.DataParser;

public class Driver extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CalendarProgram.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Productivity Tool");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {

    	ArrayList<DataParser> parsers = new ArrayList<DataParser>();
        parsers.add(new CSVDataParser());

        for (DataParser parser: parsers)
            parser.parseData();
    	
        launch(args);
        
    }
    
}
