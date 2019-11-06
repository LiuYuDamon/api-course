package com.damon.course.mapper;

import java.util.List;

import com.damon.course.model.MentorCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface MentorMapper {
	
	@Select("SELECT a.id,a.name,a.mentorName,a.skill,a.startDate,a.endDate,a.fee, coalesce(b.rating, 0) as rate, a.description FROM course a  left join (SELECT courseId, round(avg(rating)) as rating FROM rate group by courseId) b on a.id =b.courseid where a.status='available'")
	List<MentorCourse> findMentors();
	
	@Select("SELECT a.id,a.name,a.mentorName,a.skill,a.startDate,a.endDate,a.fee, a.description, a.userName FROM course a where a.userName is null")
	List<MentorCourse> searchMentors();
	
	@Update("update course set userName=#{username},progress=1 where id = #{id}")
	void bookCourse(@Param("username") String username, @Param("id") Integer id);

}