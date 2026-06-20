class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0], intervals[0][1]});

        for(int i = 1; i < intervals.length; i++) {
            int[] previousArr = list.get(list.size() - 1);
            if(previousArr[1] >= intervals[i][0]) {
                previousArr[1] = Math.max(previousArr[1], intervals[i][1]);
            } else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        return list.stream().toArray(int[][]::new);

    }
}