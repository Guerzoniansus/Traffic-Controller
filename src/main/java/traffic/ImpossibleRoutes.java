package traffic;

import java.util.*;

public class ImpossibleRoutes {

    private final Map<Integer, List<Integer>> IMPOSSIBLE_ROUTES;

    public ImpossibleRoutes() {
        IMPOSSIBLE_ROUTES = new HashMap<>();

        IMPOSSIBLE_ROUTES.put(1, new ArrayList<>(Arrays.asList(5, 9, 12, 24, 31, 38)));
        IMPOSSIBLE_ROUTES.put(2, new ArrayList<>(Arrays.asList(5, 9, 10, 11, 12, 21, 23, 31, 36)));
        IMPOSSIBLE_ROUTES.put(3, new ArrayList<>(Arrays.asList(5, 7, 8, 11, 12, 15, 21, 22, 31, 34)));
        IMPOSSIBLE_ROUTES.put(4, new ArrayList<>(Arrays.asList(8, 12, 15, 21, 22, 32, 33)));
        IMPOSSIBLE_ROUTES.put(5, new ArrayList<>(Arrays.asList(1, 2, 3, 8, 9, 11, 12, 15, 22, 23, 24, 33, 36, 38)));
        IMPOSSIBLE_ROUTES.put(7, new ArrayList<>(Arrays.asList(3, 11, 15, 22, 23, 34, 35)));
        IMPOSSIBLE_ROUTES.put(8, new ArrayList<>(Arrays.asList(3, 4, 5, 11, 12, 21, 23, 32, 35)));
        IMPOSSIBLE_ROUTES.put(9, new ArrayList<>(Arrays.asList(1, 2, 5, 11, 12, 23, 24, 35)));
        IMPOSSIBLE_ROUTES.put(10, new ArrayList<>(Arrays.asList(2, 23, 24, 36, 37)));
        IMPOSSIBLE_ROUTES.put(11, new ArrayList<>(Arrays.asList(2, 3, 5, 7, 8, 9, 15, 22, 24, 34, 37)));
        IMPOSSIBLE_ROUTES.put(12, new ArrayList<>(Arrays.asList(2, 3, 4, 5, 8, 9, 21, 24, 31, 37)));
        IMPOSSIBLE_ROUTES.put(15, new ArrayList<>(Arrays.asList(3, 4, 5, 7, 11)));
        IMPOSSIBLE_ROUTES.put(21, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 12)));
        IMPOSSIBLE_ROUTES.put(22, new ArrayList<>(Arrays.asList(3, 4, 5, 7, 11)));
        IMPOSSIBLE_ROUTES.put(23, new ArrayList<>(Arrays.asList(2, 5, 7, 8, 9, 10)));
        IMPOSSIBLE_ROUTES.put(24, new ArrayList<>(Arrays.asList(1, 5, 9, 10, 11, 12)));
        IMPOSSIBLE_ROUTES.put(31, new ArrayList<>(Arrays.asList(1, 2, 3)));
        IMPOSSIBLE_ROUTES.put(32, new ArrayList<>(Arrays.asList(4, 8, 12)));
        IMPOSSIBLE_ROUTES.put(33, new ArrayList<>(Arrays.asList(4, 5)));
        IMPOSSIBLE_ROUTES.put(34, new ArrayList<>(Arrays.asList(3, 7, 11)));
        IMPOSSIBLE_ROUTES.put(35, new ArrayList<>(Arrays.asList(7, 8, 9)));
        IMPOSSIBLE_ROUTES.put(36, new ArrayList<>(Arrays.asList(2, 5, 10)));
        IMPOSSIBLE_ROUTES.put(37, new ArrayList<>(Arrays.asList(10, 11, 12)));
        IMPOSSIBLE_ROUTES.put(38, new ArrayList<>(Arrays.asList(1, 5, 9)));
        IMPOSSIBLE_ROUTES.put(41, new ArrayList<>(Arrays.asList(42)));
        IMPOSSIBLE_ROUTES.put(42, new ArrayList<>(Arrays.asList(41)));
    }

    public List<Integer> getImpossibleRoutes(int routeToCheckFor) {
        return IMPOSSIBLE_ROUTES.get(routeToCheckFor);
    }

}
