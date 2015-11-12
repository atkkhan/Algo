package org.tamim;

public interface ProcessorFactory {
	public Processor getRequestProcessor(String reqType);
}
