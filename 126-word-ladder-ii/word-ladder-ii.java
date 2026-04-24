class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        
        if (!dict.contains(endWord)) return res;

        Map<String, List<String>> map = new HashMap<>();
        Set<String> curr = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        curr.add(beginWord);
        boolean found = false;

        while (!curr.isEmpty() && !found) {
            Set<String> next = new HashSet<>();
            visited.addAll(curr);

            for (String word : curr) {
                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = new String(arr);

                        if (!dict.contains(newWord) || visited.contains(newWord)) continue;

                        if (newWord.equals(endWord)) found = true;

                        next.add(newWord);
                        map.computeIfAbsent(newWord, k -> new ArrayList<>()).add(word);
                    }

                    arr[i] = old;
                }
            }

            curr = next;
        }

        if (!found) return res;

        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, map, path, res);
        return res;
    }

    private void backtrack(String word, String beginWord, Map<String, List<String>> map,
                           List<String> path, List<List<String>> res) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        if (!map.containsKey(word)) return;

        for (String parent : map.get(word)) {
            path.add(parent);
            backtrack(parent, beginWord, map, path, res);
            path.remove(path.size() - 1);
        }
    }
}