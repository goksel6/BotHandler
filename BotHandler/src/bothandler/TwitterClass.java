
package bothandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterClass {
      
    
   public  ChatBot siri;
    
    public TwitterClass(ChatBot s) {
        
        siri = s;
    }

    //TWİTTERDAN VERİLEN "tag" İLE İLGİLİ TWEETLERİ ÇEKER. DOSYAYA YAZAR.
    //PROJE KONTROLÜ SIRASINDA TWEET ÇEKME İŞLEMİ YAPMAYACAĞIMIZ İÇİN BEN BU METOTTA HERBİR KATEGORİ İÇİN YARATTIĞIM HERBİR DOSYAYA BİRER KERE TWEET ÇEKTİM.BU METOT ŞU ANDA HİÇBİR YERE BAĞLI DEĞİLDİR VE KULLANILMAMAKTADIR. 
        public   void tweetcek(String tag){
          
           
       ConfigurationBuilder cf = new ConfigurationBuilder();
                 cf.setDebugEnabled(true)
                         .setOAuthConsumerKey("PXdDvlw9rjdfXdBjzjH198KQa")
                         .setOAuthConsumerSecret("8WxzEQVYwGi1YRUtY7U2PkYRczrMBjVjMoyHUq88tgGJWxKUSI")
                         .setOAuthAccessToken("375506374-kdIcAQA08Zy00wy2wAELTztbRpeTlll1I9HHroIR")
                         .setOAuthAccessTokenSecret("TS4eBJAG85f5MYvLuwuEbmEfqbuFvcOfFcbdVoLOEsDWF");
                               
			
                    
                 TwitterFactory tf=new TwitterFactory(cf.build());
            twitter4j.Twitter twitter=tf.getInstance();
        try {
            Query query = new Query(tag);
            query.setCount(20);//sınırlandırıyor
            QueryResult result;
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) 
                {
                    if (tweet.getLang().equals("en")) //ingilizce tweet seçiyor
                    {
                        
                        try {
	                  File dosya = new File("tweetDosya.txt");
	                  FileWriter yazici = new FileWriter(dosya,true);
	                  BufferedWriter yaz = new BufferedWriter(yazici);
                         
	                  yaz.write(tag + tweet.getText());                        
                       yaz.newLine();         
	                  yaz.close();
	                  System.out.println("Ekleme İşlemi Başarılı");
	            }
	            catch (Exception hata){
	                  hata.printStackTrace();
	            }
				                                                                     
                    }  
                                        
                }
          System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        } 
                
             
   }
        //GÖNDERİLEN "dosya"DAKİ VERİLERİ GÖNDERİLEN "model" ANAHTAR KELİMESİYLE  TARAYARAK O KELİMEYİ İÇEREN SATIRLARI DÖNDÜRECEĞİ LİSTEYE EKLER.
        //BU FONKSİYON MODELLE İLGİLİ ATILAN TWEETLERİ BİR LİSTEDE TUTMAMIZ İÇİN YAZILDI.
        public  ArrayList<String> DosyaListele(File dosya, String model)throws FileNotFoundException, IOException
        {
            ArrayList<String> BirmodelListesi = new ArrayList<String>();
            FileInputStream FIS = new FileInputStream(dosya);
            BufferedReader buf = new BufferedReader(new InputStreamReader(FIS));            
            String yorum = buf.readLine();
            while(yorum!= null) {
            
            if(yorum.contains(model))
             {
                  BirmodelListesi.add(yorum);      
                   
                         
             }
            yorum = buf.readLine();   
            
            }
       
            return BirmodelListesi;
           
        }
        
        //LİSTEYİ ALIR HER BİR ELEMANI OLAN CÜMLEYİ KELİMELERE BÖLER O KELİMELERİ BAŞKA BİR LİSTEYE KOYAR VE GERİ DÖNDÜRÜR.
        public  ArrayList<String> KelimelereBol(ArrayList<String> mListe)
     {
         ArrayList<String> modelinKelimeleri = new ArrayList<String>();
         for(String listeninBirElemani : mListe)   
         {
             
          StringTokenizer tokenizer = new StringTokenizer(listeninBirElemani);
           while (tokenizer.hasMoreTokens()) {         
           modelinKelimeleri.add(tokenizer.nextToken());
           }
          
           
            
         }
        return modelinKelimeleri;
        }
        
    //SenticNetSingleton SINIFI İÇİNDE TANIMLADIĞIMIZ PUT METHODUNU KULLANARAK SenticNetSingleton SINIFINDAKİ HASHTABLOSUNA senticnet4.txt'DEN OKUDUĞUMUZ KELİMELERİ VE DEĞERLERİNİ ÇEKER.
             
        public   SenticNetSingleton hashtablofonksiyon(List<String> kelimeler) throws FileNotFoundException, IOException
        {
            
       //GET INSTANCE ARACILIĞIYLA SenticNetSingleton SINIFINA AİT BİR NESNE OLUŞTURUYORUZ.
            SenticNetSingleton aslındaNesne = SenticNetSingleton.getInstance() ;
        
            FileInputStream FS = new FileInputStream("files/senticnet4.txt");
            
            
            BufferedReader br = new BufferedReader(new InputStreamReader(FS));            
            String Satir = br.readLine();
            
            
        String[] cumle;
        
        while (Satir != null) {
            cumle = Satir.split("\t");
            aslındaNesne.put(cumle[0], cumle[2]);
            Satir = br.readLine();
            
        }

    
        return (aslındaNesne);
        }
        //PARAMETRE OLARAK TELEFON LİSTESİ ALIR. VE YUKARDA AÇIKLADIĞIMIZ METODLARA GÖNDEREREK EN SONUNDA BİR PUAN DEĞERİNE ULAŞIR. BU METODUN ANA AMACI TweetClass CİNSİNDEN NESNE OLUŞTURUP CHATBOT SINIFINDAKİ TELEFONLAR LİSTESİNE EKLEMEKTİR.
        public  void Fonks(ArrayList<CellPhone> cellList) throws IOException {
              SenticNetSingleton aslındaNesne = SenticNetSingleton.getInstance() ;
             ArrayList<String> kelimelerListesi = new ArrayList<>();   
               ArrayList<String> mListe = new ArrayList<>();  
               Double topPuan=0.0;
                    Double topPuan2=0.0;
               File tweetDosya = new File("tweetDosya.txt");
           for(CellPhone cellP : cellList){
                mListe=  DosyaListele(tweetDosya,cellP.getpModel());
                kelimelerListesi = KelimelereBol(mListe);
                aslındaNesne = hashtablofonksiyon(kelimelerListesi);   
                 Anaclass birinci = new HesapSınıf1();

         //topPuan DEĞİŞKENİNDE HesapSınıfı1 SINIFINCA HESAPLANMIŞ BİR PUAN VARDIR.
        //topPuan2 DEĞİŞKENİNDE HesapSınıfı2 SINIFINCA HESAPLANMIŞ BİR PUAN VARDIR.
               topPuan=  birinci.trytoHesapla(kelimelerListesi, aslındaNesne);
               birinci.setHesaplaType(new Hesapla2());
             //Anaclass ikinci = new HesapSınıf2();
           //birinci'NİN TİPİNİ setHesaplaType METHODUNU KULLANARAK Hesapla2 SINIFI TÜRÜNE FÖNÜŞTÜRÜYORUZ. 
          //VE   '  Anaclass ikinci = new HesapSınıf2(); ' ŞEKLİNDE BİR 'ikinci' NESNESİ OLUŞTURMAK YERİNE 'birinci'yi KULLANARAK Hesapla2 TÜRÜNDEN HESAPLAMA YAPIYORUZ
               topPuan2= birinci.trytoHesapla(kelimelerListesi, aslındaNesne);
                 topPuan= topPuan/mListe.size();
                TweetClass s = new TweetClass(topPuan, mListe, cellP.getpModel());
                  TweetClass s2 = new TweetClass(topPuan2, mListe, cellP.getpModel());
                siri.Telefonlar.add(s);
                 siri.Telefonlar.add(s2);
               for(String st : mListe){
                   System.out.println(st);
               }
           }
          
       }
       // BU METODUN ANA AMACI TweetClass CİNSİNDEN NESNE OLUŞTURUP CHATBOT SINIFINDAKİ TVler LİSTESİNE EKLEMEKTİR.
        public  void FonksTV(ArrayList<Television> tvList) throws IOException {
                          SenticNetSingleton aslındaNesne = SenticNetSingleton.getInstance() ;

             ArrayList<String> kelimelerListesi = new ArrayList<>();   
               ArrayList<String> mListe = new ArrayList<>();  
               Double topPuan;
               Double topPuan2;
              
               File tweetDosya = new File("tweetTV.txt");
           for(Television tv : tvList){
                mListe=  DosyaListele(tweetDosya,tv.getpModel());
                kelimelerListesi = KelimelereBol(mListe);
                 aslındaNesne = hashtablofonksiyon(kelimelerListesi);   
                 Anaclass birinci = new HesapSınıf1();
//                 Anaclass ikinci = new HesapSınıf2(); 
          //topPuan DEĞİŞKENİNDE HesapSınıfı1 SINIFINCA HESAPLANMIŞ BİR PUAN VARDIR.
        //topPuan2 DEĞİŞKENİNDE HesapSınıfı2 SINIFINCA HESAPLANMIŞ BİR PUAN VARDIR.
               topPuan=  birinci.trytoHesapla(kelimelerListesi, aslındaNesne);
              //birinci'NİN TİPİNİ setHesaplaType METHODUNU KULLANARAK Hesapla2 SINIFI TÜRÜNE FÖNÜŞTÜRÜYORUZ. 
              //VE   '  Anaclass ikinci = new HesapSınıf2(); ' ŞEKLİNDE BİR 'ikinci' NESNESİ OLUŞTURMAK YERİNE 'birinci'yi KULLANARAK Hesapla2 TÜRÜNDEN HESAPLAMA YAPIYORUZ
               birinci.setHesaplaType(new Hesapla2());
               
               topPuan2= birinci.trytoHesapla(kelimelerListesi, aslındaNesne);
                     topPuan= topPuan/mListe.size();
                TweetClass s = new TweetClass(topPuan, mListe, tv.getpModel());
                 TweetClass s2 = new TweetClass(topPuan2, mListe, tv.getpModel());
                siri.TVler.add(s);
                siri.TVler2.add(s2);
               for(String st : mListe){
                   System.out.println(st);
               }
           }
          
       }
       // BU METODUN ANA AMACI TweetClass CİNSİNDEN NESNE OLUŞTURUP CHATBOT SINIFINDAKİ isinlanmaChzlar LİSTESİNE EKLEMEKTİR.
        public  void Fonksisinlanma(ArrayList<IsınlanmaCihazi> isinList) throws IOException {
                          SenticNetSingleton aslındaNesne = SenticNetSingleton.getInstance() ;

             ArrayList<String> kelimelerListesi = new ArrayList<>();   
               ArrayList<String> mListe = new ArrayList<>();  
               Double topPuan;
               Double topPuan2;
               File tweetDosya = new File("tweetisin.txt");
           for(IsınlanmaCihazi isin : isinList){
                mListe=  DosyaListele(tweetDosya,isin.getpModel());
                kelimelerListesi = KelimelereBol(mListe);
               aslındaNesne = hashtablofonksiyon(kelimelerListesi);   
                 Anaclass birinci = new HesapSınıf1();            
//                 Anaclass ikinci = new HesapSınıf2();
                 
       //topPuan DEĞİŞKENİNDE HesapSınıfı1 SINIFINCA HESAPLANMIŞ BİR PUAN VARDIR.
        //topPuan2 DEĞİŞKENİNDE HesapSınıfı2 SINIFINCA HESAPLANMIŞ BİR PUAN VARDIR.
 
               topPuan=  birinci.trytoHesapla(kelimelerListesi, aslındaNesne);
               birinci.setHesaplaType(new Hesapla2());
               topPuan2= birinci.trytoHesapla(kelimelerListesi, aslındaNesne);
               topPuan= topPuan/mListe.size();
                TweetClass s = new TweetClass(topPuan, mListe, isin.getpModel());      
              TweetClass s2 = new TweetClass(topPuan2, mListe, isin.getpModel());

                siri.isinlanmaChzlar.add(s);
                   siri.isinlanmaChzlar2.add(s2);
               for(String st : mListe){
                   System.out.println(st);
               }
           }
          
       }
        

}
