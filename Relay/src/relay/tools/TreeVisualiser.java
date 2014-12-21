package relay.tools;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import relay.data.Block;
import relay.data.Property;

public class TreeVisualiser {
	public TreeVisualiser(Block root) {
		JFrame window = new JFrame("Relay tree");
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("root");
		buildTree(root, node);
		JTree tree = new JTree(node);
		JScrollPane scroller = new JScrollPane();
		scroller.setViewportView(tree);
		window.add(scroller);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
	}

	private void buildTree(Block root, DefaultMutableTreeNode parent) {
		for(Block block : root.getChildren()) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(block.name);
			parent.add(node);
			addProperties(block, node);
			buildTree(block, node);
		}
	}

	private void addProperties(Block block, DefaultMutableTreeNode node) {
		for(Property property : block.getProperties()) {
			node.add(new DefaultMutableTreeNode(property.type + ": " + property.value));
		}
	}
}
