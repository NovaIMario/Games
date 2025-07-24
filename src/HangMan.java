import java.sql.SQLOutput;
import java.util.*;

public class HangMan {
    static List<String> wordList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(wordList.isEmpty()){
            System.out.println("Add a Word: ");
            String word = scanner.nextLine().toLowerCase();
            wordList.add(word);
        }
        while(true){
            System.out.println("Would like to add more words?(Type No for No else type the word)");
            String word = scanner.nextLine().toLowerCase();
            if(word.equals("no"))break;
            wordList.add(word);
        }
        int size = wordList.size();
        int index = (int) (Math.random() * size);
        String word = wordList.get(index);
        char[] guesses = new char[word.length()];
        int lose = 0;
        int correct = 0;
        boolean printL = true;
        Set<Character> dupe = new HashSet<>();
        while(lose<7){
            for(int i=0; i<word.length(); i++){
                String str = guesses[i]==0? "_": guesses[i]+"";
                System.out.print(str+" ");
            }
            System.out.println();
            System.out.println("Type a letter: ");
            String str = scanner.nextLine();
            while(str.isEmpty()){
                System.out.println("No Empty Input Allowed");
                System.out.println("Type a letter: ");
                str = scanner.nextLine();
            }
            char c = str.charAt(0);
            while(!dupe.add(c)){
                System.out.println("Already typed it before");
                System.out.println("Type a letter: ");
                str = scanner.nextLine().toLowerCase();
                c = str.charAt(0);
            }
            boolean wrong = true;
            for(int i = 0; i<word.length(); i++){
                if(word.charAt(i)==c){
                    guesses[i]=word.charAt(i);
                    wrong = false;
                    correct++;
                }
            }
            if(wrong){
                lose++;
                System.out.println("It was wrong");
            }
            hangman(lose);
            if(correct==word.length()){
                System.out.println("You got it in "+ correct + " trie/s");
                printL = false;
                break;
            }
        }
        if(printL)System.out.println("You lost, the word was "+ word);

        scanner.close();
    }
    public static void hangman(int n){
        if (n == 0){
            System.out.println(
                    """
                            
                            
                            
                            """
            );
        }
        if (n == 1){
            System.out.println(
                    """
                        o   
                            
                            """
            );
        }
        if (n == 2){
            System.out.println(
                    """
                         o   
                         |   
                            """
            );
        }
        if (n == 3){
            System.out.println(
                    """
                           o 
                          /| 
                            """
            );
        }
        if (n == 4){
            System.out.println(
                    """
                           0 
                          /|\\ 
                            """
            );
        }
        if (n == 5){
            System.out.println(
                    """
                           0 
                          /|\\ 
                          / """
            );
        }
        if (n == 6){
            System.out.println(
                    """
                           0 
                          /|\\ 
                          / \\"""
            );
        }
    }
}
