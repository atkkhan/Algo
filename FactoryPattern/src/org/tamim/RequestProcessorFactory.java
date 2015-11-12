package org.tamim;

public interface RequestProcessorFactory {
	public ProcessorFactory getRequestProcessorFactory(String reqType);
}
