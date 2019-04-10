package com.learn.demo.design.spring.pattern.behavior.observer;

public class ObserverPatternMain {

	public static void main(String[] args) {
		OfficialAccount sxs = new OfficialAccount("sxs");
		OfficialAccount wf = new OfficialAccount("wf");
		
		Follower mark = new Follower("Mark");
		Follower eric = new Follower("Eric");
		Follower jack = new Follower("Jack");
		Follower frank = new Follower("Frank");
		Follower daniel = new Follower("Daniel");
		Follower alice = new Follower("Alice");
		
		sxs.register(mark);
		sxs.register(eric);
		sxs.register(jack);
		
		wf.register(frank);
		wf.register(daniel);
		wf.register(alice);
		
		sxs.pushArticle("observer design pattern video course");
		wf.pushArticle("spring 5.0 is out");

		sxs.unregister(eric);
		
		sxs.pushArticle("core java course is released");
	}

}
