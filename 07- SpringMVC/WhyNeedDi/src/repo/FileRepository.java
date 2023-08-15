package repo;

import domain.Message;

public class FileRepository implements Repository{
    @Override
    public void save(Message message) {
        System.out.println("Mesajnız dosyaya kaydedildi. Mesajınız: "+message.getMessage());

    }
}
