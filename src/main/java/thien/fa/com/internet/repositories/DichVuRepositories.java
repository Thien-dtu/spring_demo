package thien.fa.com.internet.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thien.fa.com.internet.entities.DichVu;
import thien.fa.com.internet.page.PageAble;

@Repository
public class DichVuRepositories {
  @Autowired
  private SessionFactory sessionFactory;
  
  public List<DichVu> findAll() {
    Session session = sessionFactory.getCurrentSession();
    List<DichVu> DichVus = session.createQuery("SELECT m FROM DichVu m", DichVu.class).getResultList();
    return DichVus;
  }

  public void saveOrUpdate(DichVu DichVu) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(DichVu);
  }

  public void delete(DichVu DichVu) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(DichVu);
  }

  public DichVu findById(String id) {
    Session session = sessionFactory.getCurrentSession();
    return session.find(DichVu.class, id);
  }

  public List<DichVu> findWithPageAble(PageAble pageAble) {
    Session session = sessionFactory.getCurrentSession();
    List<DichVu> DichVus = session.createQuery("SELECT m FROM DichVu m", DichVu.class)
        .setFirstResult(pageAble.getOffset())// Offset
        .setMaxResults(pageAble.getSize()) // limit
        .getResultList();

    return DichVus;
  }

  public long count() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("SELECT COUNT(*) FROM DichVu m", Long.class).getSingleResult();
  }
  
  public List<DichVu> searchDichVu(String searchKey, PageAble pageAble) {
    Session session = sessionFactory.getCurrentSession();
    Query<DichVu> query = session.createQuery(
        "FROM DichVu WHERE maDV LIKE :maDV OR donViTinh LIKE :donViTinh OR tenDV LIKE :tenDV",
        DichVu.class);
    query.setParameter("maDV", "%" + searchKey + "%");
//    query.setParameter("donGia", "%" + searchKey + "%");
    query.setParameter("donViTinh", "%" + searchKey + "%");
    query.setParameter("tenDV", "%" + searchKey + "%");
    List<DichVu> result = query.setFirstResult(pageAble.getOffset())// Offset
        .setMaxResults(pageAble.getSize()) // limit
        .getResultList();
    return result;
  }
}
