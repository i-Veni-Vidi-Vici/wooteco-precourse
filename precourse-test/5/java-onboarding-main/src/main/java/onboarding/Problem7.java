package onboarding;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        SocialNetworkingService sns = new SocialNetworkingService();
        return sns.recommend(user, friends, visitors);
    }
}
