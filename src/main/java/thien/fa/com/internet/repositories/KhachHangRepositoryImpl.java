package thien.fa.com.internet.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thien.fa.com.internet.entities.KhachHang;
import thien.fa.com.internet.page.PageAble;

@Repository
public class KhachHangRepositoryImpl {

  @Autowired
  private SessionFactory sessionFactory;

  public List<KhachHang> findAll() {
    Session session = sessionFactory.getCurrentSession();
    List<KhachHang> KhachHangs = session
        .createQuery("SELECT m FROM KhachHang m", KhachHang.class)
        .getResultList();
    return KhachHangs;
  }

  public void saveOrUpdate(KhachHang KhachHang) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(KhachHang);
  }

  public void delete(KhachHang KhachHang) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(KhachHang);
  }

  public KhachHang findById(String id) {
    Session session = sessionFactory.getCurrentSession();
    return session.find(KhachHang.class, id);
  }

  public List<KhachHang> findWithPageAble(PageAble pageAble) {
    Session session = sessionFactory.getCurrentSession();
    List<KhachHang> KhachHangs = session
        .createQuery("SELECT m FROM KhachHang m", KhachHang.class)
        .setFirstResult(pageAble.getOffset())// Offset
        .setMaxResults(pageAble.getSize()) // limit
        .getResultList();

    return KhachHangs;
  }

  public long count() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("SELECT COUNT(*) FROM KhachHang m", Long.class)
        .getSingleResult();
  }

  public List<KhachHang> searchKhachHang(String searchKey, PageAble pageAble) {
    Session session = sessionFactory.getCurrentSession();
    Query<KhachHang> query = session.createQuery(
        "FROM KhachHang WHERE maKH LIKE :maKH OR diaChi LIKE :diaChi OR diaChiEmail LIKE :diaChiEmail OR soDienThoai LIKE :soDienThoai OR tenKH LIKE :tenKH",
        KhachHang.class);
    query.setParameter("maKH", "%" + searchKey + "%");
    query.setParameter("diaChi", "%" + searchKey + "%");
    query.setParameter("diaChiEmail", "%" + searchKey + "%");
    query.setParameter("soDienThoai", "%" + searchKey + "%");
    query.setParameter("tenKH", "%" + searchKey + "%");
    List<KhachHang> result = query.setFirstResult(pageAble.getOffset())// Offset
        .setMaxResults(pageAble.getSize()) // limit
        .getResultList();
    return result;
  }
}
