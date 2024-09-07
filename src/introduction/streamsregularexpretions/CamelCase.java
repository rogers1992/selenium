package introduction.streamsregularexpretions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CamelCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "    Case";
		String[] arrayWords = str.split("\\s+");
		String result = "";
		for(String word : arrayWords) {
			if(word.substring(0, 1).length() != 0){
                String firstLetter = word.substring(0, 1);
                String newWord = word.replaceFirst(firstLetter, firstLetter.toUpperCase());
                System.out.println(word);
                System.out.println(firstLetter);
                result = result + newWord;
                System.out.println(result);
            }
		}
			
	}

}
