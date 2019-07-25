
/**
 * @author Jeff Chapin
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class selectGeometricFigures extends Application {
	public void start(Stage primaryStage) {

		/** Create GUI */

		// Create shapes
		Circle circle = new Circle(50, 50, 50);
		circle.setStroke(Color.BLACK);
		circle.setFill(null);
		Rectangle rectangle = new Rectangle(0, 0, 100, 75);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(null);
		Ellipse ellipse = new Ellipse(50, 50, 70, 30);
		ellipse.setStroke(Color.BLACK);
		ellipse.setFill(null);

		// Create panes
		BorderPane pane = new BorderPane();
		StackPane paneForShapes = new StackPane();
		HBox paneForRadioButtons = new HBox(20);

		// Create a Font
		Font font = new Font(15);

		// Create Radio Buttons
		RadioButton rbCircle = new RadioButton("Circle");
		rbCircle.setFont(font);
		RadioButton rbRectangle = new RadioButton("Rectangle");
		rbRectangle.setFont(font);
		RadioButton rbEllipse = new RadioButton("Ellipse");
		rbEllipse.setFont(font);

		// Create toggle group and add radio buttons to the group
		ToggleGroup group = new ToggleGroup();
		rbCircle.setToggleGroup(group);
		rbRectangle.setToggleGroup(group);
		rbEllipse.setToggleGroup(group);

		// Create check box
		CheckBox chkFill = new CheckBox("Fill");
		chkFill.setFont(font);

		// Add radio buttons and checkbox to the HBox
		paneForRadioButtons.getChildren().addAll(rbCircle, rbRectangle, rbEllipse, chkFill);
		paneForRadioButtons.setAlignment(Pos.CENTER);

		// Place the radio buttons on the bottom of the border pane
		pane.setBottom(paneForRadioButtons);

		/** Event handlers */

		rbCircle.setOnAction(e -> {
			pane.setCenter(circle);
		});

		rbRectangle.setOnAction(e -> {
			pane.setCenter(rectangle);
		});

		rbEllipse.setOnAction(e -> {
			pane.setCenter(ellipse);
		});

		chkFill.setOnAction(e -> {
			if (chkFill.isSelected()) {
				circle.setFill(Color.rgb(102, 153, 0));
				rectangle.setFill(Color.rgb(51, 51, 204));
				ellipse.setFill(Color.rgb(204, 0, 0));
			} else {
				circle.setFill(null);
				rectangle.setFill(null);
				ellipse.setFill(null);

			}
		});

		/** Add pane to scene */
		Scene scene = new Scene(pane, 400, 250);
		primaryStage.setTitle("Select Geometric Figures - By Jeff Chapin");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
