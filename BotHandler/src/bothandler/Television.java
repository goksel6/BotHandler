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
public class Television extends Product {
	private int screenSize;
	private String receiver ;

	public Television(int pid, String brand, String model, int screenSize, String receiver) {
		super(pid, brand, model);
		this.screenSize = screenSize;
		this.receiver = receiver;
	}

	public int getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}

	public String getreceiver() {
		return receiver;
	}

	public void setreceiver(String receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return super.toString() + " --Television [cameraSize=" + screenSize + ", receiver=" + receiver + "]";
	}

}