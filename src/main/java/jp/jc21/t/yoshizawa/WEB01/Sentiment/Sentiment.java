package jp.jc21.t.yoshizawa.WEB01.Sentiment;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import jp.jc21.t.yoshizawa.WEB01.WebApiConnector;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Sentiments message = getSentiments("Stepover Toehold With Facelock");
		if (message != null) {
			System.out.println("Negative : " + message.documents[0].confidenceScores.negative);
			System.out.println("Neutral : " + message.documents[0].confidenceScores.neutral);
			System.out.println("Posetive : " + message.documents[0].confidenceScores.positive);
		}
	}

	static Sentiments getSentiments(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3a39-text.cognitiveservices.azure.com//" + "text/analytics/v3.0/sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "34ab81a55e3840279a519cf53ca4f492");

		Docs doc = new Docs();
		doc.id = "1";	
		doc.text = s;

		Source src = new Source();
		src.documents = new Docs[1];
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
	Documents[] documents;
	String[] errors;
	String modelVersion;
}

class Documents {
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

class Source {
	Docs[] documents;
}

class Docs {
	String id;
	String text;
}
