class ApproachTwo {
    public int[] getSneakyNumbers(int[] nums) 
    {
        int[] count= new int[nums.length-2];
        int[] res= new int[2];
        res[0]=-1;res[1]=-1;
        for(int i=0;i<nums.length;++i)
        {
            count[nums[i]]++;
            if(count[nums[i]]>1)
            {
                if(res[0]==-1) res[0]=nums[i];
                else 
                {
                    res[1]=nums[i];
                    return res;
                }
            }
        }
    return res;
    }
}
