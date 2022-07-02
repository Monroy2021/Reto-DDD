package domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cita implements ValueObject<Cita.Properties> {
    private final Boolean agentoCita;
    private final String fecha;
    private final String horaCita;


    public Cita(Boolean agentoCita,String fecha, String horaCita) {
        this.agentoCita = Objects.requireNonNull(agentoCita);
        this.fecha = Objects.requireNonNull(fecha);
        this.horaCita = Objects.requireNonNull(horaCita);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public Boolean agendoCita() {
                return agentoCita;
            }

            @Override
            public String fecha() {
                return fecha;
            }

            @Override
            public String HoraCita() {
                return horaCita;
            }
        };
    }


    public interface Properties{
        Boolean agendoCita();
        String fecha();
        String HoraCita();
    }
}
