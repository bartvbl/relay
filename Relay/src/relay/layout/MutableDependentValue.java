package relay.layout;

public interface MutableDependentValue {
	public void updateCurrentValue();
	public double getCurrentValue();
	
	public MutableDependentValue[] getDependencies();
	public void registerDependency(MutableDependentValue dependencies);
}
