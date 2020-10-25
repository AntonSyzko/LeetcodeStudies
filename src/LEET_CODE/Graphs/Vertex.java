package LEET_CODE.Graphs;

public class Vertex {
    public char name;
    public boolean isVisited;

    public Vertex(char name) {
        this.name = name;
        this.isVisited = false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vertex{");
        sb.append("name=").append(name);
        sb.append(", isVisited=").append(isVisited);
        sb.append('}');
        return sb.toString();
    }
}
