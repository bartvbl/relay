package relay.types;

public enum BlockType {
	Basic,
	
	// inputs
	
	Input_TextLine,
	Input_TextMultiline,
	Input_Number,
	Input_Search,
	Input_Date,
	Input_Month,
	Input_Password,
	Input_Email,
	Input_Slider,
	
	// outputs
	
	Text,
	Image,
	
	// masking
	
	ScrollArea,
	
	// templating
	
	Template,
}
