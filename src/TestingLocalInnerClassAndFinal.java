
public class TestingLocalInnerClassAndFinal {

		private int outerField = 0;
		
		TestingLocalInnerClassAndFinal(int outerField){
			this.outerField = outerField;
		}
		public void outerMethod(){
				int n = 2;
			class Inner{
				int k;
				Inner(int k){
					this.k = k;
				}
				public void print(){
					outerField = 10;
						System.out.println("This is method local inner class accessing local variable : "+n);
						System.out.println("This is method local inner class accessing outer variable: "+outerField);
				}
			}
			System.out.println("accessing local variable within the outer clas  : "+n);
			Inner inner = new Inner(2);
			inner.print();
		}
	public static void main(String[] args) {
		TestingLocalInnerClassAndFinal outerClass = new TestingLocalInnerClassAndFinal(7);
		outerClass.outerMethod();

	}

}
