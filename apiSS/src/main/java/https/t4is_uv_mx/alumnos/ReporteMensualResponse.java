//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.06.03 a las 01:14:39 AM CDT 
//


package https.t4is_uv_mx.alumnos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="nombreAlumno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreResponsable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreCoordinador" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="horasMes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="horasTotal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="actividad" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="horas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="actividad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "nombreAlumno",
    "nombreResponsable",
    "nombreCoordinador",
    "horasMes",
    "horasTotal",
    "actividad"
})
@XmlRootElement(name = "ReporteMensualResponse")
public class ReporteMensualResponse {

    @XmlElement(required = true)
    protected String nombreAlumno;
    @XmlElement(required = true)
    protected String nombreResponsable;
    @XmlElement(required = true)
    protected String nombreCoordinador;
    protected int horasMes;
    protected int horasTotal;
    @XmlElement(required = true)
    protected List<ReporteMensualResponse.Actividad> actividad;

    /**
     * Obtiene el valor de la propiedad nombreAlumno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    /**
     * Define el valor de la propiedad nombreAlumno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAlumno(String value) {
        this.nombreAlumno = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreResponsable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreResponsable() {
        return nombreResponsable;
    }

    /**
     * Define el valor de la propiedad nombreResponsable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreResponsable(String value) {
        this.nombreResponsable = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreCoordinador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    /**
     * Define el valor de la propiedad nombreCoordinador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCoordinador(String value) {
        this.nombreCoordinador = value;
    }

    /**
     * Obtiene el valor de la propiedad horasMes.
     * 
     */
    public int getHorasMes() {
        return horasMes;
    }

    /**
     * Define el valor de la propiedad horasMes.
     * 
     */
    public void setHorasMes(int value) {
        this.horasMes = value;
    }

    /**
     * Obtiene el valor de la propiedad horasTotal.
     * 
     */
    public int getHorasTotal() {
        return horasTotal;
    }

    /**
     * Define el valor de la propiedad horasTotal.
     * 
     */
    public void setHorasTotal(int value) {
        this.horasTotal = value;
    }

    /**
     * Gets the value of the actividad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReporteMensualResponse.Actividad }
     * 
     * 
     */
    public List<ReporteMensualResponse.Actividad> getActividad() {
        if (actividad == null) {
            actividad = new ArrayList<ReporteMensualResponse.Actividad>();
        }
        return this.actividad;
    }


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
     *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="horas" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="actividad" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "fecha",
        "horas",
        "actividad"
    })
    public static class Actividad {

        @XmlElement(required = true)
        protected String fecha;
        protected int horas;
        @XmlElement(required = true)
        protected String actividad;

        /**
         * Obtiene el valor de la propiedad fecha.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFecha() {
            return fecha;
        }

        /**
         * Define el valor de la propiedad fecha.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFecha(String value) {
            this.fecha = value;
        }

        /**
         * Obtiene el valor de la propiedad horas.
         * 
         */
        public int getHoras() {
            return horas;
        }

        /**
         * Define el valor de la propiedad horas.
         * 
         */
        public void setHoras(int value) {
            this.horas = value;
        }

        /**
         * Obtiene el valor de la propiedad actividad.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActividad() {
            return actividad;
        }

        /**
         * Define el valor de la propiedad actividad.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActividad(String value) {
            this.actividad = value;
        }

    }

}
