import java.util.ArrayList;
import java.util.List;

class Triangulo {
    private float a;
    private float b;
    private float c;
    
    public Triangulo(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public float perimetro() {
        return a + b + c;
    }

    public float area() {
        float s = (a + b + c) / 2;
        return (float) Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }
}


public class GestorMostrarDatosTriangulo {
    public static void main(String[] args) {
        Triangulo t1 = new Triangulo(15, 30, 25);
        Triangulo t2 = new Triangulo(30, 40, 50);

        List<Triangulo> listaDeTriangulos = new ArrayList<>();

        listaDeTriangulos.add(t1);
        listaDeTriangulos.add(t2);
        
        

        listaDeTriangulos.forEach(triangulo -> {
            System.out.println(triangulo);
            System.out.println("Perimetro: " + triangulo.perimetro());
            System.out.println("Area: " + triangulo.area());
        });
    }
}



