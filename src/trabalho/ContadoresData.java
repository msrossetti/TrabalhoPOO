package trabalho;

public class ContadoresData {
    private int codUser = 6; // Começando após os dados iniciais
    private int codProd = 6; // Começando após os dados iniciais
    private int numPed = 6;  // Começando após os dados iniciais
    
    public ContadoresData() {
    }
    
    public ContadoresData(int codUser, int codProd, int numPed) {
        this.codUser = codUser;
        this.codProd = codProd;
        this.numPed = numPed;
    }
    
    public int getCodUser() {
        return codUser;
    }
    
    public void setCodUser(int codUser) {
        this.codUser = codUser;
    }
    
    public int getCodProd() {
        return codProd;
    }
    
    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }
    
    public int getNumPed() {
        return numPed;
    }
    
    public void setNumPed(int numPed) {
        this.numPed = numPed;
    }
    
    public void incrementarCodUser() {
        this.codUser++;
    }
    
    public void incrementarCodProd() {
        this.codProd++;
    }
    
    public void incrementarNumPed() {
        this.numPed++;
    }
}
