class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordlen = words[0].length();
        int wordslen = words.length;
        HashMap<String, Integer> wordscount = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (String str : words) {
            wordscount.put(str, wordscount.getOrDefault(str, 0) + 1);
        }
        for (int offset = 0; offset < wordlen; offset++) {
            HashMap<String, Integer> window = new HashMap<>();
            int count = 0;
            int left = offset;
            for (int i = offset; i + wordlen <= s.length(); i += wordlen) {
                String str = s.substring(i, i + wordlen);
                if (!wordscount.containsKey(str)) {
                    window.clear();
                    count = 0;
                    left = i+wordlen;
                    continue;
                }
                window.put(str, window.getOrDefault(str, 0) + 1);
                count++;

                while (window.get(str) > wordscount.get(str)) {
                    String temp = s.substring(left, left + wordlen);
                    window.put(temp, window.get(temp) - 1);
                    count--;
                    left = left + wordlen;
                }
                if (count == words.length) {
                    ans.add(left);
                    String key = s.substring(left, left + wordlen);
                    window.put(key, window.get(key) - 1);
                    count--;
                    left = left + wordlen;
                }
            }
        }
        return ans;

    }
}