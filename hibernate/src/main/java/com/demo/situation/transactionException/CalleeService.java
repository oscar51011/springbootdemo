package com.demo.situation.transactionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.JobDaoImpl;
import com.demo.entity.Job;

/**
 * 被呼叫的 Service
 * @author oscar51011
 * @date 2022年4月22日
 */
@Service
public class CalleeService {

	@Autowired
	private JobDaoImpl jobDaoImpl;
	
	
	//  ( **解決方案** ) 設置為開一個新的 transactional
	// @Transactional(propagation = Propagation.REQUIRES_NEW)
	@Transactional
	public void updateJob() {
		Job job = jobDaoImpl.getJobById(1L);
		job.setDescription("test2");
		jobDaoImpl.updateJob(job);
		// 預期出錯, 檢查會不會rollback
		System.out.println(1/0);
	} 
}
