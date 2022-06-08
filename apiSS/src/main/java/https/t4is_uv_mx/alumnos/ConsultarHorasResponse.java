//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.06.03 a las 02:10:33 AM CDT 
//


package https.t4is_uv_mx.alumnos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="horasRealizadas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="horasFaltantes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "horasRealizadas",
    "horasFaltantes"
})
@XmlRootElement(name = "ConsultarHorasResponse")
public class ConsultarHorasResponse {

    protected int horasRealizadas;
    protected int horasFaltantes;

    /**
     * Obtiene el valor de la propiedad horasRealizadas.
     * 
     */
    public int getHorasRealizadas() {
        return horasRealizadas;
    }

    /**
     * Define el valor de la propiedad horasRealizadas.
     * 
     */
    public void setHorasRealizadas(int value) {
        this.horasRealizadas = value;
    }

    /**
     * Obtiene el valor de la propiedad horasFaltantes.
     * 
     */
    public int getHorasFaltantes() {
        return horasFaltantes;
    }

    /**
     * Define el valor de la propiedad horasFaltantes.
     * 
     */
    public void setHorasFaltantes(int value) {
        this.horasFaltantes = value;
    }

}