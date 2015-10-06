package addressBook;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Writefile extends Info{

	public static Scanner sc;
	private static String[] info_arr;
	static int i=0;
	private static BufferedReader rd;
	
	public static void Read(){
		try {
			rd = new BufferedReader(new FileReader("/Users/minjee/Desktop/addressbook.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(true){
			String line = null;
			
			try {
				line = rd.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(line==null) break;
			info_arr = line.split(" ");
			name = info_arr[i++];
			phoneNumber = info_arr[i++];
			infoTable.put(name, phoneNumber);
		}
		
		try {
			rd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0;i<infoTable.size();i++)
			System.out.println("이름 :" + name + ", 전화번호 :" + phoneNumber);
	}
	
	public static void Search(){
		sc = new Scanner(System.in);
		System.out.println("검색할 이름을 입력해주세요.");
		String target = sc.nextLine();
		boolean isContains = infoTable.containsKey(target);
		
		if(isContains){
			String num = infoTable.get(target);
			System.out.println("이름 : " + target + ", 전화번호 : " + num);
		}
		else
			System.out.println("연락처에 없는 이름입니다.");
	}
	
	public static void Write(){
		
		sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		
		System.out.println("전화번호를 입력하세요.");
		phoneNumber = sc.nextLine();
		
		infoTable.put(name, phoneNumber);
		System.out.println("입력이 완료되었습니다.");
	
		try{
			BufferedWriter wt = new BufferedWriter(new FileWriter("/Users/minjee/Desktop/addressbook.txt"));
			wt.write(name);
			wt.write("\r");
			wt.write(phoneNumber);
			wt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	public static void Edit(){
		sc = new Scanner(System.in);
		System.out.println("수정할 연락처를 입력해주세요.");
		
	}
	public static void Delete(){
		sc = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력해주세요.");
		String target = sc.nextLine();
		boolean isContains = infoTable.containsKey(target);

		if(isContains){
			infoTable.remove(target);
			System.out.println("삭제가 완료되었습니다.");
		}
		else
			System.out.println("연락처에 없는 이름입니다.");
	}
	
	public static void main(String[] args){
		sc = new Scanner(System.in);
		while(true){
			mainMenu();
			int select = sc.nextInt();
			switch(select){
				case 1:
					Write();
					break;
				case 2:
					Read();
					break;
				case 3:
					Search();
					break;
				case 4:
					Edit();
					break;
				case 5:
					Delete();
					break;
				case 6:
					System.out.println("종료합니다.");
					return;
			}
		}
	}

}
