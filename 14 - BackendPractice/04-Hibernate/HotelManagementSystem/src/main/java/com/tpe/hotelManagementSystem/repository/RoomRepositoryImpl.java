package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.domain.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

    @Override
    public Room findRoomById(Long roomId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.get(Room.class, roomId);
    }

    @Override
    public List<Room> findAllRoom() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "FROM Room";
            List<Room> rooms = session.createQuery(hql, Room.class).getResultList();
            return rooms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteRoomById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Room room = session.get(Room.class, id);
            if (room != null) {
                // hotel listesinden room u kaldırmak gerek
                Hotel hotel = room.getHotel();
                if (hotel != null) {
                    hotel.getRooms().remove(room);
                }
                // Oda silme işlemi
                session.delete(room);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}