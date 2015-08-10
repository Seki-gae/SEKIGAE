package com.example.mock;

import java.util.ArrayList;

import com.example.test.Member;

public class Mock {
	public static ArrayList<Member> getLeftMembers(){
		
		Member memberA = new Member();
		Member memberB = new Member();
		Member memberC = new Member();
		Member memberD = new Member();
		memberA.setGender("man");
		memberB.setGender("woman");
		memberC.setGender("man");
		memberD.setGender("woman");
		memberA.setName("A");
		memberB.setName("A");
		memberC.setName("B");
		memberD.setName("B");
		
		ArrayList<Member> members = new ArrayList<>();
		members.add(memberA);
		members.add(memberB);
		members.add(memberC);
		members.add(memberD);
		return null;
	}
	
	public static ArrayList<Member> getRightMembers(){
		
		Member memberA = new Member();
		Member memberB = new Member();
		Member memberC = new Member();
		Member memberD = new Member();
		memberA.setGender("woman");
		memberB.setGender("man");
		memberC.setGender("woman");
		memberD.setGender("man");
		memberA.setName("C");
		memberB.setName("C");
		memberC.setName("D");
		memberD.setName("D");
		
		ArrayList<Member> members = new ArrayList<>();
		members.add(memberA);
		members.add(memberB);
		members.add(memberC);
		members.add(memberD);
		return null;
	}
}
