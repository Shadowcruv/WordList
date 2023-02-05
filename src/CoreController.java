
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CoreController {
    private FileManager fileManager;
    private WordList wordList;
    private subCore  core;
    private String Dfile;
    private Scanner scanner;

    public static void main(String[] args)throws Exception{
        CoreController coreController = new CoreController();
        coreController.start();

    }

    public CoreController(){
        fileManager = new FileManager();
        wordList = new WordList();
        Dfile = new String("");
        core = new subCore();
        scanner = new Scanner(System.in);
    }

    public void start() throws Exception{
     System.out.println("Do you want to use this software? yes or no ");
      String ans = scanner.next();
        while (true) {
          if (ans.equals("no")){
              break;
          }
            pracLike();
            System.out.println("Do you still want to use this software? yes or no ");
            ans = scanner.next();

      }
        System.out.println("Thanks for using the software");
    }

    public void pracLike() {
        String nanu = "Did not process";
        try {
            //File opened is returned to nanu as String
            nanu = fileManager.openFile();
        } catch (FileNotFoundException f) {
            System.out.println("file not found" + f.getMessage() + " " + f.getStackTrace());
        } catch (IOException e) {
            System.out.println("file cannot open" + e.getMessage() + " " + e.getStackTrace());
        }
        System.out.println("nanu : " + nanu);
         //Returned Concordance to Dfile
        Dfile = core.extractPattern(nanu);
        System.out.println("Dfile: "+ Dfile);

        try {
            fileManager.saveFile(Dfile);
        } catch(IOException x){
            System.out.println("File cannot save");
        }
        System.out.println("...Finished Saving.  You can now check your wordlist in the location in which" +
                " it was saved");
    }
}
