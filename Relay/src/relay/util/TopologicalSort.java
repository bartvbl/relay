package relay.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import relay.layout.MutableDependentValue;

public class TopologicalSort {

	public static void sort(MutableDependentValue[] linkedValues) {
		ArrayList<MutableDependentValue> sortedNodes = new ArrayList<MutableDependentValue>();
		
		ArrayList<MutableDependentValue> unlabelledNodes = new ArrayList<MutableDependentValue>();
		HashSet<MutableDependentValue> tempLabelledNodes = new HashSet<MutableDependentValue>();
		HashSet<MutableDependentValue> permanentLabelledNodes = new HashSet<MutableDependentValue>();
		
		unlabelledNodes.addAll(Arrays.asList(linkedValues));
		
		while(!unlabelledNodes.isEmpty()) {
			MutableDependentValue currentNode = unlabelledNodes.remove(0);
			visit(currentNode, unlabelledNodes, tempLabelledNodes, permanentLabelledNodes, sortedNodes);
		}
		
		// Write back in reverse
		for(int i = 0; i < linkedValues.length; i++) {
			linkedValues[i] = sortedNodes.get(linkedValues.length - 1 - i);
		}
	}

	private static void visit(MutableDependentValue currentNode, ArrayList<MutableDependentValue> unlabelledNodes, HashSet<MutableDependentValue> tempLabelledNodes, HashSet<MutableDependentValue> permanentLabelledNodes, ArrayList<MutableDependentValue> sortedNodes) {
		
		if(tempLabelledNodes.contains(currentNode)) {
			throw new RuntimeException("Cycle detected in layout definition!");
		}
		if(!permanentLabelledNodes.contains(currentNode)) {
			unlabelledNodes.remove(currentNode);
			tempLabelledNodes.add(currentNode);
			
			MutableDependentValue[] dependencies = currentNode.getDependencies();
			for(MutableDependentValue dependency : dependencies) {
				visit(dependency, unlabelledNodes, tempLabelledNodes, permanentLabelledNodes, sortedNodes);
			}
			
			permanentLabelledNodes.add(currentNode);
			tempLabelledNodes.remove(currentNode);
			sortedNodes.add(currentNode);
		}
	}

}
