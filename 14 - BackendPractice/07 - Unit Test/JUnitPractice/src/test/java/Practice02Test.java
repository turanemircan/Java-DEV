import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

public class Practice02Test {

    //Task-8:Practice02 classının add, remove, removeAll methodlarını test ediniz.
    Practice02 object = new Practice02();

    @Test
    public void testAdd(TestInfo info) {
        object.add("Donatello");
        object.add("Leonardo");
        object.add("Raphael");
        assertTrue(object.devList.contains("Donatello"));
        assertTrue(object.devList.contains("Leonardo"));
        assertEquals(3, object.devList.size());
        System.out.println(info.getDisplayName() + " çalıştı.");
    }

    @Test
    public void testRemove(TestInfo info) {
        object.devList.add("Splinter");
        object.remove("Splinter");
        assertFalse(object.devList.contains("Splinter"));
        System.out.println(info.getDisplayName() + " çalıştı...");
    }

    @Test
    public void testRemoveAll(TestInfo info) {
        object.devList.add("Splinter");
        object.removeAll();
        assertTrue(object.devList.size() == 0);
        System.out.println(info.getDisplayName() + " çalıştı...");
    }

    @Test
    public void testSizeOfDevs(TestInfo info) {
        object.devList.clear();
        assertTrue(object.sizeOfDevs() == 0);
        object.devList.add("April");
        assertTrue(object.sizeOfDevs() == 1);
        System.out.println(info.getDisplayName() + " çalıştı...");
    }

}
