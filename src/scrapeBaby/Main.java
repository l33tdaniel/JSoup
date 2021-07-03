package scrapeBaby;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

class Main {
    public static void main(String[] args) {
    		String html ="https://en.wikipedia.org/wiki/Cat";
    		
    		try {
    			Document doc = Jsoup.connect(html).get();
    			String title = doc.title();
    			System.out.println(title);


    		} catch(IOException e) {
    		System.out.println(e);
    		}
    		
    		try {
    			// this allows for ambiguity hopefully, but haven't tested on another machine
    			BufferedWriter simple = new BufferedWriter(new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\output.txt"));
    	        Document dope = Jsoup.connect("http://en.wikipedia.org/wiki/List_of_blogs").get();
    	        Elements trs = dope.select("table.wikitable tr");

    	        //remove header row
    	        trs.remove(0);

    	        for (Element tr : trs) {
    	            Elements tds = tr.getElementsByTag("td");
    	            Element td = tds.first();
    	            System.out.println("Blog: " + td.text());
    	            simple.write("Blog: " + td.text());
    	        }
    	        // make sure to catch memory leaks
    	        simple.close();
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	        System.out.println("Something went wrong, Oops!");
    	    }
    		String alex = System.getProperty("user.name");
    		System.out.println(alex);
    		
    		
    	}
    	

    }


