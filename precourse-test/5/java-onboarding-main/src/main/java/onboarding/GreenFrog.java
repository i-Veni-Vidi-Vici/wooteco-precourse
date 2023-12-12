package onboarding;

public class GreenFrog {
    public String speak(String listenValue) {
        StringBuilder speakValue = new StringBuilder();
        convert(listenValue, speakValue);
        return speakValue.toString();
    }

    private void convert(String value,StringBuilder speakValue){
        for (int index = 0; index < value.length(); index++) {
            if(Character.isUpperCase(value.charAt(index))){
                speakValue.append((char)(65 + 90 - value.charAt(index)));
                continue;
            }
            if(Character.isLowerCase(value.charAt(index))){
                speakValue.append((char)(97 + 122 - value.charAt(index)));
                continue;
            }

            speakValue.append(value.charAt(index));
        }
    }
}
