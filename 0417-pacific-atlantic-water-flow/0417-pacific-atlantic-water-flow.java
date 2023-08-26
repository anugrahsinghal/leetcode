class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;
        Set<Pair<Integer,Integer>> pacific = new HashSet<>();
        Set<Pair<Integer,Integer>> atlantic = new HashSet<>();
        // do DFS for all 4 borders
        for(int j = 0; j < n; j++) { // 
            dfs(heights, 0, j, heights[0][j], pacific);
            dfs(heights, m-1, j, heights[m-1][j], atlantic);
        }
        for(int i = 0; i < m; i++) { 
            dfs(heights, i, 0, heights[i][0], pacific);
            dfs(heights, i, n-1, heights[i][n-1], atlantic);
        }


        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++) { 
            for(int j = 0; j < n; j++) {
                var pair = new Pair<>(i,j);
                if(atlantic.contains(pair) && pacific.contains(pair)) {
                    ans.add(Arrays.asList(i,j));
                }
            } 
        }

        return ans;
    }

    // flow from atlantic to array
    void dfs(int[][] heights, int i, int j, int prevHeight, Set<Pair<Integer,Integer>> possibleAns) {
        // out of bounds
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) return;
        if(possibleAns.contains(new Pair<>(i,j))) return;
        if(heights[i][j] < prevHeight) return;

        possibleAns.add(new Pair<>(i,j)); // water can reach from ocean to here

        dfs(heights, i+1, j, heights[i][j], possibleAns);
        dfs(heights, i-1, j, heights[i][j], possibleAns);
        dfs(heights, i, j+1, heights[i][j], possibleAns);
        dfs(heights, i, j-1, heights[i][j], possibleAns);
    }

}