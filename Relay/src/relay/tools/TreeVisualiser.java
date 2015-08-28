package relay.tools;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import relay.nodes.RelayNode;

public class TreeVisualiser {
	public TreeVisualiser(RelayNode root) {
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

	private void buildTree(RelayNode root, DefaultMutableTreeNode parent) {
		for(RelayNode block : root.children) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(block);
			parent.add(node);
			buildTree(block, node);
		}
	}
}
