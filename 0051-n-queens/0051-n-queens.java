class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] mat = new char[n][n];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        helper2(mat, 0, ans);

        return ans;
    }

    void helper(char[][] mat, int rowId, List<List<String>> ans) {//r=0, r=1
        if(rowId == mat.length) {
            // System.out.println("--------------");
            // print(mat);
            // System.out.println("--------------\n\n");
            if(mat[1][0] == 'Q') {
                System.out.println("adding --------------");
                print(mat);
                System.out.println("--------------\n\n");
            }
            ans.add(copyMatrix(mat));
            return;
        }

        for(int colId = 0; colId < mat[0].length; colId++) {//c=0
            if(isValidPlace(mat, rowId, colId)) {//(0,0)
                mat[rowId][colId] = 'Q';
                if(mat[1][0] == 'Q') {
                    System.out.println("good--------------");
                    print(mat);
                    System.out.println("--------------\n\n");
                }
                helper(mat, rowId + 1, ans);//1
                mat[rowId][colId] = '.';
            }
        }
    }

    void helper2(char[][] mat, int colId, List<List<String>> ans) {//r=0, r=1
        // print(mat);
        // System.out.println();
        if(colId == mat.length) {// nXn so anything works
            // System.out.println("--------------");
            // print(mat);
            // System.out.println("--------------\n\n");
            // if(mat[1][0] == 'Q') {
            //     System.out.println("adding --------------");
            //     print(mat);
            //     System.out.println("--------------\n\n");
            // }
            ans.add(copyMatrix(mat));
            return;
        }

        for(int rowId = 0; rowId < mat.length; rowId++) {//c=0
            if(isValidPlace(mat, rowId, colId)) {//(0,0)
                mat[rowId][colId] = 'Q';
                // if(mat[1][0] == 'Q') {
                //     System.out.println("--------------");
                //     print(mat);
                //     System.out.println("--------------\n\n");
                // }
                helper2(mat, colId + 1, ans);//1
                mat[rowId][colId] = '.';
            }
        }
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

    boolean isValidPlace(char[][] mat, int rowId, int colId) {
        // if(mat[1][0] == 'Q') {
            // System.out.println("checking for row = " + rowId + " col = " + colId);
        //     mat[rowId][colId] = 'Q';
        //     print(mat);
        //     mat[rowId][colId] = '.';
        // }
        // 4x4
        // if(rowId == 0) return true; // first place so do not need to check probably

        if(mat[rowId][colId] == 'Q') return false;

        // check in same row
        for(int j = colId-1; j >= 0; j--) {  
            if(mat[rowId][j] == 'Q') {
                return false;
            }
        }

        // check in same col
        // for(int i = rowId-1; i >= 0; i--) {  
        //     if(mat[i][colId] == 'Q') {
        //         return false;
        //     }
        // }

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
        
        // for(int i = rowId-1; i >= 0; i--) { 
        //     for(int j = colId-1; j >= 0; j--) {  
        //         if(i > j && mat[i][j] == 'Q') {
        //             return false;
        //         }
        //     }
        // }

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
        

        // lower digonal
        // for(int i = rowId+1; i < mat.length; i++) { 
        //     for(int j = colId-1; j >= 0; j--) {  
        //         if(i+j == mat.length && mat[i][j] == 'Q') {
        //             return false;
        //         }
        //     }
        // }

        return true;
    }
}