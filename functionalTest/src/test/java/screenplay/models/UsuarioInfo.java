package screenplay.models;

public class UsuarioInfo {
    private String usuarioEmail = "a@a.com";
    private String usuarioFirstName = "Chuck";
    private String usuarioLastName = "Norris";
    private String nroCel = "2132131231";

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioFirstName() {
        return usuarioFirstName;
    }

    public void setUsuarioFirstName(String usuarioFirstName) {
        this.usuarioFirstName = usuarioFirstName;
    }

    public String getUsuarioLastName() {
        return usuarioLastName;
    }

    public void setUsuarioLastName(String usuarioLastName) {
        this.usuarioLastName = usuarioLastName;
    }

    public String getNroCel() {
        return nroCel;
    }

    public void setNroCel(String nroCel) {
        this.nroCel = nroCel;
    }
}
