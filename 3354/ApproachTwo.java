class Solution {
    public int countValidSelections(int[] arr) 
    {   
        int totalSum=0,leftSum=0,result=0;
        for(int i=0;i<arr.length;++i)
        {
            totalSum+=arr[i];
        }
        for(int i=0;i<arr.length;++i)
        {
            if(arr[i]==0)
            {
                if(leftSum==(totalSum-leftSum)) result+=2;
                else if(Math.abs(leftSum-(totalSum-leftSum))==1) result+=1;
            }
            leftSum+=arr[i];
        }
        return result;
    }
    
}