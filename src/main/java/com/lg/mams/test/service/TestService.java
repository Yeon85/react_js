package com.lg.mams.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.mams.test.mapper.TestMapper;

/**
 * ProgramService 클래스
 * <Notice>
 * 		공통 컴포넌트 컨트롤
 * <Disclaimer>
 *		N/A
 *
 * @author 정연주
 * @since 2023-11-22
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일         수정자           	수정내용
 *  -----------	 -------------  ----------------------
 *   2023-11-23  정연주            최초 생성
 * </pre>
 */
@Service
public class TestService {
	
	@Autowired
	public TestMapper mapper;
	
	 /**
	 * 프로그램 목록을 등록한다.
	 * @param Map<String, Object> paramMap
	 * @return List<Map<String, Object>>
	 *
	 */
	public List<Map<String, Object>> selectList(Map<String, Object> paramMap) throws Exception{
		return mapper.selectList(paramMap);
	}

	public Map<String, Object> insert(Map<String, Object> paramMap) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
    	
		int duplCheckCnt = mapper.selectDuplCheckCnt(paramMap);
		
		if(duplCheckCnt > 0) {
			resultMap.put("status", "dupl");
		}else {
			int insertCnt = mapper.insert(paramMap);
			
			//insert된 row 수 리턴
			if(insertCnt > 0) {
				resultMap.put("status", "success");
			}else {
				resultMap.put("status", "error");
				//resultMap.put("msg", "error");
			}
		}
		
		return resultMap; 
	}

	/**
	 * 프로그램 목록을 수정한다.
	 * @param Map<String, Object> paramMap
	 * @return List<Map<String, Object>>
	 *
	 */
	public Map<String, Object> update(Map<String, Object> paramMap) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int insertCnt = mapper.update(paramMap);
		
		//update된 row 수 리턴
		if(insertCnt > 0) {
			resultMap.put("msg", "ok");
		}else {
			resultMap.put("msg", "error");
		}
		
		return resultMap;
	}
	
	/**
	 * 프로그램 목록을 삭제한다.
	 * @param Map<String, Object> paramMap
	 * @return List<Map<String, Object>>
	 *
	 */
	public Map<String, Object> delete(Map<String, Object> paramMap) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int insertCnt = mapper.delete(paramMap);
		
		//delete된 row 수 리턴
		if(insertCnt > 0) {
			resultMap.put("msg", "ok");
		}else {
			resultMap.put("msg", "error");
		}
		
		return resultMap;
	}

}
