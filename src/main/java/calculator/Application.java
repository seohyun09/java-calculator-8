package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력값 검증
        if (input.startsWith("//")) {
            int i = 2;
            StringBuilder separator = new StringBuilder();
            while (i < input.length() && input.charAt(i) != '\n') {
                separator.append(input.charAt(i));
                i++;
            }
        }
    }
}
