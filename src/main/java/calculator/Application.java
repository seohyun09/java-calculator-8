package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int sum = 0;

        if (input.startsWith("//")) {
            String[] parts = input.split("\\\\n", 2);

            if (parts.length < 2) {
                throw new IllegalArgumentException();
            }

            String separator = parts[0].substring(2);
            String numbers = parts[1];

            String[] tokens = numbers.split(Pattern.quote(separator));
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
