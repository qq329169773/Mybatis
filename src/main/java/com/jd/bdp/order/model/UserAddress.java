package com.jd.bdp.order.model;

import org.apache.ibatis.type.Alias;

@Alias("userAddress")
public class UserAddress {

	private Integer addressId;
 	private String addressProvince;
	private String adressCity;
	private String addressDetail;
	private String addressType ;
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	 

	public String getAddressProvince() {
		return addressProvince;
	}

	public void setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
	}

	public String getAdressCity() {
		return adressCity;
	}

	public void setAdressCity(String adressCity) {
		this.adressCity = adressCity;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	
}
