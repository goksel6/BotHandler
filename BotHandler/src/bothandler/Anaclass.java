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

//BU SINIF HesaplaSınıf1 ve HesaplaSınıf2 SINIFLARININ ÜSTSINIFIDIR.
public class Anaclass {
    public Hesapla puanType;
   
    void setHesaplaType(Hesapla newpuanType)
    {
        puanType = newpuanType;
    }

    Double trytoHesapla(List<String> kelimeler, SenticNetSingleton aslındaNesne) {
        return puanType.puanHesapla(kelimeler, aslındaNesne);
     
    }
}
