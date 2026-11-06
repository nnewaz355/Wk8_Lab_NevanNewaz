package application;
	
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		

		 Label title = new Label("College Student Services");
		 Label userLabel = new Label("JavaFX Layouts Lab");
		 HBox header = new HBox(title, new Region(), userLabel);
		 header.setAlignment(Pos.CENTER_LEFT);
		 header.setPadding(new Insets(15));
		 

		

		 Label menuTitle = new Label("MENU");
		 Button dashboardButton = new Button("Dashboard");
		 Button registrationButton = new Button("Registration");
		 Button coursesButton = new Button("Courses");
		 Button helpButton = new Button("Help");
		 
		 VBox navigation = new VBox(12, menuTitle, dashboardButton, registrationButton, coursesButton, helpButton);
		 navigation.setPadding(new Insets(15));
		 navigation.setPrefWidth(160);

		
		Label formTitle = new Label("Student Registration");
		
		TextField idField = new TextField();
		idField.setPromptText("e.g. S1001");
		TextField nameField = new TextField();
		nameField.setPromptText("e.g. Enter full name");
		TextField emailField = new TextField();
		emailField.setPromptText("name@example.com");
		ComboBox<String> programBox = new ComboBox<>();
		programBox.getItems().addAll(
				"Computer Programming",
				"Cybersecurity",
				"Data Analytics",
				"Cloud Computing"
				);
		
		GridPane form = new GridPane();
		form.setHgap(12);
		form.setVgap(14);
		// Place nodes in the pane
		form.add(new Label("Student ID:"), 0, 0);
		form.add(idField, 1, 0);
		form.add(new Label("Full Name:"), 0, 1);
		form.add(nameField, 1, 1);
		form.add(new Label("Email:"), 0, 2);
		form.add(emailField, 1, 2);
		form.add(new Label("Program:"), 0, 3);
		form.add(programBox, 1, 3);
		ColumnConstraints labelColumn = new ColumnConstraints();
		labelColumn.setMinWidth(100);
		ColumnConstraints inputColumn = new ColumnConstraints();
		inputColumn.setHgrow(Priority.ALWAYS);
		form.getColumnConstraints().addAll(labelColumn, inputColumn);
		
		Label statusLabel = new Label("Complete the form and select Register");
		Button registerButton = new Button("Register");
		Button clearButton = new Button("Clear");
		

		HBox actions = new HBox(10, registerButton, clearButton);
		actions.setAlignment(Pos.CENTER_LEFT);
		
		VBox centerContent = new VBox(18, formTitle, form, actions, statusLabel);
		centerContent.setPadding(new Insets(25));
		centerContent.setMaxWidth(620);
		
		registerButton.setOnAction(event -> {
			String id = idField.getText().trim();
			String fullName = nameField.getText().trim();
			String email = emailField.getText().trim();
			String program = programBox.getSelectionModel().getSelectedItem();
			
			if (id.isEmpty() || fullName.isEmpty() || email.isEmpty() || program.isEmpty()) {
				statusLabel.setText("Make sure no fields are empty.");
				
			}else {
				statusLabel.setText("Registration accepted.");
			}
		});
		
		clearButton.setOnAction(event -> {
			idField.clear();
			nameField.clear();
			emailField.clear();
			programBox.getSelectionModel().clearSelection();
			statusLabel.setText("Form cleared.");
		});
		// Create a border pane
		BorderPane root = new BorderPane();
		// Place nodes in the pane
		root.setTop(header);
		root.setLeft(navigation);
		root.setCenter(centerContent);
		
		
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("College Student Services"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
