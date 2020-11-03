package org.bb.bg;

import java.util.List;

public class GraphEdge<T,L> {

    private EntityColor edgeColor;
    private List<L> value;
    private GraphNode<T,L> sourceNode;
    private GraphNode<T,L> destinationNode;

    public EntityColor getEdgeColor() {
        return edgeColor;
    }

    public void setEdgeColor(EntityColor edgeColor) {
        this.edgeColor = edgeColor;
    }

    public List<L> getValue() {
        return value;
    }

    public void setValue(List<L> value) {
        this.value = value;
    }

    public GraphNode<T,L> getSourceNode() {
        return sourceNode;
    }

    public GraphNode<T,L> getDestinationNode() {
        return destinationNode;
    }

    public GraphEdge(GraphNode sourceNode, GraphNode destinationNode) {
        this.sourceNode = sourceNode;
        this.destinationNode = destinationNode;
        this.edgeColor = EntityColor.WHITE;
    }
}
