package com.example.imports;

import java.nio.file.Path;
import java.util.List;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = csvReader;
        this.profileService = profileService;
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = csvReader.read(csvFile);
        int imported = 0;
        for (String[] row : rows) {
            if (row.length < 3) {
                System.err.println("Skipping invalid row: " + String.join(",", row));
                continue;
            }
            try {
                profileService.createProfile(row[0].trim(), row[1].trim(), row[2].trim());
                imported++;
            } catch (Exception e) {
                System.err.println("Failed to import row: " + String.join(",", row) 
                                   + " because " + e.getMessage());
            }
        }
        return imported;
    }
}
