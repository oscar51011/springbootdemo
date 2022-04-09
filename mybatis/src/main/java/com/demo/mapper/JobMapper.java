package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.entity.Job;

@Mapper
public interface JobMapper {

	@Select("SELECT * FROM JOB")
    @Results({
        @Result(property = "id",  column = "ID"),
        @Result(property = "description", column = "DESCRIPTION")
    })
    List<Job> getAll();
	
	@Select("SELECT * FROM JOB WHERE ID =#{id}")
    @Results({
        @Result(property = "id",  column = "ID"),
        @Result(property = "description", column = "DESCRIPTION")
    })
	Job getById(Long id);
	
	@Update("UPDATE JOB SET DESCRIPTION=#{description} WHERE ID =#{id}")
    void update(Job job);
}
