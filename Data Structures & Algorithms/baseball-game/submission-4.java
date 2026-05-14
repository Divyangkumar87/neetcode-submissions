class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int ans = 0;

        for(String opr : operations) {
            if(opr.equals("+")) {
               int firstElement = stack.pop();
               int secondElement = stack.peek();
               stack.push(firstElement);
               stack.push(firstElement + secondElement);
            } else if(opr.equals("C")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(opr.equals("D")) {
                stack.push(stack.peek() * 2);
            } else {
                stack.push(Integer.parseInt(opr));
            }
        }

        while(!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;
    }
}