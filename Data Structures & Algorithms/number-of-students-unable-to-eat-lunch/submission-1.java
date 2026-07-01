class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int res = students.length;
        int[] cnt = new int[2];
        for(int i = 0; i < students.length; i++) {
            cnt[students[i]]++;
        }
        for(int i = 0; i < sandwiches.length; i++) {
            if(cnt[sandwiches[i]] > 0) {
                res--;
                cnt[sandwiches[i]]--;
            } else {
                break;
            }
        }
        return res;
    }
}