package nodesStructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyStructure implements IMyStructure, Iterable<INode> {
    private List<INode> nodes = new LinkedList<>();
    private MyIterator myIterator;

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
        List<INode> flatNodes = nodes;
        myIterator = new MyIterator(flatNodes);

        while (iterator().hasNext()) {
            INode currentNode = iterator().next();
            if (currentNode instanceof ICompositeNode) {
                for (INode node : ((ICompositeNode) currentNode).getNodes()){
                    if (!flatNodes.contains(node)){
                        flatNodes.add(node);
                    }
                }
            }
        }
        return flatNodes;
    }

    void addNode(INode node) {
        nodes.add(node);
    }

    @Override
    public Iterator<INode> iterator() {
        return myIterator;
    }
}