class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        build(ans, new StringBuilder(), n, 0, 0);
        return ans;
    }

    private void build(List<String> ans, StringBuilder current,
                       int limit, int left, int right) {

        if (current.length() == 2 * limit) {
            ans.add(current.toString());
            return;
        }

        if (left < limit) {
            current.append('(');
            build(ans, current, limit, left + 1, right);
            current.deleteCharAt(current.length() - 1);
        }

        if (right < left) {
            current.append(')');
            build(ans, current, limit, left, right + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}