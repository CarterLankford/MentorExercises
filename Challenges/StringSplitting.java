import java.util.Arrays;
public class StringSplitting{

	public static void main(String[] args){
		String[] result;

		result = "/".split("/");
		System.out.println(Arrays.toString(result) + " " + result.length);
		result = "/resources".split("/");
		System.out.println(Arrays.toString(result) + " " + result.length);
		result = "/resources/path".split("/");
		System.out.println(Arrays.toString(result) + " " + result.length);
		result = "resources".split("/");
		System.out.println(Arrays.toString(result) + " " + result.length);
		result = "a/b".split("/");
		System.out.println(Arrays.toString(result) + " " + result.length);
		

		result = "a/////b///c/////".split("/");
		System.out.println(Arrays.toString(result) + " " + result.length);
		



		/*
		For each the following strings, how many elements will there be in the array returned by "split()" using "/" as delimiter? And of course, what pieces would there be in each array?

		"/"
		"/resource"
		"/resource/path"
		"resource"
		*/
	}
}