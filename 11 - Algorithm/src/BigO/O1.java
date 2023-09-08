package BigO;

// Array ne kadar buyuk olursa olsun , algoritmanin calistirilma suresi hep sabit kalacaktir

public class O1 {  // O(1)  ---> Constant Complexity

    public static void main(String[] args) {

        int[] arr = {10, 2, 5, 34, 56, 435367543, 34343, 34344, 3434};
        // arrayin son elemanini ekrana yazdiralim
        System.out.println(arr[arr.length-1]);
    }

}
