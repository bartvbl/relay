package relay.layout;

import java.util.ArrayList;

public class DimensionValue {
	private final ArrayList<DimensionValue> dependencies = new ArrayList<DimensionValue>();
	
	public void addDependency(DimensionValue dependentOn) {
		this.dependencies.add(dependentOn);
	}
}
