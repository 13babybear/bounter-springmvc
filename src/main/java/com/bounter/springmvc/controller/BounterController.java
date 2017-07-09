package com.bounter.springmvc.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bounter.springmvc.entity.Bounter;
import com.bounter.springmvc.entity.ResponseData;

@RestController
public class BounterController {
	
	/**
	 * Get: http://localhost:8080/bounter/1001
	 * @param id
	 * @return
	 */
	@RequestMapping("/bounter/{id}")
	private ResponseData<Bounter> getBounterPathVariable(@PathVariable Long id) {
		ResponseData<Bounter> responseData = new ResponseData<>();
		
		if(id == 1001L) {
			Bounter bounter = new Bounter();
			bounter.setId(1001L);
			bounter.setName("测试");
			bounter.setValue("001");
			bounter.setTimestamp(System.currentTimeMillis());
			responseData.setData(bounter);
			responseData.setSuccess(true);
		} else {
			responseData.setSuccess(false);
			responseData.setErrorMsg(id + "不存在！");
		}
		
		return responseData;
	}
	
	/**
	 * Content-Type: application/x-www-form-urlencoded
	 * body:id=1001
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/bounter", method = RequestMethod.POST)
	private ResponseData<Bounter> postBounterWithRequestParam(@RequestParam("id") Long id) {
		ResponseData<Bounter> responseData = new ResponseData<>();
		
		if(id == 1001L) {
			Bounter bounter = new Bounter();
			bounter.setId(1001L);
			bounter.setName("springmvc");
			bounter.setValue("001");
			bounter.setTimestamp(System.currentTimeMillis());
			responseData.setData(bounter);
			responseData.setSuccess(true);
		} else {
			responseData.setSuccess(false);
			responseData.setErrorMsg(id + "不存在！");
		}
		
		return responseData;
	}
	
	/**
	 * Content-Type: application/json
	 * body:{"id":"1001","name":"springmvc01"}
	 * @param bounter
	 * @return
	 */
	@RequestMapping(value = "/echoBounter", method = RequestMethod.POST)
	private ResponseData<Bounter> postBounterWithRequestBody(@RequestBody Bounter bounter) {
		ResponseData<Bounter> responseData = new ResponseData<>();
		
		responseData.setData(bounter);
		responseData.setSuccess(true);
		
		return responseData;
	}
	
	/**
	 * Content-Type: application/x-www-form-urlencoded
	 * body:id=1001&name=form
	 * @param bounter
	 * @return
	 */
	@RequestMapping(value = "/echoBounterForm", method = RequestMethod.POST)
	private ResponseData<Bounter> postBounterWithFormParams(Bounter bounter) {
		ResponseData<Bounter> responseData = new ResponseData<>();
		
		responseData.setData(bounter);
		responseData.setSuccess(true);
		
		return responseData;
	}
}
