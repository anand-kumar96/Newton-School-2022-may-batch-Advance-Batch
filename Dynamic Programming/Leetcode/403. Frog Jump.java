// https://leetcode.com/problems/frog-jump/
// method 01--> using HashMap
class Solution {
    public boolean canCross(int[] stones) {
        if(stones.length==0) return true;
        int n=stones.length;
        HashMap<Integer,HashSet<Integer>>hm=new HashMap<>();
        // here key mapping to stones and value mapping to step
        for(int i=0;i<n;i++){
            hm.put(stones[i],new HashSet<Integer>());
        }
        hm.get(0).add(1);//1 is step
        for(int i=0;i<n-1;i++){
            int stone=stones[i];
            // now find step for respective stone
            for(int step:hm.get(stone)){
                int reach=step+stone;
                if(reach==stones[n-1]){
                    return true;
                }
                // else do operation for adding step
                if( hm.get(reach)!=null){// means stone position available
                    hm.get(reach).add(step);// for k
                    if(step-1>0) // for k-1
                    hm.get(reach).add(step-1);
                    hm.get(reach).add(step+1); // for k+1
                }
            }
        }
        return false;
    }
}
