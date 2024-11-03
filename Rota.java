import java.util.ArrayList;
import java.util.List;

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
        List<Object> response = VerificarDistancia(carro, 0, new ArrayList<Eletroposto>());
        if ((Boolean) response.get(0)) {
            this.PercorrerViagem(carro, (List<Eletroposto>) response.get(1));
            sistema.registrarViagem(
                    new Viagem(id, carro, this, motorista, this.getDistancia(), (List<Eletroposto>) response.get(1)));
        } else {
            System.out.println(
                    "ERRO! A viagem não foi realizada devido a falta de autonomia no carro e não possibilidade de recarga.");
        }
    }

    private void PercorrerViagem(Carro carro, List<Eletroposto> paradas) {
        double distanciaPercorrida = 0;
        if (paradas.size() > 0) {
            for (int index = 0; index < paradas.size(); index++) {
                Eletroposto eletroposto = paradas.get(index);
                System.out.println("Chegando a um eletroposto.. Verificando vagas..");
                carro.Andar(eletroposto.getKm() - distanciaPercorrida );
                distanciaPercorrida = eletroposto.getKm();
                if (eletroposto.getVagas_disponiveis() > 0) {
                    System.out.println("Vagas disponível! Recarregando...");
                    eletroposto.carregarCarro(carro);
                } else {
                    System.out.println("Sem vagas disponíveis! Recalculando rota...");
                    if (((this.distancia - eletroposto.getKm()) - paradas.get(index).getKm()) <= carro.getAutonomia()) {
                        System.out.println("O carro consegue chegar até o próximo destino, continuando!");
                    } else {
                        System.out.println(
                                "O carro não consegue chegar ao próximo destino! Aguardando vaga no eletroposto atual...");
                        System.out.println("Vaga liberada! Recarregando...");
                        eletroposto.carregarCarro(carro);
                    }
                }

                if (index == paradas.size() - 1) {
                    System.out.println("Último reabastecimento realizado, indo ao destino final!");
                    carro.Andar(this.distancia - distanciaPercorrida);
                }
            }
        }else {
            carro.Andar(this.distancia);
        }
        System.out.println("Viagem finalizada! Distância total: " + this.distancia + "km\nAutonomia final do carro: " + carro.getAutonomia() + "km");
    }

    public List<Object> VerificarDistancia(Carro carro, double km, List<Eletroposto> paradas) {
        List<Object> lista = new ArrayList<>();
        double autonomiaAtual = carro.getAutonomia();
        double distanciaPercorrida = km;
    
        if (eletropostos.isEmpty()) {
            if (autonomiaAtual >= this.distancia) {
                lista.add(true);
                lista.add(paradas);
                return lista;
            } else {
                lista.add(false);
                return lista;
            }
        }
    
        boolean destinoAtingivel = false;
    
        for (Eletroposto eletroposto : eletropostos) {
            if (eletroposto.getKm() > distanciaPercorrida
                    && (eletroposto.getKm() - distanciaPercorrida) <= autonomiaAtual) {
                paradas.add(eletroposto);
                distanciaPercorrida = eletroposto.getKm();
                autonomiaAtual = carro.getBateriaMax();
            }
        }
    
        if ((this.distancia - distanciaPercorrida) <= autonomiaAtual) {
            destinoAtingivel = true;
        }
    
        if (destinoAtingivel) {
            lista.add(true);
            lista.add(paradas);
        } else {
            lista.add(false);
        }
    
        return lista;
    }

    public void addEletroposto(Eletroposto eletroposto) {
        eletropostos.add(eletroposto);
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
