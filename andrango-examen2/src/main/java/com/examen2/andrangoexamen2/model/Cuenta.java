package com.examen2.andrangoexamen2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cuenta {
    private String NumeroCuenta;
    private String tipoCuenta;
    private Integer saldoPromedio;

}
