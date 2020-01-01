package ee.ttu.algoritmid.trampoline;

import javafx.util.Pair;

import java.util.*;

public class HW02 implements TrampolineCenter {
    //                        D  U   R  L
    private final int dx[] = {1,  0};
    private final int dy[] = {0,  1};
    private int[][] dp; // cache - dynamic programming
    private Pair<Integer, Integer>[][] track;

    private int[][] map;

    // Solve, should return the minimum number of moves to reach the southeast corner if the guy/girl is at cell (x, y)
    // (x, y) -> 1 + Min( { (x + m, y), (x - m, y) ... (x, y + m) } )
    private int solve(int x, int y) {
        if (x == map.length - 1 && y == map[x].length - 1) {
            return 0;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int minimumNumberOfMoves = Integer.MAX_VALUE - 5; // infinity
        // up (x - map[x][y], y), down (x + map[x][y], y), right (x, y + map[x][y]), left (x, y - map[x][y])
        // (x + m, y) -> (x +`m + 0, y) (x + m - 1, y) (x + m + 1, y)
        Pair<Integer, Integer> nextState = null;
        for (int k = 0; k < 2; k++) {
            for (int delta = -1; delta <= 1; delta++) {
                // k = 0, DOWN JUMP
                // k = 1, UP JUMP
                // k = 2, RIGHT JUMP
                // k = 3, LEFT JUMP

                int newX = x + dx[k] * (map[x][y] + delta); // k = 0, x + (0) * map[x][y] => x
                int newY = y + dy[k] * (map[x][y] + delta); // k = 0, y + (1) * map[x][y] => y + map[x][y]

                if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[x].length) continue;
                if (newX == x && newY == y) continue;

                int nextStateMoves = 1 + solve(newX, newY);

                if (minimumNumberOfMoves > nextStateMoves) {
                    minimumNumberOfMoves = nextStateMoves;
                    nextState = new Pair<>(newX, newY);
                }
            }
        }
        track[x][y] = nextState;
        dp[x][y] = minimumNumberOfMoves;
        return minimumNumberOfMoves;
    }

    private List<String> resolveSteps(int x, int y) {
        List<String> steps = new ArrayList<>();
        while (track[x][y] != null) {
           int nextX = track[x][y].getKey();
           int nextY = track[x][y].getValue();
            if (x < nextX) {
                steps.add("S" + (nextX - x));
            } else {
                steps.add("E" + (nextY - y));
            }
            x = nextX;
            y = nextY;
        }
        return steps;
    }

    @Override
    public List<String> findMinJumps(int[][] map) {
        if (map.length == 0) return new ArrayList<>();
        this.map = new int[map.length][map[0].length];
        this.dp = new int[map.length][map[0].length];
        this.track = new Pair[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                this.map[i][j] = map[i][j];
                this.dp[i][j] = -1;
                this.track[i][j] = null;
            }
        }
        System.out.println(solve(0, 0));
        return resolveSteps(0, 0);
    }
}
