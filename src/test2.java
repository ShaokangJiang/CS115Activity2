import java.util.HashMap;
import java.util.regex.Pattern;

public class test2 {

	public static void main(String[] args) {
		/*
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(1, "sd");
		hmap.put(1, "233");
		System.out.println(hmap.get(1));
	*/	String content = "aaa";
		String pattern = ".*A.*";
        Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        System.out.println(Pattern.matches(pattern, content.toUpperCase()));
         
       
	}

}
