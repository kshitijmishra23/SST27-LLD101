package com.example.docaccess;

public class DocumentDemo {
    public static void main(String[] args) {
        DocumentService realService = new RealDocumentService();

        User viewer = new User("Alice", Role.VIEWER);
        User editor = new User("Bob",   Role.EDITOR);

        System.out.println("=== Document Access Demo ===");
        System.out.println();

        // TODO 1: Wrap realService with an AccessControlProxy for the viewer (Alice).
        //         - Read "doc-001" and print its content. (should succeed)
        //         - Attempt to write "doc-004" with content "Draft notes".
        //           Catch the SecurityException and print: "Blocked: " + e.getMessage()

        System.out.println("--- Viewer: " + viewer + " ---");
        // Your code here

        System.out.println();

        // TODO 2: Wrap realService with an AccessControlProxy for the editor (Bob).
        //         - Write a new document "doc-004" with content "Final notes".
        //         - Read "doc-004" back and print its content.

        System.out.println("--- Editor: " + editor + " ---");
        // Your code here
    }
}
