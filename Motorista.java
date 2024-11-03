public class Motorista {
    private int id;
    private String nome;
    private int num_carteira;
    private int experiencia; // 0 = iniciante | 1 = intermediário | 2 = avançado
    
    public Motorista(int id, String nome, int num_carteira, int experiencia) {
        this.id = id;
        this.nome = nome;
        this.num_carteira = num_carteira;
        this.experiencia = experiencia;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNum_carteira() {
        return num_carteira;
    }

    public void setNum_carteira(int num_carteira) {
        this.num_carteira = num_carteira;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    
}
