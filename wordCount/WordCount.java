package wordCount;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String wordOrLetter = sc.nextLine();
		String path = sc.nextLine();
		File file = new File(path);
		String context = readFile(file);
		count(context, wordOrLetter);
	}
	private static void count(String context, String wordOrLetter){
		if(wordOrLetter.equals("-c")){
			System.out.println("×Ö·ûÊý£º" + context.length());
		}else if(wordOrLetter.equals("-w")){
			char[] arr = context.toCharArray();
			int count = 0;
			for(int i = 0; i < arr.length; i ++){
				while(i < arr.length && arr[i] == ' ' || arr[i] == ',' || arr[i] == '\t' || arr[i] == '\r'){
					i ++;
				}
				if(i < arr.length){
					count ++;
				}
				while(i < arr.length && arr[i] != ' ' && arr[i] != ',' && arr[i] != '\t' && arr[i] != '\r'){
					i ++;
				}
				
			}
			System.out.println("µ¥´ÊÊý£º" + count);
		}
	}
	private static String readFile(File file){
		FileInputStream fis = null;
		String reString = null;
		try {
            fis = new FileInputStream(file);
    		byte[] str = new byte[1024*1024];
            int len = 0;
    		len = fis.read(str);
            reString = new String(str, 0, len);       
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reString;
	}

}
