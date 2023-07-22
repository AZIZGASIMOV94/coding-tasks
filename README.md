# Task: User Visit Count Aggregation

Your task is to implement a Java program that calculates the total visit count for each user from a list of user visit data. The program should define a `Main` class with the following methods:

1. `public static void main(String[] args)`: The entry point of the program. In this method:
    - Create an instance of the `Main` class.
    - Populate two example data maps (`user1Visits` and `user2Visits`) containing information about user visits. Each map should contain user IDs (as Strings) mapped to `UserStat` objects representing their visit counts.
    - Call the `getUserVisitCount` method with the two example data maps and store the result in a map called `result`.
    - Print the `result` map to the console.

2. `public Map<Long, Long> getUserVisitCount(Map<String, UserStat>... visits)`: This method takes a variable number of input maps (`visits`) as parameters, where each map represents user visit data. The keys of the maps are user IDs (represented as Strings), and the values are `UserStat` objects containing the visit counts.
    - The method should calculate the total visit count for each user across all input maps and return the results in a new map.
    - The keys of the result map should be the user IDs (converted to Long using the `isStrParsableToLong` method), and the values should be their respective total visit counts (as Long).
    - If any of the input maps are empty or null, the method should return an empty map.

3. `public boolean isStrParsableToLong(String input)`: This method takes a String input and attempts to parse it into a Long using the `Long.parseLong` method.
    - If the parsing is successful, the method should return `true`.
    - If the parsing fails (throws a `NumberFormatException`), the method should return `false`.

4. `public static boolean areMapsEmpty(Map<String, UserStat>... visits)`: This static method takes a variable number of maps (`visits`) as parameters and checks whether any of them are empty or null.
    - The method should iterate through the input maps and return `false` immediately if any map is not empty.
    - If all maps are empty or null, the method should return `true`.

Please implement the methods according to the given description and example code. Once completed, execute the program and verify that it correctly calculates and displays the total visit count for each user. Additionally, ensure the program handles potential edge cases, such as empty or null input maps and non-parsable user IDs, with appropriate checks and validations.
