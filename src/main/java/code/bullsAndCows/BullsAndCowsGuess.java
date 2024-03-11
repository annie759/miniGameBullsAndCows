package code.bullsAndCows;

import java.util.*;

public class BullsAndCowsGuess {
    Scanner scanner = new Scanner(System.in);
    List<String> uniqueNumbers = new ArrayList<>();
    HashMap<String, Integer> possibleAnswer = new HashMap<>();
    List<String> possibleAnswerList = new ArrayList<>();
    List<String> impossibleAnserList = new ArrayList<>();

    public BullsAndCowsGuess() {
        this.initNumbers();
    }
    public void initNumbers() {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == i) continue;
                for (int k = 0; k < 10; k++) {
                    if (k == i || k == j) continue;
                    for (int l = 0; l < 10; l++) {
                        if (l == i || l == j || l == k) continue;
                        String number = "" + i + j + k + l;
                        uniqueNumbers.remove(number);
                        uniqueNumbers.add(number);
                    }
                }
            }
        }
    }
    public void start(){
        System.out.println("Welcome, Please think of four numbers without repetition.");
        System.out.println("Press 1 to continue. Press other to exit");
        int a = Integer.parseInt(scanner.next());
        if (a != 1) {
            System.out.println("Bye!");
            return;
        }
        int bulls = 0;
        int cows = 0;
        int count = 1;
        Random random = new Random(47);
        String myGuess = uniqueNumbers.get(random.nextInt(uniqueNumbers.size()));
        while (bulls != 4) {
            System.out.println("My guess:" + myGuess);
            System.out.print("How many bulls?");
            bulls = scanner.nextInt();
            if (bulls == 4) break;
            System.out.println();
            System.out.print("How many cows?");
            cows = scanner.nextInt();
            System.out.println();
            generatePossibleAns(myGuess, bulls , cows);
            if (possibleAnswerList.isEmpty()) {
                System.out.println("According to your hint, I can't find any possible answers.");
                count = 0;
            }else {
                myGuess = possibleAnswerList.get(random.nextInt(possibleAnswerList.size()));
            }
            count ++;
        }
        if (count != 0) {
            System.out.println("Your num is : " + myGuess);
            System.out.println("total guessing num :" + count);
        }
    }
    public void generatePossibleAns(String myGuess, int bulls, int cows){
        impossibleAnserList.add(myGuess);
        possibleAnswerList.remove(myGuess);
        possibleAnswer.remove(myGuess);
        Iterator<String> iterator = uniqueNumbers.iterator();
        char[] arr = myGuess.toCharArray();
        while (iterator.hasNext()) {
            String num = iterator.next();
            int curBulls = 0;
            int curCows = 0;
            for (char c : arr) {
                if (num.indexOf(c) == myGuess.indexOf(c)) {
                    ++ curBulls;
                    if (curBulls > bulls) removeImpossibleAns(num);
                }else {
                    if (num.contains(String.valueOf(c))){
                        ++ curCows;
                        if (curCows > cows) removeImpossibleAns(num);
                    }
                }
            }
            if (curBulls == bulls && curCows == cows) {
                addPossibleAns(num, cows+bulls);
            } else {
                removeImpossibleAns(num);
            }
        }
    }

    public void removeImpossibleAns(String num){
        impossibleAnserList.remove(num);
        impossibleAnserList.add(num);
        possibleAnswerList.remove(num);
        possibleAnswer.remove(num);
    }

    public void addPossibleAns(String num, int total){
        if(!impossibleAnserList.contains(num)) {
            possibleAnswerList.remove(num);
            possibleAnswerList.add(num);
            possibleAnswer.put(num, total);
        }
    }
}
