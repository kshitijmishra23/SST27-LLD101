package com.example.imports;

import java.io.*; 
import java.nio.file.*; 
import java.util.*;

public class NaiveCsvReader {
    public List<String[]> read(Path p) {
        try {
            List<String[]> rows = new ArrayList<>();
            for (String line : Files.readAllLines(p)) rows.add(line.split(","));
            return rows;
        } catch (IOException e) { throw new UncheckedIOException(e); }
    }
}
