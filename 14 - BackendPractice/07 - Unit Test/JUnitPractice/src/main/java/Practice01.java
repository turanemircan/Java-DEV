public class Practice01 {
    public boolean isPalindrom(String word) {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        return word.equals(reverse);
    }

    public int factorial(int number) {
        int result;
        if (number < 0) {
            throw new IllegalArgumentException("Sayı 0 dan küçük olamaz");
        } else {
            result = 1;
            for (int i = 1; i <= number; i++){
                result *= i;
            }
        }
        return  result;
    }

    public double hypotenuse(double a, double b){
        double c=Math.sqrt(a*a+b*b);
        return  c;
    }


}
