package addressBook;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Info {
	
	static String name;
	static String phoneNumber;
	static Map<String, String> infoTable = new TreeMap<String, String>();
	static int i=0;
	public static Scanner sc;
	
	
	public static void mainMenu(){
		System.out.println("-----------------");
		System.out.println("1. 전화번호부 입력");
		System.out.println("2. 연락처보기(상위 10개)");
		System.out.println("3. 검색");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
		System.out.println("6. 종료");
		System.out.println("-----------------");

	}
	
}
