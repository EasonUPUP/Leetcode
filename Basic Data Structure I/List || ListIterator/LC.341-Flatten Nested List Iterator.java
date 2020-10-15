/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
  /* testcase 1
  * Input: [[1,1],2,[1,1]]
  * Output: [1,1,2,1,1]
  *
  * testcase 2
  * Input: [1,[4,[6]]]
  * Output: [1,4,6]
  */
  
  //ListIterator: https://www.geeksforgeeks.org/arraylist-listiterator-method-in-java-with-examples/

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> res = new ArrayList<>();
    private ListIterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
        it = res.listIterator();
    }
    
    private void dfs (List<NestedInteger> nestedList){
        for (NestedInteger item : nestedList){
            if (item.isInteger()){
                res.add(item.getInteger());
            }else{
                dfs(item.getList());
            }
        }
    }
    
    @Override
    public Integer next() {
        return it.next();
    }
    
    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
