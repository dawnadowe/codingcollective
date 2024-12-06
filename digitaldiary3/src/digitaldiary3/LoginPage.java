package digitaldiary3;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginPage {
    private final DigitalDiary mainApp; // Reference to the main app
    private Scene scene; // The main scene

    public LoginPage(DigitalDiary mainApp) {
        this.mainApp = mainApp;
    }

    public void start(Stage stage) {
        // UI components
        Label appTitle = createLabel("Digital Diary", 40, "#ff6b6b", true);
        Label subTitle = createLabel("by The Coding Collective", 18, "#f4a261", false);

        // Input fields
        TextField usernameField = createInputField("Enter Username or Email");
        PasswordField passwordField = createPasswordField("Enter Password");

        // Buttons
        Label messageLabel = createLabel("", 12, "RED", false);
        Button loginButton = createButton("Login", "#ff7f7f", () -> {
            String usernameOrEmail = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            // Validate login credentials
            if (DigitalDiaryDatabase.validateLogin(usernameOrEmail, password)) {
                int userId = DigitalDiaryDatabase.getUserIdByUsernameOrEmail(usernameOrEmail); // Assume this method exists
                mainApp.showDashboardPage(userId); // Pass userId to the dashboard
            } else {
                messageLabel.setText("Invalid username/email or password.");
            }
        });

        Button registerButton = createButton("Register", "#ff9b9b", () -> mainApp.showRegistrationPage());

        // Titles container for alignment
        VBox titleBox = new VBox(5); // Adjust spacing between title and subtitle
        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().addAll(appTitle, subTitle);

        // Layout
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #F5F5DC;");
        layout.getChildren().addAll(titleBox, usernameField, passwordField, loginButton, messageLabel, registerButton);

        // Set scene
        scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Digital Diary - Login");
        stage.show();
    }

    public Scene getScene() {
        return scene; // Return the login scene
    }

    // Create styled labels
    private Label createLabel(String text, int fontSize, String color, boolean bold) {
        Label label = new Label(text);
        label.setFont(Font.font("Comic Sans MS", fontSize)); // Keep Comic Sans
        label.setStyle(String.format("-fx-text-fill: %s; %s", color, bold ? "-fx-font-weight: bold;" : ""));
        return label;
    }

    // Create styled input fields
    private TextField createInputField(String promptText) {
        TextField inputField = new TextField();
        inputField.setPromptText(promptText);
        inputField.setStyle("-fx-background-color: #fff5e6; -fx-border-color: #d1bfa7; -fx-border-radius: 20; -fx-padding: 10;");
        return inputField;
    }

    // Create styled password fields
    private PasswordField createPasswordField(String promptText) {
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText(promptText);
        passwordField.setStyle("-fx-background-color: #fff5e6; -fx-border-color: #d1bfa7; -fx-border-radius: 20; -fx-padding: 10;");
        return passwordField;
    }

    // Create styled buttons
    private Button createButton(String text, String backgroundColor, Runnable action) {
        Button button = new Button(text);
        button.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: white; -fx-background-radius: 25; -fx-padding: 10; -fx-font-size: 16px;", backgroundColor));
        button.setOnAction(e -> action.run());
        return button;
    }
}


