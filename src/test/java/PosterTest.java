import org.example.PosterDTO;
import org.example.PosterManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterTest {
    PosterManager posterManager = new PosterManager();

    @Test
    public void addTest() {
        PosterDTO poster = new PosterDTO(1, "film 1", "soap");
        posterManager.add(poster);

        Assertions.assertEquals(1, posterManager.findAll().length);
    }

    @Test
    public void findLastTest() {
        int count = 5;
        PosterDTO[] posters = {
            new PosterDTO(1, "film 1", "soap"),
            new PosterDTO(2, "film 2", "soap"),
            new PosterDTO(3, "film 3", "soap"),
            new PosterDTO(4, "film 4", "soap"),
            new PosterDTO(5, "film 5", "soap"),
            new PosterDTO(6, "film 6", "soap"),
        };

        PosterDTO[] lastPosterExpected = {
                posters[5],
                posters[4],
                posters[3],
                posters[2],
                posters[1],
        };

        posterManager.add(posters[0]);
        posterManager.add(posters[1]);
        posterManager.add(posters[2]);
        posterManager.add(posters[3]);
        posterManager.add(posters[4]);
        posterManager.add(posters[5]);

        Assertions.assertEquals(count, posterManager.findLast().length);
        Assertions.assertArrayEquals(lastPosterExpected, posterManager.findLast());
    }

    @Test
    public void findLastMinTest() {
        int count = 5;

        PosterDTO[] posters = {
                new PosterDTO(1, "film 1", "soap"),
                new PosterDTO(2, "film 2", "soap"),
                new PosterDTO(3, "film 3", "soap")
        };

        PosterDTO[] lastPosterExpected = {
                posters[2],
                posters[1],
                posters[0]
        };

        posterManager.add(posters[0]);
        posterManager.add(posters[1]);
        posterManager.add(posters[2]);


        Assertions.assertEquals(3, posterManager.findLast().length);
        Assertions.assertArrayEquals(lastPosterExpected, posterManager.findLast());
    }

    @Test
    public void findLastTestCaseNullItems() {
        PosterManager posterManager = new PosterManager();
        PosterDTO[] findLastItems = posterManager.findLast();
        Assertions.assertEquals(0, findLastItems.length);
        Assertions.assertArrayEquals(new PosterDTO[0], findLastItems);
    }

    @Test
    public void findLastTestCaseCustomCount() {
        int count = 4;
        PosterManager posterManager = new PosterManager(count);
        PosterDTO[] posters = {
                new PosterDTO(1, "film 1", "soap"),
                new PosterDTO(2, "film 2", "soap"),
                new PosterDTO(3, "film 3", "soap"),
                new PosterDTO(4, "film 4", "soap"),
                new PosterDTO(5, "film 5", "soap"),
                new PosterDTO(6, "film 6", "soap"),
        };

        PosterDTO[] lastPosterExpected = {
                posters[3],
                posters[2],
                posters[1],
                posters[0],
        };

        posterManager.add(posters[0]);
        posterManager.add(posters[1]);
        posterManager.add(posters[2]);
        posterManager.add(posters[3]);

        Assertions.assertEquals(count, posterManager.findLast().length);
        Assertions.assertArrayEquals(lastPosterExpected, posterManager.findLast());
    }


}
