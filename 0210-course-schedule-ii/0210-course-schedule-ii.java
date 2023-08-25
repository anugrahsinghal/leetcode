class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<>();
        if(!canFinish(numCourses, prerequisites, ans)) return new int[]{};
        var nums = new int[numCourses];
        int k=0;
        for(int i:ans) {
            nums[k++] = i;
        }

        return nums;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites, List<Integer> ans) {
        if(numCourses == 1) return true;
        int n = numCourses;
        
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < n; i++) { 
            g.put(i, new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            g.get(edge[0]).add(edge[1]);
        }

        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++) { 
            if(dfs(g, visited, i, ans) == false) return false;
        }

        return true;
    }

    boolean dfs(Map<Integer, List<Integer>> g, Set<Integer> visited, int course, List<Integer> ans) {
        if(visited.contains(course)) return false; // already visited node - loop found
        if(g.get(course).isEmpty()) {
            if(!ans.contains(course))
                ans.add(course);// duplicate
            return true; // no pre-requisites
        }

        visited.add(course);
        // if we add empty course here
        // then it become a loop
        // for eg. if 2 course depend one course
        // so visited is not exactly to keep track of visited
        // but to find if we get in a loop
        // my commentary - thus it can be visitCount also -- maybe

        for(int preRequisite : g.get(course)) {
            if(dfs(g, visited, preRequisite, ans) == false) return false;
        }
        ans.add(course);
        visited.remove(course);
        g.get(course).clear();

        return true;
    }

}