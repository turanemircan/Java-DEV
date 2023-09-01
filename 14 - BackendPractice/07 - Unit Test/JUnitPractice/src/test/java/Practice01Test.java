import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class Practice01Test {

    //Task-1: Her bir testten önce Practice01 classından obje oluşturup, testten sonra null a set ediniz.

    public static Practice01 object;

//    @BeforeEach
//    public void beforeEach() {
//        object = new Practice01();
//        System.out.println("beforeEach çalıştı.");
//    }
//
//    @AfterEach
//    public void afterEach() {
//        object = null;
//        System.out.println("afterEach çalıştı");
//    }

    //Task-2-a:Practice01 classının Hypotenuse Metodunu pozitif senaryo ile test ediniz. 5-12-13
    @Test
    public void testHypotenuse() {
        double act = object.hypotenuse(5, 12);
        double exp = 13;
        assertEquals(exp, act);
    }

    //Task-2-b:Practice01 classının Hypotenuse Metodunu negatif senaryo ile test ediniz. 5-12-17
    @Test
    @DisplayName("testHypotenuseNegative")
    public void testHypotenus1(TestInfo info) {
        double act = object.hypotenuse(5, 12);
        double exp = 17;
        assertNotEquals(exp, act);
        System.out.println(info.getDisplayName() + " çalıştı");
    }

    //Task-3: Yukarıdaki Methodun görünen ismini testHypotenuseNegative yapınız
    //Task-4:Yukarıdaki testin ismini konsolda yazdırınız
    //Task-5:Tüm testlerde kullanmak üzere Practice01 classından obje oluşturup, kullanımı bitince nulla set ediniz


    @BeforeAll
    public static void beforeAll() {
        object = new Practice01();
        System.out.println("beforeAll çalıştı...");
    }
    @AfterAll
    public static void afterAll(){
        object=null;
        System.out.println("afterAll çalıştı...");
    }

    //Task-6-a:Practice01 classının isPalindrom metodunu pozitif senaryo ile test edin--neden
    @Test
    public  void testIsPalindrom(TestInfo info){
       assertTrue(object.isPalindrom("neden"));
        System.out.println(info.getDisplayName()+" çalıştı...");
    }
//Task-6-b:Practice01 classının isPalindrom metodunu negatif senaryo ile test edin
    @Test
    public void testIsPalindrom1(TestInfo info){
        assertFalse(object.isPalindrom("deneme"));
        System.out.println(info.getDisplayName()+" çalıştı...");
    }

    //Task-7:Practice01 classının Factorial metodunu 0,1,3 parametreleri için test ediniz.
    @Test
    public void testFactorial(TestInfo info){
        assertEquals(1,object.factorial(0));
        assertEquals(1,object.factorial(1));
        assertEquals(6,object.factorial(3));

        System.out.println(info.getDisplayName()+" çalıştı.");
    }
}
