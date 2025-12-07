package builder;

public class Computador {
    private final String processador;
    private final String memoriaRAM;
    private final String placaDeVideo;
    private final String armazenamento;
    private final String sistemaOperacional;
    private final boolean possuiRGB;
    private final boolean possuiWaterCooler;

    public Computador(Builder builder) {
        this.processador = builder.processador;
        this.memoriaRAM = builder.memoriaRAM;
        this.placaDeVideo = builder.placaDeVideo;
        this.armazenamento = builder.armazenamento;
        this.sistemaOperacional = builder.sistemaOperacional;
        this.possuiRGB = builder.possuiRGB;
        this.possuiWaterCooler = builder.possuiWaterCooler;
    }

    public String getProcessador() {
        return processador;
    }
    public String getMemoriaRAM() {
        return memoriaRAM;
    }
    public String getPlacaDeVideo() {
        return placaDeVideo;
    }
    public String getArmazenamento() {
        return armazenamento;
    }
    public String getSistemaOperacional() {
        return sistemaOperacional;
    }
    public boolean computadorPossuiRGB(){ return possuiRGB; }
    public boolean computadorPossuiWaterCooler(){ return possuiWaterCooler; }

    @Override
    public String toString() {
        return "=== Especificações do Computador ===\n" +
                "Processador: " + processador + "\n" +
                "Memória RAM: " + memoriaRAM + "\n" +
                // Usa operador ternário para verificar se é null
                "Placa de Vídeo: " + (placaDeVideo != null ? placaDeVideo : "Vídeo Integrado") + "\n" +
                "Armazenamento: " + (armazenamento != null ? armazenamento : "Não definido") + "\n" +
                "Sistema Operacional: " + (sistemaOperacional != null ? sistemaOperacional : "Sem OS") + "\n" +
                // Transforma boolean true/false em Sim/Não
                "Possui RGB: " + (possuiRGB ? "Sim" : "Não") + "\n" +
                "Water Cooler: " + (possuiWaterCooler ? "Sim" : "Não") + "\n" +
                "====================================";
    }

    public static class Builder{
        private final String processador;
        private final String memoriaRAM;
        private String placaDeVideo;
        private String armazenamento;
        private String sistemaOperacional;
        private boolean possuiRGB;
        private boolean possuiWaterCooler;

        public Builder(String processador, String memoriaRAM) {
            this.processador = processador;
            this.memoriaRAM = memoriaRAM;
        }

        public Builder comPlacaDeVideo(String placaDeVideo) {
            this.placaDeVideo = placaDeVideo;
            return this;
        }

        public Builder comArmazenamento(String armazenamento) {
            this.armazenamento = armazenamento;
            return this;
        }

        public Builder comSistemaOperacional(String sistemaOperacional) {
            this.sistemaOperacional = sistemaOperacional;
            return this;
        }

        public Builder comRGB() {
            this.possuiRGB = true;
            return this;
        }

        public Builder comWaterCooler() {
            this.possuiWaterCooler = true;
            return this;
        }

        public Computador build(){
            return new Computador(this);
        }
    }
}
