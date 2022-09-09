package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * 
 * �������� ������ �� ���ʿ� ����� ������ ������ �����ؾ���
 * ó������ �� ���뿡 ���� ��� �������� ������ ���� �����ؼ� �ð��ʰ��� ��
 *
 */
public class BOJ10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		//�������� �ٸ� ���ڷ� �ٲ��ֱ�
		input = input.replace("()", "-");
		//�� �踷��� ���� ����
		int count = 0;
		
		Stack <Character> stack = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				stack.push(input.charAt(i));
			}else if(input.charAt(i) == '-') {
				//�������� �������� ���� ������ �踷��Ⱑ ������� ����
				count += stack.size();
			}else if(input.charAt(i) == ')'){
				//������� ������ ���̸� (�� ���ְ�, �踷��� ������ �ϳ� ������ (�踷��⿡ ������ �������� 3���� �踷���� 4���� �������� �������� ����)
				count += 1;
				stack.pop();
			}
		}
		System.out.println(count);
	}

}
