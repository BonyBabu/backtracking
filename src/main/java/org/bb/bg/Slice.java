package org.bb.bg;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Slice<T, L> {

	private final List<GraphNode<T, L>> graphNodeList;
	private final boolean isLast;

	private Iterator<GraphNode<T, L>> nodeIterator;

	public Slice(List<GraphNode<T, L>> graphNodeList, boolean isLast) {
		this.graphNodeList = graphNodeList;
		this.isLast = isLast;
		this.nodeIterator = graphNodeList.listIterator();
	}

	public boolean isDeadEnd() {
		return graphNodeList.stream().filter(node -> node.isDeadEnd()).count() == graphNodeList.size() && !isLast;
	}

	public final GraphNode<T, L> getNextBestNode() {
		List<GraphNode<T, L>> graphNodeListWithOutDeadEndNodes = graphNodeList.stream().filter((graphNode) ->
				!graphNode.isDeadEnd() || isLast
		).filter((graphNode) ->
				!graphNode.isUnreachable() || graphNode.getIncomingEdge().size() == 0
		).collect(Collectors.toList());

		if (graphNodeListWithOutDeadEndNodes.isEmpty()) {
			return null;
		} else {
			if (!nodeIterator.hasNext()) {
				nodeIterator = graphNodeList.listIterator();
			}

			GraphNode nextNode = null;
			for (nextNode = nodeIterator.next(); !graphNodeListWithOutDeadEndNodes.contains(nextNode);
					nextNode = nodeIterator.next()) {
				if (!nodeIterator.hasNext()) {
					nodeIterator = graphNodeList.listIterator();
				}
			}
			return nextNode;
		}
	}

	public List<GraphNode<T, L>> getNodes() {
		return graphNodeList;

	}

	public int getNodePosition(GraphNode<T, L> node) {
		return graphNodeList.indexOf(node);
	}
}
