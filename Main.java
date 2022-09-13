import java.util.*;

public class Main {
   private static ArrayList<Album>albums=new ArrayList<>();
    public static void main(String[] args) {

        Album album=new Album("Album1","AC/DC");
        album.addsong("TNT",4.5);
        album.addsong("Highway",2.5);
        album.addsong("Thunder",3.5);


        albums.add(album);


        album=new Album("Album2","Bhupesh manuja");
        album.addsong("rap",4.5);
        album.addsong("loss your self",5.5);
        album.addsong("fighter song",3.8);

        albums.add(album);

        LinkedList<Song>playList=new LinkedList<>();
        albums.get(0).addToPlaylist("TNT",playList);
        albums.get(0).addToPlaylist("Highway",playList);
        albums.get(0).addToPlaylist("Thunder",playList);
        albums.get(1).addToPlaylist("rap",playList);
        albums.get(1).addToPlaylist("loss your self",playList);
        albums.get(1).addToPlaylist("fighter song",playList);
        

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc =new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song>listIterator= playList.listIterator();

        if(playList.size()==0){
            System.out.println("This PlayList Have no song");

        }
        else{
            System.out.println("Now playling "+listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action =sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist completed");
                    quit=true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Nowplaying"+listIterator.next().toString());
                    }else{
                        System.out.println("no song avialable ,reached to the end");
                        forward=false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing"+listIterator.previous().toString());
                    }
                    else{
                        System.out.println("We are first song");
                        forward=false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward=false;
                        }
                        else{
                            System.out.println("We are the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing"+listIterator.next().toString());
                            forward=true;
                        }else{
                            System.out.println("We have reached end of list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing"+listIterator.next().toString());

                        }
                        else{
                            if(listIterator.hasPrevious()){
                                System.out.println("now playing"+listIterator.previous().toString());
                            }
                        }
                    }

            }
        }
    }
    private static void printMenu(){
        System.out.println("Avialable option\n press");
        System.out.println("0-to quit\n"+"1-to play song\n"+"2 -to play previous song\n"+"3-replay cuurent song\n"+"4-list of all song\n"+"5 print all avialble options\n"+"6 -delete cuuren song");

    }
    private static void printList(LinkedList<Song>playList){
        Iterator<Song>iterator=playList.iterator();
        System.out.println("_____________________");

        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }
        System.out.println("_____________________");

    }
}