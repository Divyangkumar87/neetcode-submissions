class Graph {
    private HashMap<Integer, HashSet<Integer>> adjList;
    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if(!adjList.containsKey(src)) {
            adjList.put(src, new HashSet<>());
        }
        if(!adjList.containsKey(dst)) {
            adjList.put(dst, new HashSet<>());
        }
        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if(!adjList.containsKey(src) || !adjList.get(src).contains(dst)) {
            return false;
        }
        return adjList.get(src).remove(dst);
    }

    public boolean hasPath(int src, int dst) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(src);
        visited.add(src);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int v = queue.poll();
                if(v == dst) {
                    return true;
                }
                for(Integer neighbour : adjList.get(v)) {
                    if(!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }
        return false;
    }
}
