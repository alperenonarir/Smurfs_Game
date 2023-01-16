

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;




public class A_View extends JFrame{

     
 
 
     
     int flag=0;              // tuslardaki çift algılama sorunu için 
     int hamleSirasi=0;       //  tek rakamlarda pc, çift rakamlarda oyuncu oynuyor, hamle sonrası arttırılıyor
     static int adimTemp=0;   // gozluklunun 2 adım atmasını saglamak için
     static int dusmanDurumu; // 0 azman, 1 gargamel , 2 azman + gargamel 
     static boolean OyunDurumu=true;  // oyun bitince false donecek tusları kapatıyor
     static boolean mazeGosterilsinMi=false;
  
   
   static int [][] maze= new int[11][13];
   static Lokasyon[][] lokasyon = new Lokasyon[11][13];
   
  
   Toolkit sirine = Toolkit.getDefaultToolkit();
   Image sirineGoruntu=sirine.getImage("picture\\sirine.jpg");
     
   static Gozluklu gozlukluObje   = new Gozluklu(1,"gozluklu","Oyuncu");
   static Tembel   tembelObje     = new Tembel  (2,"tembel","Oyuncu");
   
   
   static Gargamel gargamelObje   = new Gargamel(3,"gargamel","Dusman");
   Toolkit Gargamell = Toolkit.getDefaultToolkit();
   Image GargamelGoruntu=Gargamell.getImage("picture\\gargamel.jpg");
   static int gargStartX; static int gargStartY;
   
   static Azman    azmanObje      = new Azman   (4,"azman","Dusman");
   Toolkit azmann = Toolkit.getDefaultToolkit();
   Image azmanGoruntu=azmann.getImage("picture\\azman.jpg");
   static int azmStartX; static int azmStartY;
    
    static Oyuncu oyuncuObje     = new Oyuncu(); 
    static int secim; // 0 sa gözlüjlü 1 se tembel
    static Toolkit oyuncu = Toolkit.getDefaultToolkit();
    static Image oyuncuGoruntu;
   
   
   
   
   public static void objeRasgeleAtama(Obje o){ // duvar gelirse tekrar deniyor, objelere kordinat atıyor
       int xx,yy;
       
       do{
         xx=  r.nextInt(13);
         yy=  r.nextInt(11);
           
       }while(lokasyon[yy][xx].lokasyonKontrol()==0);
       
       o.setXY(xx, yy);
   }
   
   
    static Puan     puanObje       = new Puan();
    
    
   static Random r=new Random(); //random sınıfı
   
   
   
   static Altin altin1 = new Altin(-5,-5);
   static Altin altin2 = new Altin(-5,-4);
   static Altin altin3 = new Altin(-5,-3);
   static Altin altin4 = new Altin(-5,-2);
   static Altin altin5 = new Altin(-5,-1);
   
   static Hazine hazine1 = new Hazine(-5,0);
   
   
    
    Toolkit hazinee = Toolkit.getDefaultToolkit();
    Image hazineGoruntu=hazinee.getImage("picture\\hazine.jpg");
    
    Toolkit altinn = Toolkit.getDefaultToolkit();
    Image altinGoruntu=altinn.getImage("picture\\gold.jpg");
    
    
 
    static boolean altinVarlik=true;
    static boolean hazineVarlik=true;
  
    static Timer altinTimer=new Timer();
    static Timer hazineTimer=new Timer();
    
 static TimerTask altinBaslama =new TimerTask() {
     @Override
        public void run() {
             altinVarlik=true;
            objeRasgeleAtama(altin1);
            objeRasgeleAtama(altin2);
            objeRasgeleAtama(altin3);
            objeRasgeleAtama(altin4);
            objeRasgeleAtama(altin5);
// if(OyunDurumu);{altinTimer.cancel();} // İSE YARAMADI BU SAYAC DÖNÜYOR AMA COK SORUN DEGİL
 System.out.println("SAYAC DURMADI!!");
                 }
             };
 
  static TimerTask altinBitis =new TimerTask(){
       @Override
       public void run() {altinVarlik=false;}};
  
        
  
 static TimerTask hazineBaslama =new TimerTask() {
     @Override
        public void run() {
             hazineVarlik=true;
            objeRasgeleAtama(hazine1);}};
 
  static TimerTask hazineBitis =new TimerTask(){
       @Override
       public void run() {hazineVarlik=false;}};
  
        
   
   
    
  
  
  
   
   
   
    
    
    
 
    public A_View(){
        setTitle("bulmaca oyunu");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    }  
    
    

         
          
            
                 
    

      @Override
    public void paint(Graphics g)
        {
             kare k = new kare();
             Yol yolBulucu = new Yol(maze);
             int uzaklikG=0;
             int uzaklikA=0;
             
           
            
            
            super.paint(g); g.translate(100, 100);
            
            for(int row =0; row<maze.length;row++)
            {
                for(int col=0;col<maze[0].length;col++)
                {
                    Color color;
                    
                    switch(maze[row][col]){        
                    case 1: color = Color.WHITE; break;
                    case 0: color = Color.gray; break;
                    default: color = Color.BLUE;
      
                   
                    }
                       if(row==5 && col==6)
                        color = Color.BLUE;
                       
                    g.setColor(color);
                    g.fillRect(30*col,30*row, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(30*col,30*row, 30, 30);
                    
                }
            }
  

            // altını ve hazineyi 2 kere ciziyoruz alınırsa kaybolsun diye 1. cizim
if(altinVarlik){
             g.drawImage(altinGoruntu,altin1.getX()*30,altin1.getY()*30,this);
             g.drawImage(altinGoruntu,altin2.getX()*30,altin2.getY()*30,this); 
             g.drawImage(altinGoruntu,altin3.getX()*30,altin3.getY()*30,this); 
             g.drawImage(altinGoruntu,altin4.getX()*30,altin4.getY()*30,this); 
             g.drawImage(altinGoruntu,altin5.getX()*30,altin5.getY()*30,this); 
                
            }               
if(hazineVarlik){g.drawImage(hazineGoruntu,hazine1.getX()*30,hazine1.getY()*30,this); }

    
 
       
       

       
          
            
                                // oyun basında kısa yolu veriyor , çift oynayısta 1. onamadan sonra kısayolu veriyor
if( hamleSirasi%2==0){  
    switch(dusmanDurumu){
  
case 0 :{ // baslangic azman kisa yol verir + mesafe yazar
            yolBulucu.rotaHesaplaHazırlık(azmanObje.getLokY(),azmanObje.getLokX());            
            uzaklikA = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik();
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki();
            for(int aa=0; aa<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik() ; aa++){
            g.fillRect(30*k.getY(),30*k.getX(), 28, 28); g.setColor(Color.LIGHT_GRAY);
            if(k.getOnceki()==null) {break;} else {k = k.getOnceki();}}break;} 
case 1 :{ // baslangic gargamel kisa yol verir + mesafe yazar
            yolBulucu.rotaHesaplaHazırlık(gargamelObje.getLokY(),gargamelObje.getLokX());
            uzaklikG=yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik();
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki();
            for(int aa=0; aa<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik() ; aa++){
            g.fillRect(30*k.getY(),30*k.getX(), 28, 28); g.setColor(Color.red);
            if(k.getOnceki()==null) {break;} else {k = k.getOnceki();}}break;}
case 2 :{ // baslangic azman + gargamel kisa yol verir + mesafe yazar
            yolBulucu.rotaHesaplaHazırlık(azmanObje.getLokY(),azmanObje.getLokX());
            uzaklikA = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik();
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki();
            for(int aa=0; aa<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik() ; aa++){
            g.fillRect(30*k.getY(),30*k.getX(), 28, 28); g.setColor(Color.LIGHT_GRAY);
            if(k.getOnceki()==null) {break;} else {k = k.getOnceki();}}
    
            yolBulucu.rotaHesaplaHazırlık(gargamelObje.getLokY(),gargamelObje.getLokX());
            uzaklikG=yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik();
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki();
            for(int aa=0; aa<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik() ; aa++){
            g.fillRect(30*k.getY(),30*k.getX(), 28, 28); g.setColor(Color.red);
            if(k.getOnceki()==null) {break;} else {k = k.getOnceki();}}break;}
    }}
                         
                                
        
            
          // OYUNCU HAREKETLERİ ++ puan durumu ++ sirine kontrol
                      
                      
                      // azmanın üstüne gidersek 
 if(oyuncuObje.getLokX()==azmanObje.getLokX() && oyuncuObje.getLokY()==azmanObje.getLokY()){        // puan düşer + gaegameli kapıya atar
      azmanObje.setLokX(azmStartX);azmanObje.setLokY(azmStartY);                                     // dusman baslangıc kordinatları ile degismeli 
      puanObje.PuanGuncelle(oyuncuObje, azmanObje);
      hamleSirasi++;}
                      
                      //gargamellin üstüne gidersek
  if(oyuncuObje.getLokX()==gargamelObje.getLokX() && oyuncuObje.getLokY()==gargamelObje.getLokY()){
     gargamelObje.setLokX(gargStartX);gargamelObje.setLokY(gargStartY);
     puanObje.PuanGuncelle(oyuncuObje, gargamelObje);
     hamleSirasi++;}
                      // sirineye ulasırsak
                      
  if(oyuncuObje.getLokX()==12 && oyuncuObje.getLokY()==7){          
               g.setColor(Color.CYAN);
               g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
               g.drawString(" Kahramanım!!", 400, 210);
                g.setColor(Color.GREEN);
               g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
               g.drawString(" KAZANDIN!!", 150, -20);
   OyunDurumu=false;
  }
            
            
              
         // DÜSMAN HAREKETLERİ 
         if(hamleSirasi%2==1){
            

switch(dusmanDurumu){
   case 0:{ // azman oyuncu hamlesi sonrası rota hesaplar - ekrana basar- oynar
       
            yolBulucu.rotaHesaplaHazırlık(azmanObje.getLokY(),azmanObje.getLokX());
            uzaklikA=yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik()-1;
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki();
            for(int aa=azmanObje.getAdimSayisi()-1; aa<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki().getAgirlik() ; aa++){
            g.fillRect(30*k.getY(),30*k.getX(), 28, 28); g.setColor(Color.LIGHT_GRAY);
            if(k.getOnceki()==null) {break;} else {k = k.getOnceki();}}
            
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()];
            for(int z=azmanObje.getAdimSayisi(); z<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik(); z++){k=k.getOnceki();}
            azmanObje.setLokX(k.getY());azmanObje.setLokY(k.getX());
  hamleSirasi++;break;}
                
                
   case 1:{// gargamel oyuncu hamlesi sonrası rota hesaplar - ekrana basar- oynar
            yolBulucu.rotaHesaplaHazırlık(gargamelObje.getLokY(),gargamelObje.getLokX());
            uzaklikG=yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik()-2;
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki();
            for(int aa=gargamelObje.getAdimSayisi()-1; aa<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki().getAgirlik() ; aa++){
            g.fillRect(30*k.getY(),30*k.getX(), 28, 28); g.setColor(Color.red);
            if(k.getOnceki()==null) {break;} else {k = k.getOnceki();}}
            
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()];
            for(int z=gargamelObje.getAdimSayisi(); z<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik(); z++){k=k.getOnceki();}
            gargamelObje.setLokX(k.getY());gargamelObje.setLokY(k.getX()); 
       
       hamleSirasi++; break;}
                       
                
                
   case 2:{// azman + gargamel oyuncu hamlesi sonrası rota hesaplar - ekrana basar- oynar
       
            yolBulucu.rotaHesaplaHazırlık(azmanObje.getLokY(),azmanObje.getLokX());
            uzaklikA = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik()-1;
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki();
            for(int aa=azmanObje.getAdimSayisi()-1; aa<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki().getAgirlik() ; aa++){
            g.fillRect(30*k.getY(),30*k.getX(), 28, 28); g.setColor(Color.LIGHT_GRAY);
            if(k.getOnceki()==null) {break;} else {k = k.getOnceki();}}
            
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()];
            for(int z=azmanObje.getAdimSayisi(); z<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik(); z++){k=k.getOnceki();}
            
            azmanObje.setLokX(k.getY());azmanObje.setLokY(k.getX());
            
            
            
            yolBulucu.rotaHesaplaHazırlık(gargamelObje.getLokY(),gargamelObje.getLokX());
            uzaklikG=yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik()-2;
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki();
            for(int aa=gargamelObje.getAdimSayisi()-1; aa<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getOnceki().getAgirlik() ; aa++){
            g.fillRect(30*k.getY(),30*k.getX(), 28, 28); g.setColor(Color.red);
            if(k.getOnceki()==null) {break;} else {k = k.getOnceki();}}
            
            k = yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()];
            for(int z=gargamelObje.getAdimSayisi(); z<yolBulucu.kareMatrisi[oyuncuObje.getLokY()][oyuncuObje.getLokX()].getAgirlik(); z++){k=k.getOnceki();}
            gargamelObje.setLokX(k.getY());gargamelObje.setLokY(k.getX());
           
            hamleSirasi++; break;
             
    }}}
       
         
         
                           
         
                                                     // puan durumu
                      
                                                     // altinla karsilasirsa puan ekler kordinatları değistirip ekrandan atar
                                                     
if(altinVarlik){
 if(oyuncuObje.getLokX()==altin1.getX() && oyuncuObje.getLokY()==altin1.getY()){puanObje.PuanGuncelle(oyuncuObje,altin1); altin1.ganimetKullanildi(); System.out.println("Altın kazandın"); }
  if(oyuncuObje.getLokX()==altin2.getX() && oyuncuObje.getLokY()==altin2.getY()){puanObje.PuanGuncelle(oyuncuObje,altin2); altin2.ganimetKullanildi(); System.out.println("Altın kazandın"); }          
    if(oyuncuObje.getLokX()==altin3.getX() && oyuncuObje.getLokY()==altin3.getY()){puanObje.PuanGuncelle(oyuncuObje,altin3); altin3.ganimetKullanildi(); System.out.println("Altın kazandın"); }
     if(oyuncuObje.getLokX()==altin4.getX() && oyuncuObje.getLokY()==altin4.getY()){puanObje.PuanGuncelle(oyuncuObje,altin4); altin4.ganimetKullanildi(); System.out.println("Altın kazandın"); }
      if(oyuncuObje.getLokX()==altin5.getX() && oyuncuObje.getLokY()==altin5.getY()){puanObje.PuanGuncelle(oyuncuObje,altin5); altin5.ganimetKullanildi(); System.out.println("Altın kazandın"); }
             g.drawImage(altinGoruntu,altin1.getX()*30,altin1.getY()*30,this);
             g.drawImage(altinGoruntu,altin2.getX()*30,altin2.getY()*30,this); 
             g.drawImage(altinGoruntu,altin3.getX()*30,altin3.getY()*30,this); 
             g.drawImage(altinGoruntu,altin4.getX()*30,altin4.getY()*30,this); 
             g.drawImage(altinGoruntu,altin5.getX()*30,altin5.getY()*30,this); 
                
            }
                                                     
 if(hazineVarlik){
 if(oyuncuObje.getLokX()==hazine1.getX() && oyuncuObje.getLokY()==hazine1.getY())
 {puanObje.PuanGuncelle(oyuncuObje,hazine1); hazine1.ganimetKullanildi(); System.out.println("hazine kazandın"); }
 g.drawImage(hazineGoruntu,hazine1.getX()*30,hazine1.getY()*30,this);}                                                    
                      
 
 
 
                      // azmanla karsılasırsa
if(oyuncuObje.getLokX()==azmanObje.getLokX() && oyuncuObje.getLokY()==azmanObje.getLokY()){
azmanObje.setLokX(azmStartX);azmanObje.setLokY(azmStartY);
puanObje.PuanGuncelle(oyuncuObje, azmanObje); }
                      

                    // gargamel ile karsılasırsa puan düser gargameli uerine yollar
if(oyuncuObje.getLokX()==gargamelObje.getLokX() && oyuncuObje.getLokY()==gargamelObje.getLokY()){
gargamelObje.setLokX(gargStartX);gargamelObje.setLokY(gargStartY);
puanObje.PuanGuncelle(oyuncuObje, gargamelObje);}
                      
         
                      
                      // puan 0 olursa bitirir 
        
              if(puanObje.PuaniGoster(oyuncuObje)<=0){ OyunDurumu=false;
               g.setColor(Color.red);
               g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
               g.drawString(" KAYBETTİN!!", 150, -20);
              }        
              
              
              // UZAKLIKLARI GÖSTERME
              switch(dusmanDurumu){
                  
                  case 0:   {
             g.setColor(Color.DARK_GRAY);
             g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
             g.drawString("Azmanın uzaklığı " + uzaklikA, 410, 50);
             break;
         }
                  case 1:  {
             g.setColor(Color.RED);
             g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
             g.drawString("Gargamelin uzaklığı " + uzaklikG, 410, 30);
             break;
         } 
                  
                  case 2:{
                      {
             g.setColor(Color.RED);
             g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
             g.drawString("Gargamelin uzaklığı " + uzaklikG, 410, 30);
             
         }
                         {
             g.setColor(Color.DARK_GRAY);
             g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
             g.drawString("Azmanın uzaklığı " + uzaklikA, 410, 50);
             
         }
                      break;
                  }  
            
            
                      
              }
            
              
              
                   ///SKOR GÖSTERME
         {
             g.setColor(Color.green);
             g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
             g.drawString("SKOR => " + oyuncuObje.getSkor(), 410, 0);
             
         }
                      
                                 ///  ikonları gösterme
switch(dusmanDurumu){
   case 0:{ g.drawImage(azmanGoruntu,azmanObje.getLokX()*30,azmanObje.getLokY()*30,this);break;}
   case 1:{g.drawImage(GargamelGoruntu,gargamelObje.getLokX()*30,gargamelObje.getLokY()*30,this);break;}
   case 2:{ g.drawImage(azmanGoruntu,azmanObje.getLokX()*30,azmanObje.getLokY()*30,this);
            g.drawImage(GargamelGoruntu,gargamelObje.getLokX()*30,gargamelObje.getLokY()*30,this);break;}
}
       
         g.drawImage(oyuncuGoruntu,oyuncuObje.getLokX()*30,oyuncuObje.getLokY()*30,this);  
         g.drawImage(sirineGoruntu,360,210,this);
         
         
        
        
         
        }
   
             
     @Override
   protected void processKeyEvent(KeyEvent e)
   {
       
  if(e.getKeyCode()==KeyEvent.VK_LEFT && OyunDurumu==true){  
           flag++;if(flag%2==0) {System.out.println("solll");
           adimTemp++ ;oyuncuObje.setLokX(oyuncuObje.getLokX()-1);
           if(oyuncuObje.getLokX() <0){oyuncuObje.setLokX(0);}  // sol kapından sola kaçmaması için
           if( lokasyon[oyuncuObje.getLokY()][oyuncuObje.getLokX()].lokasyonKontrol()==1){repaint(); }
           else { oyuncuObje.setLokX(oyuncuObje.getLokX()+1);repaint();}}
           if(oyuncuObje.getAdimSayisi()-adimTemp==0){ hamleSirasi++; adimTemp=0;repaint();} 
  
  }
       
       
       if(e.getKeyCode()==KeyEvent.VK_RIGHT && OyunDurumu==true){ 
           
           flag++;if(flag%2==0) {System.out.println("saggg");
           adimTemp++ ;oyuncuObje.setLokX(oyuncuObje.getLokX()+1);
           if(oyuncuObje.getLokX() >12){oyuncuObje.setLokX(12);}  // sag kapından sag kaçmaması için
           if( lokasyon[oyuncuObje.getLokY()][oyuncuObje.getLokX()].lokasyonKontrol()==1){repaint(); }
           else { oyuncuObje.setLokX(oyuncuObje.getLokX()-1);repaint();}}
           if(oyuncuObje.getAdimSayisi()-adimTemp==0){ hamleSirasi++; adimTemp=0;repaint();}
 
       } 
       
       
         
         if(e.getKeyCode()==KeyEvent.VK_UP && OyunDurumu==true){ 
             
           flag++;if(flag%2==0) {System.out.println("yularii");
           adimTemp++ ;oyuncuObje.setLokY(oyuncuObje.getLokY()-1);
           if(oyuncuObje.getLokY() <0){oyuncuObje.setLokY(0);}  // yukarı kapından  kaçmaması için
           if( lokasyon[oyuncuObje.getLokY()][oyuncuObje.getLokX()].lokasyonKontrol()==1){repaint(); }
           else { oyuncuObje.setLokY(oyuncuObje.getLokY()+1);repaint();}}
           if(oyuncuObje.getAdimSayisi()-adimTemp==0){ hamleSirasi++; adimTemp=0;repaint();}  
             
         
         }
           
         if(e.getKeyCode()==KeyEvent.VK_DOWN && OyunDurumu==true){  
             
           flag++;if(flag%2==0) {System.out.println("ASSAA");
           adimTemp++ ;oyuncuObje.setLokY(oyuncuObje.getLokY()+1);
           if(oyuncuObje.getLokY() >10){oyuncuObje.setLokY(10);}  // sag kapından sag kaçmaması için
           if( lokasyon[oyuncuObje.getLokY()][oyuncuObje.getLokX()].lokasyonKontrol()==1){repaint(); }
           else { oyuncuObje.setLokY(oyuncuObje.getLokY()-1);repaint();}}
           if(oyuncuObje.getAdimSayisi()-adimTemp==0){ hamleSirasi++; adimTemp=0;repaint();}
             

         }  
  
         
   }
   
  
    public static void baslangic(){
              
    JFrame frame=new JFrame("SEÇİM EKRANI");  
    
    Image iconc = Toolkit.getDefaultToolkit().getImage("picture\\gold1.png");  
    frame.setIconImage(iconc);
    
    JButton gozluklu=new JButton();  
    JButton tembel=new JButton();  
    
    gozluklu.setBounds(50,100,200,300);  
    tembel.setBounds(330,100,200,300);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    frame.add(gozluklu);  
    
    frame.add(tembel);
    frame.setSize(600,600);  
    
    frame.setLayout(null);  
    frame.setVisible(true);   
    
    frame.getContentPane().setBackground(Color.lightGray);
     
      ImageIcon icon1 = new ImageIcon("picture\\gozluklu1.png");
      gozluklu.setIcon(icon1);

      ImageIcon icon2 = new ImageIcon("picture\\tembel1.png");
      tembel.setIcon(icon2);

do{
      gozluklu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

          secim=0; mazeGosterilsinMi=true;frame.setVisible(false);
             
        }
    });

    
      tembel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

          secim=1;mazeGosterilsinMi=true;frame.setVisible(false);
        }
    });
      
        try {Thread.sleep(2000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

}
while(mazeGosterilsinMi==false);
        
    }
    
    public static void main(String[] args) {
      baslangic();
    

       int yapi; // LOKASYON MATRİSİNİ OLUSUTURUKEN KULLANIYORUZ ASSAĞIDA
      
  
       // azmanObje.setAdimSayisi(5);// azmanı adım sayisini 0 yapabiliriz
       hazine1.setPuan(1000);  // hazineler 1000 puan
      
      //  hazine1.setDurmaSuresi(2000);    
      // hazine1.setTekrarSuresi(5000);       hazine 5 sn de bir çıksın 2 sn kalsın
       
 
      
      if(secim==0){
          //  gözlüklü seçilirse
          oyuncuObje = gozlukluObje;
         
          oyuncuGoruntu=oyuncu.getImage("C:picture\\gozluklu.jpg");
      }
      else if(secim==1){
          // tembel seçilirse
          oyuncuObje = tembelObje; 
          oyuncuGoruntu=oyuncu.getImage("picture\\tembel.jpg");
        }
      
      
      oyuncuObje.setBaslangicNoktasi(6, 5);       // baslangic noktasi burada atandı  X - Y  
      
 
        
                hazineTimer.schedule(hazineBaslama,500,hazine1.getTekrarSuresi()); // hazine açma 
                hazineTimer.schedule(hazineBitis,hazine1.getDurmaSuresi()+500,hazine1.getTekrarSuresi()); // hazine kapatma
                
                altinTimer.schedule(altinBaslama,500,altin1.getTekrarSuresi()); // altın açma 
                altinTimer.schedule(altinBitis,altin1.getDurmaSuresi()+500,altin1.getTekrarSuresi()); // altın kapatma
                
                
   
       
       
     // C:\\Users\\PC\\Desktop\\pro lab 2\\harita.txt
     // C:\\Users\\ALPEREN\\Documents\\Projeler\\SmurfGame\\Harita.txt
       
      
        int m = 11;
        int n = 13;
        
        
        String g1= "Karakter:Gargamel,Kapi:A";                                                   
        String g2= "Karakter:Gargamel,Kapi:B";                 
        String g3= "Karakter:Gargamel,Kapi:C";                                                   
        String g4= "Karakter:Gargamel,Kapi:D"; 
     
                                                   
        String a1= "Karakter:Azman,Kapi:A";                                                   
        String a2= "Karakter:Azman,Kapi:B";                 
        String a3= "Karakter:Azman,Kapi:C";                                                   
        String a4= "Karakter:Azman,Kapi:D";  
          
  
          File file = new File("C:\\Users\\ALPEREN\\Documents\\Projeler\\Smurfs_Game\\Harita.txt");
                
          int lineNum = 0;
        
        
          try {
    Scanner scanner = new Scanner(file);
    Scanner scan = new Scanner(file);
     Scanner scani = new Scanner(file);
    //now read the file line by line...
   
    while (scanner.hasNextLine()) {
 
        String line = scanner.nextLine();
 if(line.equals(g1)) {lineNum++;}
 if(line.equals(g2)) {lineNum++;}
 if(line.equals(g3)) {lineNum++;}
 if(line.equals(g4)) {lineNum++;}
 if(line.equals(a1)) {lineNum++;}
 if(line.equals(a2)) {lineNum++; }
 if(line.equals(a3)) {lineNum++; }
 if(line.equals(a4)) {lineNum++;}  }

    //**************************************************************
    
    // iki tane düşman karakter varsa burayı kullanır. 1 azman + 1 gargamel 
     if(lineNum==2) 
    {
        dusmanDurumu =2;
         int sayac=0;
        
         
     while (scani.hasNextLine()) {
        String lini = scani.nextLine();
        
        sayac++;
        
 
        if(lini.equals(g1)) { 
            System.out.println(g1 +" "+lineNum); //buralardan hangi karakterin nerede olduğunu anlıyoruz, konumlarını belirleyeceğiz.
           gargamelObje.setLokX(3);gargamelObje.setLokY(0);  // A KAPIOSI 
           gargStartX= 3;gargStartY= 0;}
        
        if(lini.equals(g2)) { 
            System.out.println(g2 +" "+lineNum);
            gargStartX= 10;gargStartY= 0;
            gargamelObje.setLokX(10);gargamelObje.setLokY(0);             // B
        }
            if(lini.equals(g3)) { 
            System.out.println(g3 +" "+lineNum);
            gargStartX= 0; gargStartY= 5;
            gargamelObje.setLokX(0);gargamelObje.setLokY(5);               // C 
            }
              if(lini.equals(g4)) { 
            System.out.println(g4 +" "+ lineNum);
            gargStartX= 3; gargStartY= 10;
            gargamelObje.setLokX(3);gargamelObje.setLokY(10);                  // D
              }
   
    
   
   
            if(lini.equals(a1)) { 
            System.out.println(a1 +" "+lineNum);
            azmStartX= 3;azmStartY= 0;
            azmanObje.setLokX(3);azmanObje.setLokY(0);          // A KAPISI
            }
            if(lini.equals(a2)) { 
            System.out.println(a2 +" "+lineNum);
            azmStartX= 10;azmStartY= 0;
            azmanObje.setLokX(10);azmanObje.setLokY(0);             // B
            }
            if(lini.equals(a3)) { 
            System.out.println(a3 +" "+lineNum);
            azmStartX= 0;azmStartY= 5;
            azmanObje.setLokX(0);azmanObje.setLokY(5);               // C 
            }
              if(lini.equals(a4)) { 
            System.out.println(a4 +" "+ lineNum);
            azmStartX= 3;azmStartY= 10;
            azmanObje.setLokX(3);azmanObje.setLokY(10);                  // D
              }
        
              
    if(sayac==2){
                for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                 
            maze[i][j] = scani.nextInt();
            // System.out.println("number is "+ maze[i][j]);
              if( maze[i][j]==0){yapi=0;}
              else {yapi = 1;}
              lokasyon[i][j] = new Lokasyon(i,j,yapi);
              System.out.print(" " +maze[i][j]);
                }
                System.out.println("\n");  
            }       
 
    }
 

    }

        
    }
    
    //**************************************************************
    

    if(lineNum==1) // tek bir düşman karakter varsa burayı kullanır. 1 gargamel ya da 1 azman.
    {
       
     while (scan.hasNextLine()) {
        String lin = scan.nextLine();

               
     
   
     
        
        
        if(lin.equals(g1)) { 
            System.out.println(g1 +" "+lineNum); //buralardan hangi karakterin nerede olduğunu anlıyoruz, konumlarını belirleyeceğiz.
           dusmanDurumu =1; gargStartX= 3;gargStartY= 0;
           gargamelObje.setLokX(3);gargamelObje.setLokY(0);             // A KAPIOSI 
        }
          if(lin.equals(g2)) { 
            System.out.println(g2 +" "+lineNum);
            gargStartX= 10;gargStartY= 0;dusmanDurumu =1;
            gargamelObje.setLokX(10);gargamelObje.setLokY(0);             // B
           
        }
            if(lin.equals(g3)) { 
            System.out.println(g3 +" "+lineNum);
            gargStartX= 0;gargStartY= 5; dusmanDurumu =1;
            gargamelObje.setLokX(0);gargamelObje.setLokY(5);               // C 
            }
              if(lin.equals(g4)) { 
            System.out.println(g4 +" "+ lineNum);
            gargStartX= 3;gargStartY= 10;dusmanDurumu =1;
           gargamelObje.setLokX(3);gargamelObje.setLokY(10);                  // D
              }
       
            if(lin.equals(a1)) { 
            System.out.println(a1 +" "+lineNum);
            azmStartX= 3;azmStartY= 0;dusmanDurumu =0;
           azmanObje.setLokX(3);azmanObje.setLokY(0);             // A KAPIOSI
            }
            if(lin.equals(a2)) { 
            System.out.println(a2 +" "+lineNum);
            azmStartX= 10; azmStartY= 0;dusmanDurumu =0;
            azmanObje.setLokX(10);azmanObje.setLokY(0);             // B
            }
            if(lin.equals(a3)) { 
            System.out.println(a3 +" "+lineNum);
            azmStartX= 0; azmStartY= 5;dusmanDurumu =0;
            azmanObje.setLokX(0);azmanObje.setLokY(5);               // C 
            }
              if(lin.equals(a4)) { 
            System.out.println(a4 +" "+ lineNum);
            azmStartX= 3; azmStartY= 10;dusmanDurumu =0;
            azmanObje.setLokX(3);azmanObje.setLokY(10); 
        
              }
        
                for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                 
            maze[i][j] = scan.nextInt();
            // System.out.println("number is "+ maze[i][j]);
                
                 if( maze[i][j]==0){yapi=0;}
                 else {yapi = 1;}
                    lokasyon[i][j] = new Lokasyon(i,j,yapi);
         System.out.print(" "+maze[i][j]);
                }
                System.out.println("\n");  
            }       
    }
    
    } 
            mazeGosterilsinMi=true;
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               A_View view = new A_View();
               view.setVisible(mazeGosterilsinMi);
           }
       }); 
    
    
}  catch (Exception e) {
        e.printStackTrace();
    }
    }}


