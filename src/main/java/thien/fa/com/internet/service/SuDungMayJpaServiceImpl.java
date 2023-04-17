package thien.fa.com.internet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thien.fa.com.internet.entities.Summary;
import thien.fa.com.internet.repositories.SuDungMayJpaRepository;

@Service
public class SuDungMayJpaServiceImpl {

  @Autowired
  SuDungMayJpaRepository suDungMayJpaRepository;

  public List<Summary> findListSummary(int start, int number) {
    return suDungMayJpaRepository.findList(start, number);
  }

  public List<Summary> findListAll() {
    return suDungMayJpaRepository.findListAll();
  }

}
