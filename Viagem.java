import java.util.List;

public class Viagem {
    private int id;
    private CarroEletrico carro;
    private Rota rota;
    private Motorista motorista;
    private Double quilometragem;
    private List<Eletroposto> abastecimentos;
    
    public Viagem(int id, CarroEletrico carro, Rota rota, Motorista motorista, Double quilometragem, List<Eletroposto> abastecimentos) {
        this.id = id;
        this.carro = carro;
        this.rota = rota;
        this.motorista = motorista;
        this.quilometragem = quilometragem;
        this.abastecimentos = abastecimentos;
    }

    public List<Eletroposto> getAbastecimentos(){
        return abastecimentos;
    }

    public int getId() {
        return id;
    }

    public CarroEletrico getCarro() {
        return carro;
    }

    public Rota getRota() {
        return rota;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }
}
