import java.util.ArrayList;

public class relation {
	//public static ArrayList<String> relations = new ArrayList<String>();
	public ArrayList<ArrayList<String>> relations = new ArrayList<ArrayList<String>>();
//	public static void main(String[] args) {
//		ArrayList<String> newRelation = new ArrayList<String>();
//		newRelation.add("a");
//		newRelation.add("b");
//		ArrayList<String> new2 = new ArrayList<String>();
//		new2.add("c");
//		new2.add("b");
//		
//		relations = new ArrayList<ArrayList<String>>();
//		relations.add(newRelation);
//		relations.add(new2);
//		System.out.println(relations);
//		System.out.println(addRelation(relations,"c","a"));
//	}
	public ArrayList<ArrayList<String>> addRelation(ArrayList<ArrayList<String>> currentRels, String eltA, String eltB) {
		if (currentRels == null || currentRels.size()==0){
			relations.clear();
			ArrayList<String> newRelation = new ArrayList<String>();
			newRelation.add(eltA);
			newRelation.add(eltB);
			//relations = new ArrayList<ArrayList<String>>();
			relations.add(newRelation);
			return relations;
		}
		if (repeatCheck(currentRels, eltA, eltB) == true && contraCheck(currentRels, eltA, eltB) == true){
			ArrayList<String> newRelation = new ArrayList<String>();
			newRelation.add(eltA);
			newRelation.add(eltB);
			relations.add(newRelation);
			transitiveClosure(currentRels, eltA, eltB);
//			ArrayList<String> newRelation = new ArrayList<String>();
//			newRelation.add(eltA);
//			newRelation.add(eltB);
//			//relations = new ArrayList<ArrayList<String>>();
//			relations.add(newRelation);
			return relations;
		}
		
		return relations;
	}
	
	
	public Boolean repeatCheck(ArrayList<ArrayList<String>> currentRels, String eltA, String eltB) {
		for (int i = 0 ; i < currentRels.size(); i++) {
			if (currentRels.get(i).get(0).equals(eltA) && currentRels.get(i).get(1).equals(eltB)){
				return false;
			}
		}
		return true;
	}
	
	public Boolean contraCheck(ArrayList<ArrayList<String>> currentRels, String eltA, String eltB) {
		for (int i = 0 ; i < currentRels.size(); i++) {
			if (currentRels.get(i).get(1).equals(eltA) && currentRels.get(i).get(0).equals(eltB)){
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<ArrayList<String>> transitiveClosure(ArrayList<ArrayList<String>> currentRels, String eltA, String eltB) {
		for (int i = 0 ; i < currentRels.size(); i++) {
			if (currentRels.get(i).get(1).equals(eltA) && repeatCheck(currentRels, currentRels.get(i).get(0), eltB) && contraCheck(currentRels, currentRels.get(i).get(0), eltB)){
//				ArrayList<String> newRelation = new ArrayList<String>();
//				newRelation.add(eltA);
//				newRelation.add(eltB);
//				//relations = new ArrayList<ArrayList<String>>();
//				//addRelation(currentRels,currentRels.get(i).get(0), eltB);
//				relations.add(newRelation);
				addRelation(relations, currentRels.get(i).get(0), eltB);
//				ArrayList<String> closure = new ArrayList<String>();
//				closure.add(currentRels.get(i).get(0));
//				closure.add(eltB);
//				relations.add(closure);
//				return relations;
			}
			else if (eltB.equals(currentRels.get(i).get(0)) && repeatCheck(currentRels, eltA, currentRels.get(i).get(1)) && contraCheck(currentRels, eltA, currentRels.get(i).get(1))){
//				ArrayList<String> closure = new ArrayList<String>();
//				closure.add(eltA);
//				closure.add(currentRels.get(i).get(1));
				
//				ArrayList<String> newRelation = new ArrayList<String>();
//				newRelation.add(eltA);
//				newRelation.add(eltB);
//				relations.add(newRelation);
				addRelation(relations, eltA, currentRels.get(i).get(1));
				//relations = new ArrayList<ArrayList<String>>();
				//addRelation(currentRels,currentRels.get(i).get(0), eltB);
				
				//relations.add(closure);
//				return relations;
			}
//			else if (repeatCheck(currentRels, eltA, currentRels.get(i).get(1)) == false || contraCheck(currentRels, eltA, currentRels.get(i).get(1)) == false || repeatCheck(currentRels, currentRels.get(i).get(0), eltB) == false || contraCheck(currentRels, currentRels.get(i).get(0), eltB) == false){
//				return relations;
//			}
		}
//		ArrayList<String> newRelation = new ArrayList<String>();
//		newRelation.add(eltA);
//		newRelation.add(eltB);
//		relations.add(newRelation);
		return relations;
	}
	
//	private static ArrayList<ArrayList<String>> addRelation(ArrayList<ArrayList<String>> currentRels, String eltA, String eltB) {
//		ArrayList<String> newRelation = new ArrayList<String>();
//		newRelation.add(eltA);
//		newRelation.add(eltB);
//		relations = new ArrayList<ArrayList<String>>();
//		relations.add(newRelation);
//		return relations;
//	}
	
	
//	private static ArrayList<ArrayList<String>> permute(String prefix, String remaining) {
//		if (prefix.length() == 0){
//			perms = new ArrayList<String>();
//		}
//		if (remaining.length() == 0) {
//			perms.add(prefix);
//		}
//		
//		for (int i = 0; i < remaining.length(); i++) {
//			permute(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i+1, remaining.length()));
//		}
//		return perms;
//	}
}
