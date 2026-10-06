import java.util.*;

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        List<TreeSet<Integer>> rows = new ArrayList<>();
        List<TreeSet<Integer>> cols = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int j = 0; j < n; j++) set.add(j);
            rows.add(set);
        }

        for (int j = 0; j < n; j++) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < m; i++) set.add(i);
            cols.add(set);
        }

        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        rows.get(0).remove(0);
        cols.get(0).remove(0);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];

            if (i == m - 1 && j == n - 1) return dist[i][j];

            int right = Math.min(n - 1, j + grid[i][j]);
            TreeSet<Integer> rowSet = rows.get(i);

            Integer x = rowSet.ceiling(j + 1);
            while (x != null && x <= right) {
                int next = x;
                rowSet.remove(next);
                cols.get(next).remove(i);

                dist[i][next] = dist[i][j] + 1;
                q.offer(new int[]{i, next});

                x = rowSet.ceiling(j + 1);
            }

            int down = Math.min(m - 1, i + grid[i][j]);
            TreeSet<Integer> colSet = cols.get(j);

            Integer y = colSet.ceiling(i + 1);
            while (y != null && y <= down) {
                 int next = y;
                colSet.remove(next);
                rows.get(next).remove(j);

                 dist[next][j] = dist[i][j] + 1;
                q.offer(new int[]{next, j});

                 y = colSet.ceiling(i + 1);
            }
        }

          return -1;
    }
}