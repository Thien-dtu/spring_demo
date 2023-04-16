package thien.fa.com.internet.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thien.fa.com.internet.entities.May;
import thien.fa.com.internet.page.PageAble;

@Repository
public class MayRepositoryImpl {

  @Autowired
  private SessionFactory sessionFactory;

  public List<May> findAll() {
    Session session = sessionFactory.getCurrentSession();
    List<May> Mays = session.createQuery("SELECT m FROM May m", May.class)
        .getResultList();
    return Mays;
  }

  public void saveOrUpdate(May May) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(May);
  }

  public void delete(May May) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(May);
  }

  public May findById(String id) {
    Session session = sessionFactory.getCurrentSession();
    return session.find(May.class, id);
  }

  public List<May> findWithPageAble(PageAble pageAble) {
    Session session = sessionFactory.getCurrentSession();
    List<May> Mays = session.createQuery("SELECT m FROM May m", May.class)
        .setFirstResult(pageAble.getOffset())// Offset
        .setMaxResults(pageAble.getSize()) // limit
        .getResultList();

    return Mays;
  }

  public long count() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("SELECT COUNT(*) FROM May m", Long.class)
        .getSingleResult();
  }

  public List<May> search(String searchKey) {
    Session session = sessionFactory.getCurrentSession();
    Query<May> createQuery = session.createQuery(
        "SELECT p FROM May p where p.maMay like :searchKey or p.trangThai like :searchKey or p.viTri like :searchKey",
        May.class);
    createQuery.setParameter("searchKey", "%" + searchKey + "%");
    List<May> Mays = createQuery.getResultList();
    return Mays;
  }

  public List<May> searchMay(String searchKey, PageAble pageAble) {
    Session session = sessionFactory.getCurrentSession();
    Query<May> query = session.createQuery(
        "FROM May WHERE maMay LIKE :maMay OR viTri LIKE :viTri OR trangThai LIKE :trangThai",
        May.class);
    query.setParameter("maMay", "%" + searchKey + "%");
    query.setParameter("viTri", "%" + searchKey + "%");
    query.setParameter("trangThai", "%" + searchKey + "%");
    List<May> result = query.setFirstResult(pageAble.getOffset())// Offset
        .setMaxResults(pageAble.getSize()) // limit
        .getResultList();
    return result;
  }
}
