package com.cmz.myweb.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.admin.dao.SchemaDao;
import com.cmz.myweb.admin.domain.Schema;

@Service
public class SchemaService {
	@Autowired
	private SchemaDao schemaDao;
	
	public int add(Schema schema){
		return schemaDao.add(schema);
	}
	
	public int count(){
		return schemaDao.count();
	}
	
	public List<Schema> list(int from,int num){
		return schemaDao.list(from, num);
	}
	public int update(Schema schema){
		return schemaDao.update(schema);
	}

	public Schema getSchemaById(int id) {
		return schemaDao.getSchemaById(id);
	}


}
