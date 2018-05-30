import org.junit.Before;
import org.junit.Test;

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
    public void ShouldScrapeTheFirstNode(){
        // Arrange
        Node node = new Node("Url");

        // Act
        nodeExplorer.Explore(node);

        // Assert
        verify(mockedScrapper, times(1)).Scrape(node);
    }
}
