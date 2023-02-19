package cep;
import java.util.*;
public class RoutePlanningAlgorithm {
	 public static List<String> DeliveryRouteOptimization(Map<String, Map<String, Integer>> buildings, String startBuilding) {
	        // Create a set of unvisited buildings based on the given inputs
	        Set<String> unvisited = new HashSet<>(buildings.keySet());
	        unvisited.remove(startBuilding);

	        // Start at the first building
	        String currentBuilding = startBuilding;
	        List<String> path = new ArrayList<>();
	        path.add(startBuilding);

	        // While there are unvisited buildings
	        while (!unvisited.isEmpty()) {
	            // Find the nearest unvisited building
	            String nearestBuilding = null;
	            int minDistance = Integer.MAX_VALUE;
	            for (String building : unvisited) {
	                int distance = buildings.get(currentBuilding).get(building);
	                if (distance < minDistance) {
	                    minDistance = distance;
	                    nearestBuilding = building;
	                }
	            }
	            // Update the current building and mark it as visited
	            currentBuilding = nearestBuilding;
	            unvisited.remove(nearestBuilding);
	            // Add the building to the path
	            path.add(nearestBuilding);
	        }

	        // Return to the starting building
	        path.add(startBuilding);
	        return path;
	    }

	    public static void main(String[] args) {
	        // Example for testing the algorithm
	        Map<String, Map<String, Integer>> buildings = new HashMap<>();
	        buildings.put("A", Map.of("A", 0, "B", 2, "C", 1));
	        buildings.put("B", Map.of("A", 2, "B", 0, "C", 3));
	        buildings.put("C", Map.of("A", 1, "B", 3, "C", 0));
	        String startBuilding = "A";
	        List<String> shortestPath = DeliveryRouteOptimization(buildings, startBuilding);
	        System.out.println(shortestPath);  // Output: [A, C, B, A]
	    }
}
