package basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//1406 ������
/* �迭, ���ڿ� ������� ó���ϸ� ������ ���Կ� O(n)��ŭ ��(���ڿ� ���̸�ŭ)
 * Ŀ�� ���� ���� ���ð� ������ �������� ������
 * �׷� push�� pop�� �� O(1)��ŭ�� �� �� ����
 * */
public class B1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		/* Ŀ�� ���� ���� ���ð� ������ �������� ������ */
		Stack<Character>left = new Stack<>();
		Stack<Character>right = new Stack<>();
		
		/* Ŀ���� �� �ڿ� �����Ƿ� ���� ���ÿ� ���� �ֱ� */
		for(int i=0; i<str.length(); i++) {
			left.push(str.charAt(i));
		}
		
		while(N-->0) {
			//command�� ����� �и�
			String command = br.readLine();
			
			//��ɾ ���� ����
			switch (command.charAt(0)) {
			case 'L':
				if(!left.empty()) //Ŀ���� ���� �� ���� �� ���� 
					right.push(left.pop()); //Ŀ���� �������� �ű����ν� ���� �̵�
				break;
			case 'D':
				if(!right.empty()) //Ŀ���� ���� �� ���� �� ����
					left.push(right.pop());
				break;
			case 'B':
				if(!left.empty()) //Ŀ���� ���� �� ���� �� ����
					left.pop(); //Ŀ�� ���� ���� ����
				break;
			case 'P':
				left.push(command.charAt(2));
			default:
				break;
			}
		}
		/* ���� ������ ���� ���������� �ű�� ���� ���� �ϼ� */
		while(!left.empty())
			right.push(left.pop());
		
		/* ������ ���ÿ��� ���� pop�ؼ� ���� ����� */
		while(!right.empty())
			sb.append(right.pop());
		
		System.out.println(sb);
	}
}
