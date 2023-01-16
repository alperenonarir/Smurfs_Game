public class Gargamel extends Dusman {
    
  


    public Gargamel(int ID, String Ad, String Tur) {
        super(ID, Ad, Tur);
         this.hasarGucu = 15;
         this.adimSayisi=2;
    }
    
     public Gargamel(){}

    public int getAdimSayisi() {return adimSayisi;}
    public void setAdimSayisi(int adimSayisi) {this.adimSayisi = adimSayisi;}
    public int getHasarGucu() {return hasarGucu;}
    @Override
    public void setHasarGucu(int hasarGucu) {this.hasarGucu = hasarGucu;}
    
    
}
