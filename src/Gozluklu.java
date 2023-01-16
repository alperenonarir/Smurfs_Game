public class Gozluklu extends Oyuncu{

  
    
  
    
    @Override
    public int getAdimSayisi() {return adimSayisi;}
    @Override
    public void setAdimSayisi(int adimSayisi) {this.adimSayisi = adimSayisi;}
    @Override
    public int getDayaniklilik() {return Dayaniklilik; }
    @Override
    public void setDayaniklilik(int Dayaniklilik) { this.Dayaniklilik = Dayaniklilik;}
    
    
    public Gozluklu() {}

    public Gozluklu(int oyuncuID, String oyuncuAd, String oyuncuTur) {super(oyuncuID, oyuncuAd, oyuncuTur);
    this.Dayaniklilik=0;
    this.adimSayisi=2;
    }
    
    
  
    
    
}
