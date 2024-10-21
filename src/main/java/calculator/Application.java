package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer;
        String userInput;

        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.\n");
            userInput = scanner.nextLine();

            answer = calculateSum(userInput);

            System.out.printf("결과 : %d\n", answer);
            scanner.close();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            scanner.close();
        }
    }

    public static int calculateSum(String strInput) {
        String[] parsedList;
        int sum = 0;

        // 커스텀 구분자 확인
        if (strInput.startsWith("//")) {
            if(strInput.charAt(3) == '\\' && strInput.charAt(4) == 'n'){
                char separator = strInput.charAt(2);
                String numbersPart = strInput.substring(5);
                parsedList = numbersPart.split(String.valueOf(separator));
            } else{
                throw new IllegalArgumentException("잘못된 입력");
            }
        } else {
            parsedList = strInput.split("[,:]");
        }

        // 숫자 합 계산
        for (String element : parsedList) {
            if (!element.isEmpty() && element.matches("\\d+")) {
                sum += Integer.parseInt(element);
            } else {
                throw new IllegalArgumentException("잘못된 입력");
            }
        }

        return sum;
    }
}
