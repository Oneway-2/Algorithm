package baekjoon;

import java.util.HashSet;
import java.util.Iterator;

public class Practice {
	
	static class Pair{
		int x;
		int y;
		public Pair() {	}
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		// 보통 ide가 만들어주는거 걍 쓰면댐
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
	
	public static void main(String[] args) {
		// d이거실행어케하더라 cn
		// Set이 먼지암?대충암 ㅜ 중복허용 된다 안디ㅗㄴ다??안됨
		HashSet<Pair> st = new HashSet<>();
		st.add(new Pair(0, 1));
		st.add(new Pair(0, 1));
		System.out.println(st.size()); // 그럼 이거 결과 몇개임1?ㄷㄷ new라서그런가
		// Set이나 Map은 이미 있는 키 인지 판별할떄 안에 있는 이 객체 안에 있는 값 보는게 아니라
		// 레퍼런스만 판별함 저거 객체 생성된 주소 그런거
		// 그래서 동일한 객체인지 판별하려면 해시코드 메소드랑, equals 메소드 ㄷ오버라이딩 해줘야
		// 그거로 동일한 객체인지 판별함
		System.out.println(st.contains(new Pair(0, 1)));
		System.out.println(st.size()); 
		// 오 지린다 이제알것누? 저거  Pair x,y 들어있으면 visit true인걸로 보면댐 ㄹㅇ이네[
		// 그럼 문제해결인데 ㄹㅇ천재여? 씹련아??ㄷㄷ지리누
//		System.out.println(st.hashCode());
		
//		Iterator<Pair> it = st.iterator();
////		while(it.hasNext()) {
////			Pair a = it.next
////			System.out.println(a.x + " " + a.y);
////		}
//		
//		Pair a = it.next();
//		System.out.println(a.x + " " + a.y);
//		a = it.next();
//		System.out.println(a.x + " " + a.y);
//		a = it.next();
//		System.out.println(a.x + " " + a.y);
		
	}	
}