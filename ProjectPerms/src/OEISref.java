
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class OEISref {
	public static ArrayList<String> OEISreferences = new ArrayList<String>();
//	public static void main(String[] args) throws Exception {
//		
//		final Document document = Jsoup.connect("https://www.imdb.com/chart/top").get();
//	
//		for (Element row : document.select("table.chart.full-width tr")) {
//			final String title = row.select(".titleColumn").text();
//			final String rating = row.select(".ImdbRating").text();
//			
//			System.out.println(title + "----> Rating:  " + rating);
//		}
//	
//	}
	
//	public static void main(String[] args) {
//		
//	}
	public static ArrayList<String> refNum(String distribution) throws IOException {
		if (distribution == null || distribution.length()==0){
			OEISreferences = new ArrayList<String>();
			OEISreferences.add("Provide a Distribution");
			return OEISreferences;
		}
		
		Document document = Jsoup.connect("https://oeis.org/search?q=" + distribution).get();
		
//		for (Element row : document.select("a")) {
//			
//		}
		
		try{
			Element step = document.select("body center").get(1);
			step = step.select("table").get(4);
			step = step.select("td").get(2);
			step = step.select("a").first();
			String ref = step.text();
//			String relHref = link.attr("href"); // == "/"
				
			System.out.println(ref);
		
			OEISreferences.add(ref);
		} catch (IndexOutOfBoundsException e) {
			OEISreferences.add("No Result");
		}
		return OEISreferences;
		
	}
	
}
