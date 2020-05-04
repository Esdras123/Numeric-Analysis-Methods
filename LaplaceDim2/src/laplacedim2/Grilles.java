/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;
    
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Grilles extends Application {
    private static final int TILE_SIZE = 20;
    private static final int W = 800;
    private static final int H = 600;

    private static final int N = 20;
    private static final int M = 25;
    private static final double Min = 10;
    private static final double Max = 1000;
    private static double [][] Matrix = new double[N][M]; 
    private Scene scene;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(W, H);
        this.Matrix = initMatrix();
        for (int y = 0; y < M-1; y++) {
            for (int x = 0; x < N-1; x++) {
                Tile tile = new Tile(x, y);
                root.getChildren().add(tile);
            }
        }
        return root;
    }
    
    private double[][] initMatrix(){
        double [][]matrix = new double[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                matrix[i][j]=(double)(Math.random() * (Max+1-Min)) + Min;
              //System.out.println(matrix[i][j] +" ");
            }
        }       
        return matrix ;
    }
    
    private class Tile extends StackPane {
        private int x, y;
        private double moy = 0;
        private int valCol = 0;

        private Rectangle border = new Rectangle(TILE_SIZE - 1, TILE_SIZE - 1);

        public Tile(int x, int y) {
            this.x = x;
            this.y = y;
            setMoy(x,y);
            setValCol(this.moy,Min,Max);
            System.out.println(moy+" ");
            System.out.println(valCol+" ");
            if(0<valCol && 256>valCol){
                
                border.setFill(Color.rgb(valCol,valCol,valCol));
            }
            
            border.setStroke(Color.LIGHTGRAY);

            getChildren().addAll(border);

            setTranslateX(x * TILE_SIZE);
            setTranslateY(y * TILE_SIZE);
        }
        public void setMoy(int x, int y){
            this.moy= (Matrix[x][y]+Matrix[x+1][y]+Matrix[x][y+1]+Matrix[x+1][y+1])/4;
        }
        public double getMoy(){
            return this.moy;
        }
        public void setValCol(double moy, double min, double max){ // cette fonction va initialier la valeur de valCol avec une valeur entre 0 et 255 
            this.valCol = (int)(((moy-min)*255)/(max-min));               // de facon proportionnelle a la moy des 4 sommets entre       
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(createContent());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
