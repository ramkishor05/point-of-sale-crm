package com.brijframework.crm;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.brijframework.crm.contants.RecordStatus;
import com.brijframework.crm.entities.EOGlobalCountry;
import com.brijframework.crm.entities.EOGlobalCurrencyGroup;
import com.brijframework.crm.entities.EOGlobalCurrencyItem;
import com.brijframework.crm.repository.GlobalCountryRepository;
import com.brijframework.crm.repository.GlobalCurrencyGroupRepository;
import com.brijframework.crm.repository.GlobalCurrencyItemRepository;
import com.brijframework.production.schema.factories.JsonSchemaDataFactory;

@Component
public class CrmMainListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private GlobalCurrencyGroupRepository globalCurrencyGroupRepository;
	
	@Autowired
	private GlobalCurrencyItemRepository globalCurrencyItemRepository;
	
	@Autowired
	private GlobalCountryRepository globalCountryRepository;
	
	@Value("${spring.db.datajson.upload}")
	boolean upload;
	
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	if(upload) {
	    	JsonSchemaDataFactory instance = JsonSchemaDataFactory.getInstance();
	    	
	    	List<EOGlobalCurrencyGroup> eoGlobalCurrencyGroupJson = instance.getAll(EOGlobalCurrencyGroup.class);
	    	eoGlobalCurrencyGroupJson.forEach(eoGlobalCurrencyGroup->{
	    		EOGlobalCurrencyGroup findGlobalCurrencyGroup = globalCurrencyGroupRepository.findByTypeId(eoGlobalCurrencyGroup.getTypeId()).orElse(eoGlobalCurrencyGroup);
	    		BeanUtils.copyProperties(eoGlobalCurrencyGroup, findGlobalCurrencyGroup,"id");
	    		findGlobalCurrencyGroup.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    		EOGlobalCurrencyGroup eoGlobalCurrencyGroupSave= globalCurrencyGroupRepository.save(findGlobalCurrencyGroup);
	    		eoGlobalCurrencyGroup.setId(eoGlobalCurrencyGroupSave.getId());
	    	});
	    	
	    	List<EOGlobalCurrencyItem> eoGlobalCurrencyItemJson = instance.getAll(EOGlobalCurrencyItem.class);
	    	eoGlobalCurrencyItemJson.forEach(eoGlobalCurrencyItem->{
	    		EOGlobalCurrencyItem findGlobalCurrencyItem=globalCurrencyItemRepository.findOneByIdenNo(eoGlobalCurrencyItem.getIdenNo()).orElse(eoGlobalCurrencyItem);
	    		BeanUtils.copyProperties(eoGlobalCurrencyItem, findGlobalCurrencyItem,"id");
	    		findGlobalCurrencyItem.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    		EOGlobalCurrencyItem eoGlobalCurrencyItemSave= globalCurrencyItemRepository.save(findGlobalCurrencyItem);
	    		eoGlobalCurrencyItem.setId(eoGlobalCurrencyItemSave.getId());
	    	});
	    	
	    	List<EOGlobalCountry> globalCountryList = instance.getAll(EOGlobalCountry.class);
	    	List<String> globalCountryUrls=globalCountryList.stream().map(userEndpoint->userEndpoint.getName()).collect(Collectors.toList());
	    	Map<String, EOGlobalCountry> globalCountryMap = globalCountryRepository.findByNames(globalCountryUrls)
	    			.stream().collect(Collectors.toMap(EOGlobalCountry::getName, Function.identity()));
	    	for (EOGlobalCountry globalCountry : globalCountryList) {
	    		EOGlobalCountry eoUserEndpoint = globalCountryMap.getOrDefault(globalCountry.getName(),globalCountry);
	    		BeanUtils.copyProperties(globalCountry, eoUserEndpoint, "id");
	    		EOGlobalCountry saveGlobalCountry = globalCountryRepository.save(eoUserEndpoint);
	    		globalCountry.setId(saveGlobalCountry.getId());
	    		globalCountryMap.put(globalCountry.getName(), globalCountry);
			}
    	}
    }

}