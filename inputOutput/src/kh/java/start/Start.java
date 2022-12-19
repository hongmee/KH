package kh.java.start;

import kh.java.func.ByteStream;
import kh.java.func.CharStream;
import kh.java.func.SubStreamTest;
import kh.java.func.UserMgr;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ByteStream bs = new ByteStream();
		
//		bs.primaryStream();
		
		CharStream ch = new CharStream();
		
//		ch.primaryStream();
//		ch.subStream();
//		ch.charReader();
		
		
		SubStreamTest sst = new SubStreamTest();
		
//		sst.test1();
//		sst.test2();
		
		
		UserMgr um = new UserMgr();
		
		um.main();
		
	}

}
