package day3.mocking.sample1;

public class UserService {

    private final UserManager userManager;

    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    //bu metodu test edelim
    public String getUserById(int userId){

        //başka kodlar

        String user="User "+userManager.getUser(userId);
        //getUser(1) den beklenen "Jack Sparrow" döndürmesi

        return user;

    }

}
