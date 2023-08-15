package repo;

import domain.Message;

public class DbRepository implements Repository{
    @Override
    public void save(Message message) {
        System.out.println("Mesajnız veritabanına kaydedildi. Mesajınız: "+message.getMessage());
    }
}
