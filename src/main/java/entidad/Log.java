package entidad;

import java.sql.Timestamp;

public class Log {
    private int id;
    private Timestamp fechaCreacion;
    private int usuarioId;
    private int divisaId;

    // Constructor, getters y setters
    public Log(int id, Timestamp fechaCreacion, int usuarioId, int divisaId) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.usuarioId = usuarioId;
        this.divisaId = divisaId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Timestamp getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Timestamp fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    public int getDivisaId() { return divisaId; }
    public void setDivisaId(int divisaId) { this.divisaId = divisaId; }
}
