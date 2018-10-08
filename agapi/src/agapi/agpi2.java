package agapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class agpi2 {
	
	public static void ReadLine(String id) throws IOException {
		URL url = new URL("https://www.ecs.soton.ac.uk/people/"+id);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream())) ;

		String CurLine;

		while ((CurLine = reader.readLine()) != null) {
		    String result = CheckLine(CurLine);
		    if (result != null){
		    	System.out.println(result);
		    	break;
		    }
		}
		reader.close();
	}
	
	public static String CheckLine(String line) {
		if (line.contains("property=\"name\">")) {
			return line.substring(line.indexOf("property=\"name\">")+16,line.indexOf("</h1><h2"));
		} else 
			return null;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string;
		string = br.readLine();
		ReadLine(string);
	}
	

}
