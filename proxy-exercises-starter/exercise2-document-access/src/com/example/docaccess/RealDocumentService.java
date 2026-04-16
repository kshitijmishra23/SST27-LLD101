package com.example.docaccess;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RealDocumentService implements DocumentService {
    private final Map<String, String> store = new HashMap<>();

    public RealDocumentService() {
        store.put("doc-001", "Q1 Financial Report: Revenue $4.2M, Expenses $3.1M");
        store.put("doc-002", "Roadmap 2026: Launch new API, expand to APAC");
        store.put("doc-003", "HR Policy: Remote work guidelines updated March 2026");
    }

    @Override
    public String read(String docId) {
        Objects.requireNonNull(docId, "docId");
        String content = store.get(docId);
        if (content == null) throw new IllegalArgumentException("Document not found: " + docId);
        return content;
    }

    @Override
    public void write(String docId, String content) {
        Objects.requireNonNull(docId, "docId");
        Objects.requireNonNull(content, "content");
        store.put(docId, content);
        System.out.println("  [STORE] Saved: " + docId);
    }
}
