package thien.fa.com.internet.dto;

public class SuDungDichVuDto {
  private String maKH;
  private String tenKH;
  private String maDV;
  private String tenDV;
  private String donViTinh;
  private String donGia;
  private String ngaySuDung;
  private String gioSuDung;
  private String soLuong;
  private String tongTien;

  public SuDungDichVuDto() {
    super();
  }
  
  public SuDungDichVuDto(String maKH, String tenKH, String maDV, String tenDV,
      String donViTinh, String donGia, String ngaySuDung, String gioSuDung,
      String soLuong, String tongTien) {
    super();
    this.maKH = maKH;
    this.tenKH = tenKH;
    this.maDV = maDV;
    this.tenDV = tenDV;
    this.donViTinh = donViTinh;
    this.donGia = donGia;
    this.ngaySuDung = ngaySuDung;
    this.gioSuDung = gioSuDung;
    this.soLuong = soLuong;
    this.tongTien = tongTien;
  }



  public String getMaKH() {
    return maKH;
  }
  public void setMaKH(String maKH) {
    this.maKH = maKH;
  }
  public String getTenKH() {
    return tenKH;
  }
  public void setTenKH(String tenKH) {
    this.tenKH = tenKH;
  }
  public String getMaDV() {
    return maDV;
  }
  public void setMaDV(String maDV) {
    this.maDV = maDV;
  }
  public String getTenDV() {
    return tenDV;
  }
  public void setTenDV(String tenDV) {
    this.tenDV = tenDV;
  }
  public String getDonViTinh() {
    return donViTinh;
  }
  public void setDonViTinh(String donViTinh) {
    this.donViTinh = donViTinh;
  }
  public String getDonGia() {
    return donGia;
  }
  public void setDonGia(String donGia) {
    this.donGia = donGia;
  }
  public String getNgaySuDung() {
    return ngaySuDung;
  }
  public void setNgaySuDung(String ngaySuDung) {
    this.ngaySuDung = ngaySuDung;
  }
  public String getGioSuDung() {
    return gioSuDung;
  }
  public void setGioSuDung(String gioSuDung) {
    this.gioSuDung = gioSuDung;
  }
  public String getSoLuong() {
    return soLuong;
  }
  public void setSoLuong(String soLuong) {
    this.soLuong = soLuong;
  }
  public String getTongTien() {
    return tongTien;
  }
  public void setTongTien(String tongTien) {
    this.tongTien = tongTien;
  }

  @Override
  public String toString() {
    return "SuDungDichVuDto [maKH=" + maKH + ", tenKH=" + tenKH + ", maDV="
        + maDV + ", tenDV=" + tenDV + ", donViTinh=" + donViTinh + ", donGia="
        + donGia + ", ngaySuDung=" + ngaySuDung + ", gioSuDung=" + gioSuDung
        + ", soLuong=" + soLuong + ", tongTien=" + tongTien + "]";
  }
  
  

}
