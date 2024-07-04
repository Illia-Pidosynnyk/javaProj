package com.java_example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application{


    private ObservableList<StandartLibraryInfo> infoList;
    private TableView<StandartLibraryInfo> table;

    private enum litTypeEnum
    {
        bookLiterature("Book"),
        magazineLiterature("Magazine");
        private final String type;

        private litTypeEnum(String type)
        {
            this.type = type;
        }

        @Override
        public String toString()
        {
            return type;
        }

        static litTypeEnum getType(String value)
        {
            for(litTypeEnum enumElem : litTypeEnum.values())
            {
                if(enumElem.toString().equals(value))
                {
                    return enumElem;
                } 
            }
            return null;
        }

    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Library Management System");

        // Create the book list
        infoList = FXCollections.observableArrayList();

        // Create the table
        createTable();

        // Create the form to add a new book
        TextField titleInput = new TextField();
        titleInput.setPromptText("Title");
        TextField authorInput = new TextField();
        authorInput.setPromptText("Author");
        TextField isbnInput = new TextField();
        isbnInput.setPromptText("ISBN");
        final ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll(
            litTypeEnum.bookLiterature.toString(),
            litTypeEnum.magazineLiterature.toString()
        );

        Button addButton = new Button("Add Item");
        addButton.setOnAction(e -> {
            String errorInfo = addLiterarure(titleInput.getText(), authorInput.getText(), isbnInput.getText(), litTypeEnum.getType(typeComboBox.getValue()));
            if(errorInfo.isBlank())
            {
                titleInput.clear();
                authorInput.clear();
                isbnInput.clear();
            }
            else
            {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Error with adding info");
                errorAlert.setContentText("Error caused by:\n" + errorInfo);
                errorAlert.showAndWait();
            }
        });

        // Create the form layout
        GridPane formLayout = new GridPane();
        formLayout.setPadding(new Insets(10));
        formLayout.setHgap(10);
        formLayout.setVgap(10);
        formLayout.add(new Label("Title:"), 0, 0);
        formLayout.add(titleInput, 1, 0);
        formLayout.add(new Label("Author:"), 0, 1);
        formLayout.add(authorInput, 1, 1);
        formLayout.add(new Label("ISBN:"), 0, 2);
        formLayout.add(isbnInput, 1, 2);
        formLayout.add(new Label("Type Of Literature:"), 0, 3);
        formLayout.add(typeComboBox, 1, 3);
        formLayout.add(addButton, 2, 0);

        // Create the main layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(table, formLayout);

        // Set the scene
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void startupGUI(String[] args)
    {
        launch(args);
    }

    private void createTable()
    {
        table = new TableView<>();
        table.setItems(infoList);

        // Create table columns
        TableColumn<StandartLibraryInfo, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());

        TableColumn<StandartLibraryInfo, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());

        TableColumn<StandartLibraryInfo, String> isbnColumn = new TableColumn<>("ISBN");
        isbnColumn.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());

        TableColumn<StandartLibraryInfo, String> typeColumn = new TableColumn<>("Type Of Literature");
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeOfLiteratureProperty());

        table.getColumns().addAll(titleColumn, authorColumn, isbnColumn, typeColumn);
    }

    private String addLiterarure(String title, String author, String isbn, litTypeEnum enumType)
    {
        String returnInfo = "";

        if(title.isBlank())
        {
            returnInfo += "Empty Title\n";
        }
        if(author.isBlank())
        {
            returnInfo += "Empty Author\n";
        }
        if(isbn.isBlank())
        {
            returnInfo += "Empty ISBN\n";
        }
        else if (!isIsbnUnique(isbn))
        {
            returnInfo += "ISBN isn't unique\n";
        }

        if(returnInfo.isBlank())
        {
            if(enumType!=null)
            {
                switch (enumType) {
                    case bookLiterature:
                        infoList.add(new Book(title, author, isbn));
                        break;
                    case magazineLiterature:
                        infoList.add(new Magazine(title, author, isbn));
                        break;
                    default:
                        returnInfo += "Unexpected Enum\n";
                }
            }
            else
            {
                returnInfo += "Unexpected Enum\n";
            }
            
        }
    
        return returnInfo;
    }


    private boolean isIsbnUnique(String isbn)
    {
        for(StandartLibraryInfo libElem : infoList)
        {
            if(libElem.getIsbn().equals(isbn))
            return false; 
        }
        return true;
    }
}
