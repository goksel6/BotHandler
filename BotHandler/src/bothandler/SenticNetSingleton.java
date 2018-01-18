/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bothandler;


import java.util.Hashtable;

/**
 *
 * @author MONSTER
 */
public class SenticNetSingleton {
  //BU SINIFTA OLUŞTURULAN HASHTABLE TABLOSUNA İLERDE SENTİCNET ATANIR.
      private static SenticNetSingleton sing = new SenticNetSingleton();
    private Hashtable<String, String> hashTablo;
    
    
	private SenticNetSingleton() 
        {
                hashTablo = new Hashtable<String,String>();
	}
        public static SenticNetSingleton getInstance()
        {
            return sing;
                    
        }
        public void put(String Key, String Value)
        {
            hashTablo.put(Key, Value);
        }
        public int getSize()
        {
            return hashTablo.size();
            
        }
        public String get(String key)
        {
            return hashTablo.get(key);
           
        }
        public boolean containsKey(String key)
        {
            return(hashTablo.containsKey(key));
            
        }

   
   
   
    
}
