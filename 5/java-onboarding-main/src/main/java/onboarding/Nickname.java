package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nickname {
    public List<String> checkDuplication(List<List<String>> nicknames) {
        Set<String> emails = new HashSet<>();
        Set<String> substringNicknames;

        for (int index = 0; index < nicknames.size(); index++) {
            String nickname = nicknames.get(index).get(1);
            String email = nicknames.get(index).get(0);
            substringNicknames = new HashSet<>();

            createSeparationNickname(substringNicknames, nickname, nickname.length());

            for (int otherIndex = index + 1; otherIndex < nicknames.size(); otherIndex++) {
                String otherNickname = nicknames.get(otherIndex).get(1);
                String otherEmail = nicknames.get(otherIndex).get(0);

                for (String substringNickname : substringNicknames) {
                    if (otherNickname.contains(substringNickname)) {
                        emails.add(email);
                        emails.add(otherEmail);
                    }
                }

            }
        }

        List<String> sortedEmails = new ArrayList<>(emails);
        Collections.sort(sortedEmails);
        return sortedEmails;
    }

    private void createSeparationNickname(Set<String> substringNicknames, String nickname, Integer nicknameLength){
        for (int startIndex = 0; startIndex < nicknameLength - 1; startIndex++) {
            for (int endIndex = startIndex + 2; endIndex < nicknameLength + 1; endIndex++) {
                substringNicknames.add(nickname.substring(startIndex, endIndex));

            }
        }
    }
}
