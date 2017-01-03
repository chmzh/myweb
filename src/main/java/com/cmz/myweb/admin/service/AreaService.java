package com.cmz.myweb.admin.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.admin.dao.AreaDao;
import com.cmz.myweb.admin.domain.City;
import com.cmz.myweb.admin.domain.Country;
import com.cmz.myweb.admin.domain.Province;

@Service
public class AreaService {
	@Autowired
	private AreaDao areaDao;
	
	
	public int addCountry(Country country){
		return areaDao.addCountry(country);
	}
	
	public int addProvince(Province province){
		return areaDao.addProvince(province);
	}
	
	public int addCity(City city){
		return areaDao.addCity(city);
	}
	
	
	public int updateCountry(Country country){
		return areaDao.updateCountry(country);
	}
	
	public int updateProvince(Province province){
		return areaDao.updateProvince(province);
	}
	
	public int updateCity(@Param("c")City city){
		return areaDao.updateCity(city);
	}
	
	
	public int allCountry(){
		return areaDao.allCountry();
	}
	
	
	public int allProvince(){
		return areaDao.allProvince();
	}
	
	
	public int allCity(){
		return areaDao.allCity();
	}
	
	
	public Country getCountryById(int id){
		return areaDao.getCountryById(id);
	}
	
	public Province getProvinceById(int id){
		return areaDao.getProvinceById(id);
	}
	
	public City getCityById(int id){
		return areaDao.getCityById(id);
	}
	

	public List<Country> listCountry(int from,int num){
		return areaDao.listCountry(from, num);
	}
	
	
	public List<Province> listProvince(int from,int num){
		return areaDao.listProvince(from, num);
	}
	
	
	public List<City> listCity(int from,int num){
		return areaDao.listCity(from, num);
	}

	public List<Province> getProvinces(int countryid) {
		
		return areaDao.getProvinces(countryid);
	}
	
	public List<City> getCitys(int countryid,int provinceid){
		return areaDao.getCitys(countryid, provinceid);
	}
}
