class Dp {
    public static void main(String[] args) {
        int tc1 = Dp(new int[][] { { 5, 1 }, { 4, 5 } });
	int tc2 = Dp(new int[][] { { 5, 7 }, { 3, 4 }, { 9, 8 } });
	int tc3 = Dp(new int[][] { { 5, 7, 6, 8 }, { 3, 4, 2, 1 }, { 9, 8, 4, 6 } });
	System.out.println(tc1 + " " + tc2 + " " + tc3);
    }
    public int Dp(int[][] matrix){
        if(matrix==null || matrix.length==0)
            return 0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0; j<m; j++)
            {
                if(i==0 && j==0)
                {
                    continue;
                }
                if(i==0 && j ==1 || i==1 && j==0)
                {
                    ans[i][j]=matrix[i][j];
                    continue;
                }
              if(i==0 && j>1)
              {
                  ans[i][j]=Math.min(ans[i][j-1],matrix[i][j]);
              }
              else if(j==0 && i>1)
              {
                  ans[i][j]=Math.min(ans[i-1][j],matrix[i][j]);
              }
              else if(i==n-1 && j=m-1)
              {
                  ans[i][j]=Math.min(ans[i-1][j],ans[i][j-1]);
              }
              else
              {
                  ans[i][j]=Math.max(Math.min(ans[i-1][j],matrix[i][j]),Math.min(ans[i][j-1],matrix[i][j]));
              }

            }
        }
          return ans[n-1][m-1];
    }
}