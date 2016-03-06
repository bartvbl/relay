( root
	( sidebar
		left: parent.left
		right: parent.right
		top: parent.top
		height: 100px

		( sidebar-element
			left: parent.left
			right: parent.right
			top: previous.top
			height: 20% + 20px

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
		left: footer.left
		right: parent.right
		top: parent.top
		height: content.height

		/*{
			line from (left, top) to (right, top)
		}*/
	)

	( footer
		top: content.bottom
		left: parent.left
		height: 30px
		right: parent.right
	)

)