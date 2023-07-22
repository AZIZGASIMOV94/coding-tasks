import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        // Example data
        Map<String, UserStat> user1Visits = new HashMap<>();
        user1Visits.put("user1", new UserStat(5));
        user1Visits.put("user2", new UserStat(10));

        Map<String, UserStat> user2Visits = new HashMap<>();
        user2Visits.put("user1", new UserStat(8));
        user2Visits.put("user3", new UserStat(15));

        Map<Long, Long> result = main.getUserVisitCount(user1Visits, user2Visits);
        System.out.println(result);
    }

    public Map<Long, Long> getUserVisitCount(Map<String, UserStat>... visits) {
        if (areMapsEmpty(visits)) {
            return new HashMap<>();
        }

/*
        Map<Long, Long> userVisitCountMap = new HashMap<>();

        for (Map<String, UserStat> visit : visits) {
            if (visit != null && !visit.isEmpty()) {
                for (Map.Entry<String, UserStat> entry : visit.entrySet()) {
                    String userId = entry.getKey();
                    UserStat userStat = entry.getValue();

                    if (userStat != null) {
                        long parsedUserId = isStrParsableToLong(userId) ? Long.parseLong(userId) : 0;
                        long visitCount = userStat.getVisitCount() != null ? userStat.getVisitCount() : 0;

                        userVisitCountMap.put(parsedUserId, userVisitCountMap.getOrDefault(parsedUserId, 0L) + visitCount);
                    }
                }
            }
        }



        return userVisitCountMap;*/

        return Stream.of(visits)
                .filter(visit -> visit != null && !visit.isEmpty())
                .flatMap(visit -> visit.entrySet().stream())
                .filter(entry -> entry.getValue() != null)
                .collect(
                        HashMap::new,
                        (map, entry) -> {
                            String userId = entry.getKey();
                            UserStat userStat = entry.getValue();
                            long parsedUserId = isStrParsableToLong(userId) ? Long.parseLong(userId) : 0;
                            long visitCount = userStat.getVisitCount() != null ? userStat.getVisitCount() : 0;
                            map.put(parsedUserId, map.getOrDefault(parsedUserId, 0L) + visitCount);
                        },
                        HashMap::putAll
                );
    }

    public boolean isStrParsableToLong(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean areMapsEmpty(Map<String, UserStat>... visits) {
        for (Map<String, UserStat> visit : visits) {
            if (visit != null && !visit.isEmpty()) {
                return false; // If any map is not empty, return false immediately
            }
        }
        return true; // If all maps are empty or null, return true
    }
}