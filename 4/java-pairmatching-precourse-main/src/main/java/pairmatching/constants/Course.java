package pairmatching.constants;
public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static void checkExistence(String name){
        for (Course course : Course.values()) {
            if (course.name.equals(name)) {
                return;
            }
        }

        throw new IllegalArgumentException("[ERROR]");
    }

    public String getName() {
        return name;
    }
}
