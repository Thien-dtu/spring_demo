package thien.fa.com.internet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thien.fa.com.internet.entities.KhachHang;
import thien.fa.com.internet.page.PageAble;
import thien.fa.com.internet.repositories.KhachHangRepositoryImpl;

@Service
public class KhachHangServiceImpl {

	@Autowired
	private KhachHangRepositoryImpl repository;

	@Transactional
	public List<KhachHang> findAll() {
		return repository.findAll();
	}

	@Transactional
	public void saveOrUpdate(KhachHang KhachHang) {
		repository.saveOrUpdate(KhachHang);
	}

	@Transactional
	public void delete(String id) {
		KhachHang KhachHang = findById(id);
		if (KhachHang != null) {
			repository.delete(KhachHang);
		}
	}

	@Transactional
	public KhachHang findById(String id) {
		return repository.findById(id);
	}

	@Transactional
	public List<KhachHang> findWithPageAble(PageAble pageAble) {
		return repository.findWithPageAble(pageAble);
	}

	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = repository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	
  @Transactional
  public List<KhachHang> searchKhachHang(String searchKey, PageAble pageAble) {
    return repository.searchKhachHang(searchKey, pageAble);
  }

}
