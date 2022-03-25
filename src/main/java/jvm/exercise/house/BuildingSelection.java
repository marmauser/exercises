package jvm.exercise.house;

import java.util.*;

public class BuildingSelection {

    /**
     * Searches for most optimal building in [buildings].
     * Optimal is the closest to desired organizations [desired].
     * Returns building index and sum of distances to desired organizations
     * Given N = buildings.size; K = desired.size
     */
    public static BuildingIndex optimal(ArrayList<Map<String, Boolean>> buildings, ArrayList<String> desired) {
        BuildingIndex optimalBuilding;
        BuildingIndex currentBuilding;

        //Create map of organizations in building, but using Queues instead of array
        // K iterations
        Map<String, Queue<Integer>> map = new HashMap<>();
        for (String org : desired) {
            map.put(org, new LinkedList<>());
        }
        // N * K iterations
        for(int b = 0; b < buildings.size(); b++) {
            for(String org : desired) {
                if(buildings.get(b).get(org)) {
                    map.get(org).add(b);
                }
            }
        }

        //Make calculation for the first building
        // K Iterations
        currentBuilding = new BuildingIndex(0, 0);
        for(String org: desired) {
            int orgIndex = peekOrgIndex(map, org);
            currentBuilding.distance += orgIndex;
            currentBuilding.nearestOrganizations.put(org, orgIndex);
        }
        optimalBuilding = currentBuilding.copy();

        //Walk down the street and calculate sum of distances to desired organizations
        // N * K Iterations
        for(int b = 1; b < buildings.size(); b++) {
            int distanceSum = 0;
            for(String org : desired) {
                //first check what is nearest organization
                if(peekOrgIndex(map, org) - b <= b - currentBuilding.nearestOrganizations.get(org)) {
                    //next org is closer
                    currentBuilding.nearestOrganizations.put(org, map.get(org).poll());
                }
                distanceSum += Math.abs(currentBuilding.nearestOrganizations.get(org) - b);
            }
            currentBuilding.distance = distanceSum;
            currentBuilding.index++;    // or currentBuilding.index = b;
            if(currentBuilding.distance == 0) { // that's enough
                return currentBuilding;
            }
            if(optimalBuilding.distance > currentBuilding.distance) {
                optimalBuilding.copy(currentBuilding);
            }
        }

        // 2 * K + 2 * N * K Iterations => O(NK)
        return optimalBuilding;
    }

    /**
     * Peeking org Index from map.
     * If queue is empty, return Integer.MAX_VALUE - meaning no more organization down the street
     */
    public static Integer peekOrgIndex(Map<String, Queue<Integer>> map, String org) {
        return Objects.requireNonNullElse(map.get(org).peek(), Integer.MAX_VALUE);
    }
}
