package com.demo.situation.transactionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.demo.dao.JobDaoImpl;
import com.demo.entity.Job;

/**
 * 呼叫流程的服務
 * @author oscar51011
 * @date 2022年4月22日
 */
@Service
public class CallerService {
	
	@Autowired
	private CalleeService calleeService;

	@Autowired
	private JobDaoImpl jobDaoImpl;
	
	@Transactional
	public void addJob() {
		// insert sql
		Job job = new Job();
		job.setId(3L);
		job.setDescription("test");
		jobDaoImpl.addJob(job);
		try {
			// call update sql service
			calleeService.updateJob();
		} catch (Exception e) {
			System.out.println("catch Exception");
			// ( **解決方案** )設定手動回滾
			// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}		
		System.out.println("service done.");
	}
	
}
