package com.gradingsystem.controllers;

import com.gradingsystem.userinfo.User;
import com.gradingsystem.utils.UserDataProvider;
import com.gradingsystem.utils.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminViewController {
    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private AnchorPane sideAnchorePane;
    @FXML
    private Label userNameLabel;
    @FXML
    private ImageView settingsImageView;
    @FXML
    private Label emailLabel;
    @FXML
    private HBox gradeManagementHBox;
    @FXML
    private HBox gradeOverviewHBox;
    @FXML
    private HBox statisticsHBox;
    @FXML
    private HBox studentProfilesHBox;
    @FXML
    private HBox classManagementHBox;
    @FXML
    private HBox subjectManagementHBox;
    @FXML
    private HBox notificationsHBox;
    @FXML
    private HBox messagesHBox;
    @FXML
    private HBox settingsHBox;
    @FXML
    private HBox logoutHBox;
    private Parent root;
    private Stage loginStage;
    private Scene loginScene;
    private String name;
    private String surname;
    private String pesel;
    private String phoneNumber;
    private String email;

    public void initialize() {
        String[] userData = UserDataProvider.getUserData("admin", LoginController.userID);
        if(!userData[0].equals("GET_USER_DATA_FAILURE")) {
            name = userData[2];
            surname = userData[3];
            pesel = userData[4];
            email = userData[5];
            phoneNumber = userData[6];
            updateUserFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("USER DATA");
            alert.setContentText("Failed to fetch user data");
            alert.showAndWait();
        }
    }

    public void updateUserFields() {
        userNameLabel.setText(name + " " + surname);
        emailLabel.setText(email);
    }

    public void logout(MouseEvent event) throws IOException {
        ViewSwitcher.switchScene(event, root, loginStage, loginScene, "login-view", "login-style", this);
        LoginController.userID = -1;
    }

    public void gradeManagementClick() {
        System.out.println(LoginController.userID);
    }

    public void gradeOverviewClick() {
    }

    public void statisticsClick() {
    }

    public void studentProfilesClick(MouseEvent event) throws IOException {
        ViewSwitcher.switchScene(event, root, loginStage, loginScene, "student-profiles-view", User.getCssFileName(), this);
    }

    public void classManagementClick(MouseEvent event) throws IOException {
        ViewSwitcher.switchScene(event, root, loginStage, loginScene, "class-management-view", User.getCssFileName(), this);
    }

    public void subjectManagementClick(MouseEvent event) throws IOException {
        ViewSwitcher.switchScene(event, root, loginStage, loginScene, "subject-management-view", User.getCssFileName(), this);
    }

    public void notificationsClick() {
    }

    public void messagesClick() {
    }

    public void settingsClick(MouseEvent event) throws IOException {
        ViewSwitcher.switchScene(event, root, loginStage, loginScene, "myaccount-view", User.getCssFileName(), this);
    }
}