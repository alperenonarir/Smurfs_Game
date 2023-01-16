
public class Puan extends Oyuncu{
    
    
     @Override
     public int PuaniGoster(Oyuncu o){ return o.Skor;}
     
     public void PuanGuncelle(Oyuncu o,Dusman d){
         o.setSkor(o.getSkor() + o.getDayaniklilik() - d.getHasarGucu() );}
     
     public void PuanGuncelle(Oyuncu o,Obje ganimet){
         o.setSkor(o.getSkor() + ganimet.getPuan() );}

   
}
