/*
* @Author: Eric Phung
* @Date:   2015-04-13 21:41:54
* @Last Modified by:   Eric Phung
* @Last Modified time: 2015-04-14 00:23:32
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

public class NewStudentBox {

	static ReadName studentFound;
	static NewStudentBox student;
	static String cNumber;
	static String lastName;
	static String firstName;
	static String major;


	static Label titleLabel = new Label();

	// static vars, constants
	final static int MAX_BUTTON_WIDTH = 					200;
	final static int MAX_BUTTON_HEIGHT = 					40;
	final static int PREF_ROW_SPACING = 					250;
	final static int PREF_SUBWINDOW_WIDTH = 			800;
	final static int PREF_SUBWINDOW_HEIGHT = 			500;
	final static int PREF_MAINWINDOW_WIDTH = 			1200;
	final static int PREF_MAINWINDOW_HEIGHT = 			PREF_MAINWINDOW_WIDTH/12*9;

    //Create variable

    static boolean answer;

    public static NewStudentBox display(String title, String message) {

	    Stage window = new Stage();
	    window.initModality(Modality.APPLICATION_MODAL);
	    window.setTitle(title);
	    window.setMinWidth(250);
	    Label label = new Label();
	    label.setText(message);




    	BorderPane loginLayout = new BorderPane(); // login borders
			Scene loginScene = new Scene(loginLayout, PREF_SUBWINDOW_WIDTH,PREF_SUBWINDOW_HEIGHT); // change scene to login 600x300
			loginScene.getStylesheets().add("Style.css");

			// login top box
			HBox loginTopBox = new HBox();

			HBox loginTopContent = new HBox();
			loginTopBox.setPrefHeight(PREF_MAINWINDOW_HEIGHT/12);
			loginTopBox.setAlignment(Pos.TOP_CENTER);
			loginTopContent.setPadding(new Insets(15,12,15,12));

			loginTopContent.setPrefHeight(PREF_SUBWINDOW_HEIGHT/5);

      //Create submit button
      Button submitButton = new Button("Submit");
      submitButton.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
      submitButton.setDefaultButton(true);


		// ================================	USER INPUT FIELD

		final Label errorMessage = new Label("Hint: The CNumber is 'password'");

		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 0, 0, 10));
		vb.setSpacing(10);
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER_LEFT);



			// set grid login TOP content
		titleLabel = new Label("New Student");
			loginTopContent.getChildren().addAll(titleLabel);
			loginTopBox.getChildren().add(loginTopContent);


			// login Left box
			VBox loginLeftBox = new VBox();



			VBox loginLeftContent = new VBox();
			loginLeftContent.setPadding(new Insets(10));
			loginLeftContent.setSpacing(8);
			ListView<String> majorList = new ListView<>();
			ObservableList<String> majorItems =FXCollections.observableArrayList (
				"Accounting",
				"Advanced Automation and Robotics Technology",
				"Agriculture",
				"Automotive Technology",
				"Business Administration",
				"Early Childhood Education",
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
			majorList.setItems(majorItems);
			majorList.setPrefWidth(PREF_SUBWINDOW_WIDTH/2);
			majorList.setPrefHeight(PREF_SUBWINDOW_HEIGHT);


			loginLeftContent.getChildren().addAll(new Label("Select Your Major"),majorList);
			loginLeftBox.getChildren().add(loginLeftContent);


			// login bottom box
			HBox loginBottomBox = new HBox(); // make login bottom box
			HBox loginBottomContent = new HBox(); // login bottom content







		loginBottomContent.getChildren().add(submitButton); // add submit button

		loginBottomBox.setAlignment(Pos.BOTTOM_CENTER); // align home layout
		loginBottomBox.setPadding(new Insets(15, 12, 15, 12)); // pad home layout
		submitButton.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		submitButton.setDefaultButton(true);



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


		//Defining the c Number text field
		final TextField cNumberTextField = new TextField();
		cNumberTextField.setPromptText("Enter your C Number.");
		GridPane.setConstraints(cNumberTextField, 0, 0);
		grid.getChildren().add(cNumberTextField);


		//Defining the Name text field
		final TextField firstNameTextField = new TextField();
		firstNameTextField.setPromptText("Enter your first name.");
		GridPane.setConstraints(firstNameTextField, 0, 1);
		grid.getChildren().add(firstNameTextField);

		//Defining the Last Name text field
		final TextField lastNameTextField = new TextField();
		lastNameTextField.setPromptText("Enter your last name.");
		GridPane.setConstraints(lastNameTextField, 0, 2);
		grid.getChildren().add(lastNameTextField);

		//Defining the major text field
		final TextField majorTextField = new TextField();
		majorTextField.setPromptText("Enter your major.");
		GridPane.setConstraints(majorTextField, 0, 3);
		grid.getChildren().add(majorTextField);



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








		submitButton.setOnAction(e ->{

			// null fields
			if (majorList.getFocusModel().getFocusedItem() == null || firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty() || majorTextField.getText().isEmpty() || cNumberTextField.getText().isEmpty()) {
				titleLabel.setText("Please Complete All Text Fields and Select Your Major.");
			}
			else {
					try {
						ReadName studentFound = new ReadName(lastNameTextField.getText(),cNumberTextField.getText());
						if (studentFound.found == true) {
							window.close();
							AlertBox.display("Student ID Found","Please use a different C Number.  That one is already taken.");
						}
						else {
							new WriteFile(cNumberTextField.getText(),lastNameTextField.getText(),firstNameTextField.getText(),majorList.getFocusModel().getFocusedItem());
							AlertBox.display("Congratulations " + firstNameTextField.getText() + "!","Now you can login!");
							}// end if/else c number already exists in database

					} catch(Exception noWrited){
						System.out.print("Problem: Could not WRITe NEW STUDENT TO FILE! Oh NOz!");
					} // end try write them

				// write new student to DATABASE HERE WRITE WRITE WRITE!


				window.close();

				return;
			} // end if/else




/*
    if (
        (comment.getText() != null && !comment.getText().isEmpty())
    ) {
    label.setText(name.getText() + " " +
        lastName.getText() + ", "
        + "thank you for your comment!");
    } else {
        label.setText("You have not left a comment.");
    }
*/







		}); // end action event submt button



















        window.setScene(loginScene);
        window.show();

        //Make sure to return answer
        return student;
    } // end main













} // end class def