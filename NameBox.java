/*
* @Author: Eric Phung
* @Date:   2015-04-13 20:58:08
* @Last Modified by:   Eric Phung
* @Last Modified time: 2015-04-13 21:27:52
*/
import javafx.collections.*; // observable list
import java.util.*;


import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class NameBox {
	// static vars, constants
	final static int MAX_BUTTON_WIDTH = 					200;
	final static int MAX_BUTTON_HEIGHT = 					40;
	final static int PREF_ROW_SPACING = 					250;
	final static int PREF_SUBWINDOW_WIDTH = 			800;
	final static int PREF_SUBWINDOW_HEIGHT = 			500;
	final static int PREF_MAINWINDOW_WIDTH = 			1200;
	final static int PREF_MAINWINDOW_HEIGHT = 			PREF_MAINWINDOW_WIDTH/12*9;
    //Create variable
	static NameBox student;

	// student info vars for return
	static String cNumber;
	static String lastName;
	static String firstName;
	static String major;
	static boolean answer;
	static ArrayList<String> possibleNames;
	static String fullName;

    // constuctors
    public NameBox(){
	   	this.cNumber = cNumber;
			this.lastName = lastName;
			this.cNumber = cNumber;
			this.answer = answer;
    } // end null

    public static String display(String title, String message,List<String> possibleNames) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);


        VBox vbNamesBox = new VBox();
				vbNamesBox.setPadding(new Insets(15,12,15,12));
				// left box content (observable list)
				ListView<String> nameSlots = new ListView<String>();
				ObservableList<String> names = FXCollections.observableArrayList(possibleNames);
				// set items to slots
				nameSlots.setItems(names);
				//itemSlots.setMaxHeight(Control.USE_PREF_SIZE); // set list on list box height
				nameSlots.setPrefWidth(300);
				nameSlots.setPrefHeight(500);
				vbNamesBox.getChildren().addAll(nameSlots);


        //Create two buttons
        Button yesButton = new Button("This one");
        yesButton.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
        yesButton.setDefaultButton(true);

        Button noButton = new Button("None");
        noButton.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);


        //Clicking will set answer and close window
        yesButton.setOnAction(e -> {
            answer = true;
						//System.out.println(nameSlots.getFocusModel().getFocusedItem());
						fullName = nameSlots.getFocusModel().getFocusedItem();
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);


        //Add buttons
        layout.getChildren().addAll(vbNamesBox,label,yesButton,noButton);
        layout.setPadding(new Insets(15,12,15,12));
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("Style.css");
        window.setScene(scene);
        window.showAndWait();

        //Make sure to return answer
        return fullName;
    }

}