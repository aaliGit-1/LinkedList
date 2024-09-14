//import LL.Node;

//Find the nth Node from last and delete it
class L1{
	Node head;
    private int size=0;
    L1(){
    	this.size=0;
    }
    class Node{
    	int data;
    	Node next;
    	Node(int data){
    		this.data=data;
    		this.next=null;
    	}
    }
    public void addLast(int data) {
    	//creation of new node
    	Node newNode=new Node(data); 
    	//when the LL is empty
    	if(head==null) {
    		head=newNode;
    		return;
    	}
    	//when the LL is non-empty
    	//taking a pointer node temp which points to head
    	Node temp=head;
    	while(temp.next!=null) {
    		temp=temp.next;
    	}
    	temp.next=newNode;
    }
    public void printList() {
    	if(head==null) {
    		System.out.println("Empty LL");
    	}
    	Node temp=head;
    	while(temp!=null) {
    		System.out.print(temp.data+"->");
    		temp=temp.next;
    	}
    	System.out.println("Null");
    	
    }
    public void nthNode(int n) {
    	if(head==null) {
    		System.out.println("Empty LL");;
    	}
    	//finding the size of the LL
    	int size=0;
    	Node temp=head;
    	while(temp!=null) {
    		temp=temp.next;
    		size++;
    	}
    	//iterating till the nth-1 node i.e., previous node of the Nth Node
    	int i=1;
    	Node prevNode=head;
    	while(i<size-n) {
    		//System.out.print(prevNode.data+"->");
    		prevNode=prevNode.next;
    		i++;
    	}
    	if(n==size) {//accessing the sizeth node from last then return the head.next node
    		head=head.next;
    	}
    	else {
    	//deleting the nth Node from last
    	prevNode.next=prevNode.next.next;
    	}
    }
}
public class nthNode {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        L1 l1=new L1();
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);
        //l1.printList();
        l1.nthNode(4);
        l1.printList();
	}

}
