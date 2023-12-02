package menu.constants;

public enum Menu {
    // 일식
    GYUDON("규동", "일식"),
    UDON("우동", "일식"),
    MISOSHIRU("미소시루", "일식"),
    SUSHI("스시", "일식"),
    KATSUDON("가츠동", "일식"),
    ONIGIRI("오니기리", "일식"),
    HAYALICE("하이라이스", "일식"),
    RAMEN("라멘", "일식"),
    OKONOMIYAKI("오코노미야끼", "일식"),

    // 한식
    GIMBAP("김밥", "한식"),
    KIMCHI_STEW("김치찌개", "한식"),
    SSAMBAP("쌈밥", "한식"),
    DOENJANG_STEW("된장찌개", "한식"),
    BIBIMBAP("비빔밥", "한식"),
    KALGUKSU("칼국수", "한식"),
    BULGOGI("불고기", "한식"),
    TTEOKBOKKI("떡볶이", "한식"),
    JAEYUK_BOKKEUM("제육볶음", "한식"),

    // 중식
    KANPOONG_GI("깐풍기", "중식"),
    STIR_FRIED_NOODLES("볶음면", "중식"),
    TONGPA_YOOK("동파육", "중식"),
    JAJANGMYEON("짜장면", "중식"),
    JJAMPPONG("짬뽕", "중식"),
    MAPA_TOFU("마파두부", "중식"),
    TANGSUYUK("탕수육", "중식"),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음", "중식"),
    GOCHUJJAPCHAE("고추잡채", "중식"),

    // 아시안
    PAD_THAI("팟타이", "아시안"),
    KHAO_PAD("카오 팟", "아시안"),
    NASI_GORENG("나시고렝", "아시안"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", "아시안"),
    PHO("쌀국수", "아시안"),
    TOM_YUM_GOONG("똠얌꿍", "아시안"),
    BANH_MI("반미", "아시안"),
    FRESH_SPRING_ROLLS("월남쌈", "아시안"),
    BUNJJA("분짜", "아시안"),

    // 양식
    LASAGNA("라자냐", "양식"),
    GRATIN("그라탱", "양식"),
    NYOKKI("뇨끼", "양식"),
    KISHU("끼슈", "양식"),
    FRENCH_TOAST("프렌치 토스트", "양식"),
    BAGUETTE("바게트", "양식"),
    SPAGHETTI("스파게티", "양식"),
    PIZZA("피자", "양식"),
    PANINI("파니니", "양식");


    private final String menu;
    private final String category;

    Menu(String menu, String category) {
        this.menu = menu;
        this.category = category;
    }

    public String getMenu() {
        return menu;
    }

    public String getCategory() {
        return category;
    }

    public static boolean checkExistence(String menuName){
        for (Menu menu : Menu.values()) {
            if (menu.getMenu().equals(menuName)) {
                return true;
            }
        }

        return false;
    }
}
