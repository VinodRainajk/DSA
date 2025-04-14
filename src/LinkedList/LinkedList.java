package src.LinkedList;

public class LinkedList {
      LL head;

      private class LL {
          private LL next;
          private int value;

          public LL(int value) {
              this.value = value;
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
}
