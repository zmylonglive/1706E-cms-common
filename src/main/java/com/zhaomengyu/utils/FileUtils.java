/**
 * 
 */
package com.zhaomengyu.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * @author zhaomengyu
 *
 */
public class FileUtils {

	private static File file;

	
	
	/**
	 * ɾ���ļ������ļ��У�ʹ�õݹ���㷨
	 * @param path
	 */
	public static void del(String path) {
		
		File file = new File(path);
		//����ļ�������
		if(!file.exists()) {
			System.out.println("�����ڸ�·��" + path);
			return;
		}
		
		//������ļ� ��ɾ��
		if(file.isFile()) {
			System.out.println("ɾ�� �ļ�  " + path);
			file.delete();
		}
		//������ļ��� ��ݹ�����Լ�
		if(file.isDirectory()) {
			String[] list = file.list();
			for (int i = 0; i < list.length; i++) {
				String subFileName = path + "\\" + list[i];
				del(subFileName);
			}
			System.out.println("ɾ��Ŀ¼  " + path);
			file.delete();
		}
		
	}
	
	/**
	 * �����ļ�
	 * @param src  Դ�ļ�
	 * @param dst  Ŀ���ļ�
	 * @throws IOException 
	 */
	public static void copy(String src,String dst) throws IOException {
		File fileSrc = new File(src);
		if(!fileSrc.exists() || !fileSrc.isFile()) {
			System.out.println(src + " �ļ������ڣ����ܸ��ư���");
			return;
		}
		
		File fileDst = new File(dst);
		if(fileDst.exists()) {
			System.out.println("Ŀ���ļ��Ѿ����ڣ����ܸ���");
		}
		
		// ��ȡ������
		FileInputStream fis = new FileInputStream(fileSrc);
		FileOutputStream fos = new FileOutputStream(fileDst);
		
		byte bs[] = new byte[1024];
		while(fis.read(bs)>=0) {
			fos.write(bs);
		}
		
		/*fis.close();
		fos.close();*/
		//������������ ȥ�ر���
		StreamUtils.closeStream(fis,fos);
	}
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static String readFileByLine(String fileName) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis);
		BufferedReader  bufferedReader = new BufferedReader(reader);
		String str = null;
		while( (str=bufferedReader.readLine())!=null ) {
			sb.append(str).append("\r\n");// ׷��
		}
		//�ر���
		StreamUtils.closeStream(fis);
		return sb.toString();
		
	} 
	
	
	public static List<String> readFile(String fileName) throws IOException {
		
		List<String> strList = new ArrayList();
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis);
		BufferedReader  bufferedReader = new BufferedReader(reader);
		String str = null;
		while( (str=bufferedReader.readLine())!=null ) {
			strList.add(str);
		}
		//�ر���
		StreamUtils.closeStream(fis);
		return strList;
		
	} 
	
}
