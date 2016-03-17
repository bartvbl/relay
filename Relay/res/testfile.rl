( root
	( sidebar
		left: parent.left
		right: parent.right
		top: parent.top
		height: 100px

		( sidebar-element
			left: parent.left
			right: parent.right
			top: parent.top //previous.top
			height: 20% of parent.height + 20px

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
		) //repeat-for link in sidebar_links 

	)

	( maincontent
		def itemHeight: 100px

		left: sidebar.right
		right: parent.right
		top: parent.top
		height: parent.height

		( item1
			top: parent.top
			height: itemHeight
		)

		( item2
			top: item1.bottom
			height: itemHeight
		)

		( item3
			top: item2.bottom
			height: itemHeight
		)

		/*{
			line from (left, top) to (right, top)
		}*/
	)

	( footer
		top: parent.bottom
		left: parent.left
		height: 30px
		right: parent.right
	)

)