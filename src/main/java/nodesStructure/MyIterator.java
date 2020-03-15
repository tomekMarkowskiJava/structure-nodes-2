package nodesStructure;

import java.util.Iterator;
import java.util.List;

public class MyIterator implements Iterator<INode> {
    private int pos = 0;
    private List<INode> nodes;

    MyIterator(List<INode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean hasNext() {
        return pos < nodes.size();
    }

    @Override
    public INode next() {
        if (this.hasNext())
            return nodes.get(pos++);
        else
            return null;
    }

}
