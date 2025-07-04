import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiffCopies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        String input = scanner.nextLine();
        scanner.close();
        List<Character> list = new ArrayList<>();
        for(int i = 0; i<input.length(); i++){
            list.add(input.charAt(i));
        }
        List<List<Character>> listOfList = new ArrayList<>();
        generator(list, listOfList, new ArrayList<>());
        for(List<Character>li: listOfList){
            System.out.println(li);
        }

    }
    private static void generator(List<Character> list, List<List<Character>> listOfList, List<Character> res){
        if(list.isEmpty()){
            listOfList.add(res);
            return;
        }
        for(char c: list){
            List<Character> newList = new ArrayList<>(list);
            newList.remove(Character.valueOf(c));
            List<Character> newRes = new ArrayList<>(res);
            newRes.add(c);
            generator(newList, listOfList, newRes);
        }
    }
}
