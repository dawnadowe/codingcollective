package digitaldiary3;

import javafx.application.Application;
import javafx.stage.Stage;

public class DigitalDiaryMain extends Application {

    @Override
    public void start(Stage stage) {
        // Initialize the main application and show the login page
        new DigitalDiary(stage).showLoginPage();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
