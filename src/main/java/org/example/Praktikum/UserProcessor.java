package org.example.Praktikum;

import java.util.List;

public class UserProcessor {
    public static void processUsers(List<User> users, UserProcessorFunction processor) {
        for (User user : users) {
            processor.process(user);
        }
    }
}