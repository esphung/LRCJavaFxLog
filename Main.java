/*
* @Author: Eric Phung
* @Date:   2015-04-11 09:21:02
* @Last Modified by:   Eric Phung
* @Last Modified time: 2015-04-23 22:17:06
// JavaFx Stuff
// "Stage" is the entire window
// "Scene" is the content (stuff) inside the window ("Stage")
*/



import javafx.scene.paint.Color; // password field
import javafx.collections.*; // observable list

// javafx application, stage, scene, button imports
import javafx.application.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.geometry.*;

import java.io.*;

public class Main extends Application{
	// static vars, constants
	final static int MAX_BUTTON_WIDTH = 					200;
	final static int MAX_BUTTON_HEIGHT = 					40;
	final static int PREF_ROW_SPACING = 					250;
	final static int PREF_SUBWINDOW_WIDTH = 			800;
	final static int PREF_SUBWINDOW_HEIGHT = 			728;
	final static int PREF_MAINWINDOW_WIDTH = 			1024;
	final static int PREF_MAINWINDOW_HEIGHT = 			PREF_MAINWINDOW_WIDTH/12*9;



	// decare instance vars
	ObservableList<String> sessions;
	ListView<String> sessionSlots;
	ObservableList<String> tutors;
	ListView<String> tutorSlots;
	ObservableList<String> items;
	ListView<String> itemSlots;
	LoginBox student;
	Button loginBtn;
	//Button confirmBtn;
	Stage window; // "stage" means window
	Scene homeScene; // "scene" means screen
	Button newUserBtn;
	Button removeBtn;
	Button loadBtn;


	public Main(){
		this.itemSlots = itemSlots;
	}

	// main
	public static void main(String[] args) {
		// start as JavaFX app
		launch(args);


		//System.out.println("HelloWorld!");
	} // end main


	// called from launch()
	@Override
	public void start(Stage primaryStage) throws Exception{
		Main mainObject = new Main();
		// MAIN CODE BEGINS HERE
		window = primaryStage;

		//primaryStage.setTitle("LRC Student Queue");



		//	====================================		LOGIN STUFF
		// set login button
		loginBtn = new Button("Login");
		loginBtn.setOnAction(e -> {
		student = LoginBox.display("Login Screen");


			// validate last name
			if (student.lastName != null && !student.lastName.isEmpty()) {
				// doSomething

				items.add(student.firstName + " " + student.lastName + " -> " + student.selection);


			} // end if null

			// validate c number
			if (student.cNumber != null && !student.cNumber.isEmpty()) {
				// doSomething
				System.out.print(student.cNumber);
			} // end if null

		}); // args: title, message
		loginBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		loginBtn.setDefaultButton(true); // make "return key" listen






		//	====================================	HOME SCREEN
		// main layout (border-pane layout NESW)
		BorderPane homeLayout = new BorderPane(); // home borders (top,right,bottom,left)
		homeScene = new Scene(homeLayout,PREF_MAINWINDOW_WIDTH,PREF_MAINWINDOW_HEIGHT);
		// stylize home screen
		homeScene.getStylesheets().add("Style.css");



		// home top box
		HBox homeTopBox = new HBox(250); // arg integer pixel spacing
		HBox homeNavbar = new HBox(30); // login btn, title label
		homeNavbar.setPrefHeight(PREF_MAINWINDOW_HEIGHT/12);

		// create new user button
		newUserBtn = new Button("New User");
		newUserBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		newUserBtn.setOnAction(e -> {
			boolean result = ConfirmBox.display("New Student!","Would you like to register?");
			if (result == true) {
				System.out.println("New Student!");
			}
		}); // end set action new user button

		homeNavbar.getChildren().addAll(newUserBtn,loginBtn); // optional add login btn/ loginBtn
		homeNavbar.setPadding(new Insets(15,12,15,12));

		homeTopBox.getChildren().add(homeNavbar);
		homeTopBox.setAlignment(Pos.TOP_CENTER); // center align layout
		homeTopBox.setPadding(new Insets(15,12,15,12));




		// home left box (item listings)
		VBox homeLeftBox = new VBox(30); // left box
		homeLeftBox.setPrefWidth(PREF_MAINWINDOW_WIDTH/3);
		homeLeftBox.setPadding(new Insets(15,12,15,12));
		VBox leftContent = new VBox(30); // item listings

		//leftContent.setPadding(new Insets(0, 180, 0, 8));

		// left box content (observable list)
		itemSlots = new ListView<String>();
		items = FXCollections.observableArrayList(
			//"Judy Carpenter",
			//"John Doe",
			//"Robert Deniro"
			);
		// set items to slots
		itemSlots.setItems(items);
		//itemSlots.setMaxHeight(Control.USE_PREF_SIZE); // set list on list box height
		itemSlots.setPrefWidth(300);
		itemSlots.setPrefHeight(1000);

		// add home content
		leftContent.getChildren().addAll(new Label("\tStudents"),itemSlots);
		homeLeftBox.getChildren().add(leftContent);
		homeLeftBox.setPadding(new Insets(15,12,15,12));
		homeLeftBox.setAlignment(Pos.TOP_CENTER); // center align layout




		// home right box
		VBox homeRightBox = new VBox(30);
		homeRightBox.setPrefWidth(PREF_MAINWINDOW_WIDTH/3);
		VBox rightContent = new VBox(30);
		//rightContent.setPadding(new Insets(10));
		//rightContent.setSpacing(8);
		//Text rightContentLabel = new Text("Available Tutors");
		//rightContent.getChildren().add(new Label("Tutors"));



/*
			for (int i = 0; i < optionsColumnA.length; i++) {
				rightContent.setMargin(optionsColumnA[i], new Insets(0, 100, 0, 8));
				rightContent.getChildren().addAll(optionsColumnA[i]);
		} // end for
*/
		// home right content (observable list)
		tutorSlots = new ListView<String>();
		tutors = FXCollections.observableArrayList(
			"Andrea",
			"Becki",
			"Bruck",
			"Byron",
			"Cathy",
			"Corey",
			"Donald",
			"Elaine",
			"Eric",
			"Jason",
			"John",
			"Josh",
			"Kelly",
			"Laura",
			"Mark",
			"Michele",
			"Nicholas",
			"Phil",
			"Rhoda",
			"Sam",
			"Sara"
			);
		// set tutors to slots
		tutorSlots.setItems(tutors);
		//itemSlots.setMaxHeight(Control.USE_PREF_SIZE); // set list on list box height
		tutorSlots.setPrefWidth(300);
		tutorSlots.setPrefHeight(1000);
		rightContent.getChildren().addAll(new Label("\t\tTutors"),tutorSlots);

		// add home right content
		homeRightBox.getChildren().add(rightContent);
		homeRightBox.setPadding(new Insets(15,12,15,12));
		homeRightBox.setAlignment(Pos.TOP_CENTER); // center align layout











		// home center box
		VBox homeCenterBox = new VBox(30); // for border
		VBox centerContent = new VBox(30);


		//homeCenterBox.getChildren().addAll(new Text("\tCurrent Sessions"),centerContent);
		homeCenterBox.setPadding(new Insets(15,12,15,12));


		// home right center content
		sessionSlots = new ListView<String>();
		sessions = FXCollections.observableArrayList(
			);
		// set tutors to slots
		sessionSlots.setItems(sessions);
		sessionSlots.setPrefWidth(300);
		sessionSlots.setPrefHeight(1000);
		centerContent.getChildren().addAll(new Label("\tSessions"),sessionSlots);

		// add home center content
		homeCenterBox.getChildren().add(centerContent);
		homeCenterBox.setPadding(new Insets(15,12,15,12));
		homeCenterBox.setAlignment(Pos.TOP_CENTER); // center align layout







		// home bottom box
		HBox homeBottomBox = new HBox(250); // for border

		// home bottom content
		HBox bottomContent = new HBox(30); // for gui objects
		bottomContent.setPadding(new Insets(10));
		bottomContent.setSpacing(8);
		//Text bottomContentLabel = new Text("Bottom Content Box");

		// bottom remove button
		removeBtn = new Button("Remove");
		removeBtn.getStylesheets().add("Style.css");
		removeBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		// remove button event
		removeBtn.setOnAction(e -> {
			items.remove(itemSlots.getFocusModel().getFocusedItem());
			itemSlots.setItems(items);
		});


		// bottom load button
		loadBtn = new Button("Load");
		loadBtn.getStylesheets().add("Style.css");
		loadBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		loadBtn.setOnAction(e -> {

		}); // load button event


		// bottom start button
		Button startBtn = new Button("Start Session");
		startBtn.getStylesheets().add("Style.css");

		startBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		// start button event
		startBtn.setOnAction(e -> {
			// pull text from slot lists
			System.out.println(itemSlots.getFocusModel().getFocusedItem());
			System.out.println(tutorSlots.getFocusModel().getFocusedItem());

			String session = itemSlots.getFocusModel().getFocusedItem() + " w/ " + tutorSlots.getFocusModel().getFocusedItem() + " since " + "(time)";
			sessions.add(session);
			sessionSlots.setItems(sessions);



		}); // end start button event

		bottomContent.getChildren().addAll(removeBtn,loadBtn,startBtn);

		homeBottomBox.getChildren().add(bottomContent);
		homeBottomBox.setPadding(new Insets(15,12,15,12));
		homeBottomBox.setAlignment(Pos.TOP_CENTER); // center align layout



		// set layout of boxes as a whole (NESW)
		homeLayout.setTop(homeTopBox);
		homeLayout.setLeft(homeLeftBox);
		homeLayout.setRight(homeRightBox);
		homeLayout.setBottom(homeBottomBox);
		homeLayout.setCenter(homeCenterBox);









		// initiate window
		window.setScene(homeScene);
		window.setTitle("Welcome to the Learning Resource Center!");
		window.show();







	} // end start method/exception




} // end class def