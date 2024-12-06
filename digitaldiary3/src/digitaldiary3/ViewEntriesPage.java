package digitaldiary3;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.*;

public class ViewEntriesPage {

    private final DigitalDiary mainApp; // Reference to the main app for navigation
    private final int currentUserId; // Store the current user ID
    private final Scene scene; // The main scene

    private final ListView<String> entriesListView;

    // Constructor to initialize the ViewEntriesPage
    public ViewEntriesPage(DigitalDiary mainApp, int currentUserId) {
        this.mainApp = mainApp;
        this.currentUserId = currentUserId;

        // UI Elements
        Label appTitle = createStyledLabel("Your Diary Entries", "Comic Sans MS", 30, Color.rgb(255, 105, 97));
        entriesListView = new ListView<>();
        entriesListView.setPrefHeight(300);

        populateEntriesList(); // Populate the list with entries for the current user

        // Buttons
        VBox buttonBox = createButtonBox(
                createStyledButton("Edit Entry", this::editEntry),
                createStyledButton("Delete Entry", this::deleteEntry),
                createStyledButton("Search Entry", this::searchEntry),
                createStyledButton("Sort Entries", this::sortEntries),
                createStyledButton("Export Entry", this::exportEntry),
                createStyledButton("Back to Dashboard", () -> mainApp.showDashboardPage(currentUserId))
        );

        // Layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #f5f5f5; -fx-padding: 20;");
        layout.getChildren().addAll(appTitle, entriesListView, buttonBox);

        this.scene = new Scene(layout, 600, 600);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }

    // Populate the list of entries from the database (CSV)
    private void populateEntriesList() {
        List<String[]> entries = DigitalDiaryDatabase.readEntriesFromCSV("user_data/user_" + currentUserId + "_entries.csv");

        entriesListView.getItems().clear();
        entries.forEach(entry -> entriesListView.getItems().add(entry[1] + " - " + entry[2])); // Date - Title
    }

    // Edit an entry
    private void editEntry() {
        String[] selectedEntry = parseSelectedEntry();
        if (selectedEntry == null) return;

        String entryTitle = selectedEntry[1];

        TextInputDialog titleDialog = createInputDialog("Edit Entry", "Edit the title of your entry", entryTitle);
        Optional<String> newTitle = titleDialog.showAndWait();

        if (newTitle.isPresent()) {
            TextInputDialog contentDialog = createInputDialog("Edit Content", "Edit the content of your entry", "");
            Optional<String> newContent = contentDialog.showAndWait();

            ChoiceDialog<String> moodDialog = new ChoiceDialog<>("Happy", "Happy", "Sad", "Excited", "Angry", "Neutral", "Stressed Out", "Scared", "Bored", "Confident");
            moodDialog.setTitle("Edit Mood");
            moodDialog.setHeaderText("Select the mood for this entry");
            Optional<String> newMood = moodDialog.showAndWait();

            if (newContent.isPresent() && newMood.isPresent()) {
                boolean success = DigitalDiaryDatabase.editDiaryEntry(currentUserId, Integer.parseInt(entryTitle), newTitle.get(), newContent.get(), newMood.get(), "");

                if (success) {
                    showAlert("Entry Edited", "The entry has been successfully edited.", Alert.AlertType.INFORMATION);
                    populateEntriesList(); // Refresh the list of entries
                } else {
                    showAlert("Error", "Failed to edit entry.", Alert.AlertType.ERROR);
                }
            }
        }
    }

    // Delete an entry (soft delete and move to recycle bin)
    private void deleteEntry() {
        String[] selectedEntry = parseSelectedEntry();
        if (selectedEntry == null) return;

        String entryTitle = selectedEntry[1];
        boolean success = DigitalDiaryDatabase.deleteDiaryEntry(currentUserId, Integer.parseInt(entryTitle));

        if (success) {
            showAlert("Entry Deleted", "The entry has been deleted and moved to the recycle bin.", Alert.AlertType.INFORMATION);
            populateEntriesList(); // Refresh the entries list
        } else {
            showAlert("Error", "Failed to delete entry.", Alert.AlertType.ERROR);
        }
    }

    // Search entries by keyword
    private void searchEntry() {
        TextInputDialog dialog = createInputDialog("Search Entry", "Enter keyword to search", "");
        dialog.showAndWait().ifPresent(keyword -> {
            List<String[]> results = DigitalDiaryDatabase.searchEntries(currentUserId, keyword);

            entriesListView.getItems().clear();
            if (!results.isEmpty()) {
                results.forEach(result -> entriesListView.getItems().add(
                        "Date: " + result[1] + "\nTitle: " + result[2] + "\nContent: " + result[3]
                ));
            } else {
                showAlert("No Results", "No entries found for the keyword.", Alert.AlertType.INFORMATION);
            }
        });
    }

    // Sort entries by date (ascending/descending)
    private void sortEntries() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Ascending", "Ascending", "Descending");
        dialog.setTitle("Sort Entries");
        dialog.setHeaderText("Choose sorting order");
        dialog.showAndWait().ifPresent(order -> {
            List<String[]> sortedEntries = DigitalDiaryDatabase.sortEntriesByDate(currentUserId, order.equals("Ascending"));
            entriesListView.getItems().clear();
            sortedEntries.forEach(entry -> entriesListView.getItems().add(entry[1] + " - " + entry[2])); // Date - Title
        });
    }

    // Export selected entry (for later implementation)
    private void exportEntry() {
        String selectedEntry = entriesListView.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            System.out.println("Exporting entry: " + selectedEntry); // Placeholder
        } else {
            showAlert("No Entry Selected", "Please select an entry to export.", Alert.AlertType.WARNING);
        }
    }

    // Utility Methods
    private String[] parseSelectedEntry() {
        String selectedEntry = entriesListView.getSelectionModel().getSelectedItem();
        if (selectedEntry == null) {
            showAlert("No Entry Selected", "Please select an entry.", Alert.AlertType.WARNING);
            return null;
        }
        return selectedEntry.split(" - ");
    }

    private Button createStyledButton(String text, Runnable action) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #ff7f7f; -fx-text-fill: white; -fx-background-radius: 10;");
        button.setOnAction(e -> action.run());
        return button;
    }

    private VBox createButtonBox(Button... buttons) {
        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(buttons);
        return box;
    }

    private Label createStyledLabel(String text, String font, int size, Color color) {
        Label label = new Label(text);
        label.setFont(Font.font(font, size));
        label.setTextFill(color);
        return label;
    }

    private TextInputDialog createInputDialog(String title, String header, String defaultValue) {
        TextInputDialog dialog = new TextInputDialog(defaultValue);
        dialog.setTitle(title);
        dialog.setHeaderText(header);
        return dialog;
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}



