class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] mat = new char[n][n];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        helper(mat, 0, ans);

        return ans;
    }

    void helper(char[][] mat, int colId, List<List<String>> ans) {//r=0, r=1
        if(colId == mat.length) {// nXn so anything works
            ans.add(copyMatrix(mat));
            return;
        }

        for(int rowId = 0; rowId < mat.length; rowId++) {//c=0
            if(isValidPlace(mat, rowId, colId)) {//(0,0)
                mat[rowId][colId] = 'Q';
                helper(mat, colId + 1, ans);//1
                mat[rowId][colId] = '.';
            }
        }
    }

    boolean isValidPlace(char[][] mat, int rowId, int colId) {
        if(mat[rowId][colId] == 'Q') return false;

        // check in same row
        for(int j = colId-1; j >= 0; j--) {  
            if(mat[rowId][j] == 'Q') {
                return false;
            }
        }

        // upper digonal
        var i = rowId - 1;
        var j = colId - 1;
        while(i >= 0 && j >=0) {
            if(mat[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        // lower digonal
        i = rowId + 1;
        j = colId - 1;
        while(i < mat.length && j >= 0) {
            if(mat[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


    List<String> copyMatrix(char[][] mat) {
        List<String> ds = new ArrayList<>();
        for(int i = 0; i < mat.length; i++) {
            String s = "";
            for(int j = 0; j < mat[0].length; j++) {
                s += mat[i][j];
            }
            ds.add(s);
        }

        return ds;
    }

    void print(char[][] mat) {
        var ds = copyMatrix(mat);
        for(var s : ds) {
            System.out.println(s);
        }
    }
}