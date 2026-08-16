class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!dfs(i, graph, visited, path, stack)) {
                    return new int[0];
                }
            }
        }

        int[] answer = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            answer[i] = stack.pop();
        }

        return answer;
    }

    private boolean dfs(int course,
                        ArrayList<Integer>[] graph,
                        boolean[] visited,
                        boolean[] path,
                        Stack<Integer> stack) {

        if (path[course]) {
            return false;
        }

        if (visited[course]) {
            return true;
        }

        visited[course] = true;
        path[course] = true;

        for (int next : graph[course]) {
            if (!dfs(next, graph, visited, path, stack)) {
                return false;
            }
        }

        path[course] = false;

        stack.push(course);

        return true;
    }
}