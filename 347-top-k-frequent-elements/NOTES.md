```
map.forEach((key,v) -> {
MIN_HEAP.offer(new Pair<>(key, v));
if(MIN_HEAP.size() > k) {
MIN_HEAP.poll();
}
}
);
```
worth noting
​
it keeps complexity down to O(N log k) which is less than O (N log N)
​
as in heap we only keep at max K elements
---
### Bucket Sort
after creating the freq map
<1 occurs 3 times>...etc
we can reverse and create another map
<count 3 is for elements[1,2,4]>
then we can navigate from max count to min count
​
​
​
​
​
​
​