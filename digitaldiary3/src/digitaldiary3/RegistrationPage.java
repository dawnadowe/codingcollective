package digitaldiary3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegistrationPage extends Application {

    private DigitalDiary mainApp;
    private TextField usernameField;
    private TextField emailField;
    private PasswordField passwordField;
    private Label messageLabel;

    public RegistrationPage(DigitalDiary mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void start(Stage stage) {
        // UI components
        Label appTitle = createLabel("Digital Diary", 40, "#ff6b6b", true);
        Label subTitle = createLabel("by The Coding Collective", 18, "#f4a261", false);

        // Input fields
        usernameField = createInputField("Enter your username");
        emailField = createInputField("Enter your email");
        passwordField = createPasswordField("Enter your password");

        // Buttons
        Button registerButton = createButton("Register", "#ff7f7f", e -> handleRegister());
        Button backToLoginButton = createButton("Back to Login", "#ff9b9b", e -> mainApp.showLoginPage());

        // Message label
        messageLabel = createLabel("", 12, "RED", false);

        // Titles container for better alignment
        VBox titleBox = new VBox(5); // Adjust spacing between title and subtitle
        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().addAll(appTitle, subTitle);

        // Layout
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #F5F5DC;");
        layout.getChildren().addAll(titleBox, usernameField, emailField, passwordField, registerButton, messageLabel, backToLoginButton);

        // Set scene
        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Digital Diary - Register");
        stage.show();
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
        inputField.setOnKeyTyped(e -> clearMessage());
        return inputField;
    }

    // Create styled password fields
    private PasswordField createPasswordField(String promptText) {
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText(promptText);
        passwordField.setStyle("-fx-background-color: #fff5e6; -fx-border-color: #d1bfa7; -fx-border-radius: 20; -fx-padding: 10;");
        passwordField.setOnKeyTyped(e -> clearMessage());
        return passwordField;
    }

    // Create styled buttons
    private Button createButton(String text, String backgroundColor, javafx.event.EventHandler<javafx.event.ActionEvent> action) {
        Button button = new Button(text);
        button.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: white; -fx-background-radius: 25; -fx-padding: 10; -fx-font-size: 16px;", backgroundColor));
        button.setOnAction(action);
        return button;
    }

    // Clear message label
    private void clearMessage() {
        messageLabel.setText("");
    }

    // Show error or success message
    private void showMessage(String text, boolean success) {
        messageLabel.setText(text);
        messageLabel.setTextFill(success ? Color.GREEN : Color.RED);
    }

    // Handle registration logic
    private void handleRegister() {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();

        if (!validateInputs(username, email, password)) return;

        boolean success = DigitalDiaryDatabase.createUser(username, email, password);

        if (success) {
            showMessage("Registration successful!", true);
            clearInputs();
        } else {
            showMessage("Username or Email already exists.", false);
        }
    }

    // Validate inputs
    private boolean validateInputs(String username, String email, String password) {
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showMessage("All fields are required.", false);
            return false;
        }

        if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            showMessage("Invalid email format.", false);
            return false;
        }

        if (password.length() < 6) {
            showMessage("Password must be at least 6 characters.", false);
            return false;
        }

        return true;
    }

    // Clear input fields
    private void clearInputs() {
        usernameField.clear();
        emailField.clear();
        passwordField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



