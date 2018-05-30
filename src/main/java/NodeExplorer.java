public class NodeExplorer {

    private Scrapper scrapper;

    public NodeExplorer(Scrapper scrapper) {
        this.scrapper =  scrapper;
    }

    public void Explore(Node node){
        scrapper.Scrape(node);
    }
}
