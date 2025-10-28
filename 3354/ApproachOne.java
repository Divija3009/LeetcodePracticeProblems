class Solution {
    public int countValidSelections(int[] arr) 
    {   
        int count=0;
        int nonZeros = 0;
        for (int x : arr) if (x > 0) nonZeros++;
        for(int i=0;i<arr.length;++i)
        {
            if(arr[i]==0)
            {
                
                if (isValid(arr, nonZeros, i, "left")) count++;
                if (isValid(arr, nonZeros, i, "right")) count++;
                
            }
        }
        return count;
    }
    public boolean isValid(int[] arr,int nonZeros,int curr,String direction)
    {   int[] nums = new int[arr.length];
        System.arraycopy(arr, 0, nums, 0, arr.length);
        while(curr<nums.length && curr>-1)
        {   
            if(nums[curr]>0)
            {
                nums[curr]-=1;
                direction= direction.equals("left")?"right":"left";
                if (nums[curr] == 0) nonZeros--;               
            }
            curr= direction.equals("left")?--curr:++curr; 
            
        }
        return nonZeros == 0;
    }
    
}