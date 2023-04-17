package thien.fa.com.internet.dto;

public class SuDungMayDto {
  private String maKH;
  private String maMay;
  private String ngayBatDauSuDung;
  private int thoiGianSuDung;
  private String gioBatDauSuDung;

  public SuDungMayDto() {
    super();
  }

  public SuDungMayDto(String maKH, String maMay, String ngayBatDauSuDung,
      int thoiGianSuDung, String gioBatDauSuDung) {
    super();
    this.maKH = maKH;
    this.maMay = maMay;
    this.ngayBatDauSuDung = ngayBatDauSuDung;
    this.thoiGianSuDung = thoiGianSuDung;
    this.gioBatDauSuDung = gioBatDauSuDung;
  }

  @Override
  public String toString() {
    return "SuDungMayDto [maKH=" + maKH + ", maMay=" + maMay
        + ", ngayBatDauSuDung=" + ngayBatDauSuDung + ", thoiGianSuDung="
        + thoiGianSuDung + ", gioBatDauSuDung=" + gioBatDauSuDung + "]";
  }

  public String getMaKH() {
    return maKH;
  }

  public void setMaKH(String maKH) {
    this.maKH = maKH;
  }

  public String getMaMay() {
    return maMay;
  }

  public void setMaMay(String maMay) {
    this.maMay = maMay;
  }

  public String getNgayBatDauSuDung() {
    return ngayBatDauSuDung;
  }

  public void setNgayBatDauSuDung(String ngayBatDauSuDung) {
    this.ngayBatDauSuDung = ngayBatDauSuDung;
  }

  public int getThoiGianSuDung() {
    return thoiGianSuDung;
  }

  public void setThoiGianSuDung(int thoiGianSuDung) {
    this.thoiGianSuDung = thoiGianSuDung;
  }

  public String getGioBatDauSuDung() {
    return gioBatDauSuDung;
  }

  public void setGioBatDauSuDung(String gioBatDauSuDung) {
    this.gioBatDauSuDung = gioBatDauSuDung;
  }

  

}
