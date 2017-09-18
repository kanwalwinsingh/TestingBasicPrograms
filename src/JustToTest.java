

public class JustToTest {

	
	public static void main(String[] args) {
		javaHungrymethod();

	}
	
	
	public JustToTest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static int javaHungrymethod(){
		try{
			System.out.println("try");
			int x=4/0;
			return 10;
		}catch(Exception ex){
			System.out.println("catch");
		}finally{
			return 22;
		}
	}

}
