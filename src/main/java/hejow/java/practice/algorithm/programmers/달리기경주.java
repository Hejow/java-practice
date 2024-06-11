package hejow.java.practice.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class 달리기경주 {
    static Map<String, Integer> playerMap = new HashMap<>();

    public String[] solution(String[] players, String[] callings) {
        initMap(players);
        runRace(players, callings);
        return players;
    }

    private void runRace(String[] players, String[] callings) {
        for (String calling : callings) {
            int index = getIndex(calling);
            renewMap(players, index);
            swap(players, index);
        }
    }

    private void renewMap(String[] players, int index) {
        playerMap.put(players[index - 1], index);
        playerMap.put(players[index], index - 1);
    }

    private void swap(String[] players, int index) {
        String tmp = players[index];
        players[index] = players[index - 1];
        players[index - 1] = tmp;
    }

    private int getIndex(String key) {
        return playerMap.get(key);
    }

    private static void initMap(String[] players) {
        IntStream.range(0, players.length)
                .forEach(i -> playerMap.put(players[i], i));
    }
}
