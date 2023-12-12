package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Nickname nickname = new Nickname();
        return nickname.checkDuplication(forms);
    }
}
