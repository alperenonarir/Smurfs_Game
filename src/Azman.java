
public class Azman extends Dusman {
    

    public Azman(int ID, String Ad, String Tur) {
        super(ID, Ad, Tur);
         this.hasarGucu = 5;
    }
    
     public Azman(){}

    public int getAdimSayisi() {return adimSayisi;}
    public void setAdimSayisi(int adimSayisi) {this.adimSayisi = adimSayisi;}
    public int getHasarGucu() {return hasarGucu;}
    public void setHasarGucu(int hasarGucu) {this.hasarGucu = hasarGucu;}

    @Override
    public int getDusmanID() {return super.getDusmanID();}

    @Override
    public void setDusmanID(int dusmanID) {super.setDusmanID(dusmanID) ;}

    public String getDusmanAd() {return dusmanAd;}

    public void setDusmanAd(String dusmanAd) {this.dusmanAd = dusmanAd;}

    public String getDusmanTur() {return dusmanTur;}

    public void setDusmanTur(String dusmanTur) {
        this.dusmanTur = dusmanTur;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getTur() {
        return Tur;
    }

    public void setTur(String Tur) {
        this.Tur = Tur;
    }

    public int getLokX() {
        return lokX;
    }

    public void setLokX(int lokX) {
        this.lokX = lokX;
    }

    public int getLokY() {
        return lokY;
    }

    public void setLokY(int lokY) {
        this.lokY = lokY;
    }
    
    
}
