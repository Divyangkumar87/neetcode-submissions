/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
//(5,10) (15,20) (0,40)
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int N = intervals.size();

        int[] start = new int[N];
        int[] end = new int[N];

        for(int i = 0; i < start.length; i++) {
            start[i] = intervals.get(i).start;
        }
        for(int i = 0; i < end.length; i++) {
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0, e = 0, ans = 0, count = 0;
        while(s < N) {
            if(start[s] < end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
