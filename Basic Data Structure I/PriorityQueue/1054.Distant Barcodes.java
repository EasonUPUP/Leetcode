class Solution {
    /*
    * @para{int[]} barcodes
    * @return{int[]}
    * HashMap to make a statistic, then use the pq to make un-adjacent barcodes.
    */
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[barcodes.length];
        if (barcodes == null || barcodes.length == 0 || barcodes.length == 1)
            return barcodes;

        for (int i : barcodes)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        for (int i : map.keySet()){
            maxHeap.add(i);
        }

        int idx = 0;
        while (maxHeap.size() > 1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            res[idx++] = a;
            res[idx++] = b;
            if (map.get(a) > 1){
                map.put(a, map.get(a)-1);
                // the first element has been stored in the maxHeap, that's why stop at map.get(a) > 1
                maxHeap.add(a);
            }
            if (map.get(b) > 1){
                map.put(b, map.get(b)-1);
                maxHeap.add(b);
            }
        }

        if (maxHeap.size() > 0)
            res[idx] = maxHeap.poll();

        return res;
    }
}
