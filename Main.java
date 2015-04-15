/*
* @Author: Eric Phung
* @Date:   2015-04-11 09:21:02
* @Last Modified by:   Eric Phung
* @Last Modified time: 2015-04-14 01:12:54
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
	final static int PREF_SUBWINDOW_HEIGHT = 			500;
	final static int PREF_MAINWINDOW_WIDTH = 			1200;
	final static int PREF_MAINWINDOW_HEIGHT = 			PREF_MAINWINDOW_WIDTH/12*9;



	// decare instance vars
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
		HBox homeNavbar = new HBox(20); // login btn, title label
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
		homeLeftBox.setPrefWidth(PREF_MAINWINDOW_WIDTH/2);
		VBox leftContent = new VBox(30); // item listings

		//leftContent.setPadding(new Insets(0, 180, 0, 8));

		// left box content (observable list)
		itemSlots = new ListView<String>();
		items = FXCollections.observableArrayList(
			//"Judy Carpenter",
			//"John Doe",
			//"Robert Deniro",
			//"James Brown",
			//"George Clooney",
			//"Denzel Washington",
			//"Jessica Alba",
			//"Liam Neeson",
			//"Tupac Shakur",
			//"Eric Phung",
			//"Greatest Ever"
			);
		// set items to slots
		itemSlots.setItems(items);
		//itemSlots.setMaxHeight(Control.USE_PREF_SIZE); // set list on list box height
		itemSlots.setPrefWidth(300);
		itemSlots.setPrefHeight(1000);

		// add home content
		leftContent.getChildren().addAll(new Label("Students"),itemSlots);
		homeLeftBox.getChildren().add(leftContent);
		homeLeftBox.setPadding(new Insets(15,12,15,12));




		// home right box
		VBox homeRightBox = new VBox();
		homeRightBox.setPrefWidth(PREF_MAINWINDOW_WIDTH/2);
		VBox rightContent = new VBox();
		rightContent.setPadding(new Insets(10));
		rightContent.setSpacing(8);
		//Text rightContentLabel = new Text("Available Tutors");
		rightContent.getChildren().add(new Label("Tutors"));



		// home right content
		Hyperlink options[] = new Hyperlink[] {
			new Hyperlink("Sam Sebhatu"),
			new Hyperlink("Mark Power"),
			new Hyperlink("Corey Foley"),
			new Hyperlink("Jon Conklin"),
			new Hyperlink("Eric Phung")
		};

			for (int i = 0; i < options.length; i++) {
				rightContent.setMargin(options[i], new Insets(0, 100, 0, 8));
				rightContent.getChildren().add(options[i]);
		} // end for

		// add home right content
		homeRightBox.getChildren().add(rightContent);
		homeRightBox.setPadding(new Insets(15,12,15,12));





		// home bottom box
		HBox homeBottomBox = new HBox(30); // for border

		// home bottom content
		HBox bottomContent = new HBox(30); // for gui objects
		bottomContent.setPadding(new Insets(10));
		bottomContent.setSpacing(8);
		//Text bottomContentLabel = new Text("Bottom Content Box");

		// bottom remove button
		removeBtn = new Button("Remove");
		removeBtn.getStylesheets().add("Style.css");
		removeBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		removeBtn.setOnAction(e -> {
			items.remove(itemSlots.getFocusModel().getFocusedItem());
			itemSlots.setItems(items);
		});

		// remove button event

		// bottom load button
		loadBtn = new Button("Load");
		loadBtn.getStylesheets().add("Style.css");
		loadBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		loadBtn.setOnAction(e -> {


		}); // remove button event


		bottomContent.getChildren().addAll(removeBtn,loadBtn);

		homeBottomBox.getChildren().add(bottomContent);
		homeBottomBox.setPadding(new Insets(15,12,15,12));





		// set layout of boxes as a whole (NESW)
		homeLayout.setTop(homeTopBox);
		homeLayout.setLeft(homeLeftBox);
		homeLayout.setRight(homeRightBox);
		homeLayout.setBottom(homeBottomBox);










/*

		//	====================================	LOGIN SCREEN
		BorderPane loginLayout = new BorderPane(); // login borders
		Scene loginScene = new Scene(loginLayout, PREF_SUBWINDOW_WIDTH,PREF_SUBWINDOW_HEIGHT); // change scene to login 600x300
		loginScene.getStylesheets().add("Main.css");

		// login top box
		HBox loginTopBox = new HBox();

		HBox loginTopContent = new HBox();
		loginTopBox.setPrefHeight(PREF_MAINWINDOW_HEIGHT/12);
		loginTopBox.setAlignment(Pos.TOP_CENTER);
		loginTopContent.setPadding(new Insets(15,12,15,12));

		loginTopContent.setPrefHeight(PREF_SUBWINDOW_HEIGHT/5);

		// set grid login TOP content
		loginTopContent.getChildren().add(submitBtn);
		loginTopBox.getChildren().add(loginTopContent);


		// login Left box
		VBox loginLeftBox = new VBox();



		VBox loginLeftContent = new VBox();
		loginLeftContent.setPadding(new Insets(10));
		loginLeftContent.setSpacing(8);
		ListView<String> subjectList = new ListView<>();
		ObservableList<String> subjectItems =FXCollections.observableArrayList (
			"Stuff",
			"Geology",
			"Math",
			"Science",
			"Economics",
			"Poetry",
			"Chemistry",
			"Anthropology",
			"History",
			"Philosophy",
			"Comedy",
			"Physics",
			"Calculus",
			"Computer Science",
			"Physical Science",
			"Astronomy",
			"Counting"

		);
		subjectList.setItems(subjectItems);
		subjectList.setPrefWidth(PREF_SUBWINDOW_WIDTH/2);
		subjectList.setPrefHeight(PREF_SUBWINDOW_HEIGHT);


		loginLeftContent.getChildren().add(subjectList);
		loginLeftBox.getChildren().add(loginLeftContent);




		// login bottom box
		HBox loginBottomBox = new HBox(); // make login bottom box
		HBox loginBottomContent = new HBox(); // login bottom content


		// ================================	USER PASSWORD FIELD

		final Label message = new Label("Hint: The CNumber is 'password'");

		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 0, 0, 10));
		vb.setSpacing(10);
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER_LEFT);

		Label label = new Label("CNumber:");
		final PasswordField pb = new PasswordField();

		// Vaildate password
		//submitBtn.setOnAction(e -> window.setScene(homeScene));
		pb.setOnAction((ActionEvent e) -> {
		    if (!pb.getText().equals("password")) {
		        message.setText("Your CNumber is incorrect!");
		        message.setTextFill(Color.rgb(210, 39, 30));
		    } else {
		        message.setText("Your CNumber has been confirmed");
		        message.setTextFill(Color.rgb(21, 117, 84));
		        window.setScene(homeScene);
		    }
		    pb.clear();
		});

		hb.getChildren().addAll(label, pb);
		vb.getChildren().addAll(hb, message);

		loginBottomContent.getChildren().add(vb); // add submit button

		loginBottomBox.setAlignment(Pos.BOTTOM_CENTER); // align home layout
		loginBottomBox.setPadding(new Insets(15, 12, 15, 12)); // pad home layout
		submitBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		loginBottomBox.getChildren().add(loginBottomContent);


		// login right Box
		VBox loginRightBox = new VBox();
		loginRightBox.setPrefWidth(PREF_SUBWINDOW_WIDTH/2);

		// login right content
		VBox loginRightContent = new VBox();


				// ================================	USER TEXT FIELDS
		//Creating a GridPane container
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);

		//Defining the Name text field
		final TextField firstNameTextField = new TextField();
		firstNameTextField.setPromptText("Enter your first name.");
		GridPane.setConstraints(firstNameTextField, 0, 0);
		grid.getChildren().add(firstNameTextField);

		//Defining the Last Name text field
		final TextField lastNameTextField = new TextField();
		lastNameTextField.setPromptText("Enter your last name.");
		GridPane.setConstraints(lastNameTextField, 0, 1);
		grid.getChildren().add(lastNameTextField);

		//Defining the Comment text field
		final TextField comment = new TextField();
		comment.setPromptText("Enter your major.");
		GridPane.setConstraints(comment, 0, 2);
		grid.getChildren().add(comment);

		//Defining the Submit button
		//Button submit = new Button("Submit");
		//GridPane.setConstraints(submit, 1, 0);
		//grid.getChildren().add(submit);

		//Defining the last name label
		Label lastName = new Label();
		GridPane.setConstraints(lastName, 1, 1);
		grid.getChildren().add(lastName);


		loginRightContent.getChildren().addAll(new Label(),grid);

		loginRightBox.getChildren().add(loginRightContent);






		// login set layout
		loginLayout.setBottom(loginBottomBox);
		loginLayout.setTop(loginTopBox);
		loginLayout.setLeft(loginLeftBox);
		loginLayout.setRight(loginRightBox);





		//	================================================	DEBUG BORDERS
		loginTopBox.setStyle("-fx-border-color: black;"); // black border debug
		loginLeftBox.setStyle("-fx-border-color: black;"); // black border debug
		loginRightBox.setStyle("-fx-border-color: black;"); // black border debug
		loginBottomBox.setStyle("-fx-border-color: black;"); // black border debug

*/


/*
		homeTopBox.setStyle("-fx-border-color: black;"); // black border debug
		homeLeftBox.setStyle("-fx-border-color: black;"); // black border debug
		homeRightBox.setStyle("-fx-border-color: black;"); // black border debug
		homeBottomBox.setStyle("-fx-border-color: black;"); // black border debug

*/


		// initiate window
		window.setScene(homeScene);
		window.setTitle("Welcome to the Learning Resource Center!");
		window.show();







	} // end start method/exception




} // end class def