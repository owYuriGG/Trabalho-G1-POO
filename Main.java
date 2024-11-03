public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        sistema.addCarro(new Sedan(1, "Tesla", "Model S", 2024));
        sistema.addCarro(new SUV(2, "Ford", "Explorer", 2021));
        sistema.addCarro(new Compacto(3, "Honda", "Civic", 2019));

        sistema.addMotorista(new Motorista(1, "João Silva", 123, 2));

        Rota rota = new Rota(1, "Santa Maria", 350);
        rota.addEletroposto(new Eletroposto(1, 4, 1.0, 100)); // Eletroposto a 100 km
        rota.addEletroposto(new Eletroposto(2, 2, 2.0, 200)); // Eletroposto a 200 km

        sistema.addRota(rota);

        System.out.println("Iniciando testes de viagem para diferentes carros...");

        System.out.println("\nViagem com Sedan (Tesla Model S):");
        sistema.realizarViagem(1, 1, 1);

        System.out.println("\nViagem com SUV (Ford Explorer):");
        sistema.realizarViagem(1, 2, 1);

        System.out.println("\nViagem com Compacto (Honda Civic):");
        sistema.realizarViagem(1, 3, 1);

        System.out.println("\nTestes de viagem finalizados.");

        System.out.println("\nListando todas as viagens realizadas:");
        sistema.listarViagens();

        System.out.println("\nListando veículos com autonomia baixa:");
        sistema.listarVeiculosAutonomiaBaixa();

        System.out.println("\nListando motoristas cadastrados:");
        sistema.listarMotoristas();

        System.out.println("\nListando carros cadastrados:");
        sistema.listarCarros();

        System.out.println("\nHistórico de recargas do carro 1");
        sistema.getCarros().get(0).listarRecargas();

        System.out.println("\nViagens realizadas pelo motorista 1:");
        sistema.ListarViagensMotorista(sistema.getMotoristas().get(0));

        System.out.println("\nEletropostos totais do sistema: ");
        sistema.listarEletropostos();
    }

}
