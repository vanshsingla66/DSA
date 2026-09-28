package STRINGBUILDER;
public class StringBuilder_Demo {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("LOL");
		System.out.println(sb.capacity());
		sb.append("Gh");
		sb.append(true);
		sb.append(1);
		sb.append('a');
		sb.append("Hellottt");
		System.out.println(sb.length());
		System.out.println(sb);
		System.out.println(sb.charAt(3));
		System.out.println(sb.substring(1,3));
		System.out.println(sb.substring(1));
		String s=sb.toString();
		sb.append('p');
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		System.out.println(sb.reverse());
		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1.capacity());
		System.out.println(s);

	}

}