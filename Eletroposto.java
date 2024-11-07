import java.time.LocalDateTime;

public class Eletroposto {
    private int id;
    private int vagas_disponiveis;
    private int vagas;
    private int km;
    private Double tempo_carregamento;

    public Eletroposto(int id, int vagas, Double tempo_carregamento, int km) {
        this.id = id;
        this.vagas = vagas;
        this.vagas_disponiveis = vagas;
        this.tempo_carregamento = tempo_carregamento;
        this.km = km;
    }

    public void carregarCarro(CarroEletrico carro){
        if (vagas_disponiveis > 0){
            this.addCarro();

            Double recarregar = carro.getBateriaMax() - carro.getBateria();
            carro.addBateria(recarregar);

            LocalDateTime data = LocalDateTime.now();

            carro.addRecarga( new Recarga(data, this.getId(), recarregar));
            System.out.println("Carro recarregado! \n");
            this.removeCarro();
        } else {
            System.out.println("Não há vagas para carregar!");
        }
    }

    public int getId() {
        return id;
    }

    public int getKm(){
        return km;
    }

    public int getVagas_disponiveis() {
        return vagas_disponiveis;
    }

    public void setVagas_disponiveis(int vagas_disponiveis) {
        this.vagas_disponiveis = vagas_disponiveis;
    }

    public void addCarro(){
        if (this.vagas_disponiveis > this.vagas){
            this.vagas_disponiveis = 1;
        }
    }

    public void removeCarro(){
        this.vagas_disponiveis += 1;
    }

    public Double getTempo_carregamento() {
        return tempo_carregamento;
    }

    public int getVagas() {
        return vagas;
    } 
}
