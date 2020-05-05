/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;
    
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Grilles extends Application {
    private static int TILE_SIZE = 20;
    private static int W = 800;
    private static int H = 600;

    private static int N = 20;
    private static int M = 25;
    private static double Min = 10;
    private static double Max = 1000;
    private static double [][] Matrix = new double[N][M]; 
    private Scene scene;
    private Stage primaryStage;

    public Grilles() {
    }

    public static int getTILE_SIZE() {
        return TILE_SIZE;
    }

    public static void setTILE_SIZE(int TILE_SIZE) {
        Grilles.TILE_SIZE = TILE_SIZE;
    }

    public static int getW() {
        return W;
    }

    public static void setW(int W) {
        Grilles.W = W;
    }

    public static int getH() {
        return H;
    }

    public static void setH(int H) {
        Grilles.H = H;
    }

    public static int getN() {
        return N;
    }

    public static void setN(int N) {
        Grilles.N = N;
    }

    public static int getM() {
        return M;
    }

    public static void setM(int M) {
        Grilles.M = M;
    }

    public static double getMin() {
        return Min;
    }

    public static void setMin(double Min) {
        Grilles.Min = Min;
    }

    public static double getMax() {
        return Max;
    }

    public static void setMax(double Max) {
        Grilles.Max = Max;
    }

    public static double[][] getMatrix() {
        return Matrix;
    }

    public static void setMatrix(double[][] Matrix) {
        Grilles.Matrix = Matrix;
    }
    
    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(W, H);
       // this.Matrix = initMatrix(); si on decommente ce code on pourra initialiser la matrice donc du coup permettre d executer la matrice
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
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FileExpress");
        
        initRootLayout();
    }
    
            

       
        
     public void initRootLayout(){
            
            // Show the scene containing the root layout.
            scene = new Scene(createContent());
            primaryStage.setScene(scene);

            primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
