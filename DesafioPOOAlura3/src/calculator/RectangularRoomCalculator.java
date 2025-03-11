package calculator;

/*
* Crie uma classe CalculadoraSalaRetangular que implementa uma interface CalculoGeometrico
* com os métodos calcularArea() e calcularPerimetro() para calcular a área e o perímetro de
* uma sala retangular. A classe deve receber altura e largura como parâmetros.
* */

public class RectangularRoomCalculator implements GeometricCalculate{
    int height, width, area, perimeter;

    public RectangularRoomCalculator(int height, int width){
        this.height = height;
        this.width = width;
    }

    @Override
    public int calculateArea() {
        area = height * width;
        return area;
    }

    @Override
    public int calculatePerimeter() {
        perimeter = height*2 + width*2;
        return perimeter;
    }
}
