package restaurantReservationApp;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberMgr {
	ArrayList<Member> memberList;
	
	public Member addMember(String name, String IC, String gender, String hp){
		Member member = new Member (name, IC, gender, hp);
		return member;
		
	}
	
	public Member removeMember(String IC){
		Member member = searchMember(IC);
		memberList.remove(member);
		return member;
	}
	
	public Member updateMember(String IC, String hp){
		Member member = searchMember(IC);
		member.setHp(hp);
		return member;
	}
	
	private Member searchMember(String IC){
		Iterator<Member> itr = memberList.iterator();
		while(itr.hasNext()){
			Member member = itr.next();
			if (member.getIC().equalsIgnoreCase(IC)){
				return member;
			}
		}
		return null;
	}

}
