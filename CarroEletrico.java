import java.util.ArrayList;
import java.util.List;

public class CarroEletrico {
    protected int id; // ID
    protected String marca; // Marca do carro
    protected String modelo; // Modelo do carro
    protected int ano_fabricacao; // Ano de fabricação do carro
    protected double autonomia; // Autonomia atual do carro (em km)
    protected int tempo_recarga; // Tempo de recarga do carro
    protected double bateria_max; // Capacidade total da bateria
    protected double bateria; // Capacidade atual da bateria
    protected List<Recarga> recargas; // Registro de recargas do carro
    protected double quilometragem = 0.0; // Registro da quilometragem do carro

    public CarroEletrico(int id, String marca, String modelo, int ano_fabricacao, double autonomia, int tempo_recarga) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano_fabricacao = ano_fabricacao;
        this.autonomia = autonomia;
        this.tempo_recarga = tempo_recarga;
        this.bateria_max = autonomia;
        this.bateria = autonomia;
        this.recargas = new ArrayList<Recarga>();
    }

    public void listarRecargas() {
        for (Recarga recarga : recargas) {
            System.out.println("Recarga: Data - " + recarga.getData() + " ID do Eletroposto: "
                    + recarga.getEletropostoId() + " Quantia recarregada: " + recarga.getQuantia_carregada() + "kWh");
        }
    }

    public void addRecarga(Recarga recarga) {
        recargas.add(recarga);
    }

    public List<Recarga> getRecargas() {
        return recargas;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    private void addQuilometragem(Double quilometragem) {
        this.quilometragem += quilometragem;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno_fabricacao() {
        return ano_fabricacao;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public int getTempo_recarga() {
        return tempo_recarga;
    }

    public Double getBateria() {
        return bateria;
    }

    public void Andar(Double km) {
        bateria -= km;
        autonomia -= km;
        addQuilometragem(km);
    }

    public void addBateria(Double carga) {
        if ((bateria + carga) <= bateria_max) {
            bateria += carga;
            autonomia = bateria;
        } else {
            System.out.println("Esta carga excede a batería máxima! A carga foi limitada.");
            bateria = bateria_max;
            autonomia = bateria;
        }
    }

    public void setBateria(Double quantia) {
        bateria = quantia;
        autonomia = quantia;
    }

    public Double getBateriaMax() {
        return bateria_max;
    }
}
