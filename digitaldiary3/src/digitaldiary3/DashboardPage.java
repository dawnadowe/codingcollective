package digitaldiary3;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DashboardPage {

    private final DigitalDiary mainApp;
    private Scene scene;

    public DashboardPage(DigitalDiary mainApp, int currentUserId) {
        this.mainApp = mainApp;

        // Welcome Label
        Label welcomeLabel = new Label("Welcome to Digital Diary!");
        welcomeLabel.setFont(Font.font("Comic Sans MS", 24));
        welcomeLabel.setStyle("-fx-text-fill: #ff6b6b;");

        // Buttons
        Button createEntryButton = createStyledButton("Create Entry", () -> mainApp.showCreateEntryPage(currentUserId));
        Button viewEntriesButton = createStyledButton("View Entries", () -> mainApp.showViewEntriesPage(currentUserId));
        Button recycleBinButton = createStyledButton("Temporary Recycle Bin", () -> mainApp.showTemporaryRecycleBinPage(currentUserId));
        Button moodTrackerButton = createStyledButton("Mood Tracker", () -> mainApp.showMoodTrackerPage(currentUserId));
        Button exportEntriesButton = createStyledButton("Export Entries", () -> mainApp.showExportEntriesPage(currentUserId));
        Button logoutButton = createStyledButton("Logout", mainApp::showLoginPage);

        // Layout
        VBox layout = createStyledLayout();
        layout.getChildren().addAll(
                welcomeLabel, createEntryButton, viewEntriesButton,
                recycleBinButton, moodTrackerButton, exportEntriesButton, logoutButton
        );

        // Scene
        this.scene = new Scene(layout, 400, 500);
    }

    // Create a styled button with an action
    private Button createStyledButton(String text, Runnable action) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #ff7f7f; -fx-text-fill: white; -fx-background-radius: 10; -fx-padding: 10;");
        button.setOnAction(e -> action.run());
        return button;
    }

    // Create a styled layout
    private VBox createStyledLayout() {
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #F5F5DC;"); // Light beige background
        return layout;
    }

    // Get the scene
    public Scene getScene() {
        return scene;
    }

    // Start the DashboardPage
    public void start(Stage stage) {
        stage.setScene(getScene());
        stage.setTitle("Digital Diary - Dashboard");
        stage.show();
    }
}
