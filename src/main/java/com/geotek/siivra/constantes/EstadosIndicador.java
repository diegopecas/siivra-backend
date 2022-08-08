package com.geotek.siivra.constantes;

public interface EstadosIndicador {
    /***
     * 1	Solicitado para validación
     * 2	Validado
     * 3	Pendiente de aprobación
     * 4	Aprobado
     * 5	Rechazado
     * ***/
    Long PENDIENTE_VALIDAR = Long.valueOf(1);
    Long VALIDADO = Long.valueOf(2);
    Long PENDIENTE_APROBACION = Long.valueOf(3);
    Long APROBADO = Long.valueOf(4);
    Long RECHAZADO = Long.valueOf(5);
}
