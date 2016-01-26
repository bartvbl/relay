package relay;

public abstract class Window {
	private boolean isOpen = false;
	
	public void open() {
		if(isOpen) {
			throw new RuntimeException("This window has already been opened previously.");
		}
		openWindow();
		isOpen = true;
	}
	
	public void close() {
		if(!isOpen) {
			throw new RuntimeException("This window is not open.");
		}
		closeWindow();
		isOpen = false;
	}
	
	protected abstract void openWindow();
	protected abstract void closeWindow();
}
