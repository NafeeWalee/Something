package pureinternational.something.RecyclerView;

public class RecyclerData {
    private int id;
    private String text1;
    private String text2;
    private String text3;
    private int image;


    public RecyclerData(int id, String text1, String text2, String text3, int image) {
        this.id = id;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
