class LRUCache {

    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node current = map.get(key);
            remove(current); // remove from its current position
            insert(current); // Add it to tail
            return current.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);

        if(map.size() > this.capacity) {
            Node lruNode =  head.next;
            remove(lruNode);
            map.remove(lruNode.key);
        }
    }

    public void remove(Node node) {
       Node next = node.next;
       Node prev = node.prev;
       prev.next = next;
       next.prev = prev;
    }

    public void insert(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = prev;
    }
 }
class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
