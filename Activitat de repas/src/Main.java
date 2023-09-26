import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Factura f = new Factura("ordenador", 1000);
        Factura f2 = new Factura("mobil", 450);
        Factura f3 = new Factura("impressora", 200);
        Factura f4 = new Factura("imac", 1499.99);

        List<Factura> lista = new ArrayList<Factura>();

        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        // Definir filtro factura
        Factura facturaFiltro = new Factura("filtro", 500);

        // Filtrar les factures
        List<Factura> facturasFiltradas = filtrarFacturas(lista, facturaFiltro);

        // Imprimir el resultado
        for (Factura factura : facturasFiltradas) {
            System.out.println("Producto: " + factura.getProducto() + ", Valor: " + factura.getValor());
        }
    }

    public static List<Factura> filtrarFacturas(List<Factura> facturas, Factura facturaFiltro) {
        List<Factura> facturasFiltradas = new ArrayList<>();

        for (Factura factura : facturas) {
            if (factura.getValor() < facturaFiltro.getValor()) {
                facturasFiltradas.add(factura);
            }
        }

        return facturasFiltradas;
    }
}
