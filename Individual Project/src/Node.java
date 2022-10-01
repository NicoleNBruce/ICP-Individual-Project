import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Node{
    Airport state;
    Node parent;

    // The action that was taken to get to the current state.
    Routes action;
    int pathCost;
    ArrayList<Routes> act_list = new ArrayList<>();


    public Node(Airport airport) {
        this.state = airport;
    }

    public Node(Airport airport, Node parent, Routes action, int pathCost) {
        this.state = airport;
        this.parent = parent;
        this.action = action;
        this.pathCost = pathCost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "state=" + state +
                ", parent=" + parent +
                ", action=" + action +
                ", pathCost=" + pathCost +
                '}';
    }

    /**
     * The function takes the current node and adds the action that was taken to get to that node to a list of actions. Then it
     * sets the node to the parent of the current node and repeats the process until the parent is null. Then it reverses
     * the action list so that the actions are in the correct order
     *
     * @return The solution path of actions is being returned.
     */
    public ArrayList<Routes> solutionpath(){
        Node node = this;
        if (node.parent == null){
        }

        while (node.parent != null) {
            act_list.add(node.action);
            node = node.parent;
        }
        Collections.reverse(act_list);
        return act_list;
    }

    public Airport getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }

    public Routes getAction() {
        return action;
    }

    public int getPathCost() {
        return pathCost;
    }

    /**
     * This function returns an ArrayList of Routes objects, which is the solution path
     *
     * @return The action list is being returned.
     */
    public ArrayList<Routes> getAct_list() {
        ArrayList<Routes> action_list = solutionpath();
        return action_list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(state, node.state);
    }
}