class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) 
    {
        //create the grid
        int[][] arr= new int[m][n];
        for(int g[]:guards)
        {
            arr[g[0]][g[1]]='G';
        }
        for(int w[]:walls)
        {
            arr[w[0]][w[1]]='W';
        }  
        int count=0;
        //traverse whole grid
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(arr[i][j]=='G')
                {
                    count=count+f(arr,i,j,m,n);
                    System.out.println("count for i= "+i+" and j= "+j+"= "+count);
                }
            }
        }  
        return m*n-count-guards.length-walls.length;
    }
    public int f(int[][] arr,int i,int j,int m,int n)
    {
        int res=0;
        //check right
        for(int col=j+1;col<n;++col)
        {
            if(arr[i][col]=='G' || arr[i][col]=='W')
            {
                break;
            }
            else if(arr[i][col]==0)
            {
                ++res;
                arr[i][col]=1;
            }
        }
        //check left
        for(int col=j-1;col>=0;--col)
        {
            if(arr[i][col]=='G' || arr[i][col]=='W')
            {
                break;
            }
            else if(arr[i][col]==0)
            {
                ++res;
                arr[i][col]=1;
            }
        }
        //check top
        for(int row=i-1;row>=0;--row)
        {
            if(arr[row][j]=='G' || arr[row][j]=='W')
            {
                break;
            }
            else if(arr[row][j]==0)
            {
                ++res;
                arr[row][j]=1;
            }
        }
        //check bottom
        for(int row=i+1;row<m;++row)
        {
            if(arr[row][j]=='G' || arr[row][j]=='W')
            {   
                break;
            }
            else if(arr[row][j]==0)
            {
                ++res;
                arr[row][j]=1;
            }
        }
        return res;
    }
}