package digitaldiary3;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;
import java.io.*;
import java.time.*;
import java.util.*;

public class ExportPDFPage {

    private final DigitalDiary mainApp; // Reference to the main app
    private final int currentUserId; // Store the current user ID

    private ComboBox<String> durationComboBox;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;

    public ExportPDFPage(DigitalDiary mainApp, int currentUserId) {
        this.mainApp = mainApp;
        this.currentUserId = currentUserId;
    }

    // Get the scene for the Export PDF page
    public Scene getScene() {
        // UI Elements
        Label appTitle = createStyledLabel("Export Diary Entries to PDF", "Comic Sans MS", 30, Color.rgb(255, 105, 97));

        durationComboBox = createDurationComboBox();
        startDatePicker = createStyledDatePicker(LocalDate.now().minusDays(30));
        endDatePicker = createStyledDatePicker(LocalDate.now());

        Button exportButton = createStyledButton("Export Entries", this::exportDiaryEntries, "-fx-background-color: #6dbd63; -fx-text-fill: white;");
        Button backButton = createStyledButton("Back to Dashboard", () -> mainApp.showDashboardPage(currentUserId), "-fx-background-color: #ff9b9b; -fx-text-fill: white;");

        // Layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #f5f5f5; -fx-padding: 20;");
        layout.getChildren().addAll(
                appTitle,
                createStyledLabel("Select Duration:", "Comic Sans MS", 16, Color.BLACK),
                durationComboBox,
                createStyledLabel("Select Date Range:", "Comic Sans MS", 16, Color.BLACK),
                startDatePicker,
                endDatePicker,
                exportButton,
                backButton
        );

        return new Scene(layout, 600, 500);
    }

    // Export diary entries to PDF
    private void exportDiaryEntries() {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        String duration = durationComboBox.getValue();

        List<String[]> entries = DigitalDiaryDatabase.readEntriesFromCSV("user_data/user_" + currentUserId + "_entries.csv");
        List<String[]> filteredEntries = filterEntries(entries, startDate, endDate, duration);

        if (filteredEntries.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "No Entries Found", "No entries match the selected filters.");
            return;
        }

        // Generate PDF
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            File selectedFile = fileChooser.showSaveDialog(null);

            if (selectedFile != null) {
                createPDF(selectedFile, filteredEntries);
                showAlert(Alert.AlertType.INFORMATION, "Export Successful", "Diary Entries Exported Successfully to PDF!");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Export Error", "An error occurred while exporting the entries.\nError: " + e.getMessage());
        }
    }

    // Filter entries by date range and duration
    private List<String[]> filterEntries(List<String[]> entries, LocalDate startDate, LocalDate endDate, String duration) {
        List<String[]> filteredEntries = new ArrayList<>();
        for (String[] entry : entries) {
            LocalDate entryDate = LocalDate.parse(entry[1]);

            if (entryDate.isBefore(startDate) || entryDate.isAfter(endDate)) continue;

            switch (duration) {
                case "Day":
                    if (entryDate.isEqual(startDate)) filteredEntries.add(entry);
                    break;
                case "Week":
                    if (!entryDate.isBefore(startDate.minusWeeks(1))) filteredEntries.add(entry);
                    break;
                case "Month":
                    if (!entryDate.isBefore(startDate.minusMonths(1))) filteredEntries.add(entry);
                    break;
            }
        }
        return filteredEntries;
    }

    // Generate PDF with the filtered entries
    private void createPDF(File file, List<String[]> entries) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();

        document.add(new Paragraph("Diary Entries Exported on: " + LocalDate.now()));
        document.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(4);
        table.addCell("Date");
        table.addCell("Title");
        table.addCell("Mood");
        table.addCell("Content");

        for (String[] entry : entries) {
            table.addCell(entry[1]);  // Date
            table.addCell(entry[2]);  // Title
            table.addCell(entry[4]);  // Mood
            table.addCell(entry[3]);  // Content
        }

        document.add(table);
        document.close();
    }

    // Create a styled label
    private Label createStyledLabel(String text, String fontFamily, int fontSize, Color color) {
        Label label = new Label(text);
        label.setFont(Font.font(fontFamily, fontSize));
        label.setTextFill(color);
        return label;
    }

    // Create a styled date picker with default value
    private DatePicker createStyledDatePicker(LocalDate defaultValue) {
        DatePicker datePicker = new DatePicker(defaultValue);
        return datePicker;
    }

    // Create a duration combo box
    private ComboBox<String> createDurationComboBox() {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Day", "Week", "Month");
        comboBox.setValue("Month");
        return comboBox;
    }

    // Create a styled button with action
    private Button createStyledButton(String text, Runnable action, String style) {
        Button button = new Button(text);
        button.setStyle(style);
        button.setOnAction(e -> action.run());
        return button;
    }

    // Show an alert dialog
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

