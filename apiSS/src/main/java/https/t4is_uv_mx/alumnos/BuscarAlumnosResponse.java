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
 *         &lt;element name="alumnos" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="idAlumno" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="nombres" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="apellidoPaterno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="apellidoMaterno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="matricula" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="promedio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="idCoordinador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="idDependencia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "alumnos"
})
@XmlRootElement(name = "BuscarAlumnosResponse")
public class BuscarAlumnosResponse {

    @XmlElement(required = true)
    protected List<BuscarAlumnosResponse.Alumnos> alumnos;

    /**
     * Gets the value of the alumnos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alumnos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlumnos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BuscarAlumnosResponse.Alumnos }
     * 
     * 
     */
    public List<BuscarAlumnosResponse.Alumnos> getAlumnos() {
        if (alumnos == null) {
            alumnos = new ArrayList<BuscarAlumnosResponse.Alumnos>();
        }
        return this.alumnos;
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
     *         &lt;element name="idAlumno" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="nombres" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="apellidoPaterno" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="apellidoMaterno" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="matricula" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="promedio" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="idCoordinador" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="idDependencia" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "idAlumno",
        "nombres",
        "apellidoPaterno",
        "apellidoMaterno",
        "matricula",
        "correo",
        "token",
        "promedio",
        "idCoordinador",
        "idDependencia",
        "telefono"
    })
    public static class Alumnos {

        protected int idAlumno;
        @XmlElement(required = true)
        protected String nombres;
        @XmlElement(required = true)
        protected String apellidoPaterno;
        @XmlElement(required = true)
        protected String apellidoMaterno;
        @XmlElement(required = true)
        protected String matricula;
        @XmlElement(required = true)
        protected String correo;
        @XmlElement(required = true)
        protected String token;
        protected double promedio;
        protected int idCoordinador;
        protected int idDependencia;
        @XmlElement(required = true)
        protected String telefono;

        /**
         * Obtiene el valor de la propiedad idAlumno.
         * 
         */
        public int getIdAlumno() {
            return idAlumno;
        }

        /**
         * Define el valor de la propiedad idAlumno.
         * 
         */
        public void setIdAlumno(int value) {
            this.idAlumno = value;
        }

        /**
         * Obtiene el valor de la propiedad nombres.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombres() {
            return nombres;
        }

        /**
         * Define el valor de la propiedad nombres.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombres(String value) {
            this.nombres = value;
        }

        /**
         * Obtiene el valor de la propiedad apellidoPaterno.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApellidoPaterno() {
            return apellidoPaterno;
        }

        /**
         * Define el valor de la propiedad apellidoPaterno.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApellidoPaterno(String value) {
            this.apellidoPaterno = value;
        }

        /**
         * Obtiene el valor de la propiedad apellidoMaterno.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApellidoMaterno() {
            return apellidoMaterno;
        }

        /**
         * Define el valor de la propiedad apellidoMaterno.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApellidoMaterno(String value) {
            this.apellidoMaterno = value;
        }

        /**
         * Obtiene el valor de la propiedad matricula.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMatricula() {
            return matricula;
        }

        /**
         * Define el valor de la propiedad matricula.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMatricula(String value) {
            this.matricula = value;
        }

        /**
         * Obtiene el valor de la propiedad correo.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCorreo() {
            return correo;
        }

        /**
         * Define el valor de la propiedad correo.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCorreo(String value) {
            this.correo = value;
        }

        /**
         * Obtiene el valor de la propiedad token.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getToken() {
            return token;
        }

        /**
         * Define el valor de la propiedad token.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setToken(String value) {
            this.token = value;
        }

        /**
         * Obtiene el valor de la propiedad promedio.
         * 
         */
        public double getPromedio() {
            return promedio;
        }

        /**
         * Define el valor de la propiedad promedio.
         * 
         */
        public void setPromedio(double value) {
            this.promedio = value;
        }

        /**
         * Obtiene el valor de la propiedad idCoordinador.
         * 
         */
        public int getIdCoordinador() {
            return idCoordinador;
        }

        /**
         * Define el valor de la propiedad idCoordinador.
         * 
         */
        public void setIdCoordinador(int value) {
            this.idCoordinador = value;
        }

        /**
         * Obtiene el valor de la propiedad idDependencia.
         * 
         */
        public int getIdDependencia() {
            return idDependencia;
        }

        /**
         * Define el valor de la propiedad idDependencia.
         * 
         */
        public void setIdDependencia(int value) {
            this.idDependencia = value;
        }

        /**
         * Obtiene el valor de la propiedad telefono.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTelefono() {
            return telefono;
        }

        /**
         * Define el valor de la propiedad telefono.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTelefono(String value) {
            this.telefono = value;
        }

    }

}
