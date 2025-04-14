import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Convert a list of strings to uppercase
		List<String> string = Arrays.asList("Abc", "ask", "bIke", "CAR", "Bus", "Abc", "Abc");
		System.out.println(string.stream().map(String::toUpperCase).collect(Collectors.toList()));

		// 2. Count strings starting with "A"
		System.out.println(string.stream().filter(x -> x.startsWith("A")).count());

		// 3. Find the first even number
		List<Integer> numbers = Arrays.asList(121, 3, 5, 6, 7);
		System.out.println(numbers.stream().filter(n -> n % 2 == 0).findFirst());

		// 4. Remove nulls from a list
		List<String> listWithNulls = Arrays.asList("a", null, "b", null);
		System.out.println(listWithNulls.stream().filter(Objects::nonNull).collect(Collectors.toList()));

		// 5. Square each number in a list
		System.out.println(numbers.stream().map(n -> n * n).collect(Collectors.toList()));

		// 6. Get the last element using reduce
		System.out.println(numbers.stream().reduce((first, second) -> second));

		// 7. Sort strings in natural and reverse order
		System.out.println(string.stream().sorted().collect(Collectors.toList()));
		System.out.println(string.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

		// 8. Remove duplicates
		System.out.println(string.stream().distinct().collect(Collectors.toList()));

		// 9. Join strings with comma
		System.out.println(string.stream().collect(Collectors.joining(",")));

		// 10. Convert to set
		System.out.println(numbers.stream().collect(Collectors.toSet()));

		// 11. Count frequency of each element
		Map<String, Long> map = string.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		// 12. Find max and min
		System.out.println(numbers.stream().max(Integer::compare));
		System.out.println(numbers.stream().min(Integer::compare));

		// 13. Find average
		System.out.println(numbers.stream().mapToInt(Integer::intValue).average());
		
		// 14. Group strings by length
		Map<Integer,List<String>> mapStrings = string.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(mapStrings);
		
		// 15. Partition even and odd
		Map<Boolean, List<Integer>> evenOdd = numbers.stream().collect(Collectors.partitioningBy(x->x%2==0));
		System.out.println(evenOdd);
		
		// 16. Second highest number
		System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());
		
		// 17. First non-repeating character
		String s="bbbapjaillk";
		System.out.println(s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(x->x.getValue()==1).map(Map.Entry::getKey).findFirst());
		
		
		// 18. Duplicate elements
		System.out.println(
				s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(x->x.getValue()>1).map(x->x.getKey()).collect(Collectors.toList())
				);
		
		// 20. Flatten list of lists
		List<List<Integer>> lists = Arrays.asList(Arrays.asList(1,2),Arrays.asList(0,32));
		System.out.println(lists.stream().flatMap(List::stream).collect(Collectors.toList()));
		
		
	}

}
