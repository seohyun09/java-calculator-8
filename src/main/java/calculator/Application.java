package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int sum = 0;

        if (input.startsWith("//")) {
            int i = 2;
            StringBuilder separator = new StringBuilder();
            while (i < input.length() && input.charAt(i) != '\n') {
                separator.append(input.charAt(i));
                i++;
            }
            String numbers = input.substring(i + 1);
            String[] tokens = numbers.split(Pattern.quote(separator.toString()));
            for (String token : tokens) {
                int num = Integer.parseInt(token);
                if (num < 0) {
                    throw new IllegalArgumentException();
                }
                sum += num;
            }
        } else if (Character.isDigit(input.charAt(0))) {
            String[] tokens = input.split(",|;");
            for (String token : tokens) {
                if (Integer.parseInt(token) < 0) {
                    throw new IllegalArgumentException();
                }
                sum += Integer.parseInt(token);
            }
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println("결과 : " + sum);
    }
}
