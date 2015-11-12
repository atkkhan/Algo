package org.tamim.impl;
import org.tamim.Processor;
import org.tamim.ProcessorFactory;

public class LocationRequestProcessorFactory implements ProcessorFactory{
	public Processor getRequestProcessor(String reqType){
			
		if(reqType.equals("GPS")){
			return new GPSProcessor();
		}
		else if(reqType.equals("Cell")){
			return new CellProcessor();				
		}
		else{
			return new IPProcessor();
		}
	}
}