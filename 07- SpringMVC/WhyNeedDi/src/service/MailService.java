package service;

import domain.Message;
import repo.DbRepository;
import repo.FileRepository;
import repo.Repository;

public class MailService implements MessageService{

    private Repository repo;//null

    public MailService(Repository repo) {//bağımlı old. objeyi newlemek yerine
                                         //constda parametre olarak alınmasını sağlayarak gevşek bağlı bir yapı
                                         //sağladık, repo objesini service objesini oluştururken içine enjekte ettik
        this.repo = repo;
    }

    public void sendMessage(Message message){
        System.out.println("Ben bir MailServisiyim. Mesajınız :"+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //mesajı kaydetmek için repo objesi
       // Repository repo=new FileRepository();
        repo.save(message);
    }


}
