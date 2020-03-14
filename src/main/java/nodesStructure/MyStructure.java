package nodesStructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyStructure implements IMyStructure, Iterable<INode> {
    private List<INode> nodes = new LinkedList<>();


    private List<INode> getFlattenedNodes() {
        return null;
    }

    @Override
    public INode findByCode(String code) {
        return null;
    }

    @Override
    public INode findByRenderer(String renderer) {
        return null;
    }

    @Override
    public int count() {
        return getFlattenedNodes().size();
    }


    private void flatten(List<INode> nodes) {

    }

    public void addNode(INode node) {
        nodes.add(node);
    }

    @Override
    public Iterator<INode> iterator() {
        return new MyIterator(nodes);
    }
}