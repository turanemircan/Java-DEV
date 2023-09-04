public class Practice04 {

    Practice05 divisibleMethods;

    public Practice04(Practice05 divisibleMethods) {
        this.divisibleMethods = divisibleMethods;
    }

    public boolean ifNumberCanBeDividedBy6(int number) {
        if (divisibleMethods.findRemainderDividedBy2(number) == 0 && divisibleMethods.findRemainderDividedBy3(number) == 0) {
            return true;
        } else return false;

    }


}
