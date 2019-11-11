package com.damon.course.mapper;

import com.damon.course.model.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;



@Mapper
public interface CourseMapper {

	@Insert("insert into course(name,description,skill,startDate,endDate,mentorName,fee,tags) values(#{name},#{description},#{skill},#{startDate},#{endDate},#{mentorName},#{fee},#{tags})")
	@SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
	void addCourse(Course course);
}
