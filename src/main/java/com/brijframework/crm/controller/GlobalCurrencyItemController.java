package com.brijframework.crm.controller;

import static com.brijframework.crm.contants.Constants.TYPE_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.crm.dto.GlobalCurrencyItemRequest;
import com.brijframework.crm.dto.GlobalCurrencyItemResponse;
import com.brijframework.crm.service.GlobalCurrencyItemService;

@RestController
@RequestMapping("/api/global/currency/item")
public class GlobalCurrencyItemController {

	@Autowired
	private GlobalCurrencyItemService globalCurrencyItemService;
	
	@PostMapping
	public GlobalCurrencyItemResponse addCurrencyItem(@RequestBody GlobalCurrencyItemRequest globalCurrencyItemRequest) {
		return globalCurrencyItemService.saveCurrencyItem(globalCurrencyItemRequest);
	}
	
	@PutMapping
	public GlobalCurrencyItemResponse updateCurrencyItem(@RequestBody GlobalCurrencyItemRequest globalCurrencyItemRequest) {
		return globalCurrencyItemService.saveCurrencyItem(globalCurrencyItemRequest);
	}
	
	@GetMapping
	public List<GlobalCurrencyItemResponse> getCurrencyItemList() {
		return globalCurrencyItemService.getCurrencyItemList();
	}
	
	@GetMapping("/{id}")
	public GlobalCurrencyItemResponse getCurrencyItemList(@PathVariable("id") Long id) {
		return globalCurrencyItemService.getCurrencyItem(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCurrencyItemList(@PathVariable("id") Long id) {
		return globalCurrencyItemService.deleteCurrencyItem(id);
	}
	
	@GetMapping("/type/{typeId}")
	public List<GlobalCurrencyItemResponse> getCurrencyItemList(@PathVariable(TYPE_ID) String typeId) {
		return globalCurrencyItemService.findAllByType(typeId);
	}
}
