package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationRepositoryImpl implements ReservationRepository {

    //Step 49c write saveResevation codes
    @Override
    public Reservation saveReservation(Reservation reservation) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction=session.beginTransaction();
            session.persist(reservation);

            transaction.commit();
            session.close();
            return reservation;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
