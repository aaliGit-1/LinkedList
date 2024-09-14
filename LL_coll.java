//Creating a SLL using Collection framework
import java.util.*;
public class LL_coll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //Creating a LL
		LinkedList<String> list1=new LinkedList<String>();
		//adding an element at the beginning of a LL 
		list1.addFirst("Noor");
		list1.addFirst("Aaliya");
		//printing the LL
		//System.out.println(list1);
		//adding an element at the end of a LL 
        list1.addLast("is");
        list1.addLast("me");
        System.out.println(list1);
        System.out.println("Size of the LL:"+list1.size());
        //Iterate through the LL
        for(int i=0;i<list1.size();i++) {
        	System.out.print(list1.get(i)+"->");
        }
        System.out.println("Null");
	}

}
