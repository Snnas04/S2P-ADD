//PART 2

package cat.cifp.spaad.review;

class Factura {
    private String producto;
    private double valor;

    public Factura(String producto, double valor) {
        this.producto = producto;
        this.valor = valor;
    }

    public String getProducto() {
        return producto;
    }

    public double getValor() {
        return valor;
    }
}
