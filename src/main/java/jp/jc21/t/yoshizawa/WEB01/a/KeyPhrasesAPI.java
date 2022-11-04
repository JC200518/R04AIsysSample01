package jp.jc21.t.yoshizawa.WEB01.a;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import jp.jc21.t.yoshizawa.WEB01.Json05;
import jp.jc21.t.yoshizawa.WEB01.WebApiConnector;

public class KeyPhrasesAPI{
	
	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Language0 message = getLanguage("Stepover Toehold With Facelock");
		if (message != null) {
			String[] KeyPhrases = message.documents[0].keyPhrases;
			for(String s: KeyPhrases) {
				System.out.println(s);
			}
		}
	}

	static Language0 getLanguage(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3a39-text.cognitiveservices.azure.com/"
				+"text/analytics/v3.1/keyPhrases";
		Map<String,String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key","85b63c46687a483b9bf8731b835abf4b");
			
		Docs0 doc=new Docs0();
		doc.id="1";
		doc.text=s;
//		doc.language="ja";
		doc.language = Json05.getIso6391Name(s);

		Source0 src = new Source0();
		src.documents=new Docs0[1];
		src.documents[0]= doc;
		
		String jsonData = new Gson().toJson(src);

		//InetSocketAddress proxy =new InetSocketAddress("172.17.0.2", 80);

		//JsonReader reader = WebApiConnector.postJsonReader(url,proxy,map,jsonData);
		JsonReader reader = WebApiConnector.postJsonReader(url,map,jsonData);
		Language0 message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Language0.class);
			reader.close();
		}
		return message;
	}
	
}

class Language0{
	Documents0[] documents;
	String[] errors;
	String modelVersion;
}

class Documents0{	
	String id;
	String[] warnings; 
	String[] keyPhrases;
}

class Source0{
	Docs0[] documents;
}

class Docs0{
	  String language;
      String id;
      String text;
}


