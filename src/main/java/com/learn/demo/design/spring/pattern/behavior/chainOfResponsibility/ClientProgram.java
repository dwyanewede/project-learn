package com.learn.demo.design.spring.pattern.behavior.chainOfResponsibility;

// Client
public class ClientProgram {

	public static void main(String[] args) {
		// TODO 责任链模式可以作为流程系统的简单实现
		// 感觉此种实现存在问题，由于流程流转到下一个节点，可以直接在当前节点选择下一节点角色信息
		// 可以根据发起人所对应的 parentId去向上找对应的经理跟HR，此处需要设计字段 parentId（一对一）
		// 如果需要实现多用户扩展，可以查询可选列表，供当前节点选择指派，此处需要设计两个字段 id 和 parentId（一对多）
		TeamLeader tl = new TeamLeader();
		ProjectLeader pl = new ProjectLeader();
		HR hr = new HR();
		
		tl.setNextHandler(pl);
		pl.setNextHandler(hr);
		
		
		tl.approve(new Leave(1, 5));
		tl.approve(new Leave(2, 15));
		tl.approve(new Leave(3, 25));
		tl.approve(new Leave(4, 35));

	}

}
