import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rota {
    private int id;
    private String destino;
    private List<Eletroposto> eletropostos;
    private double distancia;

    public Rota(int id, String destino, double distancia) {
        this.id = id;
        this.destino = destino;
        this.distancia = distancia;
        this.eletropostos = new ArrayList<Eletroposto>();
    }

    @SuppressWarnings("unchecked")
    public void Viajar(Carro carro, Motorista motorista, Sistema sistema) {
        List<Object> response = VerificarDistancia(carro, this.distancia, new ArrayList<Eletroposto>());
        if ((Boolean) response.get(0)) {
            this.PercorrerViagem(carro, (List<Eletroposto>) response.get(2) );
            sistema.registrarViagem(new Viagem(id, carro, this, motorista, this.getDistancia(), (List<Eletroposto>) response.get(2)));
        } else{
            System.out.println("ERRO! A viagem não foi realizada devido a falta de autonomia no carro e não possibilidade de recarga.");
        }
    }

    public void PercorrerViagem(Carro carro, List<Eletroposto> paradas){
        for (int index = 0; index >= paradas.size(); index++){
            Eletroposto eletroposto = paradas.get(index);
            System.out.println("Chegando a um eletroposto.. Verificando vagas..");

            if (eletroposto.getVagas_disponiveis() < eletroposto.getVagas()){
                System.out.println("Vagas disponível! Recarregando...");
                eletroposto.carregarCarro(carro);
            } else {
                System.out.println("Sem vagas disponíveis! Recalculando rota...");
                if (((this.distancia - eletroposto.getKm()) - paradas.get(index).getKm()) <= carro.getAutonomia()){
                    System.out.println("O carro consegue chegar até o próximo destino, continuando!");
                } else {
                    System.out.println("O carro não consegue chegar ao próximo destino! Aguardando vaga no eletroposto atual...");
                    System.out.println("Vaga liberada! Recarregando...");
                    eletroposto.carregarCarro(carro);
                }
            }

            if (index == paradas.size()){
                System.out.println("Último reabastecimento realizado, indo ao destino final!");
                carro.setBateria(this.distancia - eletroposto.getKm());
                carro.addQuilometragem(this.distancia);
            }
        }
        System.out.println("Viagem finalizada! Distância total: " + this.distancia);
    }

    public List<Object> VerificarDistancia(Carro carro, double km, List<Eletroposto> paradas) {
        List<Object> lista = new ArrayList<>();

        if (carro.getAutonomia() >= km) {
            lista.add(true);
            lista.add(carro.getAutonomia() - km);
            lista.add(paradas);
            return lista;
        } else {
            for (Eletroposto eletroposto : eletropostos) {
                if (eletroposto.getKm() > km) {
                    if ((eletroposto.getKm() - km) <= carro.getAutonomia()) {
                        paradas.add(eletroposto);
                        if ((this.distancia - km) <= carro.getBateria_max()) {
                            lista.add(true);
                            lista.add(carro.getAutonomia() - km);
                            lista.add(paradas);
                            return lista;
                        } else {
                            return VerificarDistancia(carro, km, paradas);
                        }
                    }
                }
            }
            lista.add(false);
            return lista;
        }
    }

    public void addEletroposto() {
        Scanner scanner = new Scanner(System.in);

        int id = this.eletropostos.size() + 1;

        System.out.println("Digite a quantia de vagas para recarga: ");
        int vagas = scanner.nextInt();

        System.out.println("Digite qual o tempo médio de carregamento (em horas): ");
        double tempo_carregamento = scanner.nextDouble();

        System.out.println("Digite em qual KM da rota está o eletroposto: ");
        int km = scanner.nextInt();

        eletropostos.add(new Eletroposto(id, vagas, tempo_carregamento, km));
        scanner.close();
    }

    public int getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public List<Eletroposto> getEletropostos() {
        return eletropostos;
    }

    public double getDistancia() {
        return distancia;
    }
}
