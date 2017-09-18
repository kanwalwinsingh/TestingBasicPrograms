package GeekForGeeks.Stacks;

public class StackByArray {

	public static void main(String[] args) {
		stackByArrayReal s = new stackByArrayReal();
		s.push(2);
		s.push(3);
		s.push(1);
		
		System.out.println(s.pop()+" Popped from stack");

	}
	


}

class stackByArrayReal{
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];
	
	boolean isEmpty(){
		return (top<0);
	}
	
	public stackByArrayReal() {
		top = -1;
	}
	
	
	
	public stackByArrayReal(int top, int[] a) {
		super();
		this.top = top;
		this.a = a;
	}

	boolean push(int data){
		if(top>=MAX)
			return false;
		else{
			a[++top] = data;
			return true;
		}
	}
	
	int pop(){
		if(top<0){
			System.out.println("Stack underflow");
			return 0;
		}else{
			int x  =a[top--];
			return x;
		}
	}
	
}
