package relay.parser;

import java_cup.runtime.ComplexSymbolFactory.Location;

public class LocationRange {
	public final Location start;
	public final Location end;

	public LocationRange(Location start, Location end) {
		this.start = start;
		this.end = end;
	}
}
