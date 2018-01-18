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
public abstract class Product {
	private int pId;
	private String pBrand;
	private String pModel;

	public Product() {

	}

	public Product(int pId, String pBrand, String pModel) {
		super();
		this.pId = pId;
		this.pBrand = pBrand;
		this.pModel = pModel;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getpModel() {
		return pModel;
	}

	public void setpModel(String pModel) {
		this.pModel = pModel;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pBrand=" + pBrand + ", pModel=" + pModel + "]";
	}

}