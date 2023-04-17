package thien.fa.com.internet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thien.fa.com.internet.entities.SuDungMay;
import thien.fa.com.internet.entities.SuDungMayId;
import thien.fa.com.internet.page.PageAble;
import thien.fa.com.internet.repositories.SuDungMayRepositoryImpl;

@Service
public class SuDungMayServiceImpl {

	@Autowired
	private SuDungMayRepositoryImpl SuDungMayRepository;

	@Transactional
	public List<SuDungMay> findAll() {
		return SuDungMayRepository.findAll();
	}

	@Transactional
	public void saveOrUpdate(SuDungMay SuDungMay) {
		SuDungMayRepository.saveOrUpdate(SuDungMay);
	}

	@Transactional
	public void delete(SuDungMayId id) {
		SuDungMay SuDungMay = findById(id);
		if (SuDungMay != null) {
			SuDungMayRepository.delete(SuDungMay);
		}
	}

	@Transactional
	public SuDungMay findById(SuDungMayId id) {
		return SuDungMayRepository.findById(id);
	}

	@Transactional
	public List<SuDungMay> findWithPageAble(PageAble pageAble) {
		List<SuDungMay> SuDungMays = SuDungMayRepository.findWithPageAble(pageAble);
		return SuDungMays;
	}

	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = SuDungMayRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

	@Transactional
	public List<SuDungMay> search(String searchKey, PageAble pageAble) {
		return SuDungMayRepository.search(searchKey, pageAble);
	}
	
	@Transactional
  public List<SuDungMay> searchDate(String searchKey, PageAble pageAble) {
    return SuDungMayRepository.searchDate(searchKey, pageAble);
  }

	@Transactional
	public boolean existSerial(String serial) {
		return SuDungMayRepository.existSerial(serial);
	}
}
