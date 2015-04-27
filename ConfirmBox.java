/*
* @Author: Eric Phung
* @Date:   2015-04-13 18:20:55
* @Last Modified by:   Eric Phung
* @Last Modified time: 2015-04-27 13:26:37
*/

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

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

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        //Create two buttons
        Button yesButton = new Button("Yes");
        yesButton.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
        yesButton.setDefaultButton(true);

        Button noButton = new Button("No");
        noButton.setPrefSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);


        //Clicking will set answer and close window
        yesButton.setOnAction(e -> {
            answer = true;
            NewStudentBox student = NewStudentBox.display("","");
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);

        //Add buttons
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setPadding(new Insets(15,12,15,12));
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("Style.css");
        window.setScene(scene);
        window.showAndWait();

        //Make sure to return answer
        return answer;
    }

} // end class def