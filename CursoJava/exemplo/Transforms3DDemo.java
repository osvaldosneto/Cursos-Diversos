/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhaappjavafx;

/**
 *
 * @author User
 */

// Use a perspective camera in a 3D scene. 
import javafx.application.*;  
import javafx.scene.*;  
import javafx.stage.*;  
import javafx.scene.layout.*;  
import javafx.scene.control.*;  
import javafx.event.*;  
import javafx.geometry.*;  
import javafx.scene.transform.*; 
import javafx.scene.paint.*; 
import javafx.scene.shape.*; 
  
public class Transforms3DDemo extends Application {  
 
  Rotate hRot; 
  Rotate vRot; 
  Translate zTrans; 
  Shear shear; 
  Scale scale; 
 
  double angleH = 0; 
  double angleV = 0; 
  double zPos = -60; 
  double shearVal = 0; 
  double scaleVal = 1; 
 
  boolean trans = true; 
  
  Button btnRotateH;  
  Button btnRotateV;  
  Button btnZoomOut; 
  Button btnZoomIn; 
  Button btnScale; 
  Button btnShear; 
 
  Box box; 
  Cylinder cylinder; 
 
  PerspectiveCamera pCamera; 
 
  public static void main(String[] args) {  
  
    // Start the JavaFX application by calling launch().  
    launch(args);    
  }  
  
  // Override the start() method.  
  public void start(Stage myStage) {  
  
    // Give the stage a title.  
    myStage.setTitle("3-D Transforms Demo");  
  
    // Use a FlowPane for the root node. In this case,  
    // vertical and horizontal gaps of 10 are used. 
    FlowPane rootNode = new FlowPane(10, 10);  
  
    // Center nodes in the scene.  
    rootNode.setAlignment(Pos.CENTER);  
  
    // Create a scene.  
    Scene myScene = new Scene(rootNode, 380, 440);  
 
    // Set the scene on the stage.  
    myStage.setScene(myScene);  
 
    // Create push buttons for transforms. 
    btnRotateH = new Button("Horizontal Rotate");  
    btnRotateV = new Button("Vertical Rotate");  
    btnZoomOut = new Button("Zoom Out");  
    btnZoomIn = new Button("Zoom In");  
    btnScale = new Button("Scale"); 
    btnShear = new Button("Shear"); 
 
    // Create Rotate transforms. 
    hRot = new Rotate(0, Rotate.Y_AXIS); 
    vRot = new Rotate(0, Rotate.X_AXIS); 
 
    // Create Z translation. 
    zTrans = new Translate(0, 0, zPos); 
 
    // Create shear. 
    shear = new Shear(shearVal, shearVal); 
 
    // Create scale. 
    scale = new Scale(scaleVal, 1, 1);     
 
    // Create the camera. 
    pCamera = new PerspectiveCamera(true); 
 
    // Add transforms to the camera. 
    pCamera.getTransforms().addAll(hRot, vRot, zTrans, shear, scale); 
 
    // Set the camera's field of view and far clip. 
    pCamera.setFieldOfView(45); 
    pCamera.setFarClip(120); 
 
    // Create a 3-D box and cylinder. 
    box = new Box(10, 20, 30); 
    box.setMaterial(new PhongMaterial(Color.LIGHTSTEELBLUE));  
 
    cylinder = new Cylinder(5, 20); 
    cylinder.setMaterial(new PhongMaterial(Color.GREEN)); 
 
    // Rotate the cylinder 90 degrees so that it is horizontal. 
    // Translate the cylinder 10 units down so that it is half 
    // out of the box. 
    // Note: These transforms apply to the cylinder, itself, 
    // and not the camera. 
    cylinder.getTransforms().add(new Rotate(90,0,0)); 
    cylinder.getTransforms().add(new Translate(10, 0, 0)); 
 
    // Create a group that will hold the box and cylinder. 
    Group shapesGroup = new Group(); 
    shapesGroup.getChildren().addAll(box, cylinder); 
 
    // Create subscene to manage the group. Notice that a 
    // depth buffer is enabled. 
    SubScene shapesSub = new SubScene(shapesGroup, 340, 340, true, 
                                      SceneAntialiasing.DISABLED); 
    shapesSub.setFill(Color.AZURE); 
 
    // Set the camera on the subscene. 
    shapesSub.setCamera(pCamera); 
 
    // Handle rotation buttons by changing camera's angle. 
    btnRotateH.setOnAction(new EventHandler<ActionEvent>() {  
      public void handle(ActionEvent ae) {  
        angleH +=15; 
        hRot.setAngle(angleH); 
        if(angleH == 360) angleH = 0; 
      }  
    });  
 
    btnRotateV.setOnAction(new EventHandler<ActionEvent>() {  
      public void handle(ActionEvent ae) {  
        angleV += 15; 
        vRot.setAngle(angleV); 
        if(angleV == 360) angleV = 0; 
      }  
    });  
 
    // Handle zoom in by incrementing the Z coordinate. 
    btnZoomIn.setOnAction(new EventHandler<ActionEvent>() {  
      public void handle(ActionEvent ae) {  
        if(zPos < -30) zPos++;; 
        zTrans.setZ(zPos); 
      }  
    });  
 
    // Handle zoom out by decrementing the Z coordinate. 
    btnZoomOut.setOnAction(new EventHandler<ActionEvent>() {  
      public void handle(ActionEvent ae) {  
        if(zPos > -100) zPos--; 
        zTrans.setZ(zPos); 
      }  
    });  
 
    // Shear the X axis. 
    btnShear.setOnAction(new EventHandler<ActionEvent>() {  
      public void handle(ActionEvent ae) {  
        shearVal += 0.1; 
        if(shearVal > 0.5) shearVal = 0; 
        shear.setX(shearVal); 
      }  
    });  
 
    // Scale the X axis, which makes things look narrower. 
    btnScale.setOnAction(new EventHandler<ActionEvent>() {  
      public void handle(ActionEvent ae) {  
        scaleVal += 0.1; 
        if(scaleVal > 1.5) scaleVal = 1; 
        scale.setX(scaleVal); 
      }  
    });  
 
    rootNode.getChildren().addAll(shapesSub, btnRotateH, btnRotateV, 
                                  btnZoomIn,btnZoomOut, btnScale, 
                                  btnShear);  
 
    // Show the stage and its scene.  
    myStage.show();  
  }  
}
