
//import static şirinler.yol.rotaHesaplaHazırlık;



public abstract class Karakter {
    
    int ID;
    String Ad;
    String Tur;
    int  adimSayisi =1;
    int lokX;
    int lokY;

    
    public Karakter(int ID, String Ad, String Tur) {
        this.ID = ID;
        this.Ad = Ad;
        this.Tur = Tur;
    }
    public Karakter(){}

    
    
    
    //public void enKisaYol(int startX, int startY){rotaHesaplaHazırlık(startX,startY);}
  
    public int getID() {return ID; }
    public void setID(int ID) {this.ID = ID;}
    public String getAd() { return Ad;}
    public void setAd(String Ad) { this.Ad = Ad;}
    public String getTur() {return Tur;}
    public void setTur(String Tur) {this.Tur = Tur;}
    public int getLokX() {return lokX;}
    public void setLokX(int lokX) {this.lokX = lokX;}
    public int getLokY() {return lokY;}
    public void setLokY(int lokY) {this.lokY = lokY;}
    public int getAdimSayisi() {return adimSayisi;}
    public void setAdimSayisi(int adimSayisi) {this.adimSayisi = adimSayisi;}
    
    
}