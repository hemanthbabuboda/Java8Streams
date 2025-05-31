import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	/**
	 * @param args
	 */
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

		// 9. Join strings using comma
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
		Map<Integer, List<String>> mapStrings = string.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(mapStrings);

		// 15. Partition even and odd
		Map<Boolean, List<Integer>> evenOdd = numbers.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
		System.out.println(evenOdd);

		// 16. Second highest number
		System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());

		// 17. First non-repeating character
		String s = "bbbapjaillk";
		System.out.println(s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).findFirst());

		// 18. Duplicate elements
		System.out.println(s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList()));

		// 20. Flatten list of lists
		List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(0, 32));
		System.out.println(lists.stream().flatMap(List::stream).collect(Collectors.toList()));

		// 21. Sort Employee by salary
		List<Employee> employees = Arrays.asList(new Employee(1, "Alice", "HR", 50000),
				new Employee(2, "Bob", "IT", 60000), new Employee(3, "Charlie", "HR", 55000));
		System.out.println(employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList());

		// 22. Group employees by department
		System.out.println(employees.stream().collect(Collectors.groupingBy(x -> x.department)));

		// 23. Highest-paid employee in each department
		Map<String, Optional<Employee>> maxByDept = employees.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		System.out.println(maxByDept);

		// 24. Filter employees whose names start with 'A' and salary >= 50K.
		System.out.println(employees.stream().filter(x -> x.name.startsWith("A") && x.salary >= 50000)
				.collect(Collectors.toList()));
		// 25. Convert to map with ID as key
		Map<Integer, Employee> mapById = employees.stream()
				.collect(Collectors.toMap(Employee::getId, Function.identity()));
		System.out.println(mapById);

		// 26. Count employees by title (simulate with dept)
		Map<String,Long> countByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(countByDept);
		
		// 27. List of Employee Names sorted by join date (simulate with salary)
		List<String> listByDate = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).map(x->x.getName()).toList();
		System.out.println(listByDate);
		
		// 29. Salary summary
		DoubleSummaryStatistics salSum= employees.stream().mapToDouble(Employee::getSalary).summaryStatistics();
		System.out.println(salSum);
		
		// 30. Check if all employees have salary > 20K.
		System.out.println(employees.stream().allMatch(x->x.salary>20000));
		
	}

}
