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
			System.out.println("Analysing unlabelled node " + currentNode + ". " + unlabelledNodes.size() + " remain.");
			visit(currentNode, unlabelledNodes, tempLabelledNodes, permanentLabelledNodes, sortedNodes);
		}
		
		// Write back in reverse
		for(int i = 0; i < linkedValues.length; i++) {
			linkedValues[i] = sortedNodes.get(linkedValues.length - 1 - i);
		}
	}

	private static void visit(MutableDependentValue currentNode, ArrayList<MutableDependentValue> unlabelledNodes, HashSet<MutableDependentValue> tempLabelledNodes, HashSet<MutableDependentValue> permanentLabelledNodes, ArrayList<MutableDependentValue> sortedNodes) {
		System.out.println("\tVisiting: " + currentNode);
		if(tempLabelledNodes.contains(currentNode)) {
			throw new RuntimeException("Cycle detected in layout definition!");
		}
		if(!permanentLabelledNodes.contains(currentNode)) {
			System.out.println("\t\tNode has not yet been marked. Adding temporary label.");
			unlabelledNodes.remove(currentNode);
			tempLabelledNodes.add(currentNode);
			
			MutableDependentValue[] dependencies = currentNode.getDependencies();
			for(MutableDependentValue dependency : dependencies) {
				visit(dependency, unlabelledNodes, tempLabelledNodes, permanentLabelledNodes, sortedNodes);
			}
			if(dependencies.length == 0) {
				System.out.println("\t\tNo dependencies found.");
			}
			
			System.out.println("\t\tMarking " + currentNode + " permanently.");
			permanentLabelledNodes.add(currentNode);
			tempLabelledNodes.remove(currentNode);
			sortedNodes.add(currentNode);
		} else {
			System.out.println("\t\tNode has already been marked.");
		}
	}

}
