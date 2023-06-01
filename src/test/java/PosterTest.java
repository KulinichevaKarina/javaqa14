import org.example.PosterDTO;
import org.example.PosterManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterTest {

    @Test
    public void addTest() {
        PosterManager posterManager = new PosterManager();
        PosterDTO poster = new PosterDTO(1, "film 1", "soap");
        posterManager.add(poster);

        Assertions.assertEquals(1, posterManager.findAll().length);
    }

    @Test
    public void findLastTest() {
        int count = 5;
        PosterManager posterManager = new PosterManager();
        PosterDTO[] posters = {
            new PosterDTO(1, "film 1", "soap"),
            new PosterDTO(2, "film 2", "soap"),
            new PosterDTO(3, "film 3", "soap"),
            new PosterDTO(4, "film 4", "soap"),
            new PosterDTO(5, "film 5", "soap"),
            new PosterDTO(6, "film 6", "soap"),
        };

        for (PosterDTO poster: posters) {
            posterManager.add(poster);
        }

        PosterDTO[] lastPosterExpected = new PosterDTO[count];
        for (int i = 0; i < lastPosterExpected.length; i++) {
            lastPosterExpected[i] = posters[posters.length - 1 - i];
            if (i == count - 1) {
                break;
            }
        }
        Assertions.assertEquals(count, posterManager.findLast().length);
        Assertions.assertArrayEquals(lastPosterExpected, posterManager.findLast());
    }
    @Test
    public void findLastMinTest() {
        int count = 5;
        PosterManager posterManager = new PosterManager();
        PosterDTO[] posters = {
            new PosterDTO(1, "film 1", "soap"),
            new PosterDTO(2, "film 2", "soap"),
            new PosterDTO(3, "film 3", "soap")
        };

        for (PosterDTO poster: posters) {
            posterManager.add(poster);
        }

        PosterDTO[] lastPosterExpected = new PosterDTO[Math.min(posters.length, count)];
        for (int i = 0; i < lastPosterExpected.length; i++) {
            if (i <= count - 1) {
                lastPosterExpected[i] = posters[posters.length - 1 - i];
            }
        }
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

        for (PosterDTO poster: posters) {
            posterManager.add(poster);
        }

        PosterDTO[] lastPosterExpected = new PosterDTO[count];
        for (int i = 0; i < lastPosterExpected.length; i++) {
            lastPosterExpected[i] = posters[posters.length - 1 - i];
            if (i == count - 1) {
                break;
            }
        }
        Assertions.assertEquals(count, posterManager.findLast().length);
        Assertions.assertArrayEquals(lastPosterExpected, posterManager.findLast());
    }


}
