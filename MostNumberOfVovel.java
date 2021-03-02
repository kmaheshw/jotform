package stringManupulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MostNumberOfVovel {

	public static void main(String[] args) {
        
		String vovelWithMaxCount= maxVovel("aanbMkklaaiiiiiikkeeoousaduuuuuu");
		System.out.println("Vovel with maximum count = "+vovelWithMaxCount);
	}

	public static String maxVovel(String s) {
		String maxCountOfVovel = "";
		if (s.equals("")) { // Check if String is empty
			return "String has no elements";
		} else if (s.length() == 1) { // Check if String has one element
			return s;
		} else {

			String[] arr = (s.toLowerCase()).split(""); //Convert elements to lowercase 
			int max = 0;
			int count = 0;

			HashMap<String, Integer> map = new HashMap<>();
		    List<String> listStr = Arrays.asList("a","e","i","o","u");

			for (String ch : arr) {
				if (map.containsKey(ch) == true && listStr.contains(ch) == true) {
					count = map.get(ch) + 1;
					map.put(ch, count);
				} else if(listStr.contains(ch) == true){
					map.put(ch, 1);
				}
				if (count > max) { //check for the count if it is more replace it with old max and change vovel 
					max = count;
					maxCountOfVovel = ch;
				}
			}
		}

		return maxCountOfVovel;
	}
}
