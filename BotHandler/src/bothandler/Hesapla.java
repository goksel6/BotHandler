/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bothandler;

import java.util.List;

/**
 *
 * @author MONSTER
 */
public interface Hesapla {
    Double puanHesapla(List <String> kelimeler, SenticNetSingleton aslındaNesne);
}
//Hesapla İNTERFACE'İ 2 FARKLI ŞEKİLDE İMPLEMENTE EDİLİR. BU 2 FARKLI ŞEKİL BİZİM 2 FARKLI PUAN HESAPLAMA YÖNTEMLERİMİZİ OLUŞTURUR.
class Hesapla1 implements Hesapla{
    
 //BİRİNCİ İMPLEMENTASYONUNDA O MODEL İÇİN VERİLEN TWEETLERİN KELİMELERİNİN PUANLARI TOPLANIR. DAHA SONRA BU METHODUN ÇAĞIRILDIĞI YERDE TWEET SAYISINA BÖLÜNEREK topPuan1 DEĞİŞKENİNİN OLUŞTURULMASINI SAĞLAYACAKTIR. 
    public Double puanHesapla(List <String> kelimeler, SenticNetSingleton aslındaNesne) {
         Double topPuan = 0.00;          
           String puan = null ;
 System.out.println("\n BİRİNCİ HESAPLAMA ŞEKLİNE GÖRE HESAPLANMAYA BAŞLANIYOR \n");
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                for(String kelime : kelimeler)
        {  
            
            
        if(aslındaNesne.containsKey(kelime)) 
        {           
          puan= aslındaNesne.get(kelime);        
    
           System.out.println(kelime);
           System.out.println("version1kelimenin puanı");
           System.out.println(puan);  
        
        }
       
         if(aslındaNesne.containsKey(kelime)== true && puan != null){            
         topPuan += Double.parseDouble(puan);
         System.out.println("version1ara toplam puanı");
           System.out.println(topPuan);  
       
       }
         
            
        }
        return topPuan;
    }
    
   
}
class Hesapla2 implements Hesapla{
 
//İKİNCİ İMPLEMENTASYONUNDA O MODEL İÇİN VERİLEN TWEETLERİN KELİMELERİNİN PUANLARI TOPLANIR VE KELİME SAYISINA BÖLÜNÜR. DAHA SONRA BU METHODUN ÇAĞIRILDIĞI YERDE topPuan2 DEĞİŞKENİNİN OLUŞTURULMASINI SAĞLAYACAKTIR. 

    public Double puanHesapla(List <String> kelimeler, SenticNetSingleton aslındaNesne) {

         Double topPuan = 0.00;          
           String puan = null ;
        
                for(String kelime : kelimeler)
        {  
            
            
        if(aslındaNesne.containsKey(kelime)) 
        {           
          puan= aslındaNesne.get(kelime);        
    
           System.out.println(kelime);
           System.out.println(puan);  
        
        }
       
         if(aslındaNesne.containsKey(kelime)== true && puan != null){            
         topPuan += Double.parseDouble(puan);      
           System.out.println(topPuan);  
       
       }
                    
        }
        return topPuan/kelimeler.size();
    }
    
   
}
