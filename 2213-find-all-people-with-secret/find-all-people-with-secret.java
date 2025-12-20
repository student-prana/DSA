import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        boolean[] knows = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> participants = new HashSet<>();

            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
                participants.add(x);
                participants.add(y);
                i++;
            }

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int p : participants) {
                if (knows[p]) {
                    q.offer(p);
                    visited.add(p);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                knows[cur] = true;
                for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.offer(nei);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (knows[p]) result.add(p);
        }
        return result;
    }
}
