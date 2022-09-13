import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private
    String name;
    String artist;
    ArrayList<Song> songs;

    public Album(String name, String artist) {
   this.name=name;
   this.artist=artist;
   this.songs=new ArrayList<Song>();
    }

    public Song findSong(String tittle){
        for(Song checkedSong :songs){
            if(checkedSong.getTittle().equals(tittle)) return checkedSong;
        }
        return null;
    }
    public boolean addsong(String tittle,double duration){
        if(findSong(tittle)==null){
            songs.add(new Song(tittle,duration));
        //    System.out.println(tittle + "suceesfully added to the list");
            return true;
        }
        else{
           // System.out.println("Song with this name"+tittle+"already Exits");
            return false;
        }
    }
    public boolean addToplaylist(int tracknumber, LinkedList<Song>Playlist){
        int index=tracknumber-1;
        if(index>0 && index<=this.songs.size()){
            Playlist.add(this.songs.get(index));
            return true;
        }
      //  System.out.println("This album doesnot have song with this tracknumber"+tracknumber);
        return false;
    }
    public boolean addToPlaylist(String tittle,LinkedList<Song>PlayList){
        for(Song checkedSong :this.songs){
            if(checkedSong.getTittle().equals(tittle)){
                PlayList.add(checkedSong);
                return true;
            }

        }
     //   System.out.println(tittle + "there is no such song in album");
        return false;
    }
}
