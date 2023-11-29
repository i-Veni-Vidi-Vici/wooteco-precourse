package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SocialNetworkingService {
    public List<String> recommend(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendRecommendation = new HashMap<>();
        List<String> myFriends = new ArrayList<>();

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

        for (String myFriend : myFriends) {
            for (List<String> friend : friends) {
                if (friend.contains(myFriend) && !friend.contains(user)) {
                    if (!friend.get(0).equals(myFriend) && friendRecommendation.containsKey(friend.get(0))) {
                        friendRecommendation.replace(friend.get(0), friendRecommendation.get(friend.get(0)) + 10);
                    }
                    if (!friend.get(1).equals(myFriend) && friendRecommendation.containsKey(friend.get(1))) {
                        friendRecommendation.replace(friend.get(1), friendRecommendation.get(friend.get(1)) + 10);
                    }
                    if (!friend.get(0).equals(myFriend) && !friendRecommendation.containsKey(friend.get(0))) {
                        friendRecommendation.put(friend.get(0), 10);
                    }
                    if (!friend.get(1).equals(myFriend) && !friendRecommendation.containsKey(friend.get(1))) {
                        friendRecommendation.put(friend.get(1), 10);
                    }

                }
            }
        }

        for (String visitor : visitors) {
            if (!myFriends.contains(visitor) && !user.equals(visitor)) {
                if (friendRecommendation.containsKey(visitor)) {
                    friendRecommendation.replace(visitor, friendRecommendation.get(visitor) + 1);
                }
                if (!friendRecommendation.containsKey(visitor)) {
                    friendRecommendation.put(visitor, 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> sortedRecommendation = new ArrayList<>(friendRecommendation.entrySet());
        sortedRecommendation.sort(new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                int valueCompare = e2.getValue().compareTo(e1.getValue());
                if (valueCompare != 0) {
                    return valueCompare; // Value가 다를 경우 내림차순 정렬
                } else {
                    return e1.getKey().compareTo(e2.getKey()); // Value가 같을 경우 Key 기준 오름차순 정렬
                }
            }
        });

        List<String> recommendationResult = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : sortedRecommendation) {
            recommendationResult.add(entry.getKey());
        }

        return recommendationResult;
    }
}
