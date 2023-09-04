import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class Practice03Test {
    //Task-6:Practice03 classının addDeveloper,removeDeveloper,removeAllDeveloper methodlarını test ediniz

    //Practice02 object=new Practice02();

    Practice02 mockRepo = mock(Practice02.class);
    Practice03 service = new Practice03(mockRepo);
    Practice03 mockService = mock(Practice03.class);

    @Test
    public void testAddDeveloper() {
        service.addDeveloper("Donatello");
        verify(mockRepo).add("Donatello");
        verify(mockRepo, times(1));
    }

    @Test
    public void testRemoveDeveloper() {
        when(mockRepo.findByName("Raphael")).thenReturn("Raphael");
        service.addDeveloper("Raphael");
        service.removeDeveloper("Raphael");
        verify(mockRepo).findByName("Raphael");
        verify(mockRepo).remove("Raphael");
    }

    @Test
    public void testRemoveDeveloper1() {
        when(mockRepo.findByName("Raphael")).thenReturn("Raphael");
        mockService.addDeveloper("Raphael");
        service.removeDeveloper("Raphael");
        verify(mockRepo).findByName("Raphael");
        verify(mockRepo).remove("Raphael");
        verify(mockService).addDeveloper("Raphael");
    }

    @Test
    public void testRemoveAllDeveloper(){
        mockService.addDeveloper("Raphael");
        service.removeAllDeveloper();
        verify(mockRepo).removeAll();
        verify(mockService).addDeveloper("Raphael");
    }
}
