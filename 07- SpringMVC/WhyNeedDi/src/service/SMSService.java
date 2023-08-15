package service;

import domain.Message;
import repo.DbRepository;
import repo.FileRepository;
import repo.Repository;

public class SMSService implements MessageService {

    private Repository repo;

    public SMSService(Repository repo) {
        this.repo = repo;
    }

    public void sendMessage(Message message){
        System.out.println("Ben bir SMSServisiyim. Mesajınız :"+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //Repository repo=new FileRepository();
        repo.save(message);

    }


}
