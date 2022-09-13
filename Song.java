public class Song {
    String tittle;
    double duration;

    public Song(String tittle, double duration) {
        this.tittle = tittle;
        this.duration = duration;
    }


    public String getTittle() {
        return tittle;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title=' " + tittle + '\'' + ",duration=" + duration +
                '}';
    }
}
