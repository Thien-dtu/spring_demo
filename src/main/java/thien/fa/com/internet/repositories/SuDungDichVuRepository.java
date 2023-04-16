package thien.fa.com.internet.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thien.fa.com.internet.entities.SuDungDichVu;
import thien.fa.com.internet.entities.SuDungDichVuId;
import thien.fa.com.internet.page.PageAble;

@Repository
public class SuDungDichVuRepository {
  
  @Autowired
  private SessionFactory sessionFactory;
  
  public List<SuDungDichVu> findAll() {
    Session session = sessionFactory.getCurrentSession();
    List<SuDungDichVu> SuDungDichVus = session.createQuery("SELECT p FROM SuDungDichVu p", SuDungDichVu.class).getResultList();
    return SuDungDichVus;
  }
  
  public void saveOrUpdate(SuDungDichVu SuDungDichVu) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(SuDungDichVu);
  }
  
  public void delete(SuDungDichVu SuDungDichVu) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(SuDungDichVu);
  }

  public SuDungDichVu findById(SuDungDichVuId id) {
    Session session = sessionFactory.getCurrentSession();
    return session.find(SuDungDichVu.class, id);
  }

  public List<SuDungDichVu> findWithPageAble(PageAble pageAble) {
    Session session = sessionFactory.getCurrentSession();
    List<SuDungDichVu> SuDungDichVus = session.createQuery("SELECT p FROM SuDungDichVu p", SuDungDichVu.class)
        .setFirstResult(pageAble.getOffset())// Offset
        .setMaxResults(pageAble.getSize()) // limit
        .getResultList();

    return SuDungDichVus;
  }

  public long count() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("SELECT COUNT(*) FROM SuDungDichVu p", Long.class).getSingleResult();
  }

  public List<SuDungDichVu> search(String searchKey) {
    Session session = sessionFactory.getCurrentSession();
    Query<SuDungDichVu> createQuery = session.createQuery("FROM SuDungDichVu p where p.name like :searchKey",
        SuDungDichVu.class);
    createQuery.setParameter("searchKey", "%" + searchKey + "%");
    List<SuDungDichVu> SuDungDichVus = createQuery.getResultList();
    return SuDungDichVus;
  }

  public boolean existSerial(String serial) {
    Session session;
    try {
      session = sessionFactory.getCurrentSession();
    } catch (HibernateException e) {
      session = sessionFactory.openSession();
    }
    Query<Long> createQuery = session.createQuery("SELECT COUNT(*) FROM SuDungDichVu p WHERE p.serial=:serial",
        Long.class);
    createQuery.setParameter("serial", serial);
    long totalRecord = createQuery.getSingleResult();
    System.out.println("Total record with serial = " + totalRecord + " serial = " + serial);

    return totalRecord > 0;
  }


}
