package I_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		/*
		 * 정규표현식 : 문자열의 패턴을 검사하는 표현식
		 * 
		 * ^	뒷 문자로 시작 (^a : a로 시작)
		 * $	앞 문자로 종료 (a$ : a로 종료)
		 * .	임의의 문자(줄바꿈 제외)
		 * *	앞 문자가 0개 이상
		 * +	앞 문자가 1개 이상
		 * ?	앞 문자가 없거나 1개
		 * []	문자의 집합이나 범위([a-z]:a부터z까지, [^a-z]a부터 z가 아닌것)
		 * {}	앞 문자의 개수({2} : 2개, {2,4} : 2개 이상 4개 이하)
		 * ()	그룹화(1개의 문자처럼 인식)
		 * |	OR 연산
		 *\s	공백, 탭, 줄바꿈
		 *\S	공백, 탭, 줄바꿈이 아닌 문자
		 *\w	알파벳이나 문자
		 *\W	알바벳이나 문자가 아닌 문자
		 *\d	 숫자
		 *\D	숫자가 아닌 문자
		 *(?i)	뒷 문자의 대소문자 구분 안함
		 *\		정규표현식에서 사용되는 특수문자 표현 
		 */
		
		String str = "Q1w2e3r4";
//		String regex = "[a-z]{1}[0-9]{1}[a-z]{1}[0-9]{1}[a-z]{1}[0-9]{1}[a-z]{1}[0-9]{1}"; //정규표현식
//		String regex = "[a-z0-9]{8}";
		String regex = "\\w*";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
		
		//아이디, 비밀번호, 이메일주소의 유효성을 검사하는 정규표현식
		String id = "rokaid_1";
		String pw = "1q2w3e4r!";
		String em = "rokaid_1@roka.co.kr";
		
		String idregex = "[a-zA-Z0-9_-]{5,20}";
		String pwregex = ".{8,20}";
		String emregex = "[a-zA-Z0-9_-]{5,20}@\\w+\\.(?i)(com|org|net|([a-z]+\\.[a-z]+))";
		
		Pattern idp = Pattern.compile(idregex);
		Pattern pwp = Pattern.compile(pwregex);
		Pattern emp = Pattern.compile(emregex);
		Matcher idm = idp.matcher(id);
		Matcher pwm = pwp.matcher(pw);
		Matcher emm = emp.matcher(em);
		System.out.println(idm.matches());
		System.out.println(pwm.matches());
		System.out.println(emm.matches());
		
		//정규표현식 못하겠으면 검색해라
		//검색이 최고다 이마리야
		
		
	}

}





