import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(10,15,8,49,25,98,32);
		//numbers start with 1
		System.out.println(numbers.stream().map(String::valueOf)
				.filter(x->x.startsWith("1")).map(x->Integer.parseInt(x)).collect(Collectors.toList()));
		//sort in decreasing
		System.out.println(
				numbers.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList())
				);
		//concatenate two streams
		List<String> string1 = Arrays.asList("name1");
		List<String> string2 = Arrays.asList("name2");
		Stream<String> name = Stream.concat(string1.stream(),string2.stream());
		name.forEach(x->System.out.print(x+" "));
		
		
		
		 List<Employees> list = Arrays.asList(
		            new Employees("Alice", 30000),
		            new Employees("Bob", 25000),
		            new Employees("Alice", 22000)
		        );
		 
		        System.out.println(list.stream().sorted(Comparator.comparing(Employees::getName)
		        		.thenComparingInt(e -> e.salary)).toList());
		
	}

}
