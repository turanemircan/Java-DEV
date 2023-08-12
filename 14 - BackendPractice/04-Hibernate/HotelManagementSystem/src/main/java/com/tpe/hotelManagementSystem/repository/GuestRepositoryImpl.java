package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Address;
import com.tpe.hotelManagementSystem.domain.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GuestRepositoryImpl implements GuestRepository {

    //Step 35 c write saveGuest methods codes
    @Override
    public void saveGuest(Guest guest) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Address address=new Address();
            address.setStreet(guest.getAddress().getStreet());
            address.setCity(guest.getAddress().getCity());
            address.setCountry(guest.getAddress().getCountry());
            address.setZipCode(guest.getAddress().getZipCode());

            guest.setAddress(address);
            session.persist(guest);
            transaction.commit();
            HibernateUtils.closeSession(session);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
