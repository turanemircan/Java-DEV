package BehaivoralDP.MediatorDP;

import java.util.HashMap;
import java.util.Map;

public class MessageMediator implements Mediator{

    //tüm actorleri uzman oldukları konu ile birlikte burada tutalım

    Map<String,Actor> registeredActors=new HashMap<>();

    //map e actorleri konuları ile kaydedelim
    public void register(String topic, Actor actor){

        registeredActors.put(topic,actor);

    }

    @Override
    public void dispatch(String topic, String message) {

        //topic hk uzman olan katılımcıyı bulalım
        Actor actor=registeredActors.get(topic);

        if (actor==null){
            System.out.println("Bu konu hakkında uzman bir katılımcımız bulunmamaktadır.");
        }else {
            actor.receiveMessage(message);
        }

    }
}
