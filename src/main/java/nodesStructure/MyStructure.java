package nodesStructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyStructure implements IMyStructure, Iterable<INode> {
    private List<INode> nodes = new LinkedList<>();


    @Override
    public INode findByCode(String code) {
        return flatten()
                .stream()
                .filter(iNode -> iNode.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public INode findByRenderer(String renderer) {
        return flatten()
                .stream()
                .filter(iNode -> iNode.getRenderer().equals(renderer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int count() {
        return flatten().size();
    }


    private List<INode> flatten() {
        List<INode> flatNodes;
        flatNodes = nodes;

        while (iterator().hasNext()) {
            INode temp = iterator().next();
            if (temp instanceof ICompositeNode) {
                flatNodes.addAll(((ICompositeNode)iterator().next()).getNodes());
            }
        }
        return flatNodes;
    }

    public void addNode(INode node) {
        nodes.add(node);
    }

    @Override
    public Iterator<INode> iterator() {
        return new MyIterator(nodes);
    }
}