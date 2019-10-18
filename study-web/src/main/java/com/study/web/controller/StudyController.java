package com.study.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.service.StudyService;
import com.study.web.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/study")
public class StudyController {

	@Autowired
	StudyService studyService;
	
	/**
	 * 无返回Data
	 */
	@PostMapping("/testVoid")
	public ResponseDTO<Void> testVoid(){
		
		ResponseDTO<Void> result = ResponseDTO.success();
		try {
			//业务代码
			studyService.testVoid();
		} catch (Exception e) {
			log.error("处理异常", e);
			result.setResult(false);
			result.setCode("500");
			result.setMsg("异常");
		}
		return result;
	}
	
	/**
	 * 返回对象
	 */
	@PostMapping("/testString")
	public ResponseDTO<String> testString(){
		
		ResponseDTO<String> result = ResponseDTO.success();
		try {
			//业务代码
			String data = studyService.testString();
			result.setData(data);
		} catch (Exception e) {
			log.error("处理异常", e);
			result.setResult(false);
			result.setCode("500");
			result.setMsg("异常");
		}
		return result;
	}
	
	/**
	 * 返回对象列表
	 */
	@PostMapping("/testList")
	public ResponseDTO<List<String>> testList(){
		
		ResponseDTO<List<String>> result = ResponseDTO.success();
		try {
			//业务代码
			List<String> data = studyService.testList();
			result.setData(data);
		} catch (Exception e) {
			log.error("处理异常", e);
			result.setResult(false);
			result.setCode("500");
			result.setMsg("异常");
		}
		return result;
	}
}
