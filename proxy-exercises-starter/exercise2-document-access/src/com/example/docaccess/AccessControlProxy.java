package com.example.docaccess;

import java.util.Objects;

public class AccessControlProxy implements DocumentService {
    private final DocumentService delegate;
    private final User currentUser;

    public AccessControlProxy(DocumentService delegate, User currentUser) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
        this.currentUser = Objects.requireNonNull(currentUser, "currentUser");
    }

    @Override
    public String read(String docId) {
        // TODO: Both VIEWER and EDITOR roles may read.
        //       Print "[ACCESS] <userName> read <docId>" before delegating.
        //       Return the result from delegate.read(docId).
        throw new UnsupportedOperationException("Implement read access control");
    }

    @Override
    public void write(String docId, String content) {
        // TODO: Only EDITOR role may write.
        //       If the current user is a VIEWER, throw:
        //           new SecurityException(currentUser.getName() + " does not have write permission")
        //       Otherwise print "[ACCESS] <userName> wrote <docId>" and delegate.
        throw new UnsupportedOperationException("Implement write access control");
    }
}
