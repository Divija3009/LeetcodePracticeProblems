class Solution {
    public int minCost(String colors, int[] neededTime) 
    {
        int prev=0;
        int min=0;
        for(int i=1;i<colors.length();++i)
        {
            char currentChar= colors.charAt(i);
            if(colors.charAt(prev)==currentChar)
            {
                if(neededTime[prev]<neededTime[i])
                {
                    min+=neededTime[prev];
                    prev=i;
                }
                else
                {
                    min+=neededTime[i];
                    
                }
            }
            else
            {
                prev=i;
            }
        }  
        return min;  
    }
}