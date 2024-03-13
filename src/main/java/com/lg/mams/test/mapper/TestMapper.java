package com.lg.mams.test.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {
	
	public List<Map<String,Object>> selectList(Map<String, Object> params) throws Exception;

	public int selectDuplCheckCnt(Map<String, Object> paramMap);
	
	public int insert(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public int delete(Map<String, Object> paramMap);



}
