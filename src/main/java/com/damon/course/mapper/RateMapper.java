package com.damon.course.mapper;

import com.damon.course.model.Rate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;


@Mapper
public interface RateMapper {

	@Insert("insert into rate(mentorId,rating) values(#{mentorId},#{rating})")
	@SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
	void addRate(Rate rate);
}
