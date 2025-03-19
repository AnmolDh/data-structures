public class SearchSpecificWord{
  public static String findWord(String[] sentences, String word){
    for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
  }

  public static void main(String[] args){
    String[] sentences = {
            "This is the first sentence.",
            "Another example of a sentence.",
            "Here is the word we are looking for: magic.",
            "Yet another sentence with no match."
        };
        
        String searchWord = "magic";

        String result = findWord(sentences, searchWord);
        System.out.println(result);
  }
}