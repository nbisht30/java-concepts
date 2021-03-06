package interview;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CollectionsInterviewQuestion {

	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				if (o1.getValue().compareTo(o2.getValue()) == -1)
					return 1;
				else if (o1.getValue().compareTo(o2.getValue()) == 1)
					return -1;
				else
					return 0;
			}
		});
		HashMap<String, Integer> temp = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static void main(String[] args) {
		String data;
		HashMap<String, Integer> ipAddresses = new HashMap<>();

		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\tmp\\ipadd.txt")))) {
			while ((data = in.readLine()) != null) {
				if (ipAddresses.containsKey(data))
					ipAddresses.put(data, ipAddresses.get(data).intValue() + 1);
				else
					ipAddresses.put(data, 1);
			}
			Map<String, Integer> hm1 = sortByValue(ipAddresses);

			// print the sorted hashmap
			for (Map.Entry<String, Integer> en : hm1.entrySet()) {
				System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
