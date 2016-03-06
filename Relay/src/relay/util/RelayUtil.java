package relay.util;

public class RelayUtil {
	
	private static long nextUUID = 0; 

	public static long generateUUID() {
		long ID = nextUUID;
		nextUUID++;
		return ID;
	}

}
