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