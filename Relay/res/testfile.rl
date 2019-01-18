( root

	( sidebar
		left:parent.left
		width: max(20% of parent.width, 200px)
		top: parent.top
		bottom: footer.bottom

		for item in menu_items: 
			( sidebar-element
				left: parent.left
				right: parent.right
				top: previous.top
				height: 20% of this.width

				( icon : Image
					left: parent.left
					width: parent.height
					top: parent.top
					height: parent.height
				)
				( link : Text
					left: icon.right
					right: parent.right
					top: parent.top
					height: parent.height
				)
			) 

	)

	( maincontent
		def itemHeight: 20% of parent.height

		left: sidebar.right
		right: parent.right
		top: parent.top
		bottom: footer.bottom

		( item1
			left: parent.left + 10px
			right: parent.right - 10px
			top: parent.top - 10px
			height: itemHeight
		)

		( item2
			left: item1.left
			right: item1.right
			top: item1.bottom - 10px
			height: itemHeight
		)

		( item3
			left: item1.left
			right: item1.right
			top: item2.bottom - 10px
			height: itemHeight
		)
	)

	( footer
		bottom: parent.bottom
		height: 70px
		left: parent.left
		right: parent.right
	)

)