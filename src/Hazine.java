

public class Hazine extends Obje{

    public Hazine(int durmaSuresi, int tekrarSuresi, int puan) {
        super(durmaSuresi, tekrarSuresi, puan);
    }

    public Hazine() { super(6950, 20000, 50);}

    public Hazine(int x, int y) {
        super(6950, 20000, 50);
        this.x=x;
        this.y=y;
        
    }
     
    
    
}