package digitaldiary3;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

import java.time.*;
import java.util.*;

public class MoodTrackerPage {

    private final DigitalDiary mainApp; // Reference to the main app
    private final int currentUserId; // Store the current user ID

    private LineChart<Number, Number> moodChart;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;

    public MoodTrackerPage(DigitalDiary mainApp, int currentUserId) {
        this.mainApp = mainApp;
        this.currentUserId = currentUserId;
    }

    // Get the scene for the Mood Tracker page
    public Scene getScene() {
        // UI Elements
        Label appTitle = createStyledLabel("Mood Tracker", "Comic Sans MS", 30, Color.rgb(255, 105, 97));

        // Date Pickers for filtering
        startDatePicker = createStyledDatePicker(LocalDate.now().minusDays(30));
        endDatePicker = createStyledDatePicker(LocalDate.now());

        // Button to apply filter based on date range
        Button filterButton = createStyledButton("Filter by Date", this::filterMoodData, "-fx-background-color: #ff7f7f; -fx-text-fill: white;");

        // LineChart for displaying mood data
        moodChart = createMoodChart();

        // Back to dashboard button
        Button backButton = createStyledButton("Back to Dashboard", () -> mainApp.showDashboardPage(currentUserId), "-fx-background-color: #ff9b9b; -fx-text-fill: white;");

        // Layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #f5f5f5; -fx-padding: 20;");
        layout.getChildren().addAll(
                appTitle,
                createStyledLabel("Select Date Range:", "Comic Sans MS", 16, Color.BLACK),
                startDatePicker,
                endDatePicker,
                filterButton,
                moodChart,
                backButton
        );

        return new Scene(layout, 800, 600);
    }

    // Create a styled label
    private Label createStyledLabel(String text, String fontFamily, int fontSize, Color color) {
        Label label = new Label(text);
        label.setFont(Font.font(fontFamily, fontSize));
        label.setTextFill(color);
        return label;
    }

    // Create a styled date picker with a default value
    private DatePicker createStyledDatePicker(LocalDate defaultValue) {
        DatePicker datePicker = new DatePicker(defaultValue);
        datePicker.setConverter(new StringConverter<>() {
            @Override
            public String toString(LocalDate object) {
                return object != null ? object.toString() : "";
            }

            @Override
            public LocalDate fromString(String string) {
                return string != null && !string.isEmpty() ? LocalDate.parse(string) : null;
            }
        });
        return datePicker;
    }

    // Create a styled button with an action
    private Button createStyledButton(String text, Runnable action, String style) {
        Button button = new Button(text);
        button.setStyle(style);
        button.setOnAction(e -> action.run());
        return button;
    }

    // Create the LineChart for mood trends
    private LineChart<Number, Number> createMoodChart() {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Days");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Mood Count");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Mood Trends Over Time");

        return chart;
    }

    // Filter mood data by selected date range
    private void filterMoodData() {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        // Retrieve the mood data from the database for the selected date range
        List<String[]> entries = DigitalDiaryDatabase.readEntriesFromCSV("user_data/user_" + currentUserId + "_entries.csv");

        // Filter the entries by date
        List<String[]> filteredEntries = new ArrayList<>();
        for (String[] entry : entries) {
            LocalDate entryDate = LocalDate.parse(entry[1]);
            if ((entryDate.isEqual(startDate) || entryDate.isAfter(startDate)) &&
                    (entryDate.isEqual(endDate) || entryDate.isBefore(endDate))) {
                filteredEntries.add(entry);
            }
        }

        // Group moods by date
        Map<LocalDate, Map<String, Integer>> moodDataByDate = new HashMap<>();
        for (String[] entry : filteredEntries) {
            LocalDate entryDate = LocalDate.parse(entry[1]);
            String mood = entry[4];  // Mood is stored in column index 4

            moodDataByDate.putIfAbsent(entryDate, new HashMap<>());
            moodDataByDate.get(entryDate).put(mood, moodDataByDate.get(entryDate).getOrDefault(mood, 0) + 1);
        }

        // Prepare data for the chart
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Mood Trends");

        // Add mood counts to the chart
        List<String> moods = Arrays.asList("Happy", "Sad", "Excited", "Angry", "Neutral",
                "Stressed Out", "Scared", "Bored", "Confident");

        for (Map.Entry<LocalDate, Map<String, Integer>> entry : moodDataByDate.entrySet()) {
            LocalDate date = entry.getKey();
            for (int i = 0; i < moods.size(); i++) {
                String mood = moods.get(i);
                int count = entry.getValue().getOrDefault(mood, 0);
                series.getData().add(new XYChart.Data<>(date.toEpochDay(), count));  // X axis: date (converted to epoch day), Y axis: mood count
            }
        }

        // Clear the chart and add the new data series
        moodChart.getData().clear();
        moodChart.getData().add(series);
    }
}




