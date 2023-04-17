package thien.fa.com.internet.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import thien.fa.com.internet.entities.SuDungMay;
import thien.fa.com.internet.entities.SuDungMayId;
import thien.fa.com.internet.entities.Summary;

@Transactional
@Repository
public interface SuDungMayJpaRepository extends JpaRepository<SuDungMay, SuDungMayId>{

  @Query(value= "select kh.maKH,kh.tenkh,m.maMay, m.ViTri , m.trangThai, sdm.ngayBatDauSuDung, sdm.gioBatDauSuDung, sdm.ThoiGianSuDung, dv.maDV,dv.tenDV,sddv.ngaySuDung, sddv.gioSuDung, sddv.soLuong, soLuong * donGia as total \r\n"
      + "from khachhang  as kh \r\n"
      + "left join sudungmay as  sdm on kh.makh = sdm.makh\r\n"
      + "left join may as m on m.maMay = sdm.maMay\r\n"
      + "left join SuDungDichVu sddv on sddv.maKH = Kh.maKH\r\n"
      + "left join DichVu dv on dv.madv = sddv.maDV\r\n"
      + "where dv.maDV is not null or m.maMay is not null\r\n"
      + "order by kh.maKH\r\n"
      + "OFFSET :start ROWS fetch NEXT :number ROWS ONLY", nativeQuery = true)
  List<Summary> findList(@Param("start") int start, @Param("number") int number);
  
  @Query(value= "select kh.maKH,kh.tenkh,m.maMay, m.ViTri , m.trangThai, sdm.ngayBatDauSuDung, sdm.gioBatDauSuDung, sdm.ThoiGianSuDung, dv.maDV,dv.tenDV,sddv.ngaySuDung, sddv.gioSuDung, sddv.soLuong, soLuong * donGia as total \r\n"
      + "from khachhang  as kh \r\n"
      + "left join sudungmay as  sdm on kh.makh = sdm.makh\r\n"
      + "left join may as m on m.maMay = sdm.maMay\r\n"
      + "left join SuDungDichVu sddv on sddv.maKH = Kh.maKH\r\n"
      + "left join DichVu dv on dv.madv = sddv.maDV\r\n"
      + "where dv.maDV is not null or m.maMay is not null\r\n", nativeQuery = true)
  List<Summary> findListAll();
}
