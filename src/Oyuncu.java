
public class Oyuncu extends Karakter{
    
       int oyuncuID;
    String oyuncuAd;
    String oyuncuTur;
    
    int Dayaniklilik=0;
    int Skor=20;

    public void setBaslangicNoktasi(int x, int y) {
        this.lokX =x;
        this.lokY=y;
    }


        public int PuaniGoster(Oyuncu o){return o.Skor;}
        
        
    public Oyuncu(int oyuncuID, String oyuncuAd, String oyuncuTur) {
        super(oyuncuID, oyuncuAd, oyuncuTur);
        this.oyuncuID = oyuncuID;
        this.oyuncuAd = oyuncuAd;
        this.oyuncuTur = oyuncuTur;}

    public Oyuncu() {}
    

    
    
    
    public int getOyuncuID() {return oyuncuID;}
    public void setOyuncuID(int oyuncuID) {this.oyuncuID = oyuncuID;}
    public String getOyuncuAd() {return oyuncuAd;}
    public void setOyuncuAd(String oyuncuAd) {this.oyuncuAd = oyuncuAd;}
    public String getOyuncuTur() {return oyuncuTur;}
    public void setOyuncuTur(String oyuncuTur) {this.oyuncuTur = oyuncuTur;}
    public int getSkor() {return Skor;}
    public void setSkor(int Skor) {this.Skor = Skor;}
       @Override
    public int getAdimSayisi() {return adimSayisi;}
       @Override
    public void setAdimSayisi(int adimSayisi) {this.adimSayisi = adimSayisi;}
    public int getDayaniklilik() { return Dayaniklilik;}
    public void setDayaniklilik(int Dayaniklilik) {this.Dayaniklilik = Dayaniklilik;}

    
}


   