import java.util.*;

// This class represents a health record using multiple features for classification
public class HealthRecord implements Classifiable {
    public static final Set<String> FEATURES = Set.of("BMI", "HighBP", "HighChol");

    private Map<String, Double> features;

    // Constructs a new HealthRecord from a dataset row
    public HealthRecord(List<String> row) {
        features = new HashMap<>();
        parseRow(row);
    }

    // Parses a row from the dataset and extracts the specified features
    private void parseRow(List<String> row) {
        try {
            // Map features to their column indices in the dataset
            features.put("HighBP", Double.parseDouble(row.get(1))); // HighBP is column 1
            features.put("HighChol", Double.parseDouble(row.get(2))); // HighChol is column 2
            features.put("BMI", Double.parseDouble(row.get(4))); // BMI is column 4
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.err.println("Error parsing row: " + row);
            throw e;
        }
    }

    // Returns the set of all features in the dataset
    @Override
    public Set<String> getFeatures() {
        return FEATURES;
    }

    // Returns the numeric value for the given feature
    // Throws IllegalArgumentException if the feature is not valid
    @Override
    public double get(String feature) {
        if (!FEATURES.contains(feature)) {
            throw new IllegalArgumentException("Invalid feature: " + feature);
        }
        Double value = features.get(feature);
        if (value == null) {
            throw new NullPointerException("Feature " + feature + " is missing in the dataset.");
        }
        return value;
    }

    // Splits the dataset based on the most impactful feature difference
    @Override
    public Split partition(Classifiable other) {
        if (!(other instanceof HealthRecord)) {
            throw new IllegalArgumentException("Provided object is not an instance of HealthRecord");
        }

        HealthRecord otherRecord = (HealthRecord) other;
        String bestFeature = null;
        double maxDifference = 0.0;

        for (String feature : FEATURES) {
            double diff = Math.abs(this.get(feature) - otherRecord.get(feature));
            if (diff > maxDifference) {
                bestFeature = feature;
                maxDifference = diff;
            }
        }

        double midpoint = Split.midpoint(this.get(bestFeature), otherRecord.get(bestFeature));
        return new Split(bestFeature, midpoint);
    }

    // Creates and returns a HealthRecord from a row of data
    public static Classifiable toClassifiable(List<String> row) {
        return new HealthRecord(row);
    }
}
