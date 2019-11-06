package com.damon.course.apicontroller;

import com.damon.course.mapper.CourseMapper;
import com.damon.course.mapper.RateMapper;
import com.damon.course.model.Course;
import com.damon.course.model.Rate;
import com.damon.course.rspmodel.RspModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(description = "SBA Course Interface")
public class SbaCourseApi {

	@Autowired
	private CourseMapper courseMapper;

	@Autowired
	private RateMapper rateMapper;
	

	@RequestMapping(value = "/addcourse", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "SBA Account Register")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"), @ApiResponse(code = 403, message = "No Permission"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<RspModel> addCourse(@ApiParam(name = "body", required = true) @RequestBody Course course) {

		try {

			courseMapper.addCourse(course);
			
			RspModel rsp = new RspModel();
			rsp.setCode(200);
			rsp.setMessage("Course Created");
			return new ResponseEntity<RspModel>(rsp, HttpStatus.CREATED);

		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(value = "/addrate", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "SBA Account Register")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"), @ApiResponse(code = 403, message = "No Permission"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<RspModel> addRate(@ApiParam(name = "body", required = true) @RequestBody Rate rate) {

		try {

			rateMapper.addRate(rate);

			RspModel rsp = new RspModel();
			rsp.setCode(200);
			rsp.setMessage("Rated");
			return new ResponseEntity<RspModel>(rsp, HttpStatus.CREATED);

		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
