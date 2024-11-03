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

    public void realizarViagem(int RotaId, int CarroId, int MotoristaId){
        rotas.get(RotaId).Viajar(carros.get(CarroId), motoristas.get(MotoristaId), this);
        System.out.println("Viagem realizada!");
    }

    public void registrarViagem(Viagem viagem){
        viagens.add(viagem);
    }

    public void listarViagens(){
        for (Viagem viagem: viagens){
            System.out.println("Viagem: " + viagem.getId() + " Motorista: " + viagem.getMotorista() + " Distância percorrida: " + viagem.getQuilometragem() + " Veículo utilizado: " + viagem.getCarro().getId() + "Abastecimentos: " + viagem.getAbastecimentos());
        }
    }

    public void listarVeiculosAutonomiaBaixa(){
        System.out.println("Carros com autonomia inferior a 20%:");
        for (Carro carro : carros){
            if (carro.getAutonomia() > (carro.getBateria_max() * 0.20)){
                System.out.println("Carro ID: " + carro.getId());
            }
        }
    }

    public void ListarViagensMotorista(Motorista motorista){
        for (Viagem viagem: viagens){
            if (viagem.getId() == motorista.getId()){
                System.out.println("Viagem: " + viagem.getId() + " Motorista: " + viagem.getMotorista() + " Distância percorrida: " + viagem.getQuilometragem() + " Veículo utilizado: " + viagem.getCarro().getId() + "Abastecimentos: " + viagem.getAbastecimentos());
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

    public void listarCarros(){
        for (Carro carro: carros){
            System.err.println("Carro: " + carro.getId());
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

    public void listarMotoristas(){
        for (Motorista motorista: motoristas){
            System.out.println("Motorista: " + motorista.getNome());
        }
    }
}
