package src.LinkedList;

public class CycleStartDetection {
    public LinkedListtemplate detectCycle(LinkedListtemplate head) {
        LinkedListtemplate slow = head;
        LinkedListtemplate fast = head;
        int lengthList = 0;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast){
                lengthList = getLength(slow.next,fast);
                break;
            }

        }

        if(lengthList==0){
            return null;
        }

        LinkedListtemplate first= head;
        LinkedListtemplate second = head;

        while(lengthList!= 0){
            second = second.next;
            lengthList--;
        }

        while(first!=second){
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public int getLength(LinkedListtemplate  slow, LinkedListtemplate  fast){
        int returnLength = 1;
        while(slow!= fast){
            slow = slow.next;
            returnLength++;
        }
        return returnLength;
    }
}
