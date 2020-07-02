package com.example.demo.controllers;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/apidoc")
public class EndpointDocumentationController {

    private RequestMappingHandlerMapping handlerMapping;
	 
	@Autowired
	public void EndpointDocController(RequestMappingHandlerMapping handlerMapping) {
		this.handlerMapping = handlerMapping;
	}

	
    @RequestMapping(method = RequestMethod.GET)
	  public List<Map<String, String>> getEndpointDoc(
			  @RequestParam(value = "text", required = false) String text ) {
		
		  List<Map<String,String>> response =  new ArrayList();
		  
		  if(text != null) {
			  
			  response =  fetchAllServiceEndpoints();
			  
			  String key = "url";
			  response = response.stream()
			          .filter(map -> map.containsKey(key) && map.get(key).contains(text))
			          .collect(Collectors.toList());
		  }
		  
		  return response;
	  }
	
	private List<Map<String, String>> fetchAllServiceEndpoints() {
		Map<RequestMappingInfo, HandlerMethod> handlerMethods = this.handlerMapping.getHandlerMethods();		
		return buildEndpointsResponse(handlerMethods);
	}
	
	private List<Map<String, String>> buildEndpointsResponse(Map<RequestMappingInfo, HandlerMethod> handlerMethods) {
		
		List<Map<String,String>> response = new ArrayList<>();
		
		for(Entry<RequestMappingInfo, HandlerMethod> item : handlerMethods.entrySet()) {
	        RequestMappingInfo mapping = item.getKey();
	        HandlerMethod method = item.getValue();
	        Map<String,String> currentItem = new HashMap<>();
	        currentItem.put("fileName", method.getBean().toString());
	        currentItem.put("requestType", mapping.getMethodsCondition().toString());
	        currentItem.put("url", mapping.getPatternsCondition().toString());
	        currentItem.put("methodName", method.getMethod().getName());
	        currentItem.put("returnType", method.getMethod().getReturnType().getName());
	        
	        MethodParameter[] parametersList =  method.getMethodParameters();
	        if(parametersList.length > 0) {
	        	 StringBuilder parameters = new StringBuilder();
	        	 Class<?>[] parameterTypes =  parametersList[0].getExecutable().getParameterTypes();
	 	        for(int  i = 0; i < parameterTypes.length; i++) {
	 	        	if(i > 0) {
	 	        		parameters.append(",");
	 	        	}
	 	        	parameters.append(parameterTypes[i].getName());
	 	        }  
 	        	currentItem.put("parameters", parameters.toString());
	        }
	        response.add(currentItem);
	    }
		
		return response;
	}
}