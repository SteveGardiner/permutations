import java.util.ArrayList;

public class poset {
	//public static ArrayList<String> relations = new ArrayList<String>();
	public ArrayList<ArrayList<ArrayList<ArrayList<String>>>> posets = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();
//	public static void main(String[] args) {
//		ArrayList<String> rel1 = new ArrayList<String>();
//		ArrayList<String> rel2 = new ArrayList<String>();
//		rel1.add("1");
//		rel1.add("2");
//		rel2.add("1");
//		rel2.add("3");
//		ArrayList<ArrayList<String>> rels = new ArrayList<ArrayList<String>>();
//		rels.add(rel1);
//		rels.add(rel2);
//		
//		ArrayList<ArrayList<ArrayList<ArrayList<String>>>> egg = addPoset(null,"4",rels);
//		System.out.println(egg);
//		
//		ArrayList<String> rel3 = new ArrayList<String>();
//		ArrayList<String> rel4 = new ArrayList<String>();
//		rel3.add("2");
//		rel3.add("3");
//		rel4.add("3");
//		rel4.add("5");
//		ArrayList<ArrayList<String>> rels2 = new ArrayList<ArrayList<String>>();
//		rels2.add(rel3);
//		rels2.add(rel4);
//		
//		
//		System.out.println(egg);
//		System.out.println(addPoset(egg, "5", rels2));
//	}
	public ArrayList<ArrayList<ArrayList<ArrayList<String>>>> addPoset(ArrayList<ArrayList<ArrayList<ArrayList<String>>>> currentPosets, String length, ArrayList<ArrayList<String>> relations) {
		ArrayList<ArrayList<ArrayList<String>>> newPoset = new ArrayList<ArrayList<ArrayList<String>>>();
		ArrayList<String> Length = new ArrayList<String>();
		Length.add(length);
		ArrayList<ArrayList<String>> Length2 = new ArrayList<ArrayList<String>>();
		Length2.add(Length);
		newPoset.add(Length2);
		newPoset.add(relations);
		posets.add(newPoset);
		return posets;
	}
}
