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
        return false;
    }

    @Override
    public INode next() {
        return null;
    }
}
