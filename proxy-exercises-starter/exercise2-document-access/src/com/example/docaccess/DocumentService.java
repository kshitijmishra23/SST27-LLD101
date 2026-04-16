package com.example.docaccess;

public interface DocumentService {
    String read(String docId);
    void write(String docId, String content);
}
