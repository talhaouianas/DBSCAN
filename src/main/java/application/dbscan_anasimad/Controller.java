package application.dbscan_anasimad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {



    @FXML
    TextField epsilon_text;
    @FXML
    TextField minpoints_text;
    @FXML
    TextField csv_link_text;
    @FXML
    ChoiceBox<String> distance_function_box;
     String[] functions = {"levenshtein","quantitative_euclidean","qualitative_euclidean"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        distance_function_box.getItems().addAll(functions);
    }


    @FXML
    TextArea area0;
    @FXML
    TextArea area1;
    @FXML
    TextArea area2;
    @FXML
    TextArea area3;


    public void run(ActionEvent event) throws Exception {
        double epsilon = Double.parseDouble(epsilon_text.getText());
        double minpoints = Double.parseDouble(minpoints_text.getText());
        String csv_link = csv_link_text.getText();
        String function = distance_function_box.getValue();


                String []Tabs = display.afficher(csv_link,function,epsilon,minpoints);
        area0.setText(Tabs[0]);
        area1.setText(Tabs[1]);
        area2.setText(Tabs[2]);
        area3.setText(Tabs[3]);


    }


}
