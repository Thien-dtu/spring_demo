package thien.fa.com.internet.repositories;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thien.fa.com.internet.entities.SuDungMay;
import thien.fa.com.internet.entities.SuDungMayId;
import thien.fa.com.internet.page.PageAble;

@Repository
public class SuDungMayRepositoryImpl {

  @Autowired
  private SessionFactory sessionFactory;

  public List<SuDungMay> findAll() {
    Session session = sessionFactory.getCurrentSession();
    List<SuDungMay> SuDungMays = session
        .createQuery("SELECT p FROM SuDungMay p", SuDungMay.class)
        .getResultList();
    return SuDungMays;
  }

  public void saveOrUpdate(SuDungMay SuDungMay) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(SuDungMay);
  }

  public void delete(SuDungMay SuDungMay) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(SuDungMay);
  }

  public SuDungMay findById(SuDungMayId id) {
    Session session = sessionFactory.getCurrentSession();
    return session.find(SuDungMay.class, id);
  }

  public List<SuDungMay> findWithPageAble(PageAble pageAble) {
    Session session = sessionFactory.getCurrentSession();
    List<SuDungMay> SuDungMays = session
        .createQuery("SELECT p FROM SuDungMay p", SuDungMay.class)
        .setFirstResult(pageAble.getOffset())// Offset
        .setMaxResults(pageAble.getSize()) // limit
        .getResultList();

    return SuDungMays;
  }

  public long count() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("SELECT COUNT(*) FROM SuDungMay p", Long.class)
        .getSingleResult();
  }
  
  public List<SuDungMay> searchDate(String searchKey, PageAble pageAble) {
    Session session = sessionFactory.getCurrentSession();
    Query<SuDungMay> createQuery = session.createQuery(
        "FROM SuDungMay sdm where sdm.id.ngayBatDauSuDung = :ngayBatDauSuDung",
        SuDungMay.class);
    try {
      LocalDate ngayBatDauSuDung = LocalDate.parse(searchKey, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      createQuery.setParameter("ngayBatDauSuDung", ngayBatDauSuDung );
    } catch (DateTimeParseException ex) {
      // TODO: handle exception
      createQuery.setParameter("ngayBatDauSuDung", null);
    }
    List<SuDungMay> SuDungMays = createQuery.setFirstResult(pageAble.getOffset())// Offset
        .setMaxResults(pageAble.getSize()) // limit
        .getResultList();
    return SuDungMays;
  }

  public List<SuDungMay> search(String searchKey, PageAble pageAble) {
    Session session = sessionFactory.getCurrentSession();
    Query<SuDungMay> createQuery = session.createQuery(
        "FROM SuDungMay sdm where sdm.id.maKH like :maKH or sdm.id.maMay like :maMay or sdm.khachHang.tenKH like :tenKH or sdm.may.viTri like :viTri",
        SuDungMay.class);
    createQuery.setParameter("maKH", "%" + searchKey + "%");
    createQuery.setParameter("maMay", "%" + searchKey + "%");
    createQuery.setParameter("tenKH", "%" + searchKey + "%");
    createQuery.setParameter("viTri", "%" + searchKey + "%");
    List<SuDungMay> SuDungMays = createQuery.setFirstResult(pageAble.getOffset())// Offset
        .setMaxResults(pageAble.getSize()) // limit
        .getResultList();
    return SuDungMays;
  }

  public boolean existSerial(String serial) {
    Session session;
    try {
      session = sessionFactory.getCurrentSession();
    } catch (HibernateException e) {
      session = sessionFactory.openSession();
    }
    Query<Long> createQuery = session.createQuery(
        "SELECT COUNT(*) FROM SuDungMay p WHERE p.serial=:serial", Long.class);
    createQuery.setParameter("serial", serial);
    long totalRecord = createQuery.getSingleResult();
    System.out.println(
        "Total record with serial = " + totalRecord + " serial = " + serial);

    return totalRecord > 0;
  }
}
