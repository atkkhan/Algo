
public class ReplaceSubString {
	public static void main(String[] args){
		System.out.println(replace("abcdefgh", "bce", "xyz"));
	}

	public static String replace(String str, String oldSubStr, String newSubStr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); ++i){
			char c = str.charAt(i);
			int j = 0;
			if(c == oldSubStr.charAt(j)){
				boolean replace = true;
				for(j = 1; j < oldSubStr.length(); ++j){
					if(str.charAt(j + i) != oldSubStr.charAt(j)){
						replace = false;
						break;
					}
				}
				if(replace){
					sb.append(newSubStr);
					i=i+j;
				}
				else{
					sb.append(str.substring(i, j));
				}
			}
			else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
