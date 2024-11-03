public class Main {
    public static void main(String[] args) {
        // Criação do sistema
        Sistema sistema = new Sistema();

        // Exemplo de carros de cada categoria
        Carro sedan = new Sedan(1, "Tesla", "Model S", 2024);
        Carro suv = new SUV(2, "Ford", "Explorer", 2021);
        Carro compacto = new Compacto(3, "Honda", "Civic", 2019);

        // Adicionando carros ao sistema
        sistema.addCarro(sedan);
        sistema.addCarro(suv);
        sistema.addCarro(compacto);

        // Criando um motorista
        Motorista motorista = new Motorista(1, "João Silva", 123, 2);
        sistema.addMotorista(motorista);

        // Criando uma rota com eletropostos ao longo do caminho
        Rota rota = new Rota(1, "Santa Maria", 400);
        rota.addEletroposto(new Eletroposto(1, 4, 1.0, 100)); // Eletroposto a 100 km
        rota.addEletroposto(new Eletroposto(2, 2, 2.0, 200)); // Eletroposto a 200 km

        // Adicionando rota ao sistema
        sistema.addRota(rota);

        // Testando a viagem para cada carro
        System.out.println("Iniciando testes de viagem para diferentes carros...");

        System.out.println("\nViagem com Sedan (Tesla Model S):");
        rota.Viajar(sedan, motorista, sistema);

        System.out.println("\nViagem com SUV (Ford Explorer):");
        rota.Viajar(suv, motorista, sistema);

        System.out.println("\nViagem com Compacto (Honda Civic):");
        rota.Viajar(compacto, motorista, sistema);

        System.out.println("\nTestes de viagem finalizados.");
    }
}
