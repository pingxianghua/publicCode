package com.study.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maiyajf.apply.loan.jk.po.ServiceFeeVo;

@Component
public class StudyWorker extends SyncCacheWorker<StudyDTO, Map<String,Object>> {

	@Autowired
	StudyDAO studyDAO;
	
	@Autowired
    protected RedisCacheUtil redisCacheUtil;//这里redis版本不一样，大家可以自行决定
	
	@Override
	protected StudyDTO read(Map<String,Object> params) {
		//从缓存查询数据并返回
		//TODO
		StudyDTO result = redisCacheUtil.get(params.get("id"));
		
		return result;
	}

	@Override
	protected StudyDTO write(Map<String,Object> params) {
		//从数据库查询数据并返回
		StudyDTO result = studyDAO.getStudy(params);
		
		if (null != result) {
			String key = (String)params.get("id");
			// 先删除缓存再插入
            if (redisCacheUtil.exists(key)) {
            	redisCacheUtil.del(key);
            }
            redisCacheUtil.set(key, StudyDTO);
		}
		return result;
	}
	
	
	public void test(){
		//无锁的
		StudyDTO result1 = serviceFeeWorker.findByNoLock(params);
		//有锁的
		StudyDTO result2 = serviceFeeWorker.find(params);
		
		
	}
	
}
