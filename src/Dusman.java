public class Dusman extends Karakter {
    
    private int dusmanID;
    String dusmanAd;
    String dusmanTur;
    
     int hasarGucu = 5;
    
     public Dusman(int ID, String Ad, String Tur) {
        super(ID, Ad, Tur);
        this.dusmanID = ID;
        this.dusmanAd = Ad;
        this.dusmanTur = Tur;
    }
 
     public Dusman() { }
     
    public int getDusmanID() {return dusmanID;}
    public void setDusmanID(int dusmanID) {this.dusmanID = dusmanID;}
    public String getDusmanAd() {return dusmanAd;}
    public void setDusmanAd(String dusmanAd) { this.dusmanAd = dusmanAd;}
    public String getDusmanTur() {return dusmanTur;}
    public void setDusmanTur(String dusmanTur) { this.dusmanTur = dusmanTur;}
    public int getHasarGucu() {return hasarGucu;}
    public void setHasarGucu(int hasarGucu) {this.hasarGucu = hasarGucu;}
   
   

   
    
    
    
}


 