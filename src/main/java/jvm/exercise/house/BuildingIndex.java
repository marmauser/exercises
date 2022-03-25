package jvm.exercise.house;

import java.util.HashMap;
import java.util.Map;

class BuildingIndex {
    Integer index;
    Integer distance;
    Map<String,Integer> nearestOrganizations;

    public BuildingIndex(int index, int distance) {
        this.index = index;
        this.distance = distance;
        this.nearestOrganizations = new HashMap<>();
    }

    public BuildingIndex(int index, int distance, Map<String,Integer> nearestOrganizations) {
        this.index = index;
        this.distance = distance;
        this.nearestOrganizations = nearestOrganizations;
    }

    public BuildingIndex copy() {
        return new BuildingIndex(this.index, this.distance, this.nearestOrganizations);
    }

    public void copy(BuildingIndex from) {
        this.index = from.index;
        this.distance = from.distance;
        this.nearestOrganizations = from.nearestOrganizations;
    }
}