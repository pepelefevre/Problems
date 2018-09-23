import java.util.Map;
import java.util.HashMap;

public class Decoder {

	static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "14598791111111351342626268411156167895132165262";
		long startTime = System.currentTimeMillis();
		int num = numDecode(message);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		startTime = System.currentTimeMillis();
		int dp = numDecodeDP(message);
		endTime = System.currentTimeMillis();
		long timeDP = endTime - startTime;
		
		System.out.println(num + " : " + time + "ms");
		System.out.println(dp + " : " + timeDP + "ms");
	}

	public static int numDecodeDP(String message) {
		
		if (map.containsKey(message))
		{
			return map.get(message);
		}
		
		int result;
		if (message.length() == 1) {
			result = 1;
		} else {
			int first = Integer.parseInt(message.substring(0, 2));
			if (message.length() == 2)
			{
				result = (first <= 26) ? 2 : 1;
			}
			else if (first <= 26) {
				result = numDecodeDP(message.substring(2)) + numDecodeDP(message.substring(1));
			} else {
				result = numDecodeDP(message.substring(1));
			}
		}
		map.put(message, result);
		return result;
	}
	
	public static int numDecode(String message) {
				
		int result;
		if (message.length() == 1) {
			result = 1;
		} else {
			int first = Integer.parseInt(message.substring(0, 2));
			if (message.length() == 2)
			{
				result = (first <= 26) ? 2 : 1;
			}
			else if (first <= 26) {
				result = numDecode(message.substring(2)) + numDecode(message.substring(1));
			} else {
				result = numDecode(message.substring(1));
			}
		}
		return result;
	}
	
	public static int numDecodeButtomUp(String message) {
		
		if (map.containsKey(message))
		{
			return map.get(message);
		}
		
		int result;
		if (message.length() == 1) {
			result = 1;
		} else {
			int first = Integer.parseInt(message.substring(0, 2));
			if (message.length() == 2)
			{
				result = (first <= 26) ? 2 : 1;
			}
			else if (first <= 26) {
				result = numDecodeDP(message.substring(2)) + numDecodeDP(message.substring(1));
			} else {
				result = numDecodeDP(message.substring(1));
			}
		}
		map.put(message, result);
		return result;
	}

}
