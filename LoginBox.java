/*
* @Author: Eric Phung
* @Date:   2015-04-11 10:40:59
* @Last Modified by:   Eric Phung
* @Last Modified time: 2015-04-23 23:14:07
// ALERT BOX CLASS <- FOR RETURN STUDENT SIGN IN
*/

import javafx.scene.paint.Color; // password field
import javafx.collections.*; // observable list

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class LoginBox {
	// static vars, constants
	final static int MAX_BUTTON_WIDTH = 					200;
	final static int MAX_BUTTON_HEIGHT = 					40;
	final static int PREF_ROW_SPACING = 					250;
	final static int PREF_SUBWINDOW_WIDTH = 			800;
	final static int PREF_SUBWINDOW_HEIGHT = 			500;
	final static int PREF_MAINWINDOW_WIDTH = 			1200;
	final static int PREF_MAINWINDOW_HEIGHT = 			PREF_MAINWINDOW_WIDTH/12*9;

	static LoginBox student;

	// student info vars for return
	static String lastName;
	static String firstName;
	static String major;
	static String cNumber;
	static boolean answer;
	static String selection;

	static Button newUserBtn;

	// constructors
	public LoginBox(){} // end null
	public LoginBox(String name,String num){
		this.cNumber = cNumber;
		this.lastName = name;
		this.cNumber = num;
		this.answer = answer;
		//this.lastName = name;
		//this.firstName = student.firstName;
		//this.major = student.major;
	} // end overload


	public static LoginBox display(String title){

		// make new stage object
		Stage alertWindow = new Stage();

		// set as modal
		alertWindow.initModality(Modality.APPLICATION_MODAL);

		// set title arg
		alertWindow.setTitle(title);

		// set size
		alertWindow.setMinWidth(250.0); // arg double

		// make new label for message arg
		Label label = new Label();


		// set close button
		//Button closeBtn = new Button("Ok!");
		//closeBtn.setDefaultButton(true);
		//closeBtn.setOnAction(e -> alertWindow.close());

		// create two buttons (yes/no)
		Button yesBtn = 							new Button("Submit");
		yesBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		yesBtn.setDefaultButton(true);
		Button noBtn = 								new Button("Cancel");
		noBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);





		// set layout
		BorderPane modalLayout = new BorderPane();
		// set scene
		Scene modalScene = new Scene(modalLayout,PREF_SUBWINDOW_WIDTH,PREF_SUBWINDOW_HEIGHT);
		modalScene.getStylesheets().add("Style.css");


		// modal bottom box
		HBox modalBottomBox = new HBox();

		// modal top content
		HBox modalBottomContent = new HBox();
		modalBottomBox.setPrefHeight(PREF_SUBWINDOW_HEIGHT/12);
		modalBottomBox.setAlignment(Pos.TOP_CENTER);
		modalBottomBox.setPadding(new Insets(15,12,15,12));
		modalBottomBox.getChildren().addAll(label,yesBtn,noBtn);
		//layout.setAlignment(Pos.BOTTOM_CENTER); // center align layout
		modalBottomContent.setPadding(new Insets(15,12,15,12));
		//layout.setSpacing(20); // space pixels


		// modal Left box
		VBox modalLeftBox = new VBox();



		VBox modalLeftContent = new VBox();
		modalLeftContent.setPadding(new Insets(10));
		modalLeftContent.setSpacing(8);
		ListView<String> subjectList = new ListView<>();
		ObservableList<String> subjectItems =FXCollections.observableArrayList (
			"ACCT",
			"Accuplacer",
			"Biology",
			"Business",
			"Capstone",
			"CHEM101",
			"CHEM105",
			"CHEM106",
			"CHEM111",
			"CINS",
			"Computer",
			"Criminal Justice",
			"Earth Science",
			"Economics",
			"EDU101",
			"Electronics",
			"ENG073",
			"ENG083",
			"ENG093",
			"ENG095",
			"ENG111",
			"ENG112",
			"ENG211",
			"Engineering",
			"ESOL",
			"History",
			"Human Resources",
			"IVY101",
			"IVY120",
			"MATH015",
			"MATH120",
			"MATH121",
			"MATH122",
			"MATH123",
			"MATH127",
			"MATH128",
			"MATH129",
			"MATH135",
			"MATH136",
			"MATH137",
			"MATH200",
			"MATH201",
			"MATH211",
			"MATH212",
			"MATH213",
			"MATH221",
			"MATH222",
			"MATH261",
			"MATH264",
			"OTHER",
			"PAPER",
			"PHY101",
			"PHY102",
			"PHY221",
			"PHY222",
			"Psychology",
			"Spanish",
			"Speech/Communcations",
			"Theater",
			"Visual Basic"

		);
		subjectList.setItems(subjectItems);
		subjectList.setPrefWidth(PREF_SUBWINDOW_WIDTH/2);
		subjectList.setPrefHeight(PREF_SUBWINDOW_HEIGHT);


		modalLeftContent.getChildren().addAll(new Label("Select Course"),subjectList);
		modalLeftBox.getChildren().add(modalLeftContent);



		// login right Box
		VBox modalRightBox = new VBox();
		modalRightBox.setPrefWidth(PREF_SUBWINDOW_WIDTH/2);

		// login right content
		VBox modalRightContent = new VBox();


				// ================================	USER TEXT FIELDS
		//Creating a GridPane container
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);



/*
		//Defining the Name text field
		final TextField firstNameTextField = new TextField();
		firstNameTextField.setPromptText("Enter your first name.");
		GridPane.setConstraints(firstNameTextField, 0, 0);
		grid.getChildren().add(firstNameTextField);
*/


		//Defining the Last Name text field
		final TextField lastNameTextField = new TextField();
		lastNameTextField.setPromptText("Enter your last name.");
		GridPane.setConstraints(lastNameTextField, 0, 0);
		grid.getChildren().add(lastNameTextField);

		//Defining the cnumber text field
		final TextField cNumberTextField = new TextField();
		cNumberTextField.setPromptText("Enter your C number.");
		GridPane.setConstraints(cNumberTextField, 0, 1);
		grid.getChildren().add(cNumberTextField);

		// create new user button
		newUserBtn = new Button("New User");
		newUserBtn.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		newUserBtn.setOnAction(e -> {
			boolean result = ConfirmBox.display("New Student!","Would you like to register?");
			alertWindow.close();
		}); // end set action new user button



		// define yes/no button events
		yesBtn.setOnAction(e -> {
			answer = true;

			// query for last name

			ReadName found = new ReadName(lastNameTextField.getText(),cNumberTextField.getText());
			lastName = found.lastName;
			firstName = found.firstName;
			major = found.major;
			selection = subjectList.getSelectionModel().getSelectedItem();


			//System.out.println(selection);
			//lastName = lastNameTextField.getText();
			//cNumber = cNumberTextField.getText();



			alertWindow.close();

		}); // end yes btn event

		noBtn.setOnAction(e -> {
			answer = false;
			alertWindow.close();

		}); // end no btn event



/*
		//Defining the Comment text field
		final TextField comment = new TextField();
		comment.setPromptText("Enter your major.");
		GridPane.setConstraints(comment, 0, 2);
		grid.getChildren().add(comment);
*/


		//Defining the Submit button
		//Button submit = new Button("Submit");
		//GridPane.setConstraints(submit, 1, 0);
		//grid.getChildren().add(submit);

		//Defining the last name label
		Label lastName = new Label();
		GridPane.setConstraints(lastName, 1, 1);
		grid.getChildren().add(lastName);


		// close modal right box/content
		modalRightContent.getChildren().addAll(new Label(),grid);
		modalRightBox.getChildren().add(modalRightContent);



/*

		// DEBUG
		modalBottomBox.setStyle("-fx-border-color: black;"); // black border debug
		modalLeftBox.setStyle("-fx-border-color: black;"); // black border debug
		modalRightBox.setStyle("-fx-border-color: black;"); // black border debug
*/




		// set model layout finish
		modalLayout.setBottom(modalBottomBox);
		modalLayout.setLeft(modalLeftBox);
		modalLayout.setRight(modalRightBox);

		alertWindow.setScene(modalScene); // add scene to window
		alertWindow.showAndWait(); // wait for this to be hidden or closed






		// return answer to previous operation
		return student;
	} // end display alert




} // end class def