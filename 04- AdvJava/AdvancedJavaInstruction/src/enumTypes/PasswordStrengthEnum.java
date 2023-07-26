package enumTypes;

public enum PasswordStrengthEnum {

    LOW(10),//0
    MEDIUM(20),//1
    HIGH(30);//2



    private final int level;

    //getter

    public int getLevel() {
        return level;
    }

    //constructor-private
    PasswordStrengthEnum(int level) {
        this.level = level;
    }
}
