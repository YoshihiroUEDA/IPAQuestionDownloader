import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class TMain {
	static final String  urlmoji = "https://www.jitec.ipa.go.jp/1_04hanni_sukiru/mondai_kaitou_2015h27_2/2015h27a_fe_am_qs.pdf";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		String [] list = urlmoji.split("/");
		String filename = list[list.length-1];
		
		THtmlDownload obj = new THtmlDownload("https://www.jitec.ipa.go.jp/1_04hanni_sukiru/_index_mondai.html");
		ArrayList <String> listBase = obj.getArray();
		//	item “WŠJ
//		ArrayList <String> work =new ArrayList<String> ();
		for( int i =0; i< listBase.size(); i++){
			
		}
//		new TDownload( urlmoji,
//				"C:\\Users\\ueda\\Desktop",filename);
		

	}

}



class TDownload {

	public TDownload(String urlString, String saveFolderName, String saveFileName) {
		
		System.out.println( "urlString = " + urlString);
		System.out.println( "saveFolderName = " + saveFolderName);
		System.out.println( "saveFilename = " + saveFileName	);
		String saveFilePath = saveFolderName+File.separator+saveFileName; 
				System.out.println( "savePath = "+saveFilePath);
		
		
		URL url = null;
		URLConnection urlcon=null;
		
		BufferedReader br =null; 
		FileOutputStream fos =null;
		
		try {
			url = new URL(urlString);
			 urlcon = url.openConnection();
			InputStream is = urlcon.getInputStream();
			File fout = new File( saveFilePath	);
			FileOutputStream out = new FileOutputStream( fout, false	);
			byte [] bytes = new byte[1024*1024	];
			
			while(true ){
				int ret = is.read(bytes);
//				System.out.print( "["+ ret+"]");
				if ( ret <=0 )			break;
				out.write(bytes,0,ret);
				
			}
			out.close();
			out=null;
			is.close();
			is=null;
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
