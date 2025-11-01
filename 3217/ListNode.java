import java.util.HashMap;
import java.util.Map;

public class ListNode 
{
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 
}
 
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) 
    {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;++i)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],0);
               // System.out.println("map value="+nums[i]);
            }
        }
        ListNode temp=head;
        ListNode newHead=new ListNode(-1);
        ListNode newHeadTemp= newHead;
        while(temp!=null)
        {  // System.out.println("checking ll value="+temp.val);
            if(!map.containsKey(temp.val))
            {  // System.out.println("LL value"+temp.val+ " is not present");
                newHeadTemp.next=temp;
                newHeadTemp=newHeadTemp.next;
                
            }
            temp=temp.next;
            
        }
        //imp to break the existing links
        newHeadTemp.next=null;
        return newHead.next;
    }
}