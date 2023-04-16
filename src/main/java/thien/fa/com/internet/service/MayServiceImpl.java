package thien.fa.com.internet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thien.fa.com.internet.entities.May;
import thien.fa.com.internet.page.PageAble;
import thien.fa.com.internet.repositories.MayRepositoryImpl;

@Service
public class MayServiceImpl {

  @Autowired
  private MayRepositoryImpl repository;

  @Transactional
  public List<May> findAll() {
    return repository.findAll();
  }

  @Transactional
  public void saveOrUpdate(May may) {
    repository.saveOrUpdate(may);
  }

  @Transactional
  public List<May> search(String searchkey) {
    return repository.search(searchkey);
  }

  @Transactional
  public List<May> searchMay(String searchKey, PageAble pageAble) {
    return repository.searchMay(searchKey, pageAble);
  }

//	@Transactional
//	public void delete(String id) {
//		May May = findById(id);
//		if (May != null) {
//			repository.delete(May);
//		}
//	}

  @Transactional
  public boolean delete(String id) {
    May may = findById(id);
    if (may != null) {
      repository.delete(may);
      return true;
    } else {
      return false;
    }
  }

  @Transactional
  public May findById(String id) {
    return repository.findById(id);
  }

  @Transactional
  public List<May> findWithPageAble(PageAble pageAble) {
    return repository.findWithPageAble(pageAble);
  }

  @Transactional
  public int totalPages(PageAble pageAble) {
    long totalRecord = repository.count();
    return (int) Math.ceil((double) totalRecord / pageAble.getSize());
  }

}
