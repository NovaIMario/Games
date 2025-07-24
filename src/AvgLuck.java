import java.util.Scanner;

public class AvgLuck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int costOfHouse = 90, increment = 80, finish = 8;
        System.out.println("In this sim the year finish in "+finish+" eg. "+finish+"->10");
        System.out.println("Assumptions: 1year + "+increment+" pounds, 1house = "+costOfHouse+" pounds and 1mansion = 7houses");
        System.out.println("What year did u start(assuming end of year): ");
        int current = scanner.nextInt();
        System.out.println("What year are you currently at: ");
        int next = scanner.nextInt();
        System.out.println("How many houses do you have: ");
        int house = scanner.nextInt();
        System.out.println("How much money do you have: ");
        int money = scanner.nextInt();
        int nextb4 = next/10, curb4 = current/10, next1 = next%10, cur1 = current%10;
        int dif = (nextb4-curb4)*(finish+1)+(next1-cur1>=0?next1-cur1: next1-cur1-1);
        int totalMoney = dif*80-money;
        System.out.println("Your luck is "+(house==0? 0: totalMoney/house) +" pounds per house");
        scanner.close();
    }
}
