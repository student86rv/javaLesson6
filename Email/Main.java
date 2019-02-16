
public class Main {
	
	public static void main(String[] args) {
		
		String[] emails = {"test.email+alex@test.com","test.e.mail+bob.cathy@test.com", 
		"testemail+david@lee.test.com", "roman@test.com", "testemail@test.com"};
		
		System.out.println(numUniqueEmails(emails));
	}
	
	public static int numUniqueEmails(String[] emails) {
		String[] formattedEmails = new String[emails.length];
		for (int i = 0; i < emails.length; i++) {
			StringBuilder sb = new StringBuilder();
			String[] tmp = emails[i].split("@");
			for (int j = 0; j < tmp[0].length(); j++) {
				if (tmp[0].charAt(j) == '+') {
					break;
				}		
				if (tmp[0].charAt(j) == '.') {
					sb.append("");
				}
				else {
					sb.append(tmp[0].charAt(j));
				}
			}
			sb.append('@');
			sb.append(tmp[1]);
			formattedEmails[i] = sb.toString();		
		}
		int countUnique = 0;
		int count = 0;
		for (int i = 0; i < formattedEmails.length; i++) {
			countUnique++;
			for (int j = i + 1; j < formattedEmails.length; j++) {
				if (formattedEmails[i].equals(formattedEmails[j])) {
					count++;
					break;
				}
			}
		}
		return countUnique - count;
	}
}