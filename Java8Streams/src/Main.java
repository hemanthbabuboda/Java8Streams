import java.util.*;
import java.util.stream.Collectors;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Convert a list of strings to uppercase
        List<String> string = Arrays.asList("Abc","ask","bIke","CAR","Bus","Abc","Abc");
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
	}

}
