import java.util.LinkedList;
import java.util.List;

public class NodeExplorer {

    private Scrapper scrapper;

    public NodeExplorer(Scrapper scrapper) {
        this.scrapper =  scrapper;
    }

    public void Explore(Node baseNode){

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(baseNode);

        while(!queue.isEmpty()){
            Node nextNodeToScrape = queue.remove();

            List<Node> scrapedNode = scrapper.Scrape(nextNodeToScrape);
            for (Node node: scrapedNode) {
                queue.add(node);
            }
        }
    }
}
