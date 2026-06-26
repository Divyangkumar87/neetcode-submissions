class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < students.length; i++) {
            queue.offer(students[i]);
        }

        for(int i = 0; i < sandwiches.length; i++) {
            int length = students.length;
            while(!(queue.peek() == sandwiches[i]) && length > 0) {
                Integer studentPreference = queue.poll();
                queue.offer(studentPreference);
                length--;
            }
            if(length > 0) 
                queue.poll();
            else
                break;
        }
        return queue.size();
    }
}