//Detect a cycle in a Singly Linked List
//Using Hare and Turtle method (Floyd's Algorithm to detect a loop)
class L_1 {
	Node head;
	private int size;
	L_1(){
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
    public boolean detectLoop() {
    	//empty LL
    	if(head==null) {
    		return false;
    	}
    	Node Hare=head;//fast pointer
    	Node Turtle=head;//slow pointer
    	//Hare is not null or Hare is the in the last node
    	while(Hare!=null && Hare.next!=null) {
    		Hare=Hare.next.next;
    		Turtle=Turtle.next;
    		if(Hare==Turtle) {
    			return true;
    		} 
    	}
    	return false;
    }
}
public class cycleLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L_1 l1=new L_1();
		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(3);
		l1.addLast(4);
		l1.printList();
		System.out.println("Is a loop present in the LL? "+l1.detectLoop());
	}

}
