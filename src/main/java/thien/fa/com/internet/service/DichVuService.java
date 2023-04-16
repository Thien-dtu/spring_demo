package thien.fa.com.internet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thien.fa.com.internet.entities.DichVu;
import thien.fa.com.internet.page.PageAble;
import thien.fa.com.internet.repositories.DichVuRepositories;

@Service
public class DichVuService {
  
  @Autowired
  private DichVuRepositories repository;
  
  @Transactional
  public List<DichVu> findAll() {
    return repository.findAll();
  }

  @Transactional
  public void saveOrUpdate(DichVu DichVu) {
    repository.saveOrUpdate(DichVu);
  }

  @Transactional
  public void delete(String id) {
    DichVu DichVu = findById(id);
    if (DichVu != null) {
      repository.delete(DichVu);
    }
  }

  
  @Transactional
  public DichVu findById(String id) {
    return repository.findById(id);
  }

  @Transactional
  public List<DichVu> findWithPageAble(PageAble pageAble) {
    return repository.findWithPageAble(pageAble);
  }

  @Transactional
  public int totalPages(PageAble pageAble) {
    long totalRecord = repository.count();
    return (int) Math.ceil((double) totalRecord / pageAble.getSize());
  }

  @Transactional
  public List<DichVu> searchDichVu(String searchKey, PageAble pageAble) {
    return repository.searchDichVu(searchKey, pageAble);
  }

}
