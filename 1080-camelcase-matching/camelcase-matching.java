class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(matches(query, pattern));
        }
        return result;
    }

    private boolean matches(String query, String pattern) {
        int i = 0, j = 0;

        while (i < query.length()) {
            char qc = query.charAt(i);
            if (j < pattern.length() && qc == pattern.charAt(j)) {
                i++;
                j++;
            } else if (Character.isLowerCase(qc)) {
                i++;
            } else {
                // Uppercase letter not in pattern
                return false;
            }
        }

        // If we haven't matched the full pattern, return false
        return j == pattern.length();
    }

}