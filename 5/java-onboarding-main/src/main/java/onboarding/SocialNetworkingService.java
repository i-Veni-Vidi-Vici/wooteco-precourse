package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SocialNetworkingService {

    private void createFriends(String user, List<List<String>> friends, List<String> myFriends) {
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (!friend.get(0).equals(user)) {
                    myFriends.add(friend.get(0));
                }
                if (!friend.get(1).equals(user)) {
                    myFriends.add(friend.get(1));
                }
            }
        }
    }

    private void createAcquaintanceScore(List<String> myFriends, List<List<String>> friends, String user,
                                 Map<String, Integer> friendRecommendation) {
        for (String myFriend : myFriends) {
            processAcquaintanceScore(friends, myFriend, user, friendRecommendation);
        }
    }

    private void processAcquaintanceScore(List<List<String>> friends, String myFriend, String user,
                                 Map<String, Integer> friendRecommendation) {
        for (List<String> friend : friends) {
            if (friend.contains(myFriend) && !friend.contains(user)) {
                addAcquaintanceScore(friend, myFriend, friendRecommendation);
            }
        }
    }

    private void addAcquaintanceScore(List<String> friend, String myFriend, Map<String, Integer> friendRecommendation) {
        for (int i = 0; i < 2; i++) {
            String currentFriend = friend.get(i);

            if (!currentFriend.equals(myFriend)) {
                int recommendation = friendRecommendation.getOrDefault(currentFriend, 0);
                friendRecommendation.put(currentFriend, recommendation + 10);
            }
        }
    }

    private void createVisitorScore(List<String> myFriends, List<String> visitors, String user,
                            Map<String, Integer> friendRecommendation) {
        for (String visitor : visitors) {
            if (!myFriends.contains(visitor) && !user.equals(visitor)) {
                friendRecommendation.put(visitor, friendRecommendation.getOrDefault(visitor, 0) + 1);
            }
        }
    }

    private List<Map.Entry<String, Integer>> sort(Map<String, Integer> friendRecommendation) {
        List<Map.Entry<String, Integer>> sortedRecommendation = new ArrayList<>(friendRecommendation.entrySet());
        sortedRecommendation.sort(new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                int valueCompare = e2.getValue().compareTo(e1.getValue());
                if (valueCompare != 0) {
                    return valueCompare; // Value가 다를 경우 내림차순 정렬
                }

                return e1.getKey().compareTo(e2.getKey()); // Value가 같을 경우 Key 기준 오름차순 정렬
            }
        });

        return sortedRecommendation;
    }

    private List<String> convertToList(Map<String, Integer> friendRecommendation) {
        List<Map.Entry<String, Integer>> sortedRecommendation = sort(friendRecommendation);
        List<String> recommendationResult = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : sortedRecommendation) {
            recommendationResult.add(entry.getKey());
        }

        return recommendationResult;
    }

    public List<String> recommend(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendRecommendation = new HashMap<>();
        List<String> myFriends = new ArrayList<>();

        createFriends(user, friends, myFriends);

        createAcquaintanceScore(myFriends, friends, user, friendRecommendation);
        createVisitorScore(myFriends, visitors, user, friendRecommendation);

        return convertToList(friendRecommendation);
    }
}
