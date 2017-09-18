package geekForGeek.Queue;

public class LinkedQueue {

	static class Qnode
	{
		int key;
		Qnode next;
		
		public Qnode(int key){
			this.key = key;
			this.next = null;
		}
		
	}
	
	static class Queue{
		Qnode front, rear;
		
		public Queue(){
			this.front = this.rear = null;
		}
		
		//method to add an key to the queue
		void enqueue(int key){
			
			//crearte a new ll node
			Qnode temp = new Qnode(key);
			
			//if queue is empty, then new node is front and rear both
			if(this.rear==null){
				this.front = this.rear = temp;
				return;
			}
			
			//add the new node at the end of queue and change rear
			this.rear.next = temp;
			this.rear = temp;
		}
		
		Qnode dequeue(){
			
			//if queue is emty, return null
			if(this.front == null)
				return null;
			
			//store previous front and move front one node ahead
			Qnode temp = this.front;
			this.front = this.front.next;
			
			//if front becomes null, then change rear also as null
			if(this.front == null)
				this.rear = null;
			
			return temp;
		}
	}
	
	public static void main(String[] args) {
		Queue q = new  Queue();
		q.enqueue(10);
		 q.enqueue(20);
	        q.dequeue();
	        q.dequeue();
	        q.enqueue(30);
	        q.enqueue(40);
	        q.enqueue(50);
	         
	        System.out.println("Dequeued item is "+ q.dequeue().key);
	}

}
