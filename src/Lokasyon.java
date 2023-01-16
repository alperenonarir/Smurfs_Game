
public class Lokasyon {
    
  private  int x;
  private  int y;
  private  int yapi; // duvar mı gecit mi finish mi  ; duvarsa 0 gecitse 1

  
  
  
  public int lokasyonKontrol(){
      
     
      if(yapi==0){ // duvarsa 0 dön
          return 0;}
      else {return 1; }
          
          
          
          
      
      
      
      
      
  }
  
  
  
  
    public Lokasyon(int x, int y, int yapi) {
        this.x = x;
        this.y = y;
        this.yapi = yapi;
        
    }

    public Lokasyon(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Lokasyon() {
    }

    
     public int getYapi() {
        return yapi;
    }

    public void setYapi(int yapi) {
        this.yapi = yapi;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
    
}
