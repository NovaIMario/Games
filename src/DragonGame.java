import java.util.Scanner;

public class DragonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A dragon is incoming to your hometown, defeat it before it destroys ur hometown");
        int dragonHp = 100, dragonAtk = 30;
        int hp = 50, atk = 10, money = 0, day = 0, maxHp = 50;
        String s = "";
        while(day<7){
            System.out.println("Hp: "+hp+", atk: " +atk+", day: "+day);
            while(!s.equals("s") && !s.equals("m") && !s.equals("r")){
                System.out.println("What to do?(s to kill slime, m to kill monster, r to rest)");
                s = scanner.next().toLowerCase();
                scanner.nextLine();
                if(s.equals("s")){
                    int slimeHp = 25;
                    hp-=(slimeHp/atk)*5; money+=5;
                }
                else if(s.equals("m")){
                    int monsterHp = 50;
                    hp-=(monsterHp/atk)*20; money+=50;
                }
                else{
                    hp = maxHp;
                }
            }
            System.out.println("Hp: "+hp+", atk: " +atk+", day: "+day);
            if(hp<=0)break;
            System.out.println("Shop(keyToBuy, cost, effect)");
            System.out.println("Wood Sword(a, 5, +30Atk), Iron Sword(b, 20, +50Atk), Armor(c, 10, +10hp)");
            System.out.println("What item to buy?(q to quit)(Current money: "+money+" gold)");
            String option = scanner.next().toLowerCase();
            while(!option.equals("q")){
                if(option.equals("a")){
                    if(money<5){
                        System.out.println("not enough gold to buy");
                    }
                    atk = Math.max(atk, 30); money -=5;
                }
                else if(option.equals("b")){
                    if(money<20){
                        System.out.println("not enough gold to buy");
                    }
                    atk = Math.max(atk, 50); money-=20;
                }
                else if(option.equals("c")){
                    if(money<10){
                        System.out.println("not enough gold to buy");
                    }
                    maxHp += 10; money-=10;
                }
                else if(option.equals("hp")){
                    System.out.println("Well done to spot the UpperCase");
                    maxHp+=1000; atk = 1;
                }
                System.out.println("What item to buy?(q to quit)(Current money: "+money+" gold)");
                option = scanner.next().toLowerCase();
                scanner.nextLine();
            }
            day++; s = "";
        }
        if(hp<=0){
            System.out.println("The supposedly supposed to be hero died");
        }
        else{
            System.out.println("The day of dragon attack has come");
            hp-=(dragonHp/atk)*dragonAtk;
            if(hp>0){
                System.out.println("The hero killed the dragon without much trouble! Truly a hero");
            }
            else if(hp<0){
                System.out.println("The supposedly supposed to be hero died, but at least he tried");
            }
            else{
                System.out.println("The hero died together with the dragon, at last he accomplished his mission");
            }

        }
        scanner.close();
    }
}
