
import java.util.Scanner;

//Class Hierarchy
class Song{
    private String title; //unique
    private String artist; //not unique
    private int duration; //in seconds && non-negative
    public Song(String songTitle, String songArtist, int songDuration){
        title = songTitle;
        artist = songArtist;
        duration = songDuration;
    }
    public String getTitle(){return title;}
    public String getArtist(){return artist;}
    public int getDuration(){return duration;}
    public void setTitle(String songTitle){title = songTitle;}
    public void setArtist(String songArtist){artist = songArtist;}
    public void setDuration(int songDuration){duration = songDuration;}
    //formatDuration() changes duration from seconds into minutes:seconds
//e.g., a song that is 140 seconds long ha sa duration of 2 minutes 20 seconds formatted as 2:20
    public String formatDuration(){
        return String.format("%d:%02d", duration/60, duration%60);
    }
    public String toString(){
        return ("\"" + title + "\" by " + artist + " is " + formatDuration() + " long.");
    }
}
class Pop extends Song{
    private int peakChartPosition; //between 1 and 100, 1 being a higher and better position than 100!
    public Pop(String songTitle, String songArtist, int songDuration, int chartRank){
        super(songTitle, songArtist, songDuration);
        peakChartPosition = chartRank;
    }
    public int getPeakChartPosition(){return peakChartPosition;}
    public void setPeakChartPosition(int chartRank){peakChartPosition = chartRank;}
    public String toString(){
        return super.toString() + " The Pop song peaked at " + peakChartPosition + " on the charts!";
    }
}
class Rap extends Song{
    private boolean tooExplicitForRadioPlay; //an explicit song is a song that has many bad words and is inappropriate for radio play
    public Rap(String songTitle, String songArtist, int songDuration, boolean
            wasPlayedOnRadio){
        super(songTitle, songArtist, songDuration);
        tooExplicitForRadioPlay = wasPlayedOnRadio;
    }
    public boolean getTooExplicitForRadioPlay(){return tooExplicitForRadioPlay;}
    public void setTooExplicitForRadioPlay(boolean
                                                   wasPlayedOnRadio){tooExplicitForRadioPlay = wasPlayedOnRadio;}
    public String toString(){
        if (tooExplicitForRadioPlay == true){
            return super.toString() + " This rap song is too explicit to be played on the radio!";
        }
        else{
            return super.toString() + " This rap song is safe for radio!";
        }
    }
}
class DancePop extends Pop{
    private int beatsPerMinute; //how hard the song hits in a club
    public DancePop(String songTitle, String songArtist, int songDuration, int chartRank, int
            BPM){
        super(songTitle, songArtist, songDuration, chartRank);
        beatsPerMinute = BPM;
    }
    public int getBPM(){return beatsPerMinute;}
    public void setBPM(int BPM){beatsPerMinute = BPM;}
    public String toString(){
        if(beatsPerMinute>=120){
            return super.toString()+ " This dance pop song is a potential club record.";
        }
        else{
            return super.toString()+ " This dance pop song is not loud enough for clubs to play it.";
        }
    }
}
class SongList{
    static class Node{
        Song song;
        Node next;
        public Node(Song song){
            this.song = song;
        }
    }

    Node head;
    int length=0;
    SongList(){

    }
    SongList(Song song){
        head = new Node(song);
        head.next = null;
        length++;
    }

    public int size(){
        return length;
    }

    public void insertSongAtStart(Song songToInsert){
        if(head==null){
            head = new Node(songToInsert);
            head.next = null;
            length++;
        }else{
            Node temp = new Node(songToInsert);
            temp.next = head;
            head = temp;
            length++;
        }
    }


    public void deleteSong(String titleToDelete){
        if(head == null){
            return;
        }
        Node temp = head;
        Node prev = null;

        while (temp != null){
            if(temp.song.getTitle().equals(titleToDelete)){
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        if(temp == null){
            return;
        }

        if(prev != null){
            prev.next = temp.next;
        }else{
            head = temp.next;
        }

//        if(temp.song.getTitle().equals(titleToDelete)){
//            head = head.next;
//            length--;
//        }else{
//            while(temp.next!=null){
//                if(temp.next.song.getTitle().equals(titleToDelete)){
//                    temp.next = temp.next.next;
//                    length--;
//                }
//                temp = temp.next;
//            }
//        }
    }

    public void displayList() {
        if (head == null) {
            System.out.println("Empty");
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                System.out.print("[" + currentNode.song.getTitle() + "] -> ");
                currentNode = currentNode.next;
            }
            System.out.println("[" + currentNode.song.getTitle() + "]");
        }
    }
}


class MusicLibrary{
    int tableSize;
    SongList[] playlist;

    public MusicLibrary(int tableSize){
        this.tableSize = tableSize;
        playlist = new SongList[tableSize];

    }

    public long calculateCode(Song song) {
        String s = song.getTitle();
        int length = Math.min(s.length(), 20);
        long hashCode = 0;
        long powerOf7 = 1;
        for (int i = 0; i < length; i++) {
            int ascii = (int) s.charAt(i);
            hashCode += ascii * powerOf7;
            powerOf7 *= 7;
        }
        return hashCode;
    }
    //do modulo
    public int getHash(long hash){
        return (int) (hash%tableSize);
    }

    public int addSongToLibrary(Song song){
        long code = calculateCode(song);
        int hash = getHash(code);

        if(playlist[hash]==null){
            playlist[hash] = new SongList(song);
            return hash;
        }else{
            SongList.Node temp = playlist[hash].head;
            while(temp!=null){
                if(temp.song.getTitle().equals(song.getTitle())){
                    return -1;
                }
                temp = temp.next;
            }
            playlist[hash].insertSongAtStart(song);
            return hash;
        }
    }

    public void deleteSongWithTitle(){
        for(int i = 0; i < playlist.length; i++) {

            SongList list = playlist[i];
            if(list != null){
                SongList.Node curr = list.head;

                while (curr != null){

                    if(curr.song instanceof Rap){
                        Rap tempSong = (Rap) curr.song;
                        if(tempSong.getTooExplicitForRadioPlay()){
                            list.deleteSong(tempSong.getTitle());
                            list.length = list.length-1;
                        }
                    }

                    curr = curr.next;
                }
            }

//            if(playlist[i]!=null){
//                SongList.Node temp = playlist[i].head;
//                if(temp.song instanceof Rap && ((Rap)temp.song).getTooExplicitForRadioPlay()){
//                    playlist[i].head = temp.next;
//                }else{
//                    temp = playlist[i].head.next;
//                    SongList.Node prev = playlist[i].head;
//                    while(temp!=null){
//                        if(temp.song instanceof Rap && ((Rap) temp.song).getTooExplicitForRadioPlay()){
//                            prev.next = temp.next;
//                        }else{
//                            prev = temp;
//                        }
//                        temp = temp.next;
//
//                    }
//
//                }
//            }
        }
    }


    public void displayLibrary() {
        for (int i = 0; i < tableSize; i++) {
            System.out.println("Playlist " + i + ":");
            if (playlist[i] != null) {
                playlist[i].displayList();
            } else {
                System.out.println("Empty");
            }
// Print dashed line only if it's not the last iteration
            if (i < tableSize - 1) {
                System.out.println("----------------------");
            }
        }
    }

//    public int findNumberOfSongs() {
//        int x = 0;
//        for (int i = 0; i < tableSize; i++) {
//            System.out.println("Playlist " + i + " length" + playlist[i].length);
//        }
//        return x;
//    }
}
public class Solution_Day_77 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        MusicLibrary musicLibrary = new MusicLibrary(size);
        if(size==0){
            System.out.println("Could not sing on void!");
            return;
        }
        int indx = 0;
        int duplicates = 0;
        String s;
        while(sc.hasNext()){
            s = sc.nextLine();
            String[] strArray = s.split("\\|");

            if(s.equals("done")){
                break;
            }
            if(strArray[0].equals("any")){
                int duration = Integer.parseInt(strArray[3]);
                Song song = new Song(strArray[1],strArray[2],duration);
                indx = musicLibrary.addSongToLibrary(song);
                if(indx==-1){duplicates++;}
            }else if(strArray[0].equals("pop")){
                int duration = Integer.parseInt(strArray[3]);
                int chartRank = Integer.parseInt(strArray[4]);
                Song song = new Pop(strArray[1],strArray[2],duration, chartRank);
                indx = musicLibrary.addSongToLibrary(song);
                if(indx==-1){duplicates++;}

            }else if(strArray[0].equals("dance")){
                int duration = Integer.valueOf(strArray[3]);
                int chartRank = Integer.valueOf(strArray[4]);
                int bpm = Integer.valueOf(strArray[5]);
                Song song = new DancePop(strArray[1],strArray[2],duration, chartRank, bpm);
                indx = musicLibrary.addSongToLibrary(song);
                if(indx==-1){duplicates++;}
            } else if (strArray[0].equals("rap")) {
                int duration = Integer.valueOf(strArray[3]);
                boolean playOnRadio = Boolean.parseBoolean(strArray[4]);
                Song song = new Rap(strArray[1],strArray[2],duration,playOnRadio);
                indx = musicLibrary.addSongToLibrary(song);
                if(indx==-1){duplicates++;}
            }
        }

//        Problem 1
//        if(duplicates == 0){
//            System.out.println("");
//        }else{
//            System.out.println("You attempted to add duplicates " + duplicates + " times, only one instance of each song was added to the library.");
//        }
//
//        System.out.println("Below is your music library composed of "+ musicLibrary.tableSize + " playlists:");
//        musicLibrary.displayLibrary();

/* Problem - 2
        Song temp1 = null;
        int max = Integer.MIN_VALUE;
        int counter = 0;
        int index = 0;
        for (int i = 0; i < musicLibrary.tableSize; i++) {
            if(musicLibrary.playlist[i]!=null){
                SongList.Node temp = musicLibrary.playlist[i].head;
                while(temp!=null){
                    if(temp.song instanceof DancePop){
                        if(((DancePop) temp.song).getBPM() == max){
                            index = counter;
                            if(index==i){
                                temp1 = (DancePop)temp.song;
                            }
                        }
                        if(((DancePop) temp.song).getBPM() > max){
                            counter = i;
                            index = counter;
                            max = ((DancePop) temp.song).getBPM();
                            temp1 = (DancePop)temp.song;
                        }
                    }
                    temp = temp.next;
                }
            }
        }
        if(max==Integer.MIN_VALUE){
            System.out.println("No result found.");
        }else{
            System.out.print("The most upbeat song was found in playlist " + index + ". It is ");
            System.out.println(temp1.getTitle() + " by " + temp1.getArtist()  + ".");
        }*/

        /*Problem 3

        System.out.println("Your naughty music library:");
        System.out.println();
        musicLibrary.displayLibrary();

        musicLibrary.deleteSongWithTitle();
        System.out.println();
        System.out.println("Your polite music library:");
        System.out.println();
        musicLibrary.displayLibrary();

        */


        /* Problem 4
        //int n = musicLibrary.findNumberOfSongs();

        int n = 0;
        for (int i = 0; i < musicLibrary.tableSize; i++) {
            if(musicLibrary.playlist[i]!=null){
                n = n + musicLibrary.playlist[i].length;
            }
        }
        System.out.println("The total number of songs in your library before removing explicit Rap songs: " + n);

        musicLibrary.deleteSongWithTitle();

        int x = 0;
        for (int i = 0; i < musicLibrary.tableSize; i++) {
            if(musicLibrary.playlist[i]!=null){
                x = x + musicLibrary.playlist[i].length;
            }
        }
        System.out.println("The total number of songs in your library after removing explicit Rap songs: " + x);
        */


        /* Problem-6 */
        String artist = sc.nextLine();
        SongList songList = new SongList();

        for (int i = 0; i < musicLibrary.tableSize; i++) {

            if(musicLibrary.playlist[i]!=null){
                SongList.Node temp = musicLibrary.playlist[i].head;
                for (int j = 0; j < musicLibrary.playlist[i].length; j++) {
                    while(temp!=null){
                        if(temp.song.getArtist().equals(artist)){
                            songList.insertSongAtStart(temp.song);
                        }
                        temp = temp.next;
                    }
                }
            }

        }
//        System.out.println("Below are all the songs in the library by " + artist + ":");
//        songList.displayList();

        /*Probelm-7 */
        if(songList.head!=null){
            SongList.Node slow = songList.head;
            SongList.Node fast = songList.head.next;

            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }

            if(slow == null){
                System.out.println("No result found.");
            }else{
                System.out.println("The mid song in the list of all the songs in the library by " + slow.song.getArtist() +" is: "+ slow.song.getTitle() +".");
            }
        }else{
            System.out.println("No result found.");
        }



    }
}
