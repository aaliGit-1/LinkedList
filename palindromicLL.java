//To check whether the LL is palindrome or not 
class LL_1 {
	Node head;
	private int size;
	LL_1(){
		this.size=0;
	}
    class Node{
    	int data;
    	Node next;
        Node(int data){
        	this.data=data;
        	this.next=null;
        	size++;
        }
    }
    public void addLast(int data) {
    	Node newNode=new Node(data); 
    	if(head==null) {
    		head=newNode;
    		return;
    	}
    	Node temp=head;
    	while(temp.next!=null) {
    		temp=temp.next;
    	}
    	temp.next=newNode;
    }
    public void printList() {
    	Node temp=head;
    	if(head==null) {
    		System.out.println("Empty LinkedList");
    	}
    	while(temp!=null) {
    		System.out.print(temp.data+"->");
    		temp=temp.next;
    	}
    	System.out.println("Null");
    }
    public Node divideList(Node head) {
    	Node Hare=head;
    	Node Turtle=head;
    	while(Hare.next!=null&&Hare.next.next!=null) {
    		Hare=Hare.next.next;
        	Turtle=Turtle.next;
    	}
    	return Turtle;
    }
    public Node reverseL(Node head) {
    	Node prevNode=null;
    	Node currNode=head;
    	while(currNode!=null) {
    		Node nextNode=currNode.next;
    		currNode.next=prevNode;
    		prevNode=currNode;
    		currNode=nextNode;
    	}
    	return prevNode;//Head of the 2nd Half 
    }
    public boolean isPalinLL(Node head) {
    	//empty or one element is present
    	if(head==null || head.next==null) {
    		return true;
    	}
    	//find the middle of the LL
    	Node middle=divideList(head);
    	Node secondStart=reverseL(middle.next);//Second half start
    	Node firstStart=head;//First half start
    	//comparing the element of 1stHalf and 2nd Half
    	while(secondStart!=null) {
    		if(firstStart.data!=secondStart.data) {
    			return false;
    		}
    		firstStart=firstStart.next;
    		secondStart=secondStart.next;
    	}
    	return true;
    }
    
}
public class palindromicLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LL_1 l1=new LL_1();
		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(2);
		l1.addLast(1);
		l1.printList();
	    System.out.println("Is the LinkedList palindrome? "+l1.isPalinLL(l1.head));
	}

}
