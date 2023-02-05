import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class subCore {
 private WordList kist;


   public subCore(){
    kist = new WordList();

   }
    //Method meant to extract the words and place them in the wordlist
   public String extractPattern(String yeah) throws NullPointerException {
       //Clear the wordlist
        kist.reset();
        String yes = "pattern FAILED";
       Pattern pattern = Pattern.compile("\\w+");
       Matcher matcher = pattern.matcher(yeah);
       //Continues iterating until it doesnt find any word again
        while(matcher.find()){
        //Adds word to the Wordlist
             kist.add(yeah.substring(matcher.start(),matcher.end()));
        }
        System.out.println("Finished adding");
       yes= kist.getConcordance();


       return yes;
   }
}