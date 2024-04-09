package com.assgn3.polynomial.controllers;

import com.assgn3.polynomial.res.ApplicationHandler;
import com.assgn3.polynomial.res.SCENE_IDENTIFIER;
//import com.assgn.pt_2024_30425_bartha_tudor_assignment.utils.enums.SCENE_IDENTIFIER;

public class SceneController {
    public void changeScene(SCENE_IDENTIFIER newScene){
        ApplicationHandler.getInstance().changeScene(newScene);
    }

    public void closeApplication(){
        ApplicationHandler.getInstance().closeApplication();
    }
}
