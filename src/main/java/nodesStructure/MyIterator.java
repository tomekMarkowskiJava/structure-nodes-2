package nodesStructure;

import java.util.Iterator;
import java.util.List;

public class MyIterator implements Iterator<INode> {
    private int pos = 0;
    List<INode> nodes;

    public MyIterator(List<INode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean hasNext() {
        if (pos < nodes.size())
            return true;
        else
            return false;
    }

    @Override
    public INode next() {
        if (this.hasNext())
            return nodes.get(pos++);
        else
            return null;
    }

}
