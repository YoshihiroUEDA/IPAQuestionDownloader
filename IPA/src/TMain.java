import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class TMain {
	static final String  urlmoji = "https://www.jitec.ipa.go.jp/1_04hanni_sukiru/mondai_kaitou_2015h27_2/2015h27a_fe_am_qs.pdf";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		String [] list = urlmoji.split("/");
		String filename = list[list.length-1];
		
		THtmlDownload obj = new THtmlDownload("https://www.jitec.ipa.go.jp/1_04hanni_sukiru/_index_mondai.html");
		ArrayList<String> tmps = obj.getPDFsList();
		System.out.println( "pdf unit size = "+ tmps.size());
		for (int i  =0; i<tmps.size(); i++){
			System.out.println( tmps.get(i));
			
		}
		
		tmps = obj.getHtmlsList();
		System.out.println( "html unit size = "+ tmps.size());
		for (int i  =0; i<tmps.size(); i++){
			System.out.println( tmps.get(i));
			
		}
		
	
//		new TDownload( urlmoji,
//				"C:\\Users\\ueda\\Desktop",filename);
		

	}

}
