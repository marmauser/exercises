package jvm.exercise.house;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildingIndexTest {

    @Test
    public void testShortStreet() {
        ArrayList buildings = new ArrayList(List.of(
                Map.of("school", true, "shop", true, "gym", false, "restaurant", true),
                Map.of("school", true, "shop", false, "gym", false, "restaurant", true),
                Map.of("school", false, "shop", false, "gym", false, "restaurant", true),
                Map.of("school", true, "shop", false, "gym", false, "restaurant", false),
                Map.of("school", false, "shop", false, "gym", true, "restaurant", false)
        ));

        ArrayList<String> desiredOrganizations = new ArrayList<>(List.of("school", "gym", "shop"));

        BuildingIndex optimal = BuildingSelection.optimal(buildings, desiredOrganizations);

        System.out.printf("Optimal building is %s%n with distance %s", optimal.index, optimal.distance);
    }

    @Test
    public void testLongStreet() {
        List<String> orgs = List.of("A", "B", "C", "D", "E", "F", "G");
        ArrayList<Map<String, Boolean>> buildings = Generator.generateStreet(100000, orgs);

        BuildingIndex optimal = BuildingSelection.optimal(buildings, new ArrayList(List.of("B", "E", "F", "A")));

        System.out.printf("Optimal building is %s%n with distance %s", optimal.index, optimal.distance);
    }
}
