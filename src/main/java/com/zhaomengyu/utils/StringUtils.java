/**
 * 
 */
package com.zhaomengyu.utils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author zhaomengyu
 *
 */
public class StringUtils {

	
	
	/**
	 * 
	 */
	public static char cs[] = new char[36] ;
	// ��ʼ������
	static {
		int index=0;
		for (char i = 'a'; i <='z' ; i++) {
			cs[(int)index ++]=i;
		}
		
		for (char i = '0'; i <='9' ; i++) {
			cs[(int)index ++]=i;
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		/*String str = randomChar(10);
		System.out.println("10��������ַ��� " + str);
		
		
		String s = StringUtils.randomCharAndNumber(20);
		System.out.println("s is " + s);
		
		System.out.println("��չ���ǣ�"  + StringUtils.getFileSuffix("��־��-1706E-���μƻ�.xlsx"));
		
		System.out.println(" reg 234 " + StringUtils.isNumber("234") );

		System.out.println(" reg 2a34 " + StringUtils.isNumber("2a34") );
		System.out.println(" reg kong  " + StringUtils.isNumber("") );
		
		
		System.out.println(" is email  ? zhuzh@qq.com " + StringUtils.isEmail("zhuzh@qq.com"));
		System.out.println(" is email ? zhuzg@qq.c1n  " + StringUtils.isEmail("zhuzg@qq.c1n") );
		
		System.out.println(" type2 is email  ? zhuzh@qq.com " + StringUtils.isEmail2("zhuzh@qq.com"));
		System.out.println(" type2   email ? zhuzg@qq.c1n  " + StringUtils.isEmail2("zhuzg@qq.c1n") );
		*/
		
		String str = "����\r\n����";
		String dst = toHtml(str);
		System.out.println("dst is " + dst);
		
		
		
	}
	
	
	
	/**
	 * �ж�Դ�ַ����Ƿ�Ϊ�գ�������Ҳ��ûֵ��
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		
		//return (str==null|| "".equals(str.trim()));
		return (str==null || 0== str.trim().length());
	}
	
	/**
	 * �ж�Դ�ַ����Ƿ���ֵ��������Ҳ��ûֵ��
	 * @param str
	 * @return
	 */
	public static boolean hasText(String str) {
		//return !(str==null || 0== str.trim().length());
		return str!=null && 0 < str.trim().length();   
	
	}
	
	
	public static boolean isUrl(String str) {
		//ת��ΪСд
		 str = str.toLowerCase();
		String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https��http��ftp��rtsp��mms
	               + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp��user@  
	               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP��ʽ��URL- ���磺199.194.52.184  
	                 + "|" // ����IP��DOMAIN��������
	                 + "([0-9a-z_!~*'()-]+\\.)*" // ����- www.  
	                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // ��������  
	                + "[a-z]{2,6})" // first level domain- .com or .museum  
	                + "(:[0-9]{1,5})?" // �˿ں����Ϊ65535,5λ��
	                + "((/?)|" // a slash isn't required if there is no file name  
	                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
	        return  str.matches(regex);
	}
	
	public static String toUniqueTerm(String term) throws UnsupportedEncodingException{
		//ʵ�ִ���
		term=term.toLowerCase();
		term=term.trim();
		term=term.replaceAll("", "-");
		return URLEncoder.encode(term,"UTF-8");
	}
	
	
	
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static String randomChar(int n) {
		Random random = new Random();
		String str = "";
		for (int i = 0; i < n; i++) {
			 char c = (char)('a' + 	random.nextInt(26));// a - z
			str += c;
		}
		return str;
		
	}
	
	/**
	 * ������ɳ���Ϊn���ַ��������а�����ĸ������
	 * @param n
	 * @return
	 */
	public static String randomCharAndNumber(int n) {
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			sb.append(cs[random.nextInt(36)]);
		}
		return sb.toString();
		
	}
	
	/**
	 * ��ȡһ���ļ����Ƶ���չ��
	 * ���磺 mytest/mynewFile.txt return .txt
	 * @param fileName
	 * @return
	 */
	public static String getFileSuffix(String fileName) {
		
		//return ".txt";
		int dotIndex = fileName.lastIndexOf('.');
		if(dotIndex==-1)
			return "";
		
		return fileName.substring(fileName.lastIndexOf('.'));
		
	}
	
	/**
	 * �ж��Ƿ�Ϊ�ַ���
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		
		String reg = "[0-9]+\\\\.?[0-9]+?";
		return str.matches(reg);
	}
	
	/**
	 * ��֤����
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		String reg = "^[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[a-z]{2,3}";
		return str.matches(reg);
		
	}
	
	public static boolean isEmail2(String str) {
		
		String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"; 
        Pattern p = Pattern.compile(regEx1);
        Matcher m = p.matcher(str);
        return m.find();

	}
	
	/**
	 * У��һ���ַ����Ƿ�Ϊ��ȷ�ĵ绰����
	 * @param mobile
	 * @return
	 */
	public  static boolean isMobile(String mobile) {
		
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		boolean isMatch = m.matches();
		return isMatch;
	}
	
	/**
	 * (1)����Html��<p>��ǩ�������ı��Ļ��С�
		(2)Windowsϵͳ���з��ǡ�\r\n��,Linuxϵͳ�ǡ�\n�������Ҫ��\n\r�滻��һ��\n��
		(3)�ٽ�\n��β�������ı���<p></p>��ǩ�������� ����\n����      <p>����</p><p>����</p>
		(4)�����������\r�ַ�Ҫʹ��<br/>��ǩ�滻��
	 * @param src
	 * @return
	 */
	public static String toHtml(String src) {
		//Windowsϵͳ���з��ǡ�\r\n��,Linuxϵͳ�ǡ�\n�������Ҫ��\n\r�滻��һ��\n��
		String dst = src.replaceAll("\r\n", "\n");
		
		//�ٽ�\n��β�������ı���<p></p>��ǩ�������� ����\n����      <p>����</p><p>����</p>
		dst=dst.replaceAll("\n", "</p><p>");
		dst="<p>" + dst + "</p>";
		//�����������\r�ַ�Ҫʹ��<br/>��ǩ�滻��
		dst=dst.replaceAll("\r", "<br/>");
		return dst;
	}
	
	/**
	 * �ٷֱȼ���
	 * @Title: percent 
	 * @Description: TODO
	 * @param num
	 * @param total
	 * @return
	 * @return: String
	 */
	public static String percent(Integer num,Integer total ) {
		// ����һ����ֵ��ʽ������   
		NumberFormat numberFormat = NumberFormat.getInstance(); 
		// ���þ�ȷ��С�����0λ   
		numberFormat.setMaximumFractionDigits(0); 
		String result = numberFormat.format((float)num/(float)total*100);
		return result;
	}
	
}
