package geekForGeek.Queue;

public class FirstQueueExample {

	int front, rear, size;
	int capacity;
	int array[];
	
	public FirstQueueExample(int capacity){
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity-1;
		array = new int[this.capacity];
	}
	
	//queue is full when size become equal to capacity
	boolean isFull(FirstQueueExample queue){
		return (queue.size == queue.capacity);
	}
	
	//queue is empty when size become equal to capacity
	boolean isEmpty(FirstQueueExample queue){
		return(queue.size == 0);
	}
	
	//method to add an item to the queue
	//it changes rear and size
	void enqueue(int item){
		if(isFull(this))
			return;
		this.rear = (this.rear+1)%this.capacity;
		this.array[this.rear] = item;
		this.size = this.size+1;
		System.out.println(item+ " enqueued to queue");
	}
	
	//method to remove an item from queue
	//it changes front and size
	int dequeue(){
		if(isEmpty(this))
			return Integer.MIN_VALUE;
		int item = this.array[this.front];
		this.front = (this.front+1)%this.capacity;
		this.size = this.size-1;
		return item;
		
	}
	
	//method to get front of queue
	int front(){
		if(isEmpty(this))
			return Integer.MIN_VALUE;
		
		return this.array[this.front];
	}
	
	//method to get rear of the queue
	int rear(){
		if(isEmpty(this))
			return Integer.MIN_VALUE;
		
		return this.array[this.rear];
	}
	
	public static void main(String[] args) {
		FirstQueueExample queue = new FirstQueueExample(5);
		System.out.println(queue.isEmpty(queue));
		System.out.println(queue.isFull(queue));
		System.out.println("The element dequeued from the queue is "+queue.dequeue());
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		
		System.out.println("The element dequeued from the queue is "+queue.dequeue());
	}

}
