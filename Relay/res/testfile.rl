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

			( icon
				left: parent.left
				width: parent.height
				top: parent.top
				height: parent.height
				content: link.icon_src
			)
			( link
				left: icon.right
				right: parent.right
				top: parent.top
				height: parent.height
				content: link.title
			)
		) //repeat-for link in sidebar_links
	)

	( maincontent
		left: footer.left
		right: parent.right
		top: parent.top
		height: content.height

		origin: bottom-left

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