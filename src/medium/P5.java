package medium;

public class P5 {

public static void main(String[] args) {
    longestPalindrome("cbbd");
}

    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] tab = new int[n][n];
        Step[][] trace = new Step[n][n];
        findLongestReconstruct(s, tab, trace, n);
        display(trace, n);
        Pair p = findMax(trace, n);
        return s.substring(p.lo, p.hi + 1);
    }    
    
    
    private static Pair findMax(Step[][] trace, int n) {
        int row = 0, col = n - 1;
        while (row >= 0 && col >= 0 && row <= col) {
            if (trace[row][col] == Step.LEFT) col--;
            else if (trace[row][col] == Step.DOWN) row++;
            else return new Pair(row, col);
        }
        return null;  // should never reach this point
    }
    
    
    // these only find the length
    static int findLongest(String s, int lo, int hi) {
        if (lo == hi) return 1; // odd length
        if (lo > hi) return 0; // even length
        
        if (s.charAt(lo) == s.charAt(hi)) return 2 + findLongest(s, lo + 1, hi - 1);
        else {
            return Math.max(
                findLongest(s, lo + 1, hi),
                findLongest(s, lo, hi - 1)
            );
        }
    }
    
    static int findLongestTab(String s) {
        int n = s.length();
        int[][] tab = new int[n][n];
        /* rows represent lo values and column 
           represent hi values */
        for (int row = 0; row < n; row++) {
            int col = row;
            tab[row][col] = 1; // base case: diag values = 1
            for (col = row - 1; col >= 0; col--) {
                tab[row][col] = 0; // base case lo > hi = 0
            }
        }
        for (int lo = 0; lo < n; lo++) {
            for (int hi = lo + 1; hi < n; hi++) {
                if (s.charAt(lo) == s.charAt(hi)) {
                    tab[lo][hi] = 2 + tab[lo + 1][hi - 1];
                }
                else {
                    tab[lo][hi] = Math.max(
                        tab[lo + 1][hi],
                        tab[lo][hi - 1]
                    );
                }
            }
        }
        
        return tab[n - 1][n - 1];
    }
    
    private static void findLongestReconstruct(String s, int[][] tab, Step[][] trace, int n) {
        /* rows represent lo values and column 
           represent hi values */
        for (int row = 0; row < n; row++) {
            int col = row;
            tab[row][col] = 1; // base case: diag values = 1
        }
        for (int lo = 0; lo < n; lo++) {
            for (int hi = lo + 1; hi < n; hi++) {
                if (s.charAt(lo) == s.charAt(hi)) {
                    tab[lo][hi] = 2 + tab[lo + 1][hi - 1];
                    trace[lo][hi] = Step.DIAG;
                }
                else {
                    int down = tab[lo + 1][hi];
                    int left = tab[lo][hi - 1];
                    if (down >= left) {
                        tab[lo][hi] = down;
                        trace[lo][hi] = Step.DOWN;
                    }
                    else {
                        tab[lo][hi] = left;
                        trace[lo][hi] = Step.LEFT;
                    }
                }
            }
        }
    }

    private static void display(Step[][] steps, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(steps[i][j] + " ");
            }
            System.err.println();
        }
    }
    

}


class Pair {
    final int lo;
    final int hi;
    Pair(int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
    }
}

enum Step {
    DOWN("DOWN"), LEFT("LEFT"), DIAG("DIAG");
    
    final String step;
    Step(String step) {
        this.step = step;
    }
    
    @Override 
    public String toString() { return step; }
}

