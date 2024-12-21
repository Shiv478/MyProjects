import java.util.*;
import java.util.function.*;
import java.io.*;

// Client class for interaction with Classifiers
public class Client {
    public static final String TRAIN_FILE = "data/HealthRecord/train.csv";
    public static final String TEST_FILE = "data/HealthRecord/test.csv";
    public static final int LABEL_INDEX = 0;
    public static final Function<List<String>, Classifiable> CONVERTER = HealthRecord::toClassifiable;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the Health Record Classifier!");
        System.out.println();
        Classifier c = createModel(console);

        System.out.println();
        System.out.println("What would you like to do with your model?");
        int choice = -1;
        do {
            System.out.println();
            System.out.println("1) Test with an input file");
            System.out.println("2) Get testing accuracy");
            System.out.println("3) Save to a file");
            System.out.println("4) Quit");
            System.out.print("Enter your choice here: ");

            choice = console.nextInt();
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                System.out.print("Please enter a valid option from above: ");
                choice = console.nextInt();
            }

            if (choice == 1) {
                System.out.print("Please enter the file you'd like to test: ");
                evalModel(c, console.next());
            } else if (choice == 2) {
                testModel(c, TEST_FILE);
            } else if (choice == 3) {
                System.out.print("Please enter the file name you'd like to save to: ");
                c.save(new PrintStream(console.next() + ".txt"));
            }
        } while (choice != 4);
    }

    // Creates a classifier from client-provided information
    private static Classifier createModel(Scanner console) throws FileNotFoundException {
        System.out.println("1) Train classification model");
        System.out.println("2) Load model from file");
        System.out.print("Enter your choice here: ");

        int choice = console.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.print("Please enter a valid option from above: ");
            choice = console.nextInt();
        }

        if (choice == 1) {
            DataLoader loader = new DataLoader(TRAIN_FILE, LABEL_INDEX, CONVERTER);
            return new ClassificationTree(loader.getData(), loader.getLabels());
        } else {
            System.out.print("Please enter the path to the file you'd like to load: ");
            Scanner input = new Scanner(new File(console.next()));
            return new ClassificationTree(input);
        }
    }

    // Evaluates the model with a given file
    private static void evalModel(Classifier c, String fileName) throws FileNotFoundException {
        DataLoader loader = new DataLoader(fileName, LABEL_INDEX, CONVERTER);
        List<String> results = new ArrayList<>();
        for (Classifiable data : loader.getData()) {
            results.add(c.classify(data));
        }
        System.out.println("Results: " + results);
    }

    // Tests the classifier's accuracy
    private static void testModel(Classifier c, String fileName) throws FileNotFoundException {
        DataLoader loader = new DataLoader(fileName, LABEL_INDEX, CONVERTER);
        Map<String, Double> labelToAccuracy = c.calculateAccuracy(loader.getData(), loader.getLabels());
        for (String label : labelToAccuracy.keySet()) {
            System.out.println(label + ": " + labelToAccuracy.get(label));
        }
    }
}
