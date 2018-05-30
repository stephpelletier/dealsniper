import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class NodeExplorerTests {

    private NodeExplorer nodeExplorer;
    private Scrapper mockedScrapper;

    @Before
    public void SetUp(){
        mockedScrapper = mock(Scrapper.class);

        nodeExplorer = new NodeExplorer(mockedScrapper);
    }

    @Test
    public void ShouldScrapeEveryNode(){
        // Arrange
        Node baseNode = new Node("Url1");
        Node firstNode = new Node("Url1");
        Node secondNode = new Node("Url1");

        List<Node> scrappedBaseNode = new ArrayList<Node>();
        scrappedBaseNode.add(firstNode);
        scrappedBaseNode.add(secondNode);

        when(mockedScrapper.Scrape(baseNode)).thenReturn(scrappedBaseNode);

        // Act
        nodeExplorer.Explore(baseNode);

        // Assert
        verify(mockedScrapper, times(1)).Scrape(baseNode);
        verify(mockedScrapper, times(1)).Scrape(firstNode);
        verify(mockedScrapper, times(1)).Scrape(secondNode);

    }
}
