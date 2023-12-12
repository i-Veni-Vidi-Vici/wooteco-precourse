package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Cryptography cryptography = new Cryptography();
        return cryptography.decode(cryptogram);
    }
}
