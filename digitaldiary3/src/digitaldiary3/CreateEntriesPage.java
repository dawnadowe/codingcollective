package digitaldiary3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class CreateEntriesPage extends Application {
    private final DigitalDiary mainApp; // Reference to the main app
    private final int currentUserId; // Store the current user ID

    private TextField titleField;
    private TextArea contentArea;
    private DatePicker datePicker;
    private ComboBox<String> moodComboBox;
    private ListView<String> imageListView;
    private Label quoteLabel;
    private ObservableList<String> imagePaths;
    private Stage primaryStage;
    private Scene scene; // Store the scene for `getScene`

    // Constructor accepting the mainApp and userId
    public CreateEntriesPage(DigitalDiary mainApp, int userId) {
        this.mainApp = mainApp;
        this.currentUserId = userId; // Store user ID
    }

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        // UI elements
        Label appTitle = createStyledLabel("Create Diary Entry", "Comic Sans MS", 30, Color.rgb(255, 105, 97));
        Label subtitle = createStyledLabel("Write down your thoughts and feelings.", "Comic Sans MS", 16, Color.BLACK);
        titleField = createStyledTextField("Enter Entry Title");
        contentArea = createStyledTextArea("Write your content here...");
        datePicker = createStyledDatePicker();

        // Mood selection combo box
        moodComboBox = createMoodComboBox();
        moodComboBox.setOnAction(e -> displayMotivationalQuotes(moodComboBox.getValue()));

        // Image upload and display
        Button uploadButton = createStyledButton("Upload Image(s)", this::uploadImage, "-fx-background-color: #ff7f7f; -fx-text-fill: white;");
        imagePaths = FXCollections.observableArrayList();
        imageListView = new ListView<>(imagePaths);
        imageListView.setPrefHeight(100);

        // Display motivational quote
        quoteLabel = createStyledLabel("", "Comic Sans MS", 14, Color.DARKGREEN);

        // Save, Back, and Export buttons
        Button saveButton = createStyledButton("Save Entry", this::saveDiaryEntry, "-fx-background-color: #6dbd63; -fx-text-fill: white;");
        Button backButton = createStyledButton("Back to Dashboard", () -> mainApp.showDashboardPage(currentUserId), "-fx-background-color: #ff9b9b; -fx-text-fill: white;");
        Button exportButton = createStyledButton("Export Entry", this::exportDiaryEntry, "-fx-background-color: #87CEEB; -fx-text-fill: white;");

        // Layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #f5f5f5; -fx-padding: 20;");
        layout.getChildren().addAll(appTitle, subtitle, titleField, contentArea, datePicker, moodComboBox, quoteLabel, uploadButton,
                imageListView, saveButton, backButton, exportButton);

        this.scene = new Scene(layout, 600, 600); // Store the scene
        stage.setScene(scene);
        stage.setTitle("Create Diary Entry");
        stage.show();
    }

    // Create a styled label
    private Label createStyledLabel(String text, String fontFamily, int fontSize, Color color) {
        Label label = new Label(text);
        label.setFont(Font.font(fontFamily, fontSize));
        label.setTextFill(color);
        return label;
    }

    // Create a styled text field
    private TextField createStyledTextField(String prompt) {
        TextField textField = new TextField();
        textField.setPromptText(prompt);
        textField.setStyle("-fx-background-color: #f2f2f2;");
        return textField;
    }

    // Create a styled text area
    private TextArea createStyledTextArea(String prompt) {
        TextArea textArea = new TextArea();
        textArea.setPromptText(prompt);
        textArea.setWrapText(true);
        textArea.setStyle("-fx-background-color: #f2f2f2;");
        return textArea;
    }

    // Create a styled date picker
    private DatePicker createStyledDatePicker() {
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now()); // Default to today's date
        return datePicker;
    }

    // Create a mood combo box
    private ComboBox<String> createMoodComboBox() {
        ComboBox<String> comboBox = new ComboBox<>();
        ObservableList<String> moods = FXCollections.observableArrayList(
                "Happy", "Sad", "Excited", "Angry", "Neutral", "Stressed Out", "Scared", "Bored", "Confident"
        );
        comboBox.setItems(moods);
        comboBox.setValue("Happy");
        return comboBox;
    }

    // Create a styled button with action
    private Button createStyledButton(String text, Runnable action, String style) {
        Button button = new Button(text);
        button.setStyle(style);
        button.setOnAction(e -> action.run());
        return button;
    }

    // Display motivational quotes based on selected mood
    private void displayMotivationalQuotes(String mood) {
        String filePath = "moods/" + mood.toLowerCase() + ".txt";
        List<String> quotes = readQuotesFromFile(filePath);
        if (quotes.isEmpty()) {
            quoteLabel.setText("No quotes available for this mood.");
        } else {
            Random random = new Random();
            String randomQuote = quotes.get(random.nextInt(quotes.size()));
            quoteLabel.setText(randomQuote);
        }
    }

    // Read quotes from a file based on the mood
    private List<String> readQuotesFromFile(String filePath) {
        List<String> quotes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                quotes.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading quotes file: " + e.getMessage());
        }
        return quotes;
    }

    // Upload images for the diary entry
    private void uploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(primaryStage);
        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                imagePaths.add(file.getAbsolutePath());
            }
        }
    }

    // Save the diary entry to the database (CSV)
    private void saveDiaryEntry() {
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();
        if (title.isEmpty() || content.isEmpty()) {
            showWarningAlert("Validation Error", "Please ensure that both the entry title and content are filled.");
            return;
        }
        LocalDate date = datePicker.getValue();
        String mood = moodComboBox.getValue();
        String imagePathsConcatenated = String.join(";", imagePaths); // Store image paths as a semicolon-separated string

        // Save to the database (use currentUserId)
        boolean success = DigitalDiaryDatabase.createDiaryEntry(currentUserId, title, content, mood, date, imagePathsConcatenated);
        if (success) {
            showSaveConfirmation();
            mainApp.showDashboardPage(currentUserId); // Navigate back to DashboardPage
        } else {
            showErrorAlert("Failed to Save Entry");
        }
    }

    // Export the diary entry to a file
    private void exportDiaryEntry() {
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();
        if (title.isEmpty() || content.isEmpty()) {
            showWarningAlert("Export Error", "Please ensure that both the entry title and content are filled before exporting.");
            return;
        }
        LocalDate date = datePicker.getValue();
        String mood = moodComboBox.getValue();
        String imagePathsConcatenated = String.join(";", imagePaths); // Semicolon-separated string for image paths

        // Create export content
        StringBuilder exportContent = new StringBuilder();
        exportContent.append("Diary Entry\n");
        exportContent.append("Title: ").append(title).append("\n");
        exportContent.append("Date: ").append(date).append("\n");
        exportContent.append("Mood: ").append(mood).append("\n");
        exportContent.append("Content:\n").append(content).append("\n");
        if (!imagePaths.isEmpty()) {
            exportContent.append("Images:\n").append(imagePathsConcatenated).append("\n");
        }

        // FileChooser to save the file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Diary Entry");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showSaveDialog(primaryStage);

        if (selectedFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                writer.write(exportContent.toString());
                showInformationAlert("Export Successful", "Diary entry exported successfully!");
            } catch (IOException e) {
                showErrorAlert("Error exporting the entry: " + e.getMessage());
            }
        }
    }

    // Show a confirmation alert
    private void showSaveConfirmation() {
        showInformationAlert("Success", "Diary entry saved successfully!");
    }

    // Show a warning alert
    private void showWarningAlert(String title, String content) {
        showAlert(Alert.AlertType.WARNING, title, content);
    }

    // Show an information alert
    private void showInformationAlert(String title, String content) {
        showAlert(Alert.AlertType.INFORMATION, title, content);
    }

    // Show an error alert
    private void showErrorAlert(String content) {
        showAlert(Alert.AlertType.ERROR, "Error", content);
    }

    // Show a general alert
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}



