package streamSandBox;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String str = "ABCAABBCCCDEEF";
		long count = StreamUtil.zip(str.chars().boxed(), str.chars().skip(1).boxed(), str.length() - 1)
		        .peek(p -> System.out.println("before:" + (char)p.first.intValue() 
		                          + " after:" + (char)p.second.intValue())) // デバッグ用
		        .filter(p -> p.first.equals(p.second)).count();
		System.out.println(count); //5
	}
}
