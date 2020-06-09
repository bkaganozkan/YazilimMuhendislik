package urlpaket;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Hello world!
 *
 */
public class Urloku 
{
  
    
    public String GetUrl() {
    	  final String keyword = "emre varol";
          final String url = "https://www.google.com/search?q="+keyword;
          List<String> myList = new ArrayList<String>();
          try {
          	final Document document = Jsoup.connect(url).get();
          	
          	for(Element row: document.select("div[class=g]")) {
          		final String title = row.select("div[class=TbwUpd NJjxre]").text();
          		myList.add(title);
          		
          	}
          	
          }
          catch (Exception ex){
          	ex.printStackTrace();
          }
          String liste = myList.toString();
		  return liste;
          
    }
    public String GetUrl1(String kelime) {
  	  final String keyword = "emre varol";
        final String url = "https://www.google.com/search?q="+kelime;
        List<String> myList = new ArrayList<String>();
        try {
        	final Document document = Jsoup.connect(url).get();
        	
        	for(Element row: document.select("div[class=g]")) {
        		final String title = row.select("div[class=TbwUpd NJjxre]").text();
        		myList.add(title);
        		
        	}
        	
        }
        catch (Exception ex){
        	ex.printStackTrace();
        }
        String liste1 = myList.toString();
		  return liste1;
        
  }
    void deneme() {
    	return;
    }
}
