package org.tamim.impl;
public class RequestProcessorFactory implements RequestProcessorFactory{

	public ProcessorFactory getRequestProcessorFactory(String reqType){
		if(reqType.equals("LBS")){
			return new LocationRequestProcessor();
		}
		else 
			return null;
	}
}