package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements Initializable {

    //==================EDIT 29/1/200 10:34

    //GETTING CHAR
    public static int converter(char x){
        int baseName=0;

        switch (x)
        {
            case 'a':
                baseName=1001;
                break;
            case 'b':
                baseName=1002;
                break;
            case 'c':
                baseName=1003;
                break;
            case 'd':
                baseName=1004;
                break;
            case 'e':
                baseName=1005;
                break;
            case 'f':
                baseName=1006;
                break;
            case 'g':
                baseName=1007;
                break;
            case 'h':
                baseName=1008;
                break;
            case 'i':
                baseName=1009;
                break;
            case 'j':
                baseName=1010;
                break;
            case 'k':
                baseName=1011;
                break;
            case 'l':
                baseName=1012;
                break;
            case 'm':
                baseName=1013;
                break;
            case 'n':
                baseName=1014;
                break;
            case 'o':
                baseName=1015;
                break;
            case 'p':
                baseName=1016;
                break;
            case 'q':
                baseName=1017;
                break;
            case 'r':
                baseName=1018;
                break;
            case 's':
                baseName=1019;
                break;
            case 't':
                baseName=1020;
                break;
            case 'u':
                baseName=1021;
                break;
            case 'v':
                baseName=1022;
                break;
            case 'w':
                baseName=1023;
                break;
            case 'x':
                baseName=1024;
                break;
            case 'y':
                baseName=1025;
                break;
            case 'z':
                baseName=1026;
                break;
            case ' ':
                baseName=1222;
                break;
            default:
                baseName=1999;
        }
        return baseName;
    }

    @FXML
    private MediaView mediaView;


    //Media 1
    private File file1;
    private Media media1;

    //Media 2
    private File file2;
    private Media media2;

    //Media 3
    private File file3;
    private Media media3;

    //Media 4
    private File file4;
    private Media media4;

    //Media 5
    private File file5;
    private Media media5;

    //Media 6
    private File file6;
    private Media media6;

    //Media 7
    private File file7;
    private Media media7;

    //Media 8
    private File file8;
    private Media media8;

    //Media 9
    private File file9;
    private Media media9;

    //Media 10
    private File file10;
    private Media media10;

    //Media 11
    private File file11;
    private Media media11;

    //Media 12
    private File file12;
    private Media media12;


    //Media 13
    private File file13;
    private Media media13;

    //Media 14
    private File file14;
    private Media media14;

    //Media 15
    private File file15;
    private Media media15;

    private List<Media> media;
    private int curIndex;

    private MediaPlayer mediaPlayer;

    private void playNextVideo() {
        disposePlayer();
        if (curIndex == media.size()) {
            return; // no more videos to play
        }

        mediaPlayer = new MediaPlayer(media.get(curIndex++));
        mediaPlayer.setAutoPlay(true); // play ASAP
        mediaPlayer.setOnEndOfMedia(this::playNextVideo); // play next video when this one ends
        mediaView.setMediaPlayer(mediaPlayer);
    }

    private void disposePlayer() {
        MediaPlayer player = mediaView.getMediaPlayer();
        if (player != null) {
            player.dispose(); // release resources
        }
    }
    public void playMedia() {

        mediaPlayer.play();
    }

    public void pauseMedia() {

        mediaPlayer.pause();
    }

    public void resetMedia() {

        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
        }
    }

    //=========================================================================
    //BSL ALGORITHM
    @FXML
    private MediaView mediaViewBsl;

    //Meida Bsl1
    private File fileBsl1;
    private Media mediaBsl1;

    //Meida Bsl2
    private File fileBsl2;
    private Media mediaBsl2;

    //Meida Bsl3
    private File fileBsl3;
    private Media mediaBsl3;

    //Meida Bsl4
    private File fileBsl4;
    private Media mediaBsl4;

    //Meida Bsl5
    private File fileBsl5;
    private Media mediaBsl5;

    //Meida BslEnd
    private File fileBslEnd;
    private Media mediaBslEnd;


    private List<Media> mediaBsl;
    private int curIndexBsl;

    private MediaPlayer mediaPlayerBsl;

    private void playNextVideoBsl() {
        disposePlayerBsl();
        if (curIndexBsl == mediaBsl.size()) {
            return; // no more videos to play
        }


            mediaPlayerBsl = new MediaPlayer(mediaBsl.get(curIndexBsl++));
            mediaPlayerBsl.setAutoPlay(true); // play ASAP
            mediaPlayerBsl.setOnEndOfMedia(this::playNextVideoBsl); // play next video when this one ends
            mediaViewBsl.setMediaPlayer(mediaPlayerBsl);

    }
    private void disposePlayerBsl() {
        MediaPlayer playerBsl = mediaViewBsl.getMediaPlayer();
        if (playerBsl != null) {
            playerBsl.dispose(); // release resources
        }
    }



    //BSL STARTUP

    LinkedList<String> linky=new LinkedList<String>();

    public void BslStartup()
    {
        Scanner bslScanner = null;

        Path currentRelativePath = Paths.get("");
        String bslPath = currentRelativePath.toAbsolutePath().toString();
       // System.out.println("Current absolute path is: " + bslPath);

        try {
            bslScanner = new Scanner(new File(bslPath+"\\src\\home\\allWords.txt"));

        }catch(Exception e)
        {
            System.out.println("Could not find file");
        }
        String inputToStore;

        while(bslScanner.hasNext())
        {
            inputToStore =bslScanner.next();
           // System.out.println(inputToStore);
            linky.add(inputToStore);
        }
    }


    //================================================================

    @FXML
    private VBox pnItems = null;

    @FXML
    private BorderPane Mainpane;
    
    @FXML
    private Button btnHomepage;

    @FXML
    private Button btnPageSpell; //change

    @FXML
    private Button btnPageBsl;  //change

    @FXML
    private Button btnMembers;
    
    @FXML
    private Button btnSignout;

    @FXML
    private Button btnSubmitSpell; //search button page translate spell

    @FXML
    private Button btnSubmitBsl; //search button page translate BSL
    
    @FXML
    private TextField textSpell; //tmpt type word page translate spell

    @FXML
    private TextField textBsl; //tmpt type word page translate Bsl

    String textInput;

    public void handleClicks(ActionEvent actionEvent) {
        
        if (actionEvent.getSource() == btnHomepage) {
            loadUI("ui1"); //page homepage
        }
        if(actionEvent.getSource()==btnPageSpell)
        {
            loadUI("ui2"); //page spell
        }
        if (actionEvent.getSource() == btnPageBsl) {
            loadUI("ui4"); //page BSL
           // BslStartup();
        }
        if (actionEvent.getSource() == btnMembers) {
            loadUI("ui3"); //page ahli memeber
        }
        if (actionEvent.getSource() == btnSignout) {
            Stage primaryStage = (Stage) Mainpane.getScene().getWindow(); //exit software
            primaryStage.close();
        }
        if(actionEvent.getSource()==btnSubmitSpell) //button search pageSpell
             {
                 textInput = textSpell.getText(); //get the text from input page translate
                 System.out.println(textInput);

                 if(textInput.isEmpty())
                 {
                     return;
                 }else {

                     //MANIPULATION
                     String example = textInput; //example of string to video
                     String lowExample = example.toLowerCase();  //set to become lower case

                     char[] inputChar = new char[15]; //Data store for char to string

                     for (int i = 0; i < example.length(); i++)  //string to char
                     {
                         inputChar[i] = lowExample.charAt(i);
                     }
                     for (int y = example.length(); y < 15; y++) {
                         inputChar[y] = '9'; //9 is dummy
                     }
                     int[] exampleFileIntBaseName = new int[15];
                     for (int i = 0; i < 15; i++) {
                         exampleFileIntBaseName[i] = converter(inputChar[i]);
                         ;
                         //System.out.println(exampleFileIntBaseName[i]);
                     }

                     String cwd = Path.of("").toAbsolutePath().toString();
                     //System.out.println(cwd);

                     file1 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[0] + ".mp4");
                     media1 = new Media(file1.toURI().toString());

                     file2 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[1] + ".mp4");
                     media2 = new Media(file2.toURI().toString());

                     file3 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[2] + ".mp4");
                     media3 = new Media(file3.toURI().toString());

                     file4 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[3] + ".mp4");
                     media4 = new Media(file4.toURI().toString());

                     file5 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[4] + ".mp4");
                     media5 = new Media(file5.toURI().toString());

                     file6 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[5] + ".mp4");
                     media6 = new Media(file6.toURI().toString());

                     file7 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[6] + ".mp4");
                     media7 = new Media(file7.toURI().toString());

                     file8 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[7] + ".mp4");
                     media8 = new Media(file8.toURI().toString());

                     file9 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[8] + ".mp4");
                     media9 = new Media(file9.toURI().toString());

                     file10 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[9] + ".mp4");
                     media10 = new Media(file10.toURI().toString());

                     file11 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[10] + ".mp4");
                     media11 = new Media(file11.toURI().toString());

                     file12 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[11] + ".mp4");
                     media12 = new Media(file12.toURI().toString());

                     file13 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[12] + ".mp4");
                     media13 = new Media(file13.toURI().toString());

                     file14 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[13] + ".mp4");
                     media14 = new Media(file14.toURI().toString());

                     file15 = new File(cwd + "/src/videos/" + exampleFileIntBaseName[14] + ".mp4");
                     media15 = new Media(file15.toURI().toString());


                     //STARTING TO STORING THE FILE

                     media = Arrays.asList(media1, media2, media3, media4, media5, media6, media7, media8, media9, media10
                             , media11, media12, media13, media14, media15);

                     mediaPlayer = new MediaPlayer(media1);
                     mediaView.setMediaPlayer(mediaPlayer);


                     playNextVideo();

                 }

            }
        if(actionEvent.getSource()==btnSubmitBsl) //button search pageBSL
        {
            String textInputBsl = textBsl.getText(); //get the text from input pageBSL
            //System.out.println(textInputBsl + "This is pure text");
            String[] inputBsl=new String[5];
            if(textInputBsl.isEmpty())
            {
                return;
            }else {


                Pattern pattern = Pattern.compile("\\w+");
                Matcher matcher = pattern.matcher(textInputBsl);
                int i=0;
                while (matcher.find()) {
                    if(i==5)
                    {
                        break;
                    }
                    else{
                        System.out.println(matcher.group());
                    inputBsl[i]=matcher.group();
                    i++;}
                }

                for(int yBsl=i;yBsl<5;yBsl++)
                {
                    inputBsl[yBsl]="noWordFound";
                }

                for(int iBsl=0;i<5;i++)
                {
                    if(inputBsl[iBsl]==null)
                    {
                        inputBsl[iBsl]="noWordFound";
                    }
                }
                    System.out.println("===================");

                //BSL Search Algorithm
            /*    for (int xyz=0;xyz<5;xyz++)
                {
                    System.out.println(inputBsl[xyz]);
                    for(int through=0;through<=linky.size();through++)
                    {
                        String dummy=null;
                        dummy=linky.get(through);

                        if(inputBsl[xyz]==dummy)
                        {
                            System.out.println(inputBsl[xyz]+" is Found");
                            break;
                        }
                        else{
                            inputBsl[xyz]="noWordFound";
                        }
                    }
                }*/


                String cwd = Path.of("").toAbsolutePath().toString();
                //System.out.println(cwd);
                fileBsl1 = new File(cwd + "/src/videos/Reserved BSL/" + inputBsl[0] + ".mp4");
                mediaBsl1 = new Media(fileBsl1.toURI().toString());

                fileBsl2 = new File(cwd + "/src/videos/Reserved BSL/" + inputBsl[1] + ".mp4");
                mediaBsl2 = new Media(fileBsl2.toURI().toString());

                fileBsl3 = new File(cwd + "/src/videos/Reserved BSL/" + inputBsl[2] + ".mp4");
                mediaBsl3 = new Media(fileBsl3.toURI().toString());

                fileBsl4 = new File(cwd + "/src/videos/Reserved BSL/" + inputBsl[3] + ".mp4");
                mediaBsl4 = new Media(fileBsl4.toURI().toString());

                fileBsl5 = new File(cwd + "/src/videos/Reserved BSL/" + inputBsl[4] + ".mp4");
                mediaBsl5 = new Media(fileBsl5.toURI().toString());

                fileBslEnd = new File(cwd + "/src/videos/Reserved BSL/END.mp4");
                mediaBslEnd = new Media(fileBslEnd.toURI().toString());

                mediaBsl = Arrays.asList(mediaBsl1, mediaBsl2, mediaBsl3, mediaBsl4,
                        mediaBsl5,mediaBslEnd);

                mediaPlayerBsl = new MediaPlayer(mediaBsl1);
                mediaViewBsl.setMediaPlayer(mediaPlayerBsl);
                playNextVideoBsl();

            }

        }

    }
    private void loadUI(String ui){ //load multiple fxml
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Mainpane.setCenter(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
