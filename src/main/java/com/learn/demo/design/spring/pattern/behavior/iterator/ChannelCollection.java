package com.learn.demo.design.spring.pattern.behavior.iterator;

// Aggregate
public interface ChannelCollection {
	
	public void addChannel(Channel c);
	
	public void removeChannel(Channel c);
	
	public ChannelIterator iterator(ChannelTypeEnum type);
}
