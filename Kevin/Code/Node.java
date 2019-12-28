package Kevin.Code;

import java.util.HashMap;
import java.util.LinkedList;

import Michel.Employer;

public class Node{
    private Node parent;
    private LinkedList<Node> adjaceNodes = new LinkedList<>();
    private LinkedList<String> autoComplete = new LinkedList<>();
    private HashMap<String, Employer> listeEmployers = new HashMap<String, Employer>();
    private char value = ' ';

    public Node(Node parent, char value){
        this.parent = parent;
        this.value = value;
    }

    public Node(Node parent, LinkedList<Node> adjaceNodes, LinkedList<String> autoComplete, char value){
        this.adjaceNodes = adjaceNodes;
        this.parent = parent;
        this.autoComplete = autoComplete;
        this.value = value;
    }

    public void afficherAutoComplete() {
       System.out.println(autoComplete);   
   }

    public Node nextChild(char val) {
        for(Node node : this.adjaceNodes){
            if(node.getValue() == val){
                return node;
            }
        }
        return null;
    }

    public HashMap<String, Employer> getListeEmployers() {
        return listeEmployers;
    }

    public void setListeEmployers(HashMap<String, Employer> listeEmployers) {
        this.listeEmployers = listeEmployers;
    }


    public char getValue() {
        return value;
    }
    public void setAdjaceNodes(LinkedList<Node> adjaceNodes) {
        this.adjaceNodes = adjaceNodes;
    }

    public void setAutoComplete(LinkedList<String> autoComplete) {
        this.autoComplete = autoComplete;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public LinkedList<Node> getAdjaceNodes() {
        return adjaceNodes;
    }

    public LinkedList<String> getAutoComplete() {
        return autoComplete;
    }

    public Node getParent() {
        return parent;
    }


    public Node clone(){
        return new Node(this.parent, this.adjaceNodes, this.autoComplete, this.value);
    }



}