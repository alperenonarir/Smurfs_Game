
public class Obje {
    int x,y;
     int durmaSuresi;
    int tekrarSuresi;
    int puan;
    
    
public Obje(int x, int y) { this.x = x; this.y = y;}
public Obje() {}
public Obje(int durmaSuresi, int tekrarSuresi, int puan) {
        this.durmaSuresi = durmaSuresi;
        this.tekrarSuresi = tekrarSuresi;
        this.puan = puan;
    }
  
  
    

    public  void ganimetKullanildi() { this.x = -10; this.y=-10; } // ganimet kullanilince bu fonk ile haritadan atıyoruz karsılasmaması için tekrar
    public int getDurmaSuresi() {return durmaSuresi;}
    public void setDurmaSuresi(int durmaSuresi) {this.durmaSuresi = durmaSuresi; }
    public int getTekrarSuresi() {return tekrarSuresi;}
    public void setTekrarSuresi(int tekrarSuresi) { this.tekrarSuresi = tekrarSuresi;}
    public int getPuan() {return puan;}
    public void setPuan(int puan) {this.puan = puan;}  
    
    
    
    public int getX() {return x;}
    public void setX(int x) { this.x = x;}
    public int getY() {return y;}
    public void setY(int y) {this.y = y; }
  public void setXY(int x,int y) {this.x = x;  this.y = y;}
    
  
}
