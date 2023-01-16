public class Tembel extends Oyuncu{

  

    
    @Override
    public int getAdimSayisi() {return adimSayisi;}
    @Override
    public void setAdimSayisi(int adimSayisi) {this.adimSayisi = adimSayisi;}
    @Override
    public int getDayaniklilik() {return Dayaniklilik; }
    @Override
    public void setDayaniklilik(int Dayaniklilik) { this.Dayaniklilik = Dayaniklilik;}
    
    
    public Tembel() {}

    public Tembel(int oyuncuID, String oyuncuAd, String oyuncuTur) {super(oyuncuID, oyuncuAd, oyuncuTur);}
    
    
  
    
    
}
