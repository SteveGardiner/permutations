import java.util.ArrayList;

public class permutations {
	public static ArrayList<String> perms = new ArrayList<String>();
//	public static void main(String[] args) {
//		permute("ABCD");
//	}
	public static ArrayList<String> permute(String full) {
		if (full == null || full.length()==0){
			perms = new ArrayList<String>();
			perms.add("Provide a String");
			return perms;
		}
		permute("", full);
		return perms;
	}
	
	private static ArrayList<String> permute(String prefix, String remaining) {
		if (prefix.length() == 0){
			perms = new ArrayList<String>();
		}
		if (remaining.length() == 0) {
			perms.add(prefix);
		}
		
		for (int i = 0; i < remaining.length(); i++) {
			permute(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i+1, remaining.length()));
		}
		return perms;
	}
}
