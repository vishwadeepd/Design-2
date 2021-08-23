// Time Complexity : O(bucket/bucketItem) -> bucket: # of possible keys, bucketItem: # of  buckets defined for the possible keys
// Space Complexity : O(bucket +bucketItem) -> 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Used Jaspinder's approach to have a boolean represenation in the nested bucket, instead of storing the whole integer value everytime. 

class MyHashSet {
    boolean [][] container;
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        container =new boolean[buckets][];
    }
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketItem(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket= bucket(key);
        int bucketItem=bucketItem(key);
        if (container[bucket]==null){
            /// Handling the corner case of bucket value when 1000
            if (bucket==0){
                
                container[bucket]=new boolean[bucketItems+1];
            }else{
                container[bucket]= new boolean[bucketItems];
                    
            }
        }
        container[bucket][bucketItem]=true;
        
    }
    
    public void remove(int key) {
        //Check the position of the primary index and secondary index
        int bucket= bucket(key);
        int bucketItem=bucketItem(key);
        if (container[bucket]==null) return;
        container[bucket][bucketItem]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        //Check the position of the primary index and secondary index
        int bucket= bucket(key);
        int bucketItem=bucketItem(key);
        if (container[bucket]==null) return false;
        return container[bucket][bucketItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
