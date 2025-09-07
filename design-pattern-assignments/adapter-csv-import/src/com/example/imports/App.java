package com.example.imports;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) throw new IllegalArgumentException("path required");
        Path csv = Path.of(args[0]);
        // TODO: Implement and use CsvProfileImporter here
        // ProfileImporter importer = new CsvProfileImporter(new NaiveCsvReader(), new ProfileService());
        // int n = importer.importFrom(csv);
        // System.out.println("Imported " + n + " profiles");
        System.out.println("Import OK (wire the adapter to complete).");
    }
}
