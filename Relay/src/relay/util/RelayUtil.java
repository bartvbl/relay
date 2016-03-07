package relay.util;

public class RelayUtil {
	
	private static long nextUUID = 0; 

	public static long generateUUID() {
		long ID = nextUUID;
		nextUUID++;
		return ID;
	}
	
	public static String mergeVariableAccessStrings(String[] identifyers) {
		if(identifyers.length == 1) {
			return identifyers[0];
		}
		
		StringBuilder completeIdentifyer = new StringBuilder();
		
		for(int i = 0; i < identifyers.length - 1; i++) {
			completeIdentifyer.append(identifyers[i]).append(".");
		}
		
		if(identifyers.length > 1) {
			completeIdentifyer.append(identifyers[identifyers.length - 1]);			
		}
		return completeIdentifyer.toString();
	}
	

}
