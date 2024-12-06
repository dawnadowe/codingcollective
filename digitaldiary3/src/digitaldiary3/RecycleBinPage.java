package digitaldiary3;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.*;

public class RecycleBinPage {

    private final DigitalDiary mainApp; // Reference to the main app
    private final int currentUserId; // Store the current user ID

    private ListView<String> recycleBinListView;

    public RecycleBinPage(DigitalDiary mainApp, int currentUserId) {
        this.mainApp = mainApp;
        this.currentUserId = currentUserId;
    }

    // Generate the scene for the Recycle Bin page
    public Scene getScene() {
        Label appTitle = createStyledLabel("Recycle Bin", "Comic Sans MS", 30, Color.rgb(255, 105, 97));
        recycleBinListView = new ListView<>();
        recycleBinListView.setPrefHeight(300);
        populateRecycleBinList();

        // Create buttons
        Button restoreButton = createStyledButton("Restore Entry", this::restoreEntry, "-fx-background-color: #6dbd63; -fx-text-fill: white;");
        Button permanentlyDeleteButton = createStyledButton("Permanently Delete Entry", this::permanentlyDeleteEntry, "-fx-background-color: #ff7f7f; -fx-text-fill: white;");
        Button backButton = createStyledButton("Back to Dashboard", () -> mainApp.showDashboardPage(currentUserId), "-fx-background-color: #ff9b9b; -fx-text-fill: white;");

        // Layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #f5f5f5; -fx-padding: 20;");
        layout.getChildren().addAll(appTitle, recycleBinListView, restoreButton, permanentlyDeleteButton, backButton);

        return new Scene(layout, 600, 600);
    }

    // Populate the list of entries in the recycle bin
    private void populateRecycleBinList() {
        List<String[]> deletedEntries = DigitalDiaryDatabase.readEntriesFromCSV("user_data/user_" + currentUserId + "_recycle_bin.csv");
        recycleBinListView.getItems().clear();

        for (String[] entry : deletedEntries) {
            String entryInfo = "Date: " + entry[1] + " - Title: " + entry[2];  // Format: Date - Title
            recycleBinListView.getItems().add(entryInfo);
        }
    }

    // Restore a selected entry to the main diary
    private void restoreEntry() {
        String selectedEntry = recycleBinListView.getSelectionModel().getSelectedItem();
        if (selectedEntry == null) {
            showAlert("No Entry Selected", "Please select an entry to restore.");
            return;
        }

        String[] entryDetails = extractEntryDetails(selectedEntry);
        int entryId = Integer.parseInt(entryDetails[1]);

        if (DigitalDiaryDatabase.restoreDiaryEntry(currentUserId, entryId)) {
            showAlert("Entry Restored", "The entry has been successfully restored to your diary.");
            populateRecycleBinList();
        } else {
            showAlert("Error", "Failed to restore entry.");
        }
    }

    // Permanently delete a selected entry
    private void permanentlyDeleteEntry() {
        String selectedEntry = recycleBinListView.getSelectionModel().getSelectedItem();
        if (selectedEntry == null) {
            showAlert("No Entry Selected", "Please select an entry to permanently delete.");
            return;
        }

        String[] entryDetails = extractEntryDetails(selectedEntry);
        int entryId = Integer.parseInt(entryDetails[1]);

        if (DigitalDiaryDatabase.permanentlyDeleteFromRecycleBin(currentUserId, entryId)) {
            showAlert("Entry Permanently Deleted", "The entry has been permanently deleted from the recycle bin.");
            populateRecycleBinList();
        } else {
            showAlert("Error", "Failed to permanently delete entry.");
        }
    }

    // Extract entry details (date and title) from the selected ListView item
    private String[] extractEntryDetails(String selectedEntry) {
        String[] parts = selectedEntry.split(" - ");
        String entryDate = parts[0].split(":")[1].trim(); // Extract date
        String entryTitle = parts[1].split(":")[1].trim(); // Extract title
        return new String[]{entryDate, entryTitle};
    }

    // Utility: Create a styled button
    private Button createStyledButton(String text, Runnable action, String style) {
        Button button = new Button(text);
        button.setStyle(style);
        button.setOnAction(e -> action.run());
        return button;
    }

    // Utility: Create a styled label
    private Label createStyledLabel(String text, String fontFamily, int fontSize, Color color) {
        Label label = new Label(text);
        label.setFont(Font.font(fontFamily, fontSize));
        label.setTextFill(color);
        return label;
    }

    // Utility: Show an alert dialog
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

