import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Mohan", "ram","Hemanth","Ravi");
		System.out.println(
				names.stream().sorted(Comparator.comparingInt(x->x.length())).toList()
				);
	}
}
