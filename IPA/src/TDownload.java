import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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