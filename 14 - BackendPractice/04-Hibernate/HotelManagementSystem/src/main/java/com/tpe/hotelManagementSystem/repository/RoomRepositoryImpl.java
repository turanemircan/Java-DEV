package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public Room saveRoom(Room room) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) { //hazır methodlardan bir session açtık
            Transaction transaction = session.beginTransaction(); //session dan transaction üretildi
            session.persist(room);  //room objesi db ye kaydedildi
            transaction.commit(); //commitlemesek db de kalıcı olmaz
            HibernateUtils.closeSession(session); //session kapatıldı //session.close() aynı işlevi yapar
            return room;
        } catch (Exception e) {
            e.printStackTrace();  //hatanın nerede ve hangi methodta tetiklediğini gösterir
            return null;
        }
    }
}
