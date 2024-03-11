package code.bullsAndCows;

import java.util.Random;
import java.util.Scanner;

public class BullsAndCowsGiveHint {
    String myNumber;

    Scanner scanner = new Scanner(System.in);
    public BullsAndCowsGiveHint() {
        myNumber = init();
    }

    public void start(){
        String guess="";
        System.out.println("Welcome, Please think of four numbers without repetition.");
        System.out.println("Press 1 to continue. Press other to exit");
        System.out.println("Please guess a 4-digit number without repeating digits.");
        System.out.print("Your guess is :");
        guess = scanner.next();
        while (!guess.equals(myNumber)){
            while (!isValid(guess)){
                System.out.println("Please guess a 4-digit number without repeating digits.");
                System.out.print("Your guess is :");
                guess = scanner.next();
            }
            hint(guess);
            System.out.print("Your guess is :");
            guess = scanner.next();
        }
        System.out.println("You got the right number! Congratulations!");
    }

    public void hint(String guess){
        char[] arr = guess.toCharArray();
        int bulls = 0;
        int cows = 0;
        for (char a : arr){
            if(myNumber.indexOf(a) == guess.indexOf(a)) {
                bulls ++;
            } else if (myNumber.contains(String.valueOf(a))){
                cows ++;
            }
        }
        System.out.println("Your guess has "+ bulls + " bulls and " + cows + " cows.");
        System.out.println("Please try again.");
    }
    public boolean isValid(String input){
        if (input.matches("\\d{4}")) {
            for (int i = 0; i < input.length(); i++) {
                for (int j = i + 1; j < input.length(); j++) {
                    if (input.charAt(i) == input.charAt(j)) {
                        return false; // 如果有重复字符，返回 false
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public String init(){
        StringBuilder sb = new StringBuilder(); // 用于存储生成的四位数
        Random random = new Random();

        // 生成第一位，确保不为 0
        int firstDigit = random.nextInt(9) + 1;
        sb.append(firstDigit);

        // 生成后三位，确保不重复
        while (sb.length() < 4) {
            int randomNumber = random.nextInt(10); // 生成一个位于 0 到 9 之间的随机数字
            if (sb.indexOf(String.valueOf(randomNumber)) == -1) { // 检查随机数字是否与已有数字重复
                sb.append(randomNumber); // 添加不重复的随机数字
            }
        }
        return sb.toString();
    }
}
