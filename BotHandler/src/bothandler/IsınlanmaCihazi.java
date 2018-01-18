/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bothandler;

/**
 *
 * @author Köksal
 */
public class IsınlanmaCihazi extends Product {
	private int YerSapmasiyuzdesi;
	private String hucreKaybi;

	public IsınlanmaCihazi(int id, String brand, String model, int YerSapmasiyuzdesi, String hucreKaybi) {
		super(id, brand, model);
		this.YerSapmasiyuzdesi = YerSapmasiyuzdesi;
		this.hucreKaybi = hucreKaybi;
	}

	public int getCameraSize() {
		return YerSapmasiyuzdesi;
	}

	public void setCameraSize(int YerSapmasiyuzdesi) {
		this.YerSapmasiyuzdesi = YerSapmasiyuzdesi;
	}

	public String getRamSize() {
		return hucreKaybi;
	}

	public void setRamSize(String ramSize) {
		this.hucreKaybi = hucreKaybi;
	}

	@Override
	public String toString() {
		return super.toString() + " --IsınlanmaCihazi [YerSapmasiyuzdesi=" + YerSapmasiyuzdesi + ", hucreKaybi=" + hucreKaybi + "]";
	}

}