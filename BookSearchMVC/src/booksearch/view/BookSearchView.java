package booksearch.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookSearchView extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = null;

		FXMLLoader loader = new FXMLLoader( // fxml 파일을 불러들임
				getClass().getResource("JavaFXBookSearchTableView.fxml")
				);

		try {
			root = loader.load();
		}
		catch (Exception e){
			System.out.println("Main에서 bookfx.fxml 로딩에서 문제가 생겼어용");
		}


		Scene scene = new Scene(root); //Scene을 만들고

		primaryStage.setScene(scene); //Stage에 Scene을 붙여서

		primaryStage.show(); // show해서 올린다.
	}


	public static void main(String[] args) {
		launch(args);
	}
}


