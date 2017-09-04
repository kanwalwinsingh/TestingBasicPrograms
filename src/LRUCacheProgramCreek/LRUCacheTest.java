package LRUCacheProgramCreek;

public class LRUCacheTest {

	public static void main(String[] args) {
		LRUCache lr=new LRUCache(5);

		lr.set(1, 1);

		lr.set(2,2);

		lr.set(3, 3);

		lr.set(4, 4);

		lr.set(5, 5);

		int val=lr.get(1);

		System.out.println(""+val);

		lr.set(6, 6);

		int val2=lr.get(2);

		System.out.println(""+val2);	// TODO Auto-generated method stub

	}

}
