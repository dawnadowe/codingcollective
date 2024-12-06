package digitaldiary3;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DigitalDiaryDatabase {

    private static final String USER_CSV_DIRECTORY = "user_data/";  // Folder where user CSV files will be stored
    private static final String USERS_CSV = "users.csv";  // CSV for storing user data

    // Initialize the directory for user data
    static {
        File directory = new File(USER_CSV_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdir();  // Create directory if it doesn't exist
        }
    }

    // Stream entries from CSV to optimize memory usage for large datasets
    private static Stream<String[]> streamEntriesFromCSV(String userFileName) throws IOException {
        Path filePath = Paths.get(userFileName);
        if (!Files.exists(filePath)) return Stream.empty();

        return Files.lines(filePath)
                .map(line -> line.split(","))
                .onClose(() -> System.out.println("Stream closed for: " + userFileName));
    }

    // Read all entries from a CSV file (default List)
    public static List<String[]> readEntriesFromCSV(String userFileName) {
        try (Stream<String[]> entries = streamEntriesFromCSV(userFileName)) {
            return entries.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error reading entries from CSV: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Write entries back to a CSV file
    private static void writeEntriesToCSV(String userFileName, List<String[]> entries) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFileName))) {
            for (String[] entry : entries) {
                writer.write(String.join(",", entry));  // Join the entry elements with commas
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing entries to CSV: " + e.getMessage());
        }
    }

    // Create a new diary entry
    public static boolean createDiaryEntry(int userId, String title, String content, String mood, LocalDate date, String imagePathsConcatenated) {
        String userFileName = USER_CSV_DIRECTORY + "user_" + userId + "_entries.csv";

        // Read existing entries
        List<String[]> entries = readEntriesFromCSV(userFileName);

        // Create a new entry
        String[] newEntry = {
            String.valueOf(entries.size() + 1),
            date.format(DateTimeFormatter.ISO_LOCAL_DATE),
            title,
            content,
            mood,
            imagePathsConcatenated
        };

        entries.add(newEntry);
        writeEntriesToCSV(userFileName, entries);
        return true;
    }

    // Fetch quotes for a specific mood
    public static List<String> getMoodQuotes(String mood) {
        return MotivationalQuotes.getQuotesForMood(mood);  // Call the method from the MotivationalQuotes class
    }

    // Validate login credentials
    public static boolean validateLogin(String usernameOrEmail, String password) {
        String filePath = USER_CSV_DIRECTORY + USERS_CSV;
        try (Stream<String[]> users = streamEntriesFromCSV(filePath)) {
            return users.anyMatch(user -> (user[0].equalsIgnoreCase(usernameOrEmail) || user[1].equalsIgnoreCase(usernameOrEmail)) 
                                        && user[2].equals(password));
        } catch (IOException e) {
            System.out.println("Error validating login: " + e.getMessage());
            return false;
        }
    }

    // Create a new user
    public static boolean createUser(String username, String email, String password) {
        String filePath = USER_CSV_DIRECTORY + USERS_CSV;

        List<String[]> users = readEntriesFromCSV(filePath);

        // Check for existing username or email
        if (users.stream().anyMatch(user -> user[0].equalsIgnoreCase(username) || user[1].equalsIgnoreCase(email))) {
            return false;  // Username or email already exists
        }

        users.add(new String[]{username, email, password});
        writeEntriesToCSV(filePath, users);
        return true;
    }

    // Edit an existing diary entry
    public static boolean editDiaryEntry(int userId, int entryId, String newTitle, String newContent, String newMood, String newImagePath) {
        String userFileName = USER_CSV_DIRECTORY + "user_" + userId + "_entries.csv";
        List<String[]> entries = readEntriesFromCSV(userFileName);

        boolean entryFound = false;
        for (String[] entry : entries) {
            if (Integer.parseInt(entry[0]) == entryId) {
                entry[2] = newTitle;
                entry[3] = newContent;
                entry[4] = newMood;
                entry[5] = newImagePath;
                entryFound = true;
                break;
            }
        }

        if (entryFound) {
            writeEntriesToCSV(userFileName, entries);
            return true;
        }
        return false;
    }

    // Delete a diary entry (soft delete)
    public static boolean deleteDiaryEntry(int userId, int entryId) {
        String userFileName = USER_CSV_DIRECTORY + "user_" + userId + "_entries.csv";
        List<String[]> entries = readEntriesFromCSV(userFileName);
        String recycleBinFileName = USER_CSV_DIRECTORY + "user_" + userId + "_recycle_bin.csv";
        List<String[]> recycleBinEntries = readEntriesFromCSV(recycleBinFileName);

        Iterator<String[]> iterator = entries.iterator();
        while (iterator.hasNext()) {
            String[] entry = iterator.next();
            if (Integer.parseInt(entry[0]) == entryId) {
                recycleBinEntries.add(entry);
                iterator.remove();
                writeEntriesToCSV(userFileName, entries);
                writeEntriesToCSV(recycleBinFileName, recycleBinEntries);
                return true;
            }
        }
        return false;
    }

    // Search entries by keyword
    public static List<String[]> searchEntries(int userId, String keyword) {
        String userFileName = "user_data/user_" + userId + "_entries.csv";
        try (Stream<String[]> entries = Files.lines(Paths.get(userFileName))
                .map(line -> line.split(","))) {
            return entries.filter(entry -> Arrays.stream(entry)
                    .anyMatch(field -> field.toLowerCase().contains(keyword.toLowerCase())))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error searching entries: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Sort entries by date
    public static List<String[]> sortEntriesByDate(int userId, boolean ascending) {
        String userFileName = USER_CSV_DIRECTORY + "user_" + userId + "_entries.csv";
        List<String[]> entries = readEntriesFromCSV(userFileName);

        entries.sort((entry1, entry2) -> {
            LocalDate date1 = LocalDate.parse(entry1[1]);
            LocalDate date2 = LocalDate.parse(entry2[1]);
            return ascending ? date1.compareTo(date2) : date2.compareTo(date1);
        });

        return entries;
    }

    // Restore a diary entry from recycle bin
    public static boolean restoreDiaryEntry(int userId, int entryId) {
        String recycleBinFileName = USER_CSV_DIRECTORY + "user_" + userId + "_recycle_bin.csv";
        List<String[]> recycleBinEntries = readEntriesFromCSV(recycleBinFileName);
        String userFileName = USER_CSV_DIRECTORY + "user_" + userId + "_entries.csv";
        List<String[]> entries = readEntriesFromCSV(userFileName);

        Iterator<String[]> iterator = recycleBinEntries.iterator();
        while (iterator.hasNext()) {
            String[] entry = iterator.next();
            if (Integer.parseInt(entry[0]) == entryId) {
                entries.add(entry);
                iterator.remove();
                writeEntriesToCSV(recycleBinFileName, recycleBinEntries);
                writeEntriesToCSV(userFileName, entries);
                return true;
            }
        }
        return false;
    }

    // Permanently delete an entry from the recycle bin
    public static boolean permanentlyDeleteFromRecycleBin(int userId, int entryId) {
        String recycleBinFileName = USER_CSV_DIRECTORY + "user_" + userId + "_recycle_bin.csv";
        List<String[]> recycleBinEntries = readEntriesFromCSV(recycleBinFileName);

        Iterator<String[]> iterator = recycleBinEntries.iterator();
        while (iterator.hasNext()) {
            String[] entry = iterator.next();
            if (Integer.parseInt(entry[0]) == entryId) {
                iterator.remove();
                writeEntriesToCSV(recycleBinFileName, recycleBinEntries);
                return true;
            }
        }
        return false;
    }

    // Method to fetch the user ID by username or email
    public static int getUserIdByUsernameOrEmail(String usernameOrEmail) {
        String filePath = USER_CSV_DIRECTORY + USERS_CSV;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int userId = 1; // Assume user IDs are sequential starting from 1
            while ((line = reader.readLine()) != null) {
                String[] user = line.split(",");
                if (user[0].equalsIgnoreCase(usernameOrEmail) || user[1].equalsIgnoreCase(usernameOrEmail)) {
                    return userId; // Return the user ID if matched
                }
                userId++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if user not found
    }
}

