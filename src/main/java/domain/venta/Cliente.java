package domain.venta;

import co.com.sofka.domain.generic.Entity;
import domain.venta.values.*;

import java.util.Objects;

public class Cliente extends Entity<ClienteID> {
    private Identificacion identificacion;
    private Comprobante comprobante;
    private NumeroContacto numero;
    private Deposito deposito;

    public Cliente(ClienteID entityId, Identificacion identificacion, Comprobante comprobante, NumeroContacto numero, Deposito deposito) {
        super(entityId);
        this.identificacion = Objects.requireNonNull(identificacion);
        this.comprobante = Objects.requireNonNull(comprobante);
        this.numero = Objects.requireNonNull(numero);
        this.deposito = Objects.requireNonNull(deposito);
    }

    public Identificacion Identificacion() {
        return identificacion;
    }

    public Comprobante Comprobante() {
        return comprobante;
    }

    public NumeroContacto Numero() {
        return numero;
    }

    public Deposito Downpayment() {
        return deposito;
    }

    public void actualizarIdentificacion(Identificacion identificacion){

        this.identificacion=Objects.requireNonNull(identificacion);
    }

    public void actualizarComprobante(Comprobante comprobante){
        this.comprobante= Objects.requireNonNull(comprobante);
    }

    public void actualizarNumeroContacto(NumeroContacto numero){
        this.numero=Objects.requireNonNull(numero);;
    }
}
