package Java8Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapMethodTest {

	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1,"knawal",new Address("Delhi","Delhi",123)));
		empList.add(new Employee(2,"tulsi",new Address("haldwani","U.K",123)));
		empList.add(new Employee(3,"srishti",new Address("dehradun","U.K",123)));
		empList.add(new Employee(4,"manisha",new Address("Mujjafnagar","U.P",123)));
		empList.add(new Employee(5,"aditi",new Address("dehradun","U.K.A",123)));
	List<Address> add2 = empList.stream().map(Employee::getAddress).filter(add->add.getCity().equals("dehradun"))
	.collect(Collectors.toList());
	
	add2.forEach(a->System.out.println(a.getState()));
	}
	
	
	
}
