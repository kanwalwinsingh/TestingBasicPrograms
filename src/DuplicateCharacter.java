
public class DuplicateCharacter {
	public static void main(String[] args) {
		String s="ab12cd1234";
		char[] c=s.toCharArray();
		//System.out.println(s.length());
		StringBuilder sb=new StringBuilder();
		for(int i=c.length-1;i>=0;i--)
		{
			if(c[i]==(char)0+48 ||c[i]==(char)1+48||c[i]==(char)2+48||c[i]==(char)3+48||c[i]==(char)4+48||c[i]==(char)5+48||c[i]==(char)6+48||c[i]==(char)7+48||c[i]==(char)8+48)
			{
				continue;
			}
			else
			{
				sb.append(c[i]);
			}
		}
		for(int i=0;i<c.length;i++)
		{
			if(c[i]==(char)0+48 ||c[i]==(char)1+48||c[i]==(char)2+48||c[i]==(char)3+48||c[i]==(char)4+48||c[i]==(char)5+48||c[i]==(char)6+48||c[i]==(char)7+48||c[i]==(char)8+48)
			{
				sb.append(c[i]);
			}
			else
			{
				continue;
			}
		}
		
		System.out.println(sb);
	}

}
