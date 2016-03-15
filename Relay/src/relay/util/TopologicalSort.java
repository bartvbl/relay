package relay.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import relay.layout.MutableDependentValue;

public class TopologicalSort {

	public static void sort(MutableDependentValue[] linkedValues) {
		ArrayList<MutableDependentValue> sortedNodes = new ArrayList<MutableDependentValue>();
		ArrayList<MutableDependentValue> unsortedNodes = new ArrayList<MutableDependentValue>();
		
		unsortedNodes.addAll(Arrays.asList(linkedValues));
		
		HashSet<MutableDependentValue> labelledNodes = new HashSet<MutableDependentValue>();
		
		while(unsortedNodes.size() > 0) {
			for(int i = 0; i < unsortedNodes.size(); i++) {
				MutableDependentValue currentNode = unsortedNodes.get(i);
				MutableDependentValue[] dependencies = currentNode.getDependencies();
				
				if(dependencies.length == 0 || allDependenciesMarked(dependencies, labelledNodes)) {
					unsortedNodes.remove(i);
					labelledNodes.add(currentNode);
					sortedNodes.add(currentNode);
					
					i--;
				}
			}
		}
		
		for(int i = 0; i < linkedValues.length; i++) {
			linkedValues[i] = sortedNodes.get(i);
		}
		
		
	}

	private static boolean allDependenciesMarked(MutableDependentValue[] dependencies, HashSet<MutableDependentValue> labelledNodes) {
		for(MutableDependentValue dependency : dependencies) {
			if(!labelledNodes.contains(dependency)) {
				return false;
			}
		}
		return true;
	}

}
