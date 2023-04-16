package thien.fa.com.internet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thien.fa.com.internet.entities.SuDungDichVu;
import thien.fa.com.internet.entities.SuDungDichVuId;
import thien.fa.com.internet.page.PageAble;
import thien.fa.com.internet.repositories.SuDungDichVuRepository;

@Service
public class SuDungDichVuServiceImpl {
  
  @Autowired
  private SuDungDichVuRepository repository;
  
  @Transactional
  public List<SuDungDichVu> findAll() {
    return repository.findAll();
  }

  @Transactional
  public void saveOrUpdate(SuDungDichVu SuDungDichVu) {
    repository.saveOrUpdate(SuDungDichVu);
  }

  @Transactional
  public void delete(SuDungDichVuId id) {
    SuDungDichVu SuDungDichVu = findById(id);
    if (SuDungDichVu != null) {
      repository.delete(SuDungDichVu);
    }
  }

  @Transactional
  public SuDungDichVu findById(SuDungDichVuId id) {
    return repository.findById(id);
  }

  @Transactional
  public List<SuDungDichVu> findWithPageAble(PageAble pageAble) {
    List<SuDungDichVu> SuDungDichVus = repository.findWithPageAble(pageAble);
    return SuDungDichVus;
  }

  @Transactional
  public int totalPages(PageAble pageAble) {
    long totalRecord = repository.count();
    return (int) Math.ceil((double) totalRecord / pageAble.getSize());
  }

  @Transactional
  public List<SuDungDichVu> search(String searchKey) {
    return repository.search(searchKey);
  }

  @Transactional
  public boolean existSerial(String serial) {
    return repository.existSerial(serial);
  }
  
}
