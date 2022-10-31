package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Sentiments message = getSentiments("Stepover Toehold With Facelock");
		if (message != null) {
			System.out.println("Negative : " + message.documents[0].confidenceScores.negative*100 + "%");
			System.out.println("Neutral : " + message.documents[0].confidenceScores.neutral*100 + "%");
			System.out.println("Posetive : " + message.documents[0].confidenceScores.positive*100+ "%");
		}
	}

	static Sentiments getSentiments(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3a39-text.cognitiveservices.azure.com//" + "text/analytics/v3.0/sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "85b63c46687a483b9bf8731b835abf4b");

		Docs1 doc = new Docs1();
		doc.id = "1";	
		doc.text = s;
		doc.language="ja";
		doc.language= Json05.getIso6391Name(s);


		Source1 src = new Source1();
		src.documents = new Docs1[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);

		InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		JsonReader reader = WebApiConnector.postJsonReader(url, proxy, map, jsonData);
		Sentiments message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Sentiments.class);
			reader.close();
		}
		return message;
	}
}

class Sentiments {
	Documents1[] documents;
	String[] errors;
	String modelVersion;
}

class Documents1 {
	ConfidenceScore confidenceScores;
	String id;
	Sentences[] sentences;
	String sentiment;
	String[] warnings;
}

class ConfidenceScore {
	double negative;
	double neutral;
	double positive;
}

class Sentences {
	Target[] targets;
	ConfidenceScore confidenceScores;
	int length;
	int offset;
	Assesment[] assesments;
	String sentiment;
	String text;
}

class Target {
	ConfidenceScore confidenceScores;
	int length;
	int offset;
	Relations[] relations;	
	String sentiment;
	String text;
}

class  Relations{
	String ref;
	String relationType;
}

class Assesment{
	ConfidenceScore confidenceScores;
	String isNegated;
	String length;
	String offset;
	String sentiment;
	String text;
}

class Source1 {
	Docs1[] documents;
}

class Docs1 {
	String language;
	String id;
	String text;
}
