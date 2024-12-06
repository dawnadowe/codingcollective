package digitaldiary3;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DigitalDiary {

    private final Stage stage; // The main application window (stage)

    // Constructor for initializing the app and the stage
    public DigitalDiary(Stage stage) {
        this.stage = stage; // Initialize the stage passed to the constructor
    }

    // Generic method to show a page
    private void showPage(Scene scene, String title) {
        if (stage != null) {
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } else {
            throw new IllegalStateException("Stage is not initialized");
        }
    }

    // Show Login Page
    public void showLoginPage() {
        LoginPage loginPage = new LoginPage(this);
        loginPage.start(stage); // Ensure proper initialization and display
    }

    // Show Create Entry Page
    public void showCreateEntryPage(int userId) {
        CreateEntriesPage createEntriesPage = new CreateEntriesPage(this, userId);
        createEntriesPage.start(stage); // Ensure proper initialization and display
    }

    // Show Dashboard Page
    public void showDashboardPage(int userId) {
        DashboardPage dashboardPage = new DashboardPage(this, userId);
        dashboardPage.start(stage); // Ensure proper initialization and display
    }

    // Show Registration Page
    public void showRegistrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(this);
        registrationPage.start(stage); // Ensure proper initialization and display
    }

    // Getter for the stage
    public Stage getStage() {
        return stage;
    }

    Button showViewEntriesPage(int currentUserId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Button showTemporaryRecycleBinPage(int currentUserId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Button showMoodTrackerPage(int currentUserId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Button showExportEntriesPage(int currentUserId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
