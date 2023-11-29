package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nickname {
    public List<String> checkDuplication(List<List<String>> nicknames) {
        Set<String> emails = new HashSet<>();

        for (int index = 0; index < nicknames.size(); index++) {
            String nickname = nicknames.get(index).get(1);
            String email = nicknames.get(index).get(0);

            for (int otherIndex = index + 1; otherIndex < nicknames.size(); otherIndex++) {
                String otherNickname = nicknames.get(otherIndex).get(1);
                String otherEmail = nicknames.get(otherIndex).get(0);

                for (int startIndex = 0; startIndex < nicknames.get(index).get(1).length()-1 ; startIndex++) {
                    for (int endIndex = startIndex+2; endIndex <nicknames.get(index).get(1).length()+1 ; endIndex++) {
                        if (otherNickname.contains(nickname.substring(startIndex, endIndex))) {
                            emails.add(email);
                            emails.add(otherEmail);
                        }
                    }
                }
            }
        }

        List<String> sortedEmails = new ArrayList<>(emails);
        Collections.sort(sortedEmails);
        return sortedEmails;
    }
}
