class Solution {
    public boolean kLengthApart(int[] nums, int k) 
    {   int dis=-1;
        for(int i=0;i<nums.length;++i)
        {
            if(nums[i]==1)
            {   
                //check if they are at least k distance apart
                if(dis==-1 || (i-dis-1)>=k)
                {
                    dis=i;
                    continue;
                }
                else
                {
                    return false;
                }
                
            }
        
        }  
        return true; 
    }
}