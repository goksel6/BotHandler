/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bothandler;

import java.lang.reflect.Array;
import java.util.List;

/**
 *
 * @author MONSTER
 */

//BU SINIF 'PRODUCT' SINIFININ ALTSINIFLARI OLAN CELLPHONE TELEVISION VE ISINLANMACİHAZI SINIFLARI TİPİNDEN 
//DÖNDÜRDÜKLERİNİ DAHA BU SINIFLARIN NESNELERİNİN OLUŞTURULMAYA GEREK DUYULDUĞU YERLERDE PRODUCT SINIFI TÜRÜNDEN OLUŞTURULMUŞ NESNEYE RETURN İLE  DÖNDÜRÜR.
//POLİMORFİK BİR ATAMA GERÇEKLEŞİR.
public class ProductFactory {
    
    public static Product createProduct(String tür, String[] özellikler)
    {
        
        if(tür.equals(CellPhone.class.getSimpleName()))       
            return new CellPhone(Integer.parseInt(özellikler[0]),özellikler[1], özellikler[2],Integer.parseInt(özellikler[3]),özellikler[4]);
        else if(tür.equals(Television.class.getSimpleName()))
                return new Television(Integer.parseInt(özellikler[0]),özellikler[1], özellikler[2],Integer.parseInt(özellikler[3]),özellikler[4]);
        else if(tür.equals(IsınlanmaCihazi.class.getSimpleName()))  
                return new IsınlanmaCihazi(Integer.parseInt(özellikler[0]),özellikler[1], özellikler[2],Integer.parseInt(özellikler[3]),özellikler[4]);
        else 
            return null;
        
    }
}
