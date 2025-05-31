import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(10,20,30,30,10,50);
//		System.out.println(numbers);
//		int secondHighest = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
//		System.out.println(secondHighest);
//		Map<Integer, String> names = new HashMap<>();
//		names.put(1, "hema");
//		names.put(112, "nick");
//		names.put(413, "jack");
		
//		System.out.println(names);
//		List<Integer> id = new ArrayList<>(names.keySet());
//		id = names.entrySet().stream().map(x->x.getKey()).toList();
//		System.out.println(id);
//		List<String> name = new ArrayList<>(names.values());
//		System.out.println(name);
		
//		List<String> names = Arrays.asList("kasdass","tim" );
////		System.out.println(names.stream().map(x->x.toUpperCase()).toList());
//		
//		
//		
////		System.out.println(IntStream.range(0, numbers.size()).mapToObj(i->numbers.get(numbers.size()-i-1)).toList());
//		
//		System.out.println(IntStream.range(0, names.size()).mapToObj(i->names.get(names.size()-i-1)).toList());
//		System.out.println(names.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()));
	
//	System.out.println(numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst());
	
		List<Integer> list = Arrays.asList(10, 20, 20, 30, 30, 50);
		
		System.out.println(
				list.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()))
		.entrySet()
		.stream()
		.filter(x->x.getValue()==1)
		.map(x->x.getKey())
		.skip(1)
		.findFirst().orElse(null));

	}

}
