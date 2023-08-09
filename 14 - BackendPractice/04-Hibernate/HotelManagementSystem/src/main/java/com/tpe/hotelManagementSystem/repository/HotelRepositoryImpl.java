package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HotelRepositoryImpl implements HotelRepository{
    @Override
    public Hotel saveHotel(Hotel hotel) {
        try(Session session= HibernateUtils.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(hotel);
            transaction.commit();
            HibernateUtils.closeSession(session); //session.close();
            return hotel;
        }catch (Exception e){
            e.printStackTrace(); //Hatanın nerede hangi methodda tetiklendiğini bildirir
        }

        return null;
    }

    @Override
    public Hotel findHotelById(Long id) {

        Session session=HibernateUtils.getSessionFactory().openSession();

        return session.get(Hotel.class,id);

    }
}
