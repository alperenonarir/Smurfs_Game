
import java.util.ArrayList;


public class Yol {
    
   static kare kareMatrisi[][] = new kare[11][13];
  static  int costMatris[][][][][] = new int[11][13][11][13][1];
  static   int haritaMatrisi[][] = new int[11][13];
    
    public Yol(){ // harita
        // cost matris için harita matrisini de göndereceğiz simdilik konsoldan okuyorum
        // haritaMatrisi = harita; gibi
        kareMatrisi();
        costmatrishesapla();
        }
    Yol(int[][] maze) {
        haritaMatrisi = maze;
        kareMatrisi();
        costmatrishesapla();
    
    }
  public static void rotaHesaplaHazırlık(int startx, int starty){
        
       kareMatrisiTemizle();
       kareMatrisi[startx][starty].setAgirlik(0);
       rotaHesapla(startx, starty);
    }
  
  
  
     static void rotaHesapla(int startx, int starty){
     
       kareMatrisi[startx][starty].setKullanildiMi(true); // konum kullanıldı olarak isaretlendi
       
        for (int i = 0; i < 11; i++) {                      // costmatriste gidebileceği her nokta bulunuyor ve güncelleniyor
            for (int j = 0; j <13; j++) {
                
                if (kareMatrisi[i][j].isKullanildiMi()==false
                   &&  kareMatrisi[startx][starty].getAgirlik()+ costMatris[startx][starty][i][j][0] < kareMatrisi[i][j].getAgirlik()
                        ){
                    kareMatrisi[i][j].setAgirlik(kareMatrisi[startx][starty].getAgirlik() + costMatris[startx][starty][i][j][0]) ;
                    kareMatrisi[i][j].setOnceki(kareMatrisi[startx][starty]);
                }}}kareMatrisMinBul(); }
      
      
      static  void kareMatrisi() {

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                kareMatrisi[i][j] = new kare();
                kareMatrisi[i][j].setX(i);kareMatrisi[i][j].setY(j);
            } } }
        
        
        
public static void kareMatrisiTemizle() {

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
               
                if(haritaMatrisi[i][j]==0){kareMatrisi[i][j].setAgirlik(-1); kareMatrisi[i][j].setKullanildiMi(true);}
                else{kareMatrisi[i][j].setAgirlik(999);kareMatrisi[i][j].setKullanildiMi(false);kareMatrisi[i][j].setOnceki(null); }
            }}}
         
         
         
 static void kareMatrisMinBul(){
    int flag=0;
     int temp =999;
     int tempx = 0,tempy = 0;
       for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                if(kareMatrisi[i][j].isKullanildiMi()==false && haritaMatrisi[i][j]==1) flag++;{}
                if(kareMatrisi[i][j].isKullanildiMi()==false && kareMatrisi[i][j].getAgirlik() < temp ){
                    tempx=i;tempy=j;
                    temp=kareMatrisi[i][j].getAgirlik();
                  }}}
       if(flag==0){return;}
       rotaHesapla(tempx,tempy);
                         }
 
 
 
 
   static   void costmatrishesapla() {

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                
                for (int k = 0; k < 11; k++) {
                    for (int l = 0; l < 13; l++) {
                        costMatris[i][j][k][l][0] = 999;
                        
                        if(j==l && k==i+1 && haritaMatrisi[k][l] == 1){costMatris[i][j][k][l][0]=1;} // alt
                        if(j==l && i==k+1 && haritaMatrisi[k][l] == 1){costMatris[i][j][k][l][0]=1;}
                        if(i==k && l==j+1 && haritaMatrisi[k][l] == 1){costMatris[i][j][k][l][0]=1;}
                        if(i==k && j==l+1 && haritaMatrisi[k][l] == 1){costMatris[i][j][k][l][0]=1;} //SOL
                        if(i==k && j==l && haritaMatrisi[k][l] == 1 ){costMatris[i][j][k][l][0]=0;} // kendi ise
                    } }} }}

      
      
      
      
      
      public static void main(String[] args){
       
        Yol yolBulucu = new Yol();
        
        yolBulucu.rotaHesaplaHazırlık(0,10);
          
        
        System.out.print(yolBulucu.kareMatrisi[0][10].getAgirlik() + " aaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println();
        
          for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(yolBulucu.kareMatrisi[i][j].getAgirlik() + "   ");
            }
            System.out.println();
        }
          // System.out.print(yol.dugumDizisi[5][6].agırlık + " ");
           // nereden geldi 
           kare k = new kare();
           k = yolBulucu.kareMatrisi[5][6];
           for(int i=0; i<yolBulucu.kareMatrisi[5][6].getAgirlik() ; i++){
              
               System.out.print(k.getX() + " " + k.getY());
              System.out.println();
              k = k.getOnceki();
            //  if (k.onceki==null){break;}
              
              
           }
           
             for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(yolBulucu.kareMatrisi[i][j].isKullanildiMi());
            }
            System.out.println();
        }
    }

   
      
      
      
      
}

class kare{
    
    private int x;
    private int y;
    private int agirlik;
    private  boolean kullanildiMi = false;
    private kare onceki=null;
    
    public kare() {}
    public kare(int y, kare onceki) {this.y = y;this.onceki = onceki;}
    
    public boolean isKullanildiMi() {return kullanildiMi;}
    public void setKullanildiMi(boolean kullanildiMi) {this.kullanildiMi = kullanildiMi;}
    public int getAgirlik() {return agirlik;}
    public void setAgirlik(int agirlik) {this.agirlik = agirlik;}
    public kare getOnceki() {return onceki;}
    public void setOnceki(kare onceki) {this.onceki = onceki;}
    public int getX() {return x;}
    public void setX(int x) {this.x = x;}
    public int getY() { return y;}
    public void setY(int y) {this.y = y;}


    }
  