package timbuchalka.CollectionsFramework;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		Map<String, String> languages = new HashMap<>();
		languages.put("Java", "a compiled high level, object oriented platform independent language");
		languages.put("Python",
				"an interpreted, object oriented high level programming language with dynamic semantics");
		languages.put("Algo1", "an algorithmic language");
		languages.put("BASIC", "beginners all purposes symbolic instruction code");
		languages.put("Lisp", "Therin lies madness");

		System.out.println(languages.put("Java", "My favourite language!!")); 
		// returns the old as well as updated value
		System.out.println(languages.get("Java"));
		
		if(languages.containsKey("Algo1")) {
			System.out.println("Already there");
		}
		else 
		{
			languages.put("Algo1", "New value");
		}
		System.out.println("===============");
		for(String key: languages.keySet()) {
			System.out.println(key +" : "+languages.get(key));
		}
	}
}
