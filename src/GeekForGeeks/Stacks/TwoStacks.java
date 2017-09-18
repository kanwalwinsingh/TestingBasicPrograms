package GeekForGeeks.Stacks;

public class TwoStacks {

	int size;
	int top1, top2;
	int arr[];
	
	public TwoStacks(int n) {
		arr = new int[n];
		size = n;
		top1 = -1;
		top2 = size;
	}
	
	//method to push an element x to stack1
	void push1(int x){
		
		//there is atleast one empty space for new element
		if(top1<top2-1)
		{
			top1++;
			arr[top1] = x;
		}else{
			System.out.println("Stack 1 overflow");
			System.exit(1);
		}
	}
	
	//method to push an element x to stack2
	void push2(int x){
		
		//there is atleast one empty space for new element
		if(top1<top2-1){
			top2--;
			arr[top2] = x;
		}else{
			System.out.println("Stack 2 overflow");
			System.exit(1);
		}
	}
	
	//method to pop an element from stack
	int pop1(){
		if(top1>=0)
		{
			int x = arr[top1];
			top1--;
			return x;
		}else{
			System.out.println("Stack 1 underflow");
			System.exit(1);
		}
		return 0;
	}
	
	//method to pop an element from stack 2
	int pop2(){
		if(top2<size){
			int x = arr[top2];
			top2++;
			return x;
		}else{
			System.out.println("Stack 2 underflow");
			System.exit(1);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks(5);
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);
		 System.out.println("Popped element from" +
                 " stack1 is " + ts.pop1());
ts.push2(40);
System.out.println("Popped element from" +
               " stack2 is " + ts.pop2());
		
	}
}