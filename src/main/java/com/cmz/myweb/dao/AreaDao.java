package com.cmz.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.domain.City;
import com.cmz.myweb.domain.Country;
import com.cmz.myweb.domain.Province;

public interface AreaDao {
	public final static String CTable = "`country`";
	public final static String PTable = "`province`";
	public final static String CityTable = "`city`";
	
	public final static String cfields = "`id`,`name`";
	public final static String pfields = "`id`,`countryid`,`name`";
	public final static String cityfields = "`id`,`countryid`,`provinceid`,`name`";
	
	
	@Insert("INSERT INTO "+CTable+"("+cfields+")VALUES(0,#{c.name})")
	public int addCountry(@Param("c")Country country);
	@Insert("INSERT INTO "+PTable+"("+pfields+")VALUES(0,#{p.countryid},#{p.name})")
	public int addProvince(@Param("p")Province province);
	@Insert("INSERT INTO "+CityTable+"("+cityfields+")VALUES(0,#{c.countryid},#{c.provinceid},#{c.name})")
	public int addCity(@Param("c")City city);
	
	@Update("UPDATE "+CTable+" SET `name`=#{c.name} WHERE `id`=#{c.id}")
	public int updateCountry(@Param("c")Country country);
	@Update("UPDATE "+PTable+" SET `countryid`=#{p.countryid},`name`=#{p.name} WHERE `id`=#{p.id}")
	public int updateProvince(@Param("p")Province province);
	@Update("UPDATE "+CityTable+" SET `countryid`=#{c.countryid},`provinceid`=#{c.provinceid},`name`=#{c.name} WHERE `id`=#{c.id}")
	public int updateCity(@Param("c")City city);
	
	@Select("SELECT COUNT(1) FROM "+CTable)
	public int allCountry();
	
	@Select("SELECT COUNT(1) FROM "+PTable)
	public int allProvince();
	
	@Select("SELECT COUNT(1) FROM "+CityTable)
	public int allCity();
	
	@Select("SELECT "+cfields+" FROM "+CTable+" WHERE id=#{id}")
	public Country getCountryById(@Param("id")int id);
	@Select("SELECT "+pfields+" FROM "+PTable+" WHERE id=#{id}")
	public Province getProvinceById(@Param("id")int id);
	@Select("SELECT "+cityfields+" FROM "+CityTable+" WHERE id=#{id}")
	public City getCityById(@Param("id")int id);
	
	@Select("SELECT "+cfields+" FROM "+CTable+" LIMIT #{from},#{num}")
	public List<Country> listCountry(@Param("from")int from,@Param("num")int num);
	
	@Select("SELECT p.id,p.countryid,p.name FROM "+PTable+" as p LEFT JOIN "+CTable+" as c ON p.countryid=c.id ORDER BY p.id asc LIMIT #{from},#{num}")
	public List<Province> listProvince(@Param("from")int from,@Param("num")int num);
	
	@Select("SELECT c.id,c.countryid,c.provinceid,c.name FROM "+CityTable+" as c LEFT JOIN ("+CTable+" as c1,"+PTable+" as p) ON (c.countryid=c1.id and c.provinceid=p.id) ORDER BY c.id asc LIMIT #{from},#{num}")
	public List<City> listCity(@Param("from")int from,@Param("num")int num);
	
	@Select("SELECT "+pfields+" FROM "+PTable+" WHERE `countryid`=#{countryid}")
	public List<Province> getProvinces(@Param("countryid")int countryid);
	
	@Select("SELECT "+cityfields+" FROM "+CityTable+" WHERE `countryid`=#{countryid} AND `provinceid`=#{provinceid}")
	public List<City> getCitys(@Param("countryid")int countryid,@Param("provinceid")int provinceid);
}
