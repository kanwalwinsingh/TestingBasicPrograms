package GeekForGeeks.Stacks;

import java.util.Scanner;

public class LinkedStackImplement {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		linkedStack ls = new linkedStack();
		
		System.out.println("Linked stack test\n");
		char ch;
		do{
			 System.out.println("\nLinked Stack Operations");
	            System.out.println("1. push");
	            System.out.println("2. pop");
	            System.out.println("3. peek");
	            System.out.println("4. check empty");
	            System.out.println("5. size");
	            
	            int choice = scan.nextInt();
	            switch(choice){
	            case 1 :
	                System.out.println("Enter integer element to push");
	                ls.push( scan.nextInt() ); 
	                break;                         
	            case 2 : 
	                try
	                {
	                    System.out.println("Popped Element = "+ ls.pop());
	                }
	                catch (Exception e)
	                {
	                    System.out.println("Error : " + e.getMessage());
	                }    
	                break;                         
	            case 3 : 
	                try
	                {
	                    System.out.println("Peek Element = "+ ls.peek());
	                }
	                catch (Exception e)
	                {
	                    System.out.println("Error : " + e.getMessage());
	                }
	                break;                         
	            case 4 : 
	                System.out.println("Empty status = "+ ls.isEmpty());
	                break;                
	            case 5 : 
	                System.out.println("Size = "+ ls.getSize()); 
	                break;                
	            case 6 : 
	                System.out.println("Stack = "); 
	                ls.display();
	                break;                        
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;
	            }           
	            /* display stack */    
	            ls.display();            
	            System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);       
	 
	        } while (ch == 'Y'|| ch == 'y');                 
	    }
}




class Node{
	protected int data;
	protected Node link;
	public Node(int data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}
	public void setLink(Node n)
    {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
	
}

class linkedStack
{
	protected Node top;
	protected int size;
	
	public linkedStack() {
		top = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int getSize(){
		return size;
	}
	
	public void push(int data){
		Node nptr = new Node(data, null);
		if(top==null){
			top = nptr;
		}else{
			nptr.setLink(top);
			top = nptr;
		}
		size++;
	}
	
	public int pop()
	{
		if(isEmpty()){
			System.out.println("Underflow Exception");
			return -1;
		}else{
			Node ptr =top;
			top = ptr.getLink();
			size--;
			return ptr.getData();
		}
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("Underflow Exception");
			return -1;
		}
		return top.getData();
	}
	
	public void display(){
		System.out.println("\nStack =");
		if(size==0){
			System.out.println("Empty\n");
			return;
		}
		Node ptr = top;
		while(ptr!=null){
			System.out.println(ptr.getData()+" ");
			ptr = ptr.getLink();
		}
		System.out.println();
	}
}