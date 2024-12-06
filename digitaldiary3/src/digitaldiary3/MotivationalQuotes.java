package digitaldiary3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MotivationalQuotes {

    private static final String MOODS_DIRECTORY = "moods/";

    static {
        createMoodsDirectory();
    }

    // Ensure the moods directory exists
    private static void createMoodsDirectory() {
        File moodsDir = new File(MOODS_DIRECTORY);
        if (!moodsDir.exists()) {
            if (moodsDir.mkdirs()) {
                System.out.println("Moods directory created at: " + moodsDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create moods directory.");
            }
        } else {
            System.out.println("Moods directory already exists at: " + moodsDir.getAbsolutePath());
        }
    }

    // Method to fetch quotes for a given mood
    public static List<String> getQuotesForMood(String mood) {
        List<String> quotes = new ArrayList<>();
        File file = new File(MOODS_DIRECTORY + mood.toLowerCase() + ".txt");
        System.out.println("Reading quotes from: " + file.getAbsolutePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                quotes.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading quotes file: " + file.getAbsolutePath());
            e.printStackTrace();
        }
        return quotes;
    }

    // Create text files for each mood with the quotes
    public static void initializeMoodFiles() {
        createMoodFile("Happy", "Be happy for this moment. This moment is your life. ― Omar Khayyam\n" +
                "Happiness shared is happiness doubled. ― Swedish Proverb\n" +
                "If you want to be happy, be. ― Leo Tolstoy");

        createMoodFile("Sad", "Turn your wounds into wisdom. ― Oprah Winfrey\n" +
                "New beginnings are often disguised as painful endings. – Lao Tzu\n" +
                "Of all sad words of tongue or pen, the saddest are these — It might have been. – John Greenleaf Whittier");

        createMoodFile("Excited", "Enthusiasm is excitement with inspiration, motivation, and a pinch of creativity. – Bo Bennett\n" +
                "Celebrate the excitement of trying to build something new and wonderful. – Abhijit Banerjee\n" +
                "Success breeds the excitement to continue going. – Annie Lennox");

        createMoodFile("Angry", "For every minute you remain angry, you give up sixty seconds of peace of mind. – Ralph Waldo Emerson\n" +
                "When you hold on to anger and unforgiveness, you can't move forward. – Mary J. Blige\n" +
                "Anger is a wind which blows out the lamp of the mind. – Robert Green Ingersoll");

        createMoodFile("Neutral", "Health is the greatest gift, contentment the greatest wealth, faithfulness the best relationship. – Buddha\n" +
                "Health is the greatest possession. Contentment is the greatest treasure. Confidence is the greatest friend. Non-being is the greatest joy. – Lao Tzu\n" +
                "Contentment is the only real wealth. – Alfred Nobel");

        createMoodFile("Stressed Out", "Stress should be a powerful driving force, not an obstacle. ― Bill Phillips\n" +
                "The greatest weapon against stress is our ability to choose one thought over another. ― William James\n" +
                "Much of the stress that people feel doesn’t come from having too much to do. It comes from not finishing what they’ve started. ― David Allen");

        createMoodFile("Scared", "Courage is being scared to death... and saddling up anyway. – John Wayne\n" +
                "Feel the fear, and do it anyway. That's the mentality. Even if you're scared, just do it. – Bree Runway\n" +
                "Life is too short to be scared and not take risks. I'd rather be the person that's like, 'I messed up,' than, 'I wish I did that.' – Justine Skye");

        createMoodFile("Bored", "You need to let the little things that would ordinarily bore you suddenly thrill you. – Andy Warhol\n" +
                "Is life not a thousand times too short for us to bore ourselves? – Friedrich Nietzsche\n" +
                "There are no uninteresting things, only uninterested people. – G.K. Chesterton");

        createMoodFile("Confident", "Your success will be determined by your own confidence and fortitude. — Michelle Obama\n" +
                "Inhale confidence, exhale doubt. — Alex Toussaint\n" +
                "Self-confidence is contagious. — Stephen Richards");
    }

    // Helper method to create mood files
    private static void createMoodFile(String mood, String quotes) {
        File file = new File(MOODS_DIRECTORY + mood.toLowerCase() + ".txt");
        if (file.exists()) {
            System.out.println("File for mood already exists: " + file.getAbsolutePath());
            return;
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(quotes);
            System.out.println("Created file for mood: " + mood + " at " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error creating file for mood: " + mood);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initializeMoodFiles(); // Initialize all mood files
    }
}

