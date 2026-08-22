class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int L = 0;
        int R = people.length - 1;
        int boats = 0;
        /*[1,3,2,3,2]
        [1,2,2,3,3]*/
        while(L <= R) {
           int remain = limit - people[R];
           boats++;
           R--;
           if(L <= R && remain >= people[L]) {
                L++;
           }
        }
        return boats;
    }
}