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
public class CellPhone extends Product {
	private int cameraSize;
	private String ramSize;

	public CellPhone(int pid, String brand, String model, int cameraSize, String ramSize) {
		super(pid, brand, model);
		this.cameraSize = cameraSize;
		this.ramSize = ramSize;
	}

	public int getCameraSize() {
		return cameraSize;
	}

	public void setCameraSize(int cameraSize) {
		this.cameraSize = cameraSize;
	}

	public String getRamSize() {
		return ramSize;
	}

	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}

	@Override
	public String toString() {
		return super.toString() + " --CellPhone [cameraSize=" + cameraSize + ", ramSize=" + ramSize + "]";
	}

}