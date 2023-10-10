package com.brijframework.production.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.production.global.rest.GlobalCountFreqRequest;
import com.brijframework.production.global.rest.GlobalCountFreqResponse;
import com.brijframework.production.global.service.GlobalCountFreqService;

@RestController
@RequestMapping("/api/global/countfreq")
public class GlobalCountFreqController {

	@Autowired
	GlobalCountFreqService globalCountFreqService;
	
	@PostMapping
	public GlobalCountFreqResponse addCountFreq(@RequestBody GlobalCountFreqRequest globalCountFreqRequest) {
		return globalCountFreqService.saveCountFreq(globalCountFreqRequest);
	}
	
	@PutMapping
	public GlobalCountFreqResponse updateCountFreq(@RequestBody GlobalCountFreqRequest globalCountFreqRequest) {
		return globalCountFreqService.saveCountFreq(globalCountFreqRequest);
	}
	
	@GetMapping
	public List<GlobalCountFreqResponse> getCountFreqList() {
		return globalCountFreqService.getCountFreqList();
	}
	
	@GetMapping("/{typeId}")
	public GlobalCountFreqResponse getCountFreqList(@PathVariable("typeId") String typeId) {
		return globalCountFreqService.getCountFreq(typeId);
	}
}
