package src.LinkedList;

public class LinkedList {
      LL head;

      private class LL {
          private LL next;
          private int value;

          public LL(int value) {
              this.value = value;
          }

          public LL() {
                       }
      }

    public void addNodFirst(int value){
        LL ll = new LL(value);
        ll.next = null;

        if(head== null){
            head= ll;
            return;
        }

        ll.next = head;
        head = ll;

    }

    public void display(){
        LL node = head;

        while (node!= null){
            System.out.print(node.value+" ->");
            node= node.next;
        }
        System.out.print("END");
    }

    public void recusrsiveAddition(int curIndx, int targetIndex, LL node, int value){

          if(curIndx+1==targetIndex){
              LL ll = new LL(value);
              ll.next = node.next;
              node.next = ll;
              return;
          }

           curIndx++;
           if(node!= null){
                node = node.next;
            }
        recusrsiveAddition(curIndx,targetIndex,node,value);
    }


    public LL recursiveAdditon2(int currIndx, int value,LL currnode){

          if(currIndx==1){
              LL newList = new LL(value);
              newList.next = currnode;
              return newList;
          }
       currIndx--;
       LL nodeVal = recursiveAdditon2(currIndx,value,currnode.next);
       currnode.next = nodeVal;
       return currnode;
    }

    public LL deleteDuplicates(LL head) {
        LL node  =  head;
        LL prevnode = null;
        while(node !=null){

             if(prevnode== null){
                 prevnode =  node;
             }else {
                 if(prevnode.value != node.value){
                    prevnode.next = node;
                    prevnode= prevnode.next;
                 }else{
                     prevnode.next = node.next;
                 }

             }

            node = node.next;
        }
     return head;

    }

    public LL deleteDuplicates2(LL head) {
        LL node  =  head;
        while(node.next !=null){
            if(node.value== node.next.value){
                node.next =node.next.next;
            }else {
                node = node.next;
            }

        }
        return head;

    }

    public LL mergeTwoLists(LL list1, LL list2) {
        LL head = new LL();
        LL returnList = head;

        while(list1 != null || list2 != null){

            if(list1 != null && list2 != null){
                LL temp = new LL();
                if(list1.value <= list2.value){
                    temp = list1;
                    list1 = list1.next;
                }else{
                    temp = list2;
                    list2 = list2.next;
                }
                returnList = temp;
                System.out.println(returnList.value);

                returnList = returnList.next;
            } else if(list1 == null){
                returnList = list2;
                break;
            } else if(list2 == null){
                returnList = list1;
                break;
            }


        }

        return returnList.next;
    }




}
