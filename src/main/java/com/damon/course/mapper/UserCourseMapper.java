package com.damon.course.mapper;

import java.util.List;

import com.damon.course.model.UserCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface UserCourseMapper {

	@Select("SELECT id,skill,name,description,startDate,endDate,mentorName,progress,tags FROM course where progress=#{progress} and userName=#{username}and (a.name LIKE CONCAT('%',#{searchText},'%') or a.tags LIKE CONCAT('%',#{searchText},'%'))")
	List<UserCourse> findUserCourse(@Param("username") String username, @Param("progress") Integer progress,@Param("searchText") String searchText);
}
