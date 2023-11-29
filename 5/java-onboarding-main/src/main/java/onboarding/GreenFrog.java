package onboarding;

public class GreenFrog {
    public String convert(String value) {
        StringBuilder convertedValue = new StringBuilder();

        for (int index = 0; index < value.length(); index++) {
            if(Character.isUpperCase(value.charAt(index))){
                convertedValue.append((char)(65 + 90 - value.charAt(index)));
            }
            if(Character.isLowerCase(value.charAt(index))){
                convertedValue.append((char)(97 + 122 - value.charAt(index)));
            }
        }

        return convertedValue.toString();
    }
}
