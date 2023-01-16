![image](https://user-images.githubusercontent.com/121980906/212622287-c2f0fda7-4046-4954-b535-90c7a2c264ef.png)



# Özet

  Bu proje ile **nesneye yönelik programlama** ve  **veri yapıları ve algoritmaları** kullanarak Şirinler oyunu tasarlanması amaçlanmıştır.
  Seçilen oyuncunun Labirent içerisinde puanlarını bitirmeden önce Şirine’ye ulaşması gerekmektedir. Kullanıcı oyun başlamadan önce seçtiği 
  oyunculardan birini klavye yardımı ile kontrol edecek ve Şirine’ye ulaştırmaya çalışacaktır. Gözlüklünün hızı tembel şirinin 2 katıdır fakat daha dayanıksızdır.
  Düşman karakterler ise oyuncuyu **Dijikstra Algoritması** yardımı ile yakalamaya çalışacaktır.
    
    
## Kullanılan Teknolojiler
- OOP
- VYA
- JFRAME
- Dijikstra Algoritması


## UML DİYAGRAMI

 Sınıf hiyerarşisi üzerine kurulan oyun mimarisi ana sınıf olan soyut karakter sınıfının temel ıd,lokasyon, vb bilgileri ile olusturulması ile baslar. düşman ve oyuncu 
 sınıfları karakter sınıfından kalıtım alırlar ve getter setter marifetleri ile ve kendilerine has parametrelerle özelleştirilirler. 
 ![image](https://user-images.githubusercontent.com/121980906/212622768-433efeea-a5dc-4e37-baca-787782645767.png)
 

  Seçim ekranı butonlar ile tembel veya gözlüklü olarak oyuncuya karakterini seçme sansı sunar. Oyuncu sınıfından türetilen tembel ve gözlüklü sınıfları özelleştirilmiştir. (örn adımSayisi)  oyuncu karakteri sabit baslangıc noktasında baslamak üzere oyuncuObje.setlokX() gibi metotlarla oyuna hazırlanır.

  Dışarıdan 0 ve 1 ler seklinde kodlanan labirent bilgisi  ve string halde sunulan düşman ve düşmanın başlangıc durum bilgileri okunarak labirent çizimi sağlanır. 
  Düşman kunan lokasyonlarda yerini almıs ve en kısa yol algoritması ile oyuncunun güncel lokasyonuna göre en kısa mesafeyi bulur, ekrana çizer ve sırası geldiğinde  
  hamlesini yapar.

  Oyun view sınıfı içerisinde oynanmakta main metodumuzda dosya okuma islemleri yapılmaktadır. 

  Puan durumu güncel olarak hesaplanmakta, ve ekrana yansıtılmaktadır. Oyun şirineye ulasıldıgını veya puanın 0 a düştüğünü yakalarsa sona ermektedir.
  
  **Harita.txt dosya yolunu A_View sınıfı içerisine güncellemeniz gerekmektedir.**



## KARMAŞIKLIK ANALİZİ : 

```
kareMatrisi();
for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                kareMatrisi[i][j] = new kare();              
                kareMatrisi[i][j].setX(i);kareMatrisi[i][j].setY(j);
           } } 
```       
11 * 13 * (1+1+1) 





 ```
 costmatrishesapla();
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
 ```
                    
11 * 13 * 11 * 13 * 5 * (1+1 +1 +1 +1)

```
rotaHesaplaHazırlık()
               kareMatrisiTemizle();
               rotaHesapla(startx, starty)

kareMatrisiTemizle();
for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
               
                if(haritaMatrisi[i][j]==0){kareMatrisi[i][j].setAgirlik(-1); kareMatrisi[i][j].setKullanildiMi(true);}
                else{kareMatrisi[i][j].setAgirlik(999);kareMatrisi[i][j].setKullanildiMi(false);kareMatrisi[i][j].setOnceki(null); }
            }}}
```

11 * 13 * (1+1+1)

```
 RotaHesapla()
kareMatrisi[startx][starty].setKullanildiMi(true); 
       
        for (int i = 0; i < 11; i++) {                      // costmatriste gidebileceği her nokta bulunuyor ve güncelleniyor
            for (int j = 0; j <13; j++) {
                
                if (kareMatrisi[i][j].isKullanildiMi()==false
                   &&  kareMatrisi[startx][starty].getAgirlik()+ costMatris[startx][starty][i][j][0] < kareMatrisi[i][j].getAgirlik()
                        ){
                    kareMatrisi[i][j].setAgirlik(kareMatrisi[startx][starty].getAgirlik() + costMatris[startx][starty][i][j][0]) ;
                    kareMatrisi[i][j].setOnceki(kareMatrisi[startx][starty]);
                }}}kareMatrisMinBul(); }
```

11 * 13 * (1+1+1+1+1+1)

```
KareMatrisMinBul
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
```

11 * 13 * (1+1+1+1+1+1+1+1)

Dijikstra Algoritması big O notasyonu algoritmanın  rekrüsif oldugu noktanın n degerinin max noktaya ulaşması sebebi ile bu noktada belirlenir. 

RotaHesapla – kareMatrisMinBul metotları arasında belirlenen big O değeri logaritmik seyretmektedir.
Metot düğüm değeri kadar tekrar edecektir .burada 11*13 düğüm değerini temsil etmektedir M = düğüm sayısı kabul edilecek olursa

Her tekrar için costMatriste mevcut yol sayısı kadar hesaplama yapma gereği ortaya cıkmaktadır. Fakat algoritma çalıştıkça kullanılmıs değerler isaretlenmekte ve her adımda adım sayısı azalmaktadır. Buda logaritmik bir azalmaya/artmaya sebep olmaktadır. 

Dolayısıyla m düğüm ve n kenar için dijikstra **big O M log N** olarak hesaplanmıstır.


### Zaman karmaşıklığı hesabı = 

+11*13*(1+1+1) + 
+11*13*11*13*5*(1+1 +1 +1 +1)
+11*13*(1+1+1)
+11*13*(1+1+1+1+1+1)  *  11*13*(1+1+1+1+1+1+1+1)

 429 + 511225 + 429 + 981552  = **1493635**
