class MinStack {

    int min = Integer.MAX_VALUE;
    ArrayList<StackNode> internalStack;

    public MinStack() {   
        internalStack = new ArrayList<>(); 
    }
    
    public void push(int val) {
        min = Math.min(val, min);
        StackNode node = new StackNode(val, min);
        internalStack.add(node);
    }
    
    public void pop() {
        internalStack.remove(internalStack.size() - 1);
        if(!internalStack.isEmpty())
            min = internalStack.get(internalStack.size() - 1).minValue;
        else
            min = Integer.MAX_VALUE;
    }
    
    public int top() {
        return internalStack.get(internalStack.size() - 1).currentValue;
    }
    
    public int getMin() {
        return min;
    }
}
class StackNode {
    int currentValue;
    int minValue;
    public StackNode(int currentValue, int minValue) {
        this.minValue = minValue;
        this.currentValue = currentValue;
    }
}
