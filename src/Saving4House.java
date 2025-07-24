import java.util.Scanner;

public class Saving4House{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int costOfHouse = 90, increment = 80, finish = 8;
        System.out.println("In this sim the year finish in "+finish+" eg. "+finish+"->10");
        System.out.println("Assumptions: 1year + "+increment+" pounds, 1house = "+costOfHouse+" pounds and 1mansion = 7houses");
        System.out.println("What year u at(assuming end of year): ");
        int current = scanner.nextInt();
        System.out.println("How many houses do you have: ");
        int house = scanner.nextInt();
        System.out.println("How much money do you have: ");
        int money = scanner.nextInt();
        System.out.println("How many houses do you want: ");
        int houseWant = scanner.nextInt();
        int aimHouse = houseWant - house;
        int year = ((int) Math.ceil((double)aimHouse*costOfHouse/increment))/(finish+1)*10+((int) Math.ceil((double)aimHouse*costOfHouse/increment))%(finish+1);
        int display = (current/10 + year/10)*10 + ((current%10+year%10>=9)? current%10+year%10+1: current%10+year%10);
        System.out.println("The year will be: "+ year);
        scanner.close();
    }
}
