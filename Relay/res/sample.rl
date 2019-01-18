( root
	def verticalMargin: 10px
	def horizontalMargin: 20px
	def textHeight: localGameArea.width

	( titleArea
		top: parent.top
		height: 30px
	)
	( localGameArea
		top: titleArea.bottom
		left: parent.left
		width: max(50% of parent.width, playButton.right + horizontalMargin)
		
		( localGameTitle : Text
			left: parent.left + horizontalMargin
			right: parent.right - horizontalMargin
			top: parent.top - verticalMargin
			height: textHeight
		)
		
		( puzzleSelectionTitle : Text
			left: parent.left + horizontalMargin
			right: parent.right - horizontalMargin
			top: localGameTitle.bottom - verticalMargin
			height: textHeight
		)
		
		( puzzleSelectionList : List
			top: puzzleSelectionTitle.bottom - verticalMargin
			bottom: createPuzzleButton.top + verticalMargin
			left: parent.left + horizontalMargin
			right: parent.right - horizontalMargin
		)

		( createPuzzleButton : Button
			left: parent.left + horizontalMargin
			width: 240px
			bottom: parent.bottom + verticalMargin
			height: 40px
		)

		( playButton : Button
			left: createPuzzleButton.right + horizontalMargin
			width: 120px
			bottom: createPuzzleButton.bottom
			height: createPuzzleButton.height
		)
	)
	( onlineGameArea
		top: titleArea.bottom
		left: localGameArea.right
		right: parent.right

		( onlineGameTitle : Text
			left: parent.left + horizontalMargin
			right: parent.right - horizontalMargin
			top: parent.top - verticalMargin
			height: textHeight
		)
		
		( serverAddressLabel : Text
			left: parent.left + horizontalMargin
			width: 200px
			top: onlineGameTitle.bottom - verticalMargin
			height: textHeight
		)

		( connectButton : Button
			right: parent.right - horizontalMargin
			width: 150px
			top: serverAddressInput.bottom - verticalMargin
			height: createPuzzleButton.height
		)
		
		( serverAddressInput : TextInput
			left (if parent.width < 200px): parent.left + horizontalMargin
			left (otherwise): serverAddressLabel.right + horizontalMargin
			right: parent.right - horizontalMargin
			top (if parent.width < 200px): serverAddressLabel.bottom - verticalMargin
			top (otherwise): serverAddressLabel.top
			height: textHeight
		)
	)
)