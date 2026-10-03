class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        for(int c = 0; c < numCourses; c++) {
           if(!dfs(c)) {
                return false;
           }
        }
        return true;
    }
    private boolean dfs(int course) {
        if(visiting.contains(course)) return false;
        if(preMap.get(course).isEmpty()) return true;
        visiting.add(course);
        for(int preCourse : preMap.get(course)) {
            if(!dfs(preCourse)) {
                return false;
            }
        }
        visiting.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
