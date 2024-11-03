import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Carro> carros;
    private List<Motorista> motoristas;
    private List<Viagem> viagens;
    private List<Rota> rotas;

    public Sistema() {
        this.carros = new ArrayList<Carro>();
        this.motoristas = new ArrayList<Motorista>();
        this.viagens = new ArrayList<Viagem>();
        this.rotas = new ArrayList<Rota>();
    }

    public void addRota(Rota rota){
        rotas.add(rota);
    }

    public void realizarViagem(int rotaId, int carroId, int motoristaId) {
        Rota rota = buscarRotaPorId(rotaId);
        Carro carro = buscarCarroPorId(carroId);
        Motorista motorista = buscarMotoristaPorId(motoristaId);
    
        if (rota != null && carro != null && motorista != null) {
            rota.Viajar(carro, motorista, this);
        } else {
            System.out.println("Erro: Rota, Carro ou Motorista não encontrados com os IDs fornecidos.");
        }
    }

    public void registrarViagem(Viagem viagem){
        viagens.add(viagem);
    }

    public void listarViagens(){
        for (Viagem viagem: viagens){
            System.out.println("ID da viagem: " + viagem.getId() + " ID do motorista: " + viagem.getMotorista().getId() + " Distância percorrida: " + viagem.getQuilometragem() + "km ID do veículo utilizado: " + viagem.getCarro().getId() + " Paradas: " + viagem.getAbastecimentos());
        }
    }

    public void listarVeiculosAutonomiaBaixa(){
        System.out.println("Carros com autonomia inferior a 20%:");
        for (Carro carro : carros){
            if (carro.getAutonomia() <= (carro.getBateriaMax() * 0.20)){
                System.out.println("Carro ID: " + carro.getId());
            }
        }
    }

    public void ListarViagensMotorista(Motorista motorista){
        for (Viagem viagem: viagens){
            if (viagem.getId() == motorista.getId()){
                System.out.println("ID da viagem: " + viagem.getId() + " Distância percorrida: " + viagem.getQuilometragem() + " Veículo utilizado: " + viagem.getCarro().getId() + " Paradas: " + viagem.getAbastecimentos());
            }
        }
    }

    public void ListarCarrosManutencao(){
        for (Carro carro: carros){
            if (carro.getQuilometragem() > 10000){
                System.out.println(carro.getId());
            }
        }
    }

    public void addCarro (Carro carro){
        carros.add(carro);
        System.err.println("O carro " + carro.getId() + " foi cadastrado com sucesso.");
    }

    public void delCarro (Carro carro){
        carros.remove(carro);
        System.err.println("O carro " + carro.getId() + " foi removido com sucesso.");
    }

    public List<Carro> getCarros(){
        return carros;
    }

    public void listarCarros(){
        for (Carro carro: carros){
            System.err.println("Carro ID: " + carro.getId());
        }
    }

    public void addMotorista(Motorista motorista){
        motoristas.add(motorista);
        System.err.println("O motorista " + motorista.getId() + " foi cadastrado com sucesso.");
    }

    public void delMotorista(Motorista motorista){
        motoristas.remove(motorista);
        System.err.println("O motorista " + motorista.getId() + " foi removido com sucesso.");
    }

    public List<Motorista> getMotoristas(){
        return motoristas;
    }

    public void listarMotoristas(){
        for (Motorista motorista: motoristas){
            System.out.println("Motorista: " + motorista.getNome());
        }
    }

    private Rota buscarRotaPorId(int id) {
        for (Rota rota : rotas) {
            if (rota.getId() == id) {
                return rota;
            }
        }
        return null;
    }
    
    private Carro buscarCarroPorId(int id) {
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                return carro;
            }
        }
        return null;
    }
    
    private Motorista buscarMotoristaPorId(int id) {
        for (Motorista motorista : motoristas) {
            if (motorista.getId() == id) {
                return motorista;
            }
        }
        return null;
    }
}
