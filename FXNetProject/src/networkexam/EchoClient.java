package networkexam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EchoClient extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        // 화면 구성 역할
        // fxml 파일을 이용해서 Pane을 가져와서 Scene을 만들고 Stage에 붙여서 사용
        Parent root = null;
        
        FXMLLoader loader = new FXMLLoader( // fxml 파일을 불러들이는 것
                getClass().getResource("echoClient.fxml")
        );
        
        
        try {
            root = loader.load();
        }catch (Exception e){
            System.err.println(e);
        }
        
        
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
