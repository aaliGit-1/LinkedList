//Creating Singly Linked List
class LL {
	Node head;
	private int size;
	LL(){
		this.size=0;
	}
    class Node{
    	String data;
    	Node next;
        Node(String data){
        	this.data=data;
        	this.next=null;
        	//whenever we make a new node size gets incremented
        	size++;
        }
    }
    //Insertion: add- first 
    public void addFirst(String data) {
    	//creation of new node
    	Node newNode=new Node(data);
    	//when the LL is empty
    	if(head==null) {
    		head=newNode;
    		return;
    	}
    	//when the LL is non-empty
    	newNode.next=head;
    	head=newNode;
    	
    }
    //Insertion: add-last
    public void addLast(String data) {
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
    //print the list
    public void printList() {
    	Node temp=head;
    	//when LL is empty
    	if(head==null) {
    		System.out.println("Empty LinkedList");
    	}
    	while(temp!=null) {
    		System.out.print(temp.data+"->");
    		temp=temp.next;
    	}
    	System.out.println("Null");
    }
    //Deletion at the beginning
    public String delBegin() {
    	//Empty LL
    	String delEle="";
    	//whenever we make remove a node size gets decremented
    	size--;
    	if(head==null) {
    		System.out.println("No element is being deleted.");
    		return delEle;
    	}
    	//having a single element in a LL
    	else if(head.next==null) {
    		delEle=head.data;
    		head=null;
    		return delEle;
    	}
    	//Non-Empty LL
    	delEle=head.data;//taking the delete element 
    	head=head.next;
    	return delEle;
    }
    //Deletion at the end
    public String delEnd() {
    	//Empty LL
    	String delEle="";
    	//whenever we make remove a node size gets decremented
    	size--;
    	if(head==null) {
    		System.out.println("No element is being deleted.");
    		return delEle;
    	}
    	//having a single element in a LL
    	else if(head.next==null) {
    		delEle=head.data;
    		head=null;
    		return delEle;
    	}
    	//Non-Empty LL
    	Node temp=head;//pointer node for traversal 
    	while(temp.next.next!=null) {//reaching the second last element
    		temp=temp.next;
    	}
    	delEle=temp.next.data;//taking the data
    	temp.next=null;//break the link to delete it 
    	return delEle;
    }
    public int sizeLL() {
    	System.out.println("Size of the LL: ");
    	return size;
    }
    public void insertAtPos(String d,int pos) {
    	Node newNode=new Node(d);
    	//a pointer for traversal
    	Node temp=head;
    	int ind=0;
    	if(ind==pos) {//single element is present 
    		addFirst(d);
    	}
    	else if(pos==sizeLL()-1) {//at the end of the LL
    		addLast(d);
    	}
    	else{//any position between beginning and end
    		while(ind!=pos-1) {
    		temp=temp.next;
    		ind++;
    		}
    	newNode.next=temp.next;
    	temp.next=newNode;
    	}
    }
    //Search an element and return its index
    public int searchPos(String d) {
    	//A pointer for traversal
    	Node temp=head;
    	int count=0;
    	while(temp!=null) {
    		if(temp.data==d) {
    			break;
    		}
    		temp=temp.next;
    		count++;
    	}
    	return count;
    }
    //Deletion at any position
    public String delPos(int ind) {
    	Node temp=head;
    	String delEle="";
    	int count=0;
    	//ind-2: to reach the ind-1 element after while gets terminated 
    	while(count<(ind-2)) {
    		temp=temp.next;
    		count++;
    	}
    	delEle=temp.next.data;
    	temp.next=temp.next.next;
    	return delEle;
    }
    public void revIterate() {//without an extra LL
    	if(head==null || head.next==null) {//when LL is empty or has one element in it
    		return;
    	}
    	Node prevNode=head;
    	Node currNode=head.next;
    	while(currNode!=null) {//at the end of the LL
    		Node nextNode=currNode.next;
    		currNode.next=prevNode;
    		//update
    		prevNode=currNode;
    		currNode=nextNode;
    	}
    	//pointing head and null value
    	head.next=null;
    	head=prevNode;
    }
    public Node revRecursive(Node head) {
    	//Base condition
    	if(head==null ||head.next==null) {// LL is empty or single element is present in LL
    		return head;
    	}
    	//head.next==null is used at the end of the reversing the LL
    	Node newHead=revRecursive(head.next);
    	head.next.next=head;//reversing the connection
    	head.next=null;//deleting the existing connection
    	return newHead;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LL list1=new LL();
        list1.addLast("A");
        list1.addLast("B");
        list1.addLast("C");
        list1.printList();
        /*System.out.println("Element deleted: "+list1.delEnd());
        list1.printList();
        System.out.println("Element deleted: "+list1.delBegin());
        list1.printList();
        list1.sizeLL();
        list1.insertAtPos("C", 0);
        list1.insertAtPos("A", 1);
        list1.insertAtPos("D", 3);
        list1.printList();
        System.out.println("A is present at: "+list1.searchPos("A"));
        System.out.println("3rd element is deleted. "+list1.delPos(3));
        list1.printList();*/
        list1.head=list1.revRecursive(list1.head);//as it returns the head of the LL
        list1.printList();
	}

}
