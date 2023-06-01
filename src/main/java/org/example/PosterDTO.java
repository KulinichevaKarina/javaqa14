package org.example;

public class PosterDTO {
    private int id;
    private String name;
    private String genre;

    public PosterDTO(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
