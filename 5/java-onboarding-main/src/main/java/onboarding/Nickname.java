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
            Set<String> substringNicknames = new HashSet<>();
            createSeparationNickname(substringNicknames, nickname, nickname.length());
            List<List<String>> otherNicknames = nicknames.subList(index + 1, nicknames.size());

            if (findDuplication(substringNicknames, emails, otherNicknames)) {
                emails.add(nicknames.get(index).get(0));
            }
        }

        return sortEmails(emails);
    }

    private List<String> sortEmails(Set<String> emails) {
        List<String> sortedEmails = new ArrayList<>(emails);
        Collections.sort(sortedEmails);
        return sortedEmails;
    }

    private void createSeparationNickname(Set<String> substringNicknames, String nickname, Integer nicknameLength) {
        for (int startIndex = 0; startIndex < nicknameLength - 1; startIndex++) {
            for (int endIndex = startIndex + 2; endIndex < nicknameLength + 1; endIndex++) {
                substringNicknames.add(nickname.substring(startIndex, endIndex));

            }
        }
    }

    private boolean findDuplication(Set<String> substringNicknames, Set<String> emails,
                                    List<List<String>> otherNicknames) {
        boolean isDuplication = false;

        for (List<String> otherNickname : otherNicknames) {
            for (String substringNickname : substringNicknames) {
                if (otherNickname.get(1).contains(substringNickname)) {
                    emails.add(otherNickname.get(0));
                    isDuplication = true;
                }
            }
        }

        return isDuplication;
    }
}
