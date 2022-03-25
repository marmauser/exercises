package jvm.exercise.house;

import java.util.*;

public class Generator {
    private static Random rnd = new Random();

    public static ArrayList<Map<String, Boolean>> generateStreet(Integer size, List<String> orgs) {
        List<Map<String, Boolean>> street = new LinkedList<>();
        int counter = 0;
        while (counter < size) {
            Map<String, Boolean> building = new HashMap<>();
            for(String org : orgs) {
                building.put(org, randomBoolean(98));
            }
            street.add(building);
            counter++;
        }

        return new ArrayList<>(street);
    }

    public static Boolean randomBoolean(int edge) {
        return rnd.nextInt(100) > edge;
    }
}
