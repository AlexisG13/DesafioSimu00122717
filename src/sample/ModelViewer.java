package sample;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class ModelViewer {

    static MeshView loadMeshViews() {
        URL url = ModelViewer.class.getResource("/sample/img/tetra.stl");
        StlMeshImporter importer = new StlMeshImporter();
        importer.read(url.toString());
        Mesh mesh = importer.getImport();
        return new MeshView(mesh);
    }

    public static void display(){
        Stage primaryStage = new Stage();
        MeshView mesh = loadMeshViews();
        double max = Math.max(mesh.getBoundsInLocal().getWidth(),
                Math.max(mesh.getBoundsInLocal().getHeight(),
                        mesh.getBoundsInLocal().getDepth()));
        PhongMaterial phongMaterial = new PhongMaterial(Color.ROYALBLUE);
        phongMaterial.setDiffuseColor(Color.BLUEVIOLET);
        mesh.setMaterial(phongMaterial);
        SmartObject root = new SmartObject();
        root.getChildren().add(mesh);
        Transform transform = new Rotate(65,new Point3D(1,1,0));
        root.getTransforms().add(transform);
        Image background = new Image(ModelViewer.class.getResourceAsStream("/sample/img/background.jpg"));
        ImagePattern pattern = new ImagePattern(background);
        Scene scene = new Scene(root, 600, 400, true, SceneAntialiasing.BALANCED);
        scene.setFill(pattern);
        Camera camera = new PerspectiveCamera();
        camera.setTranslateZ(-3*max);
        scene.setCamera(camera);
        primaryStage.setTitle("Utiliza las teclas Q-W-E-A-S-D para moverte!");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event ->{
            switch(event.getCode()){
                case S:
                    root.rotateByX(10);
                    break;
                case W:
                    root.rotateByX(-10);
                    break;
                case E:
                    root.rotateByY(10);
                    break;
                case Q:
                    root.rotateByY(-10);
                    break;
                case A:
                    root.rotateByZ(10);
                    break;
                case D:
                    root.rotateByZ(-10);
                    break;
            }
        });
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.showAndWait();
    }

    static class SmartObject extends Group {
        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int ang){
            r = new Rotate(ang,Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByY(int ang){
            r = new Rotate(ang,Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByZ(int ang){
            r = new Rotate(ang,Rotate.Z_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
    }
}
