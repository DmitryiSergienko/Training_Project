package org.example.Praktikum;

import java.util.HashMap;
import java.util.Map;

public class HobbitsPriorityStatus {

    private final Map<String, Integer> hobbitsMiles = new HashMap<>();

    public HobbitsPriorityStatus() {
        hobbitsMiles.put("Фродо", 505);
        hobbitsMiles.put("Сэм", 499);
        hobbitsMiles.put("Мэри", 350);
        hobbitsMiles.put("Пиппин", 350);
    }

    public void addNewHobbit(String hobbitName) {
        hobbitsMiles.put(hobbitName, 0);
    }

    public void addMilesToHobbit(String hobbitName, int miles) {
        if (hobbitsMiles.containsKey(hobbitName)) {
            hobbitsMiles.put(hobbitName, miles);
        }
    }

    public String getStatus(String hobbitName) {
        if (!hobbitsMiles.containsKey(hobbitName)) {
            return "";
        } else if (hobbitsMiles.get(hobbitName) < 300) {
            return "Classic";
        } else if (300 <= hobbitsMiles.get(hobbitName) && hobbitsMiles.get(hobbitName) < 400) {
            return "Silver";
        } else if (400 <= hobbitsMiles.get(hobbitName) && hobbitsMiles.get(hobbitName) < 500) {
            return "Gold";
        } else if (hobbitsMiles.get(hobbitName) >= 500) {
            return "Platinum";
        } else {
            return "";
        }
    }
}