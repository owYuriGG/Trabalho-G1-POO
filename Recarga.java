import java.time.LocalDateTime;

public class Recarga {
    private LocalDateTime data; // Data da recarga
    private int eletroposto; // ID do eletroposto utilizado
    private Double quantia_carregada; // Quantia recarregada (em kWh)
    
    public Recarga(LocalDateTime data, int eletroposto, Double quantia_carregada) {
        this.data = data;
        this.eletroposto = eletroposto;
        this.quantia_carregada = quantia_carregada;
    }

    public LocalDateTime getData() {
        return data;
    }

    public int getEletropostoId() {
        return eletroposto;
    }

    public Double getQuantia_carregada() {
        return quantia_carregada;
    }
}
