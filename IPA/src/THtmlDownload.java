import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class THtmlDownload {
	ArrayList<String> list = new ArrayList<String>();
	/**
	 * htmlファイルからURLを抜き出してリスト化するコンストラクタ。
	 * コンストラクタで面倒な処理を一切合財行う。
	 * @param urlString
	 */
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
	
	/**
	 * コンストラクタで生成されたリストの中からPDFファイルだけを取り出すための関数
	 * @return
	 */
	public  ArrayList<String>	getPDFsList(){
		ArrayList<String> work = new ArrayList<String>();
		for ( int i =0; i<list.size();i++){
			if ( list.get(i).indexOf(".PDF")>=0 || list.get(i).indexOf(".pdf")>=0){
				work.add(list.get(i));
				
			}
		}
		return work;
	}
	
	/**
	 * コンストラクタで生成したリストの中から、ｈｔｍｌファイルのURLだけを抜き出す。
	 * @return
	 */
	public ArrayList<String>	getHtmlsList(){
		ArrayList<String> lis = new ArrayList<String>();
		for( int i  =0; i < list.size();i++){
			if ( list.get(i).indexOf(".html")>=0 || list.get(i).indexOf(".HTML")>=0){
				lis.add(list.get(i));
			}
		}
		return lis;
	}
	


	
 }
