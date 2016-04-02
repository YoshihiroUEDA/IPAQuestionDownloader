import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class THtmlDownload {
	ArrayList<String> list = new ArrayList<String>();

	public THtmlDownload(String urlString) {
		try {
			//	
			URL url = new URL( urlString);
			HttpURLConnection urlcon = (HttpURLConnection) url	.openConnection();
			urlcon.setRequestMethod("GET");
			BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream(),"UTF-8"));
			String line ;
			while ( null != (line=br.readLine())){
				if (line.indexOf("<a")>=0 && line.indexOf("href")>=0){
					String [] lists = line.split("\"");
					for (int i =0 ; i < lists.length; i++){
						if ( lists[i].indexOf("http://")>=0){
//							System.out.println( lists[i]);
							list.add(lists[i]);
						}
					}
				}
			}
			br.close();
			br=null;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	ArrayList<String> getArray(){
		return list;
	}
 }
