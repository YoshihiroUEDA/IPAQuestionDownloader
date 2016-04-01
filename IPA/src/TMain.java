import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		new TDownload( "http://www.yahoo.co.jp", "c:\"","saas.txt");

	}

}

class TDownload {

	public TDownload(String urlString, String saveFolderName, String saveFileName) {
		URL url = null;
		HttpURLConnection urlcon = null;

		try {
			url = new URL(urlString);
			urlcon = (HttpURLConnection) url.openConnection();
			urlcon.setRequestMethod("GET");
			
			BufferedReader br =new BufferedReader( new InputStreamReader( urlcon.getInputStream()));
			String line ;
			
			System.out.println( "BufferedReader Ok.");
			while ( null != ( line=br.readLine())){
				System.out.println(line);
				
			}
			br.close();
			br=null;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("URL Object cannot created.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("HttpURLConnection object cannot created.");
			e.printStackTrace();
		}

	}
}
